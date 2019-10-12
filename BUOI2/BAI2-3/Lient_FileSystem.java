import java.io.*;
import java.net.*;
import java.util.*;
public class Lient_FileSystem{
	public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RESET = "\u001B[0m";
	public static void main(String []args){
		try{
			Socket s = new Socket("localhost",2109);// tao mot socket ket noi qua cong 2109
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(System.in);
			Scanner scs = new Scanner(is);
			PrintWriter wr = new PrintWriter(os);
			String command = "";
			String content = "";
			int total = 0;
			while (true){
				System.out.print("Nhap lenh cua ban : ");
				command = sc.nextLine();// nhap lenh tu ban phim
				wr.println(command);// gui lenh cho server
				wr.flush();
				if (command.equals("@")) break;
				total = scs.nextInt();// nhap so nguyen tu server
				scs.skip("\n");
				if (total == -2) System.out.println(ANSI_RED+"Duong Dan Khong Ton tai! "+ANSI_RESET);// neu gia tri la -2 thi thong bao la Thu muc khong ton tai
				else if (total == -1) System.out.println(ANSI_RED+"Khong phai la thu muc! "+ANSI_RESET);// neu gia tri la -1 thi thong bao la file
						else if (total == -3 ) System.out.println(ANSI_RED+"Khong phai tap tin! "+ANSI_RESET);
									else if (total == -4 ) System.out.println(ANSI_RED+"Lenh khong ton tai! vui long chon (LIST,READ)"+ANSI_RESET);
												else {
													System.out.println("Tong so : "+total);
													for (int i =0 ; i<total; i ++){
														content = scs.nextLine();// lay 1 ten tu server
														System.out.println(ANSI_GREEN+content+" "+ANSI_RESET);// in ra man hinh
													}
													// in ten cac file tren moi dong
												}// nguoc lai

			}// lap lai den khi nhap duoc chuoi chi cua @
			s.close();
		}
		catch(IOException e){
			System.out.print("Loi! vui long kiem tra lai! ");
		}
	}

}
