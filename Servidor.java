import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		int porta = 3001;
		
		try {
			
			ServerSocket tmpsocket = new ServerSocket(porta);
			System.out.println("Aguardando cliente");
			Socket socket = tmpsocket.accept();
			
			InputStreamReader entrada = new InputStreamReader(socket.getInputStream());
			BufferedReader le = new BufferedReader(entrada);
			String resposta = le.readLine();
			System.out.println("Cliente: " + resposta);
			socket.close();
		
			
		} catch (BindException e) {
			System.out.println("Endereco em uso");
		
		} catch (Exception e) {
			System.out.println("Erro " + e);
		}
	}
}
