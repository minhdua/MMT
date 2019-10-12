import java.io.*;
import java.net.*;
import java.util.*;
public class Lient_NhiPhan {
  public static void main(String []args){
    try{
      Socket s = new Socket("localhost",3232);// Tao socket ket noi den server cong 3232
      System.out.println(">>> Ket noi thanh cong !");
      InputStream is = s.getInputStream();
      OutputStream os = s.getOutputStream();
      Scanner sc = new Scanner(System.in);
      Scanner ssc = new Scanner(is);
      PrintWriter pw = new PrintWriter(os);
      while(true){
          System.out.print(">>> Nhap 1 so tu ban phim: ");
          String number = sc.nextLine();// Nhan mot day so nguyen tu ban phim
          byte b[] = new byte [30];
          pw.println(number);
          pw.flush();// Gui cho server
          if (number.equals("@")) break;
          String result = ssc.nextLine();// Nhan ket qua chuoi nhi phan tu server
          System.out.println(">>> Ket qua la: " + result);// Hien thi ket qua
      }// Nhap chuoi tiep theo de khi gap chuoi @ thi dung
      s.close();
      // dong socket
    }
    catch(IOException e){
      System.out.println(">>> Khong tim thay server!");
    }
  }
}
