import java.net.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class DateTime_Server{
	public static void main(String []args){
		try{
			DatagramSocket ds = new DatagramSocket(2323);
			while(true){

				byte []receive_data = new byte[64000];
				DatagramPacket in = new DatagramPacket(receive_data,receive_data.length);
				ds.receive(in);

				String data = new String(in.getData(),0,in.getLength());
				if (data.equals("")){
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					String dateTime = dtf.format(now);
					byte []send_data = dateTime.getBytes();
					InetAddress address = in.getAddress();
					int port = in.getPort();
					int length_data = send_data.length;
					DatagramPacket out = new DatagramPacket(send_data,length_data,address,port);
					ds.send(out);
				}
			}

		}
		catch(IOException e){
			System.err.println(e);
		}
		
	}
}


