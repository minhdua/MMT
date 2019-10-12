import java.net.*;
import java.io.*;

public class SystemFile_Lient{
	public static void main(String []args){
		
		try{
			DatagramSocket ds = new DatagramSocket();			

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Nhap lenh tu ban phim! ");
			String command = br.readLine();
			byte []send_data = command.getBytes();
			InetAddress serverIP = InetAddress.getByName(args[0]);
			int serverPort = Integer.parseInt(args[1]);
			DatagramPacket send_packet = new DatagramPacket(send_data,send_data.length,serverIP,serverPort);
			ds.send(send_packet);

			byte []receive_data = new byte[64000];
			DatagramPacket receive_packet = new DatagramPacket(receive_data,receive_data.length);
			ds.receive(receive_packet);
			if (receive_packet.getLength() > 0){
				System.out.print("You input file name for save,please! : "); 
				String fileName = br.readLine();
				FileOutputStream fo = new FileOutputStream(fileName);
				fo.write(receive_packet.getData());
				fo.close();
			}
			else System.out.println("Khong tim thay file hoac file yeu cau qua lon! ");
			ds.close();
		}
		catch (IOException e){
			System.err.println(e);
		}
		
		
	}
}
