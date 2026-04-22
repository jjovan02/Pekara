package main;

import communication.Communication;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.LoginForm;
import style.Stil;

public class Main {

    public static void main(String[] args) {
        Stil.stilizujOptionPane();
        Main client = new Main();
        try {
            client.connect();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void connect() throws IOException {
        Socket socket = new Socket("localhost", 9000);
        Communication.getInstance().setSocket(socket);
        (new LoginForm()).setVisible(true);
    }
}
