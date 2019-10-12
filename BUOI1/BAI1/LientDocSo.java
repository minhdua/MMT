import java.net.Socket;
import java.io.*;
import java.util.*;
public class LientDocSo{
	public static void main(String[] args){
			// tao 1 socket
			try {
				Socket s = new Socket("localhost",2828);
				System.out.println(">> Lient: da noi ket den Server! ");
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				Scanner sc = new Scanner(System.in);
				// nhan 1 so tu ban phim
				while (true){
					System.out.print(">>> cho mot so tu ban phim! ");
					try{
						int ch = sc.nextInt();
						if (ch == -1 ) break;
						System.out.println(">>> so da nhap: "+ch);
						// gui 1 ki tu toi server
						os.write(ch);
						// nhan 1 ki tu tu server
						ch = is.read();
						System.out.println(">>> ket qua: "+ch);
				}
				catch (InputMismatchException e){
					System.out.println(">>> Khong phai la so! ");
					break;
				}
			}
				s.close();
				System.out.println(">>> Da ngat ket noi voi Server! ");
		}
		catch(IOException e){
				System.out.println(">>> khong tao duoc Socket");
		}
	}
}
