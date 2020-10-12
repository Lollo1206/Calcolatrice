/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatrice;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

		public static void main(String[] args) throws IOException {
			float num1, num2;
			char operazione;
			Calcolatrice calcolatrice;
			
			
			ServerSocket server = new ServerSocket(1235);
		
			
			while(true) {
				Socket client = server.accept();
				
				BufferedReader input = 
						new BufferedReader(new
						InputStreamReader(client.getInputStream()));
				
				DataOutputStream output = 
						new DataOutputStream(client.getOutputStream());
				
				String[] nums = input.readLine().split(" ");
				num1 = Float.parseFloat(nums[0]);
				num2 = Float.parseFloat(nums[2]);
				operazione = nums[1].charAt(0);
				calcolatrice = new Calcolatrice(num1, num2);
				
				switch(operazione) {
					case '+' : {
						output.writeBytes(String.valueOf(calcolatrice.addizione()) + "\n");
						break;
					}
					case '-' : {
						output.writeBytes(String.valueOf(calcolatrice.sottrazione()) + "\n");
						break;
					}
					case '/' : {
						output.writeBytes(String.valueOf(calcolatrice.divisione()) + "\n");
						break;
					}
					case '*' : {
						output.writeBytes(String.valueOf(calcolatrice.moltiplicazione()) + "\n");
						break;
					}
					default : {
						output.writeBytes("Errore" + "\n");
						break;
					}
				}
				

				
				
			}
			
		}
}

