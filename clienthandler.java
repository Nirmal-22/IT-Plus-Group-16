import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.lang.NumberFormatException;

public class clienthandler implements Runnable 
{
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private int max = 100;
    

    public clienthandler(Socket clientSocket) throws IOException,NumberFormatException{
        this.client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream());
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        out.println("Welome to the auction");
        out.println("Enter your name pls");
        out.flush();
        
    out.println("Following are the rules for the auction, please read them carefully");
    out.println(" ");
    out.println("1 "+ "The auction will start after all the bidders have joined");
    out.println("2 "+ "The bidder shall not bid lesser than the previous bid, any such bid will be considered invalid");
    out.println("3 "+ "In case the bidder chooses to withdraw from the auction, enter 0");
    out.println("4 "+ "There will be 10 rounds in all for all the bidders, the last bid will be the maximum and hence the respective bidder would be declared a winner");
    out.println("5 "+ "A base price would be set for the item by the organiser, the bid shall be added to base price to make a total");
    out.flush();
       
    String name = new String();
        try {
            
            //out.flush();
            String z = in.readLine();
            name = z;
            for(int j =0; j<2; j++){
                
                String a = in.readLine();
                
                
                int i=Integer.parseInt(a); 

                System.out.println("Amount bidded by client "+z+ " " +(a));
                System.out.println("Total amount auctioned = "+ (i+100));
                String b = String.valueOf(i+100);
                out.println(b);
                out.flush();
                
            }
    
            }catch (NumberFormatException | IOException e) {
                System.err.println(" ");
            }
        

        finally{
            System.out.println("Client " + name + " has exhausted all their chances");
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        synchronized(this)
        {
            notifyAll();
        }   
        
                   
    }
    public synchronized int get() throws InterruptedException
    {
        while (max == 0)
            wait();

        return max;
    }
    public synchronized String getname() throws InterruptedException{
        return getname();
    }
    
}
