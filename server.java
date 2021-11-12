import java.io.*;
import java.lang.reflect.Executable;
import java.net.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server {
    private static int nthreadpool = 3;
    private static ArrayList<clienthandler>clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(nthreadpool);
    private static final int port = 9090;
    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(port);

        int i =0;
        while (i< nthreadpool) {
            System.out.println("Waiting for connection");
            Socket client = listener.accept();
            System.out.println("Server connected to client "+(i+1));
            clienthandler clientthread = new clienthandler(client);
            clients.add(clientthread);

            pool.execute(clientthread);
            i++;
        }
    }
}