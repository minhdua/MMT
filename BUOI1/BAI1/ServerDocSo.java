import java.io.*;
import java.net.*;
public class ServerDocSo{
  public static void main(String [] args){
    // Tao mot server Socket
    try{
      ServerSocket ss = new ServerSocket(2828);
      System.out.println(">>> Server DocSo Dang Chay ... ");
      while (true){
        // chap nhan noi ket
        Socket s = ss.accept();
        System.out.println(">>> Thiet bi "+s.getInetAddress()+" Dang noi ket");
        // doc mot ki tu tu Lient
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        int ch;
        while(true){
          try{
            ch = is.read();
            if (ch == -1) break;
            System.out.println(">>> Thiet bi "+s.getInetAddress()+" gui "+ch);
            // xu ly yeu cau 'Lay phan du khi chia cho 5'
            ch = ch % 5;
            // tra ket qua ve Lient
            os.write(ch);
            System.out.print(">>> Ket qua: "+ch);
            // dong Socket
        }catch(IOException e){
            System.out.println(">>> Loi nhap xuat");
        }
      }// while
      System.out.println(s.getInetAddress()+">>> Da ngat ket noi! ");
      s.close();
    }
  }
  catch (IOException e){
    System.out.println("Loi xuat nhap!! ");
  }
  }
}
