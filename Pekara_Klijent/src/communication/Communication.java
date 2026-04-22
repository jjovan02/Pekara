package communication;

import java.net.Socket;
import model.communication.*;

public class Communication {
    private static Communication instance;
    private Socket socket;

    private Communication() {
    }

    public static Communication getInstance() {
        if (instance == null) instance = new Communication();
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    

    private Response sendAndReceive(Request request) throws Exception {
        new Sender(socket).send(request);
        return (Response) new Receiver(socket).receive();
    }

    public Response prijaviPekara(Request request) throws Exception {
        System.out.println("Zahtev za prijavom na sistem je poslat...");
        return sendAndReceive(request);
    }

    public Response kreirajKategorijaKupca(Request request) throws Exception {
        System.out.println("Zahtev za kreiranje kategorije kupca poslat...");
        return sendAndReceive(request);
    }

    public Response vratiListuSviKategorijaKupca(Request request) throws Exception {
        System.out.println("Zahtev za svim kategorijama kupca poslat...");
        return sendAndReceive(request);
    }

    public Response obrisiKategorijaKupca(Request request) throws Exception {
        System.out.println("Zahtev za brisanjem kategorije kupca poslat...");
        return sendAndReceive(request);
    }

    public Response promeniKategorijaKupca(Request request) throws Exception {
        System.out.println("Zahtev za promenom kategorije kupca poslat...");
        return sendAndReceive(request);
    }

    public Response kreirajPecivo(Request request) throws Exception {
        System.out.println("Zahtev za kreiranje peciva poslat...");
        return sendAndReceive(request);
    }

    public Response vratiListuSviPecivo(Request request) throws Exception {
        System.out.println("Zahtev za svim pecivima poslat...");
        return sendAndReceive(request);
    }

    public Response obrisiPecivo(Request request) throws Exception {
        System.out.println("Zahtev za brisanjem peciva poslat...");
        return sendAndReceive(request);
    }

    public Response promeniPecivo(Request request) throws Exception {
        System.out.println("Zahtev za promenom peciva poslat...");
        return sendAndReceive(request);
    }

    public Response kreirajPekar(Request request) throws Exception {
        System.out.println("Zahtev za kreiranje pekara poslat...");
        return sendAndReceive(request);
    }

    public Response vratiListuSviPekar(Request request) throws Exception {
        System.out.println("Zahtev za svim pekarima poslat...");
        return sendAndReceive(request);
    }

    public Response obrisiPekar(Request request) throws Exception {
        System.out.println("Zahtev za brisanjem pekara poslat...");
        return sendAndReceive(request);
    }

    public Response promeniPekar(Request request) throws Exception {
        System.out.println("Zahtev za promenom pekara poslat...");
        return sendAndReceive(request);
    }

    public Response ubaciSertifikat(Request request) throws Exception {
        System.out.println("Zahtev za ubacivanje sertifikata poslat...");
        return sendAndReceive(request);
    }

    public Response vratiListuSviSertifikat(Request request) throws Exception {
        System.out.println("Zahtev za svim sertifikatima poslat...");
        return sendAndReceive(request);
    }

    public Response obrisiSertifikat(Request request) throws Exception {
        System.out.println("Zahtev za brisanjem sertifikata poslat...");
        return sendAndReceive(request);
    }

    public Response promeniSertifikat(Request request) throws Exception {
        System.out.println("Zahtev za promenom sertifikata poslat...");
        return sendAndReceive(request);
    }

    public Response kreirajKupac(Request request) throws Exception {
        System.out.println("Zahtev za kreiranje kupca poslat...");
        return sendAndReceive(request);
    }

    public Response vratiListuSviKupac(Request request) throws Exception {
        System.out.println("Zahtev za svim kupcima poslat...");
        return sendAndReceive(request);
    }

    public Response obrisiKupac(Request request) throws Exception {
        System.out.println("Zahtev za brisanjem kupca poslat...");
        return sendAndReceive(request);
    }

    public Response promeniKupac(Request request) throws Exception {
        System.out.println("Zahtev za promenom kupca poslat...");
        return sendAndReceive(request);
    }

    public Response kreirajRacun(Request request) throws Exception {
        System.out.println("Zahtev za kreiranje racuna poslat...");
        return sendAndReceive(request);
    }

    public Response promeniRacun(Request request) throws Exception {
        System.out.println("Zahtev za promenom racuna poslat...");
        return sendAndReceive(request);
    }

    public Response vratiListuSviRacun(Request request) throws Exception {
        System.out.println("Zahtev za svim racunima poslat...");
        return sendAndReceive(request);
    }
}
