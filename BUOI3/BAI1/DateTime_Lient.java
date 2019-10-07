import java.net.*;
import java.io.*;

public class DateTime_Lient{
	public static void main(String []args){
		try{
			DatagramSocket ds = new DatagramSocket();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				String emptyString = br.readLine();
				byte []send_data = emptyString.getBytes();
				
				if (emptyString.equals("@")) break;				

				InetAddress server = InetAddress.getByName("localhost");
				int port = 2323;
				int len_data = send_data.length;
				DatagramPacket out = new DatagramPacket(send_data,len_data,server,port);
				ds.send(out);
				
				byte []receive_data = new byte[64000];
				DatagramPacket in = new DatagramPacket(receive_data,receive_data.length);
				ds.receive(in);
				String dateTime = new String(in.getData(),0,in.getLength());
				System.out.println("Date time system is: "+dateTime);
			}
			ds.close();
		}
		catch(IOException e){
			System.err.println(e);
		}
	}
}
