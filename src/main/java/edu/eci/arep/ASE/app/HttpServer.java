package edu.eci.arep.ASE.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public static void main(String[] args) throws IOException {

        HttpConnection httpConnection = new HttpConnection();
        
        ServerSocket serverSocket = null;
        try { 
            serverSocket = new ServerSocket(36000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        boolean running = true;

        while(running){

            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            
            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;

            String firstLine = null;
            while ((inputLine = in.readLine()) != null) {
                if(firstLine == null){
                    firstLine = inputLine;
                }

                if (!in.ready()) {break; }
            }

            if(firstLine==null){
                continue;
            }

            ReadFile readFile = new ReadFile();
            String path = firstLine.split(" ")[1];

            if(path.startsWith("/calculadora")){
                readFile.leerArchivo(clientSocket, httpConnection, path.split("/")[2]);
            }else if(path.startsWith("/")){
                readFile.leerArchivo(clientSocket, httpConnection, path);
            }
         
            in.close(); 
            clientSocket.close(); 
            serverSocket.close(); 
        }
    }
    
}
