/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.io.*;
import java.net.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) throws IOException{
		String operazione;
		
		Scanner scanner = new Scanner(System.in);
		
		Socket client = new Socket("127.0.0.1", 1235);
		
		DataOutputStream output = 
				new DataOutputStream(client.getOutputStream());
		
		BufferedReader input = 
				new BufferedReader(new
				InputStreamReader(client.getInputStream()));
		
		System.out.println("Inserisci operazione usando gli spazi tra numero/operatore (Esempio: 1 + 1): ");
		operazione = scanner.nextLine();
		
		output.writeBytes(operazione + "\n");
		
		System.out.println("Risultato: " + input.readLine());
		scanner.close();
		client.close();

	}
}
