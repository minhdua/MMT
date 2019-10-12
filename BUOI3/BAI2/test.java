import java.io.*;

public class test{
	public static void main(String []args){
		try{
			String filename = "test.txt";
			FileOutputStream fo = new FileOutputStream(filename);
			String str = "Hello World!  abc";
			byte []b = str.getBytes();
			fo.write(b);
			fo.close();
		}
		catch(IOException e){
			System.err.print(e);
		}
	}
}
