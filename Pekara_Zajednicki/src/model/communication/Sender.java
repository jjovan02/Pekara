package model.communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {
    private Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    public void send(Object object) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(object);
        out.flush();
    }
}
