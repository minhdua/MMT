import java.net.*;
import java.io.*;
import java.util.*;

public class TALK1{
	public static int sandwitch = 64000;
	public static void main(String []args){
		try{
			DatagramSocket ds = new DatagramSocket(2323);
			InetAddress serverIP = InetAddress.getByName(args[0]);
			int serverPort = Integer.parseInt(args[1]);
			Scanner sc = new Scanner(System.in);
			while(true){
				System.out.print("You talk: ");
				String you_talk = sc.nextLine();
				if (you_talk.equals("exit")) break;
				byte []send_messages = you_talk.getBytes();
				DatagramPacket send_packet = new DatagramPacket(send_messages,send_messages.length,serverIP,serverPort);
				ds.send(send_packet);

				byte []receive_messages = new byte[sandwitch];
				DatagramPacket receive_packet = new DatagramPacket(receive_messages,receive_messages.length);
				ds.receive(receive_packet);
				String you_listen = new String(receive_packet.getData(),0,receive_packet.getLength());
				System.out.println(receive_packet.getPort()+" : "+you_listen);
			}
		}
		catch (IOException e){
			System.err.println(e);
		}
	}
}
