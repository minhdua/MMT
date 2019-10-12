import java.io.*;
import java.net.*;
public class Lient_DocSo {
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RESET = "\u001B[0m";
  final int MAX_BYTE = 30;
  public static void main(String []args){
    try {
      Socket s = new Socket("localhost",3333);// tao mot Socket ket noi toi Server_Docso cong 3333
      InputStream is = s.getInputStream();
      OutputStream os = s.getOutputStream();
      while(true){
        System.out.print(">>> Nhap vao 1 ki tu so : ");
        int ch = System.in.read();// doc 1 ki tu tu ban phim
        System.in.skip(2);
        if (ch=='@') break;
        os.write(ch);// gui ki tu qua Socket
        byte[] b = new byte[30];
        int n=10;
        n = is.read(b);// lay mot chuoi byte tu Socket
        System.out.println(">>> Ket qua: " + ANSI_GREEN+ new String(b,0,n)+ANSI_RESET);// hien thi
      }
      s.close();// dong socket
    }
    catch(IOException e){

      System.out.println(ANSI_RED+">>> Loi xuat nhap: "+ANSI_RESET);

    }
    catch (NullPointerException e) {
      System.out.println(ANSI_RED+">>> Du lieu khong phu hop! "+ANSI_RESET);
    }
  }
}
