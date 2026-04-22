
package threads;


import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.Controller;
import model.*;
import model.communication.*;


public class HandleClientThread extends Thread {

    private Socket socket;
    
    private Pekar prijavljeniPekar;

    public Pekar getPrijavljeniPekar() {
        return prijavljeniPekar;
    }

    public HandleClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                Request request = (Request) new Receiver(socket).receive();
                Response response = handleRequest(request);
                new Sender(socket).send(response);
            } catch (Exception ex) {
                System.out.println("Klijent se odvezao ili je doslo do greske");
                break;
            }
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(HandleClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServerThread.getClients().remove(this);  

    }

    public Socket getSocket() {
        return socket;
    }

    private Response handleRequest(Request request) {
        switch (request.getOperation()) {
            case LOGIN: return login(request);

            case KREIRAJ_KATEGORIJA_KUPCA: return kreirajKategorijaKupca(request);
            case LISTA_SVI_KATEGORIJA_KUPCA: return vratiListaSviKategorijaKupca(request);
            case LISTA_NEKI_KATEGORIJA_KUPCA: return vratiListaNekiKategorijaKupca(request);
            case OBRISI_KATEGORIJA_KUPCA: return obrisiKategorijaKupca(request);
            case PROMENI_KATEGORIJA_KUPCA: return promeniKategorijaKupca(request);

            case KREIRAJ_PECIVO: return kreirajPecivo(request);
            case LISTA_SVI_PECIVO: return vratiListaSviPecivo(request);
            case LISTA_NEKI_PECIVO: return vratiListaNekiPecivo(request);
            case OBRISI_PECIVO: return obrisiPecivo(request);
            case PROMENI_PECIVO: return promeniPecivo(request);

            case KREIRAJ_PEKAR: return kreirajPekar(request);
            case LISTA_SVI_PEKAR: return vratiListaSviPekar(request);
            case LISTA_NEKI_PEKAR: return vratiListaNekiPekar(request);
            case OBRISI_PEKAR: return obrisiPekar(request);
            case PROMENI_PEKAR: return promeniPekar(request);

            case UBACI_SERTIFIKAT: return ubaciSertifikat(request);
            case LISTA_SVI_SERTIFIKAT: return vratiListaSviSertifikat(request);
            case LISTA_NEKI_SERTIFIKAT: return vratiListaNekiSertifikat(request);
            case OBRISI_SERTIFIKAT: return obrisiSertifikat(request);
            case PROMENI_SERTIFIKAT: return promeniSertifikat(request);

            case KREIRAJ_KUPAC: return kreirajKupac(request);
            case LISTA_SVI_KUPAC: return vratiListaSviKupac(request);
            case LISTA_NEKI_KUPAC: return vratiListaNekiKupac(request);
            case OBRISI_KUPAC: return obrisiKupac(request);
            case PROMENI_KUPAC: return promeniKupac(request);

            case KREIRAJ_RACUN: return kreirajRacun(request);
            case LISTA_SVI_RACUN: return vratiListaSviRacun(request);
            case LISTA_NEKI_RACUN: return vratiListaNekiRacun(request);
            case PROMENI_RACUN: return promeniRacun(request);

            default: return null;
        }
    }

    
    
    private Response login(Request request) {
        Response response = new Response();
        Pekar pekar = (Pekar) request.getArgument();
        try {
            // Proveri da li je vec ulogovan
            for (HandleClientThread client : ServerThread.getClients()) {
                if (client != this && client.getPrijavljeniPekar() != null &&
                    client.getPrijavljeniPekar().getKorisnickoIme().equals(pekar.getKorisnickoIme())) {
                    throw new Exception("Pekar je već ulogovan na sistemu!");
                }
            }
            pekar = Controller.getInstance().prijaviPekar(pekar);
            this.prijavljeniPekar = pekar;  
            
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(pekar);
            
        } catch (Exception ex) {
            
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response kreirajKategorijaKupca(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().kreirajKategorijaKupca((KategorijaKupca) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    
    private Response vratiListaSviKategorijaKupca(Request request) {
        Response response = new Response();
        try {
            ArrayList<KategorijaKupca> lista = Controller.getInstance().vratiListuSviKategorijaKupca((KategorijaKupca) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(lista);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    
    private Response vratiListaNekiKategorijaKupca(Request request) {
        Response response = new Response();
        try {
            ArrayList<KategorijaKupca> lista = Controller.getInstance().vratiListuNekiKategorijaKupca((KategorijaKupca) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(lista);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    
    
    private Response obrisiKategorijaKupca(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().obrisiKategorijaKupca((KategorijaKupca) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response promeniKategorijaKupca(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().promeniKategorijaKupca((KategorijaKupca) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response kreirajPecivo(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().kreirajPecivo((Pecivo) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaSviPecivo(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuSviPecivo((Pecivo) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaNekiPecivo(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuNekiPecivo((Pecivo) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response obrisiPecivo(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().obrisiPecivo((Pecivo) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response promeniPecivo(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().promeniPecivo((Pecivo) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response kreirajPekar(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().kreirajPekar((Pekar) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaSviPekar(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuSviPekar((Pekar) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaNekiPekar(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuNekiPekar((Pekar) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response obrisiPekar(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().obrisiPekar((Pekar) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response promeniPekar(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().promeniPekar((Pekar) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response ubaciSertifikat(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().ubaciSertifikat((Sertifikat) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaSviSertifikat(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuSviSertifikat((Sertifikat) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaNekiSertifikat(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuNekiSertifikat((Sertifikat) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response obrisiSertifikat(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().obrisiSertifikat((Sertifikat) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response promeniSertifikat(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().promeniSertifikat((Sertifikat) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response kreirajKupac(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().kreirajKupac((Kupac) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaSviKupac(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuSviKupac((Kupac) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaNekiKupac(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuNekiKupac((Kupac) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response obrisiKupac(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().obrisiKupac((Kupac) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response promeniKupac(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().promeniKupac((Kupac) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response kreirajRacun(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().kreirajRacun((Racun) request.getArgument());
            System.out.println("Uspesno kreiran racun!");
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaSviRacun(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuSviRacun((Racun) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaNekiRacun(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuNekiRacun((Racun) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response promeniRacun(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().promeniRacun((Racun) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }
}
