package sockets.br.com.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.net.Socket;
import java.text.DecimalFormat;

public class ClientSocket {

	protected static Socket clientSocket;
	
	protected static BufferedReader in;
	
	protected static PrintWriter out;
	
	public static void iniciarConexao(String host, int port) throws IOException {
		clientSocket = new Socket(host, port);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		out = new PrintWriter(clientSocket.getOutputStream(), true);
	}
	
	public static void fecharConexao() throws IOException {
		out.close();
		in.close();
		clientSocket.close();
	}
	
	public static String formatarResposta(String resposta) {
		double percentual = Double.parseDouble(resposta.replace("," , "."));
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.DOWN);
		return df.format(percentual);
	}
	
}
