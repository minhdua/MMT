import java.io.*;
import java.net.*;

public class FTP_Server{
	public static void main(String []args){
		try{
			DatagramSocket socket = new DatagramSocket(3110);
			File f = new File("phone1.txt");
			FileInputStream fi = new FileInputStream(f);
			int n = (int) f.length();
			byte []b = new byte[n];
			fi.read(b);
			InetAddress address = InetAddress.getByName("230.0.0.1");
			DatagramPacket sp = new DatagramPacket(b,b.length,address,2110);
			while(true){
				socket.send(sp);
				Thread.sleep(5000);
			}
			//socket.close();
		}
		catch(IOException e){
			
		}
		catch(InterruptedException e){
			System.out.print(e);
		}
	}
	
}