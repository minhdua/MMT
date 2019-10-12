import java.io.*;
import java.net.*;
import java.util.*;
public class Server_NhiPhan{
  public static void main(String []args){
    try{
        ServerSocket ss = new ServerSocket(3232);// Tao mot server socket
        System.out.println(">>> Server Nhi Phan da duoc tao ... ");
          while(true){
            Socket s = ss.accept();// chap nhap 1 noi ket
            System.out.println(">>> Thiet bi "+s.getInetAddress()+" da ket noi! ");
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            Scanner sc = new Scanner(is);
            PrintWriter pw = new PrintWriter(os);
            byte b[] = new byte[30];
            while(true){
                String number_string = sc.nextLine();// lay yeu cau tu noi ket
                System.out.println(">>> Thiet bi" + s.getInetAddress() + "Da gui chuoi so :" + number_string);
                if (number_string.equals("@")) break;
                try{
                  int number_decimal = Integer.parseInt(number_string);// xu ly yeu cau noi ket (doi sang chuoi nhi phan)
                  String result = Integer.toBinaryString(number_decimal);
                  pw.println("\u001B[32m" + result + "\u001B[0m");//Tra ve ket qua
                  pw.flush();
                }catch(NumberFormatException e){
                  System.out.println(">>> Loi: sai dinh dang so");
                  pw.println("\u001B[31m Loi: sai dinh dang so \u001B[0m");//Tra ve ket qua
                  pw.flush();
                }
            }// nhan yeu cau tiep theo den khi nhan duoc ki tu @
            System.out.println(">>> Thiet bi " + s.getInetAddress() + " da ngat ket noi !");
            s.close();// dong noi ket
          }// lang nghe noi ket tiep theo
      }
      catch(IOException e){
        System.out.println(">>> Khong the tao Server! ");
      }
      //ss.close();
  }
}
