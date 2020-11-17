package serverSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args)  {
		
		try {
			ServerSocket server = new ServerSocket(1234);
			System.out.println("server iniciado");
			Socket s = server.accept();		
			
			OutputStream ;
			System.out.println("cliente conectado! " + s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
