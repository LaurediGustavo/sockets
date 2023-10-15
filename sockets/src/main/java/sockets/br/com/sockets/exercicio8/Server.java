package sockets.br.com.sockets.exercicio8;

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
			
			double pesoAtual = Double.parseDouble(in.readLine());
            double pesoDesejado = Double.parseDouble(in.readLine());
			
            double percentualEliminado = ((pesoAtual - pesoDesejado) / pesoAtual) * 100;

            out.println(percentualEliminado);
            
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
