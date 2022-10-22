package server;

import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;
// ClientHandler class
class ClientHandler extends Thread
{
	DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
	DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
	final DataInputStream dis;
	final DataOutputStream dos;
	final Socket s;
	

	// Constructor
	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)
	{
		this.s = s;
		this.dis = dis;
		this.dos = dos;
	}

	@Override
	public void run()
	{
		String received;
		String toreturn;
		while (true)
		{
			try {

				// Ask user what he wants
				dos.writeUTF("What do you want?[BMI | BMR]..\n"+
							"Type Exit to terminate connection.");
				
				// receive the answer from client
				received = dis.readUTF().toLowerCase();

				
				if(received.equals("exit"))
				{
					System.out.println("Client " + this.s + " sends exit...");
					System.out.println("Closing this connection.");
					this.s.close();
					System.out.println("Connection closed");
					break;
				}
				
				
				// write on output stream based on the
				// answer from the client
				switch (received) {
				
					case "bmi" :
                    dos.writeUTF("Enter Weight in Kg\n");
                    int weight = dis.readInt();

                    dos.writeUTF("Enter Height in Cm\n");
                        int height = dis.readInt();
                    BMICalculatorBrain bmi = new BMICalculatorBrain(height, weight);
                    dos.writeUTF(bmi.getResult());
						break;
						
					case "bmr" :
                    dos.writeUTF("Enter Weight in Kg\n");
                    weight = dis.readInt();

                    dos.writeUTF("Enter Height in Cm\n");
                        height = dis.readInt();

                    dos.writeUTF("Enter age in years\n");
                        int age = dis.readInt();
                    dos.writeUTF("Enter gender as in Male or Female");
                        String gender = dis.readUTF();
                        BMRCalculatorBrain bmr = new BMRCalculatorBrain(gender, weight, height, age);
                    dos.writeUTF(bmr.getResult());
						break;
						
					default:
						dos.writeUTF("Invalid input");
						break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try
		{
			// closing resources
			this.dis.close();
			this.dos.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
