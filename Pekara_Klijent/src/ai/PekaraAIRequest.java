package ai;

import java.util.List;


public class PekaraAIRequest {

    private List<String> peciva;
    private String tipDogadjaja;
    private int brojGostiju;

    public PekaraAIRequest() {}

    public PekaraAIRequest(List<String> peciva, String tipDogadjaja, int brojGostiju) {
        this.peciva = peciva;
        this.tipDogadjaja = tipDogadjaja;
        this.brojGostiju = brojGostiju;
    }

    public List<String> getPeciva() { return peciva; }
    public void setPeciva(List<String> peciva) { this.peciva = peciva; }

    public String getTipDogadjaja() { return tipDogadjaja; }
    public void setTipDogadjaja(String tipDogadjaja) { this.tipDogadjaja = tipDogadjaja; }

    public int getBrojGostiju() { return brojGostiju; }
    public void setBrojGostiju(int brojGostiju) { this.brojGostiju = brojGostiju; }
}
