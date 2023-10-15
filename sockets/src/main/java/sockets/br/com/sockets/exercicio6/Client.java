package sockets.br.com.sockets.exercicio6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Locale;

import sockets.br.com.sockets.ClientSocket;

public class Client extends ClientSocket {

	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 12345;

		try {
			iniciarConexao(host, port);
 
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Digite o total das despesas no restaurante: ");
			double despesas = Double.parseDouble(userInput.readLine());

			out.println(despesas);

			String resposta = in.readLine();
			double valorComGorjeta = Double.parseDouble(resposta);
			NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("pt").setRegion("BR").build());
			System.out.println("O valor total a ser pago com gorjeta: " + formatter.format(valorComGorjeta));
			
			fecharConexao();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
