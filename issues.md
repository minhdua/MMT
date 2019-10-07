## DateTime_Server.java:24: error: cannot find symbol DatagramPacket out = new DataramPacket(send_data,length_data,address,port);
- fix syntax
## error: no suitable constructor found for DatagramPacket(byte[],long,InetAddress,int) DatagramPacket out = new DatagramPacket(send_data,length_data,address,port);
- change data type
## error: ';' expected String data = new String(in.getData(),0,in.getLength());
- remove Noise characters above 

## Main method not found in class DateTime_Server, please define the main method as: public static void main(String[] args) or a JavaFX application class must extend javafx.application.Application
-  Addition argument for main function
## java.net.BindException: Permission denied (Bind failed)
- Change port 
- sudo lsof -i -P -n | grep LISTEN
##  java.net.BindException: Address already in use (Bind failed)
- because lient close()



