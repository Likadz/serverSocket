package serverSockerClase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		try {
			Socket socket=new Socket("127.0.0.1",1234);
			System.out.println("Me he conectado!");
			//leemos lo que escribe el servidor
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String line;				
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//para iniciar la comunicación
			while((line=br.readLine()) != null){
				System.out.println(line);
				bw.write("AGUR! \n");
				bw.flush();
			}
			
			bw.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
