/**
 * @author (Ebube Abara)
 */
import java.io.*;
import java.net.*;
public class EbubeUDPServer
{
    public static void main(String args[]) throws Exception
    {
        DatagramSocket serverDatagramSocket = new DatagramSocket(20002);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true)
        {
              DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
              serverDatagramSocket.receive(receivePacket);
              String inputData = new String( receivePacket.getData());
              System.out.println("RECEIVED: " + inputData);
              InetAddress IPAddress = receivePacket.getAddress();
              int port = receivePacket.getPort();
              String capitalizedSentence = inputData.toUpperCase();
              sendData = capitalizedSentence.getBytes();
              DatagramPacket sendPacket =
              new DatagramPacket(sendData, sendData.length, IPAddress, port);
              serverDatagramSocket.send(sendPacket);
        }
        }
}
