import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class client {

        public static void main(String[] args)throws IOException ,NumberFormatException 
        {
            
       
        Socket socket = new Socket("localhost",9090 );
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        String serverResponse = input.readLine();
        System.out.println("Host :"+ serverResponse);

        String serverrequest_name = input.readLine();
        System.out.println("Host:" + serverrequest_name);
        String name = keyboard.readLine();
        out.println(name);
        out.flush();

        String serverResponse2;
        for(int i = 0; i< 7; i++){
            serverResponse2 = input.readLine();
            System.out.println("Host : "+ serverResponse2);
        }





        int j =-1;
        int max = -1;
        for(int i =0; i< 2 ;i++){
           
            System.out.println("Client enter your bid");
            String bid = keyboard.readLine();

            j =Integer.parseInt(bid); 


             if (j>max && (j != 0 || bid != "0")) {
                 //String s = String.valueOf(bid);
            out.println(bid);
            out.flush();

            String response = input.readLine();
            System.out.println("Amount bidded = "+ response);

            max = j;
            }
   
           else{
               while (max > j && j != 0) {
                    
                System.out.println("Invalid bidding");
                System.out.println(" ");
                System.out.println("Please enter valid bid(greater than previous bid)");
                System.out.println(" ");
                 bid = keyboard.readLine();
                 j =Integer.parseInt(bid); 

                }
                 out.println(bid);
                 out.flush();
 
                 String response = input.readLine();
                 System.out.println("Amount bidded = "+ response);   
           }
            
        }
           
        
        socket.close();


    }
}
