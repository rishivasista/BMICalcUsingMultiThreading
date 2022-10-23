package client;
// Java implementation for a client
// Save file as Client.java

import java.io.*;
import java.net.*;
import java.util.Scanner;

// Client class
public class Client
{   
    static final int PORT = 5056;
	public static void main(String[] args) throws IOException
	{
		try
		{
			Scanner scn = new Scanner(System.in);
			
			// getting localhost ip
			InetAddress ip = InetAddress.getByName("localhost");
            
			// establish the connection with server port 5056
			Socket s = new Socket(ip, PORT);
            System.out.println("Connect on IP "+ip+" and Port " + PORT);
			// obtaining input and out streams
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	
			// the following loop performs the exchange of
			// information between client and client handler
			while (true)
			{
				System.out.println(dis.readUTF());
				String tosend = scn.nextLine();
				dos.writeUTF(tosend);
				
                if(tosend.toLowerCase().equals("bmi")){
                    System.out.println(dis.readUTF());
                    int weight = scn.nextInt();
                    dos.writeInt(weight);
                    
                    System.out.println(dis.readUTF());
                    int height = scn.nextInt();
                    dos.writeInt(height);
                }

                else if(tosend.toLowerCase().equals("bmr")){
                    System.out.println(dis.readUTF());
                    int weight = scn.nextInt();
                    dos.writeInt(weight);
                    
                    System.out.println(dis.readUTF());
                    int height = scn.nextInt();
                    dos.writeInt(height);

                    System.out.println(dis.readUTF());
                    int age = scn.nextInt();
                    dos.writeInt(age);
                    
                    System.out.println(dis.readUTF());
                    int gender = scn.nextInt();
                    dos.writeInt(gender);
                }
				// If client sends exit,close this connection
				// and then break from the while loop
				else if(tosend.toLowerCase().equals("exit"))
				{
					System.out.println("Closing this connection : " + s);
					s.close();
					System.out.println("Connection closed");
					break;
				}
                else {
                    System.out.println("Invalid Choice");
                }
				
				// printing bmi or bmr result as requested by client
				String received = dis.readUTF();
				System.out.println(received);
			}
			
			// closing resources
			scn.close();
			dis.close();
			dos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
