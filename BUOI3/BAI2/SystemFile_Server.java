import java.io.*;
import java.net.*;

public class SystemFile_Server{
	public static void main(String []args){
		try{
			DatagramSocket ds = new DatagramSocket(2020);
			
			while(true){
				byte []receive_data = new byte[64000];
				DatagramPacket receive_packet = new DatagramPacket(receive_data,receive_data.length);
				ds.receive(receive_packet);

				String command = new String(receive_packet.getData(),0,receive_packet.getLength());
				String []parsers = command.split(" ",2);
				int n = 0;
				byte []send_data = new byte[64000];
				if (parsers[0].equals("READUDP")){
					File f = new File(parsers[1]);
					if (f.exists() && f.isFile() && f.length()<=64000){
						FileInputStream fi = new FileInputStream(f);
						n = fi.read(send_data);
						fi.close();
					}
				}

				DatagramPacket send_packet = new DatagramPacket(send_data, n, receive_packet.getAddress(), receive_packet.getPort());
				ds.send(send_packet);
			}
		}
		catch(IOException e){
			System.err.println(e);
		}
	}
}
