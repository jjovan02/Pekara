package threads;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import konfiguracija.Konfiguracija;

public class ServerThread extends Thread {

    private ServerSocket serverSocket;
    private static List<HandleClientThread> clients = new ArrayList<>();

    public static List<HandleClientThread> getClients() {
        return clients;
    }

    public ServerThread() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config/server.properties"));
        serverSocket = new ServerSocket(Integer.parseInt(properties.getProperty(Konfiguracija.DB_CONFIG_PORT)));
        
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            try {
                System.out.println("Cekam klijente...");
                Socket socket = serverSocket.accept();
                HandleClientThread thread = new HandleClientThread(socket);
                thread.start();
                clients.add(thread);
                System.out.println("Klijent povezan!");
            } catch (SocketException ex) {
                System.out.println("Serverski socket je zatvoren ili je doslo do greske!");
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        stopAllThreads();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    private void stopAllThreads() {
        for (HandleClientThread client : clients) {
            try {
                client.getSocket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
