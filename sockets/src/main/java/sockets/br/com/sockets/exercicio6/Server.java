package sockets.br.com.sockets.exercicio6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			Socket clientSocket = serverSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			
			double despesas = Double.parseDouble(in.readLine());
            double valorComGorjeta = despesas * 1.10;
			
            out.println(valorComGorjeta);
            
            in.close();
			out.close();
			clientSocket.close();
			serverSocket.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
