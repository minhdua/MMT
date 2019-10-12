import java.io.*;
import java.net.*;
public class Server_DocSo {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String []args){
      try {

        ServerSocket ss = new ServerSocket(3333);// Tao mot Server socket
        System.out.println("Server da duoc khoi tao");
        while(true){
          try{
            Socket s  = ss.accept();// Chap nhan noi Ket
            System.out.println(">>> Thiet bi: "+s.getInetAddress()+" da ket noi! ");
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            while(true){
              int ch = is.read();// Nhap yeu cau thu Lient
              if (ch == '@') break;
              String result = null;
              switch (ch) {
                case '1': {
                          result = "Mot";
                          break;
                          }
                case '2': {
                          result = "Hai";
                          break;
                }
                case '3': {
                          result = "Ba";
                          break;
                }case '4': {
                          result = "Bon";
                          break;
                }
                case '5': {
                          result = "Nam";
                          break;
                }
                case '6': {
                          result = "Sau";
                          break;
                }
                case '7': {
                          result = "Bay";
                          break;
                }
                case '8': {
                          result = "Tam";
                          break;
                }
                case '9': {
                          result = "Chin";
                          break;
                }
                default : result = "Khong phai la so";
              }// Xu ly yeu cau
              byte[] b = new byte[30];
              b = result.getBytes();
              os.write(b);// Tra ve ket qua cho Lient
            }// Tiep tuc nhan yeu cau den khi Lient yeu cau ngat ket noi
            s.close();//dong socket
        }
        catch (IOException e){
          System.out.print(ANSI_RED + ">>> Loi SerVer !" + ANSI_RESET);
        }
      }// Lang nghe Lient tiep theo
        //ss.close();//dong Server
      }catch(IOException e){
        System.out.println(ANSI_RED + ">>> Loi Khong the tao server !" + ANSI_RESET);
      }
  }
}
