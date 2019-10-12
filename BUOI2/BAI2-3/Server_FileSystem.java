import java.io.*;
import java.net.*;
import java.util.*;
public class Server_FileSystem{
	public static void main(String []args){
		try{
			ServerSocket ss =  new ServerSocket(2109);// tao mot server socket co cong 2109
			System.out.println("Server 2109 xin kinh chao quy khach ! ");
			while(true){
				try{
					Socket s = ss.accept();// lang nghe yeu cau ket noi tu lient
					System.out.println("Co lient :" + s.getInetAddress()+" ket noi ! ");
					Processing_FileSystem pgn = new Processing_FileSystem(s);// truyen socket vua tao cho ham xu ly lay ten
					pgn.start();
				} catch(NullPointerException e){
					System.out.println("Loi khong tao duoc thread");
				}
			}// lap lai qua trinh tren
		} catch(IOException e){
			System.out.print("Loi! khong the tao duoc server");
		}
		//ss.close();
	}
}
