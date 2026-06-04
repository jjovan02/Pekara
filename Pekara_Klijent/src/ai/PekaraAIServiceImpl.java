package ai;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionCreateParams;


public class PekaraAIServiceImpl implements PekaraAIService {

    private final OpenAIClient client;

    public PekaraAIServiceImpl(String apiKey) {
        this.client = OpenAIOkHttpClient.builder().apiKey(apiKey).build();
    }

    @Override
    public String getPreporuka(PekaraAIRequest request) {
        String prompt = kreirajPrompt(request);

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder().model(ChatModel.GPT_4_1_MINI).addUserMessage(prompt).build();

        return client.chat().completions().create(params).choices().get(0).message().content().orElse("Nije dobijen odgovor od AI servisa.");
    }

    private String kreirajPrompt(PekaraAIRequest request) {
        return """
                Organizujemo %s za %d gostiju.
                
                Dostupna peciva u nasoj pekari:
                %s
                
                Predlozi preporucene kolicine za svako pecivo.
                Vrati odgovor iskljucivo kao JSON sa poljem "peciva",
                gde svaki element ima polja "naziv" i "kolicina".
                Primer formata:
                {
                  "peciva": [
                    {"naziv": "kifla", "kolicina": 40},
                    {"naziv": "kroasan", "kolicina": 20}
                  ]
                }
                """.formatted(request.getTipDogadjaja(),request.getBrojGostiju(),String.join(", ", request.getPeciva()));
    }
}