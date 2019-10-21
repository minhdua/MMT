import java.io.*;
import java.net.*;
  
public class BrowserHTML {
    public static void main(String[] args) {
          
        String hostName = "elcit.ctu.edu.vn";
        int portNumber = 80;
		
  
        try {
			//URL weburl = new URL(hostName);
			//Proxy webProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("http://cache-st.ctu.edu.vn", 3128));
			//HttpURLConnection webProxyConnection  = (HttpURLConnection) weburl.openConnection(webProxy);
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out =
                new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            //out.println("GET / HTTP/1.1\nHost: ctu.edu.vn\n\n");
			out.println("GET /somedir/page.html HTTP/1.0\n\n");
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        } 
    }
}