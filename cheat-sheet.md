## Convert data type

-**toString()**: convert to string
-**Integer.valueOf(String).intValue() or Integer.parseInt(String)** 
-**String.getBytes()**: convert to bytes from string

##  String

-**import java.lang.Object**:
- **String(""), String(char[]),String(),String(byte[]),String(byte[],int,int)**
-**getByte()**: Encodes this String into a sequence of byte using the platform's default charset, storing the result into a new byte array.
-**isEmpty()**: Returns true if , and only if, length is 0
-**length()**: return the length of this string
-**replaceAll(String regex, String replacement)**:Replaces each substring of this string that matches the given regular expression with the given replacement.
- **replaceFirst(String regex, String replacement)**:Replaces the first substring of this string that matches the given regular expression with the given replacement.
- **split(String regex),split(String regex, int limit)**
- **substring(int beginIndex), substring(int beginIndex, int endIndex)**
- **toLowerCase()**
- **toUpperCase()**
- **trim()**

## Datagram
- **DatagramSocket()**: dynamic port, DatagramSocket(int port)**: static port
- **DatagramPacket(data,length data,Address,port)**: packet send
- **DatagramPacket(data,length data)**: packet receive

## InetAddress
- **java.net.InetAddress**
- **getAddress()**: Returns the raw IP address of this InetAddress object.
- **getHostName()**: Gets the host name for this IP address.
- **getAllByName(String host)**: Given the name of a host, returns an array of its IP addresses, based on the configured name service on the system.
- **getByName(String host)**: Determines the IP address of a host, given the host's name.

##  Socket
- **import java.net.Socket**
- **SocketExcetion,UnknowHostExcetion,IOException,NullPointerException**
- **Socket(InetAddress address, int port)**: Creates a stream socket and connects it to the specified port number at the specified IP address.
- **bind(SocketAddress bindpoint)**: Binds the socket to a local address.
- **close()**: Closes this socket.
- **getInetAddress()**: Returns the address to which the socket is connected.
- **getInputStream()**: Returns an input stream for this socket.
- **getLocalAddress()**: Gets the local address to which the socket is bound.
- **getLocalPort()**: Returns the local port number to which this socket is boun
- **getOutputStream()**: Returns an output stream for this socket.
- **getPort()**: Returns the remote port number to which this socket is connected.
- **setSoTimeout(int timeout)**: Enable/disable SO_TIMEOUT with the specified timeout, in milliseconds.

##  Server Socket
- **import java.net.ServerSocket**
- **ServerSocket(),ServerSocket(int port)**
- **accept()**: Listens for a connection to be made to this socket and accepts it.
- **close()**: Closes this socket.
- **getInetAddress()**: Returns the local address of this server socket.
- **getLocalPort()**: Returns the port number on which this socket is listening.
- **getSoTimeout()**: Retrieve setting for SO_TIMEOUT.
- **setSoTimeout(int timeout)**: Enable/disable SO_TIMEOUT with the specified timeout, in milliseconds.

##  System
- **Sysem.out**
- **System.in**
- **System.err**

##  InputStream
- **import java.lang.Object**
- **IOExeption**
- **InputStream**: abstract class
- **read()**: reads the next byte of data from the input stream
- **read(byte[] b)**: reads some number of bytes from the input stream and  store them into the buffer array b
- **read(byte[] b, int off, int len)**: Reads up to len bytes of data from the input stream in to the buffer array b
- **skip (long n)**: Skips over and discards n bytes of data fro this input stream

## OutputStream
- **import java.lang.Object**
- **IOExeption**
- **write(int b)**: writes the specified byte to this output stream
- **write(byte [] b, int off, int len)**: Writes len bytes from the specified byte array starting at offset off to this output stream.
- **write(byte[] b)**: Writes b.length bytes from the specified byte array to this output stream.
- **flush()**: Flushes this output stream and forces any buffered output bytes to be written out.

##  Scanner
* **import java.util.Scanner**
- **Scanner(stream)**
- **nextByte()**: reads a byte value from the user
- **nextFloat()**: reads a float value from the user
- **nextInt()**: reads a int value from the user
- **nextLine()**: reads a String value from the user
- **nextLong()**: reads a long value from the user

##  PrintWriter
- **import java.oi.PrintWriter**
- **PrintWriter(stream)**
- **flush()**: Flushes the stream.
- **print()**:
- **println()**: boolean,char,double,float,string,int...
- **write()**:Writes an array of characters. Writes a string.

##  File
* import java.io.File
- **IOException**
- **File(String pathname)**:Creates a new File instance by converting the given pathname string into an abstract pathname.
- **exists()**: Test whether the file exists
- **length()**: Return the size of the file in bytes
- **list()**: Return an array of the files in the directory
- **mkdir()**: Creates a directory
- **getName()**: Returns the name of the file or directory denoted by this abstract pathname.
- **isFile()**: Tests whether the file denoted by this abstract pathname is a normal file.
- **listFiles()** : Returns an array of abstract pathnames denoting the files in the directory denoted by this abstract pathname.
## FileReader
- **import java.io.Reader**
- **FileReader(File file)** : Creates a new FileReader, given the File to read from.
- **FileReader(String fileName)**: Creates a new FileReader, given the name of the file to read from.
- **read()**: Reads a single character.
- **read(char[] cbuf, int offset,int length)**:Reads characters into a portion of an array.
- **skip(long n)**:Skips characters. This method will block until some characters are available, an I/O error occurs, or the end of the stream is reached.
##  FileWriter
- **import java.io.FileWriter**
- **IOExeption**
- **FileWriter(File file), FileWriter(String fileName)**: Constructs a FileWriter object given a file name.
- **FileWriter(String fileName, boolean append)**: Constructs a FileWriter object given a file name with a boolean indicating whether or not to append the data written
- **FileWriter.write(String str,int off,int len)**: Writes a portion of a string.
- **FileWriter.close()**:Closes the stream, flushing it first
- **flush()**:Flushes the stream.
## FileInputStream
- **java.io.InputStream**
- **FileInputStream(File file)**: Creates a FileInputStream by opening a connection to an actual file, the file named by the File object file in the file system.
- **FileInputStream(String name)**: Creates a FileInputStream by opening a connection to an actual file, the file named by the path name name in the file system.
- **close()**: Closes this file input stream and releases any system resources associated with the stream.
- **read()**: Reads a byte of data from this input stream.
- **read(byte[] b)**: Reads up to b.length bytes of data from this input stream into an array of bytes.
- **read(byte[] b, int off, int len)**: Reads up to len bytes of data from this input stream into an array of bytes.
- **skip(long n)**: Skips over and discards n bytes of data from the input stream.
## FileOutputStream
- **java.io.OutputStream**
- **FileOutputStream(File file)**: Creates a file output stream to write to the file represented by the specified File object.
- **FileOutputStream(String name)**: Creates a file output stream to write to the file with the specified name.
- **FileOutputStream(String name, boolean append)**: Creates a file output stream to write to the file with the specified name.
- **close()**: Closes this file output stream and releases any system resources associated with this stream.
- **write(byte[] b)**: Writes b.length bytes from the specified byte array to this file output stream.
- **write(byte[] b, int off, int len)**: Writes len bytes from the specified byte array starting at offset off to this file output stream.
- **write(int b)**: Writes the specified byte to this file output stream.
##  DatagramSocket
- **import java.net.DatagramSocket**
- **DatagramSocket()**: Constructs a datagram socket and binds it to any available port on the local host machine.
- **DatagramSocket(int port)**: Constructs a datagram socket and binds it to the specified port on the local host machine.
- **close()**: Closes this datagram socket.
- **receive(DatagramPacket p)**: Receives a datagram packet from this socket.
- **send(DatagramPacket p)**: Sends a datagram packet from this socket.

##  DatagramPacket
- **import java.net.DatagramPacket**
- **DatagramPacket(byte[] buf, int length)**: Constructs a DatagramPacket for receiving packets of length length.
- **DatagramPacket(byte[] buf, int length, InetAddress address, int port)**: Constructs a datagram packet for sending packets of length length to the specified port number on the specified host.
- **getAddress()**: Returns the IP address of the machine to which this datagram is being sent or from which the datagram was receive
- **getData()**: Returns the data buffer.
- **getLength()**: Returns the length of the data to be sent or the length of the data received
- **getPort()**: Returns the port number on the remote host to which this datagram is being sent or from which the datagram was received.
- **setAddress(InetAddress iaddr)**: Sets the IP address of the machine to which this datagram is being sent.
- **setData(byte[] buf)**: Set the data buffer for this packet.
- **setData(byte[] buf, int offset, int length)**: Set the data buffer for this packet.
- **setLength(int length)**: Set the length for this packet.
- **setPort(int iport)**: Sets the port number on the remote host to which this datagram is being sent.

##  DateTimeFormatter
- **import java.time.format.DateTimeFormatter**
- **import java.time.LocalDateTime**
- **DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")**
- **LocalDateTime now  LocalDateTime.now();**
- **dtf.format(now)**

## BufferedReader
- **java.io.Reader**
- **BufferedReader(Reader in)**: Creates a buffering character-input stream that uses a default-sized input buffer.
- **BufferedReader(Reader in, in sz)**:Creates a buffering character-input stream that uses an input buffer of the specified size.
- **close()**:Closes the stream and releases any system resources associated with it.
- **line()**:Returns a Stream, the elements of which are lines read from this BufferedReader.
- **read()**:Reads a single character.
- **readLine()**:Reads a line of text.
- **skip(long n)**: Skips characters.

## OutputStreamWriter
- **java.io.Writer**
- **BufferedWriter(Writer out)** :Creates a buffered character-output stream that uses a default-sized output buffer.
- **BufferedWriter(Writer out, int sz)**: Creates a new buffered character-output stream that uses an output buffer of the given size.
- **close()**:Close
- **flush()**: Flushes the stream.s the stream, flushing it first.
- **newLine()**: Writes a line separator.
- **write(int c)**: Writes a single character.
- **write(String s, int off, int len)**: Writes a portion of a String.
## InputStreamReader
- **java.io.Reader**
- **InputStreamReader(InputStream in)**: Creates an InputStreamReader that uses the default charset.
- **close()**: Closes the stream and releases any system resources associated with it.
- **read()**: Reads a single character.
- **ready()**: Tells whether this stream is ready to be read.
## OutputStreamWriter
- **java.io.Writer**
- **OutputStreamWriter(OutputStream out)**: Creates an OutputStreamWriter that uses the default character encoding.
- **close()**: Closes the stream, flushing it first.
- **flush()**:  Flushes the stream.
- **write(String str, int off, int len)**: Writes a portion of a string.


