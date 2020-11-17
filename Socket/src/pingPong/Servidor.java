package pingPong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1234); //el puerto
			System.out.println("server iniciado");
			Socket s = server.accept();	//el server acepta las conexiones del cliente
			
			//System.out.println("cliente conectado! Puerto:" + s.getPort());
			
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//para iniciar la comunicación
			
			
			bw.write("PING!\n");//mensaje para el cliente
			bw.flush();
			
			//leemos lo que escribe el cliente
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String line;
			while((line=br.readLine()) != null){
				System.out.println(line);
				System.out.println("PING");
				bw.write("PING!\n");//mensaje para el cliente
				bw.flush();
			}
			
			bw.close();//cerramos el writer (OBLIGATORIO!!)
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
