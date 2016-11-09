/**
 * @author (Ebube Abara)
 */
import java.io.*;
import java.net.*;
public class EbubeUDPClient
{
    public static void main(String args[]) throws Exception
   {
      BufferedReader inFromEbubeUser =
         new BufferedReader(new InputStreamReader(System.in));
      
      DatagramSocket clientDatagramSocket = new DatagramSocket();
      InetAddress IPAddress = InetAddress.getByName("localhost");
      
      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];
      String sentence = inFromEbubeUser.readLine();
      sendData = sentence.getBytes();
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 20002);
      clientDatagramSocket.send(sendPacket);
      
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientDatagramSocket.receive(receivePacket);
      
      String modifiedSentence = new String(receivePacket.getData());
      System.out.println("FROM EBUBE'S UDP SERVER:" + modifiedSentence);
      clientDatagramSocket.close();
   }
}
