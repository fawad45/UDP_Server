/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package udpcommunication;

/**
 *
 * @author fawad
 */
import java.io.*;
import java.net.*;

class UDPCommunication
{
   public static void main(String args[]) throws Exception
      {
         DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            while(true)
               {
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  serverSocket.receive(receivePacket);
                  String sentence = new String( receivePacket.getData());
                  System.out.println("RECEIVED: " + sentence);
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();
                  String capitalizedSentence = sentence.toUpperCase();
                  sendData = capitalizedSentence.getBytes();
                  DatagramPacket sendPacket =
                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  serverSocket.send(sendPacket);
                  sendPacket.setData("gfdgdfgdfg".getBytes());
                  serverSocket.send(sendPacket);
                  sendPacket.setLength(9);
                  sendPacket.setData("gfdgdfgdfg".getBytes());
                  serverSocket.send(sendPacket);
                  sendPacket.setData("gfdgdfgdfg".getBytes());
                  serverSocket.send(sendPacket);
                  sendPacket.setData("gfdgdfgdfg".getBytes());
                  serverSocket.send(sendPacket);
                  sendPacket.setData("break".getBytes());
                  sendPacket.setLength(5);
                  serverSocket.send(sendPacket);
                  
                  receiveData[0] = '\0';
               }
      }
}