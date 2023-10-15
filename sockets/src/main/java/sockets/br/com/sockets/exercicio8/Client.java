package sockets.br.com.sockets.exercicio8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import sockets.br.com.sockets.ClientSocket;

public class Client extends ClientSocket {

	static Locale locale = new Locale.Builder().setLanguage("pt").setRegion("BR").build();
	
	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 12345;

		try {
			iniciarConexao(host, port);
 
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Digite o seu peso atual: ");
			double pesoAtual = Double.parseDouble(userInput.readLine());
			out.println(pesoAtual);
			
			System.out.print("Digite o seu peso desejado: ");
			double pesoDesejado = Double.parseDouble(userInput.readLine());
			out.println(pesoDesejado);
			
            String percentualEliminado = in.readLine();
            System.out.println("Percentual de peso a ser eliminado: " + formatarResposta(percentualEliminado));
			
			fecharConexao();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
