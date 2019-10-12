import java.io.*;
import java.net.*;
import java.util.*;
public class Processing_GetName extends Thread{
	private Socket s;
	public Processing_GetName(Socket s1){
		s = s1;
	}// tao mot ham xay dung co 1 doi so la socket
	public void run(){
		try{
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			String si = "";
			String so = "";
			while(true){	
				si = sc.nextLine();// nhap chuoi tu socket
				if (si.equals("@")) break;// lap lai den khi nhan duoc 1 ki tu @
				so = getName(si);// lay ten trong chuoi
				pw.println(so);// tra ve cho socket tu cuoi cung trong chuoi
				pw.flush();
			}	
			s.close();
		} catch(IOException e){
			System.out.print("Loi xu ly duoc");
		}
	}// tao ham run
	public String getName(String s){
		String [] arrs = s.split(" ");
		int n = arrs.length;
		return arrs[n-1];
	}
}
