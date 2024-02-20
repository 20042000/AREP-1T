package edu.eci.arep.ASE.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class ReadFile {

    public void leerArchivo(Socket clientSocket, HttpConnection httpConnection, String path) throws IOException{
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        String outputLine;

        out.println("HTTP/1.1 200 OK\r\n");
        out.println("Content-Type: text/html\r\n");
        out.println("\r\n");

        File file = new File("src/main/resources/index.html");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        while ((outputLine = bufferedReader.readLine()) != null) {
            out.println(outputLine);
            out.println("\n");
        }

        out.println(outputLine);
        out.close();
        bufferedReader.close();
        
    }

    public void archivoNoEncontrado(Socket clientSocket, HttpConnection httpConnection, String path) throws IOException{

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        String outputLine = "HTTP/1.1 404 NOT FOUND\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Archivo no encontrado</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>404 NOT FOUND</h1>\n"
                + "</body>\n"
                + "</html>\n";
        out.println(outputLine);
        out.close();
    }
    
}
