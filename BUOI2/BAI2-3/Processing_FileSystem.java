import java.io.*;
import java.net.*;
import java.util.*;
public class Processing_FileSystem extends Thread{
	private Socket s;
	public Processing_FileSystem(Socket s1){
		s = s1;
	}// tao mot ham xay dung co 1 doi so la socket
	public void run(){
		try{
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			String command = "";
			while(true){
				command = sc.nextLine();// nhan lenh tu lient
				if (command.equals("@")) break;// lap lai den khi nhan duoc ki tu @
				String []params = command.split(" ",2);// tach chuoi ra la 2 phan
				if (params[0].equals("LIST")){// neu phan dau la list thi phan sau la duong dan
					File [] listOfFiles = null;
					int numbers_file=0;
					String filename = "";
					String path =  params[1];//lay ten duong dan tu lient
					//System.out.println(path);
					File dir = new File(path);// kiem tra xem duong dan co ton tai hay khong
					if (!dir.exists()) numbers_file = -2;// neu khong ton tai thi gui n = -2 cho lient
					else if (! dir.isDirectory()) numbers_file = -1; // nguoi lai kiem tra xem duong dan do phai la thu muc hay khong
						                                              // khong phai thi gui ve -1
						 else{
							 listOfFiles = dir.listFiles();
							 numbers_file = listOfFiles.length;
						 }
						//System.out.println(numbers_file);
						pw.println(numbers_file);
						pw.flush();// tra ve so luong file co trong thu muc
					for (int i = 0; i<numbers_file; i++){
						filename = listOfFiles[i].getName();
						//System.out.println(filename);
						pw.println(filename);
						pw.flush();
					}// tra ve lan luoc cac file trong danh sach
				}
				else if (params[0].equals("READ")){// nguoi lai neu phan dau la read thi phai sau la ten file
					int numbers_line=0;
					String []list_line = new String[100];
					String path =  params[1];//lay ten duong dan tu lient
					//System.out.println("path = "+path);
					File filename = new File(path);// kiem tra xem duong dan co ton tai hay khong
					if (!filename.exists()) numbers_line = -2;// neu khong ton tai thi gui n = -2 cho lient
					else if (!filename.isFile()) numbers_line = -3; // nguoi lai kiem tra xem duong dan do phai la thu muc hay khong
						 else{
								FileReader fr = new FileReader(filename);// tao mot file FileReader
								LineNumberReader lnr = new LineNumberReader(fr);// tao mot LineNumberReader
								String s_temp = null;
								while (true){
									 s_temp = lnr.readLine();
									 if (s_temp != null){
										 //System.out.println(s_temp);
										 list_line[numbers_line]=s_temp;
										 numbers_line ++;
									 }
									 else break;
								}// ghi tung dong cua file vao ds chuoi
						 }
						//System.out.println(numbers_line);
						pw.println(numbers_line);
						pw.flush();// tra ve so luong file co trong thu muc
					for (int i = 0; i<numbers_line; i++){
						//System.out.println(list_line[i]);
						pw.println(list_line[i]);
						pw.flush();
					}// tra vec lai tra ve -1
				}
				else {
					pw.println(-4);
					pw.flush();
				}
			}
			s.close();
		} catch(IOException e){
			System.out.print("Loi xu ly duoc");
		}
	}// tao ham run
}
