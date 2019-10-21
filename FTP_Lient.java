import java.io.*;
import java.net.*;
import java.util.*;

public class FTP_Lient{
	public static void main(String []agrs){
		try{
			MulticastSocket socket = new MulticastSocket(2110);
			InetAddress address = InetAddress.getByName("230.0.0.1");
			socket.joinGroup(address);
			
			byte []b = new byte[64000];
			DatagramPacket rp = new DatagramPacket(b,b.length);
			int n=0;
			Scanner sc = new Scanner(System.in);
			System.out.print("nhap vao ten file: ");
			String name = sc.nextLine();
			while(true){
				socket.receive(rp);
				//Time time = new Time();
				String content = new String(rp.getData(),0,rp.getLength());
				//System.out.println(time.toString());
				FileOutputStream fo = new FileOuputStream(filename);
				System.out.println(content);
				
			}
			//socket.leaveGroup(address);
			//socket.close();
		}
		catch(IOException e){
			
		}
		// Tao socket theo dang Multicast tren cong 2110
		// Tham gia vao nhom dia chi 230.0.0.1
		// Nhan goi tin tu server
		// Roi khoi nhom dia chi lop DATA_CONVERSION
		
		
	}
	
}