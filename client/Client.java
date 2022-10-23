package client;
// Java implementation for a client

// Save file as Client.java

import java.io.*;
import java.net.*;
import java.util.Scanner;

// Client class
public class Client {
	static final int PORT = 5056;

	public static void main(String[] args) throws IOException {
		int height;
		int weight;
		try {
			Scanner scn = new Scanner(System.in);

			// getting localhost ip
			InetAddress ip = InetAddress.getByName("localhost");

			// establish the connection with server port 5056
			Socket s = new Socket(ip, PORT);
			System.out.println("Connect on IP " + ip + " and Port " + PORT);
			// obtaining input and out streams
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());

			// the following loop performs the exchange of
			// information between client and client handler
			while (true) {
				System.out.println(dis.readUTF());
				String tosend = scn.nextLine();
				dos.writeUTF(tosend);

				switch (tosend.toLowerCase()) {
					case "bmi":
						System.out.println(dis.readUTF());
						weight = scn.nextInt();
						dos.writeInt(weight);

						System.out.println(dis.readUTF());
						height = scn.nextInt();
						dos.writeInt(height);
						break;

					case "bmr":
						System.out.println(dis.readUTF());
						weight = scn.nextInt();
						dos.writeInt(weight);

						System.out.println(dis.readUTF());
						height = scn.nextInt();
						dos.writeInt(height);

                    System.out.println(dis.readUTF());
                    int age = scn.nextInt();
                    dos.writeInt(age);
                    
                    System.out.println(dis.readUTF());
                    int gender = scn.nextInt();
                    dos.writeInt(gender);
					break;

					default:
					continue;
                }
				// If client sends exit,close this connection
				// and then break from the while loop
				 if(tosend.toLowerCase().equals("exit"))
				{
					System.out.println("Closing this connection : " + s);
					s.close();
					System.out.println("Connection closed");
					break;
				}
				
				// printing date or time as requested by client
				String received = dis.readUTF();
				System.out.println(received);
			}

			// closing resources

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
