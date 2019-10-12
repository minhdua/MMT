import java.io.*;
import java.net.*;
import java.util.*;
public class Lient_GetName{
	public static void main(String []args){
		try{
			Socket s = new Socket("localhost",2109);// tao mot socket ket noi qua cong 2109
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(System.in);
			Scanner scs = new Scanner(is);
			PrintWriter wr = new PrintWriter(os);
			String si = "";
			String so = "";
			while (true){
				System.out.print("Nhap ho va ten cua ban : ");
				si = sc.nextLine();// nhap mot chuoi tu ban phim
				wr.println(si);// gui chuoi vua nhap cho server
				wr.flush();
				if (si.equals("@")) break;
				so = scs.nextLine();// lay chuoi tu server
				System.out.println("Ten cua ban la : "+ so);// hien thi ra man hinh
			}// lap lai den khi nhap duoc chuoi chi cua @
			s.close();
		}
		catch(IOException e){
			System.out.print("Loi! vui long kiem tra lai! ");
		}
	}
	
}