/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.s04_sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author brooklyn
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("conectando al puerto " + socket.getPort()
                + " desde mi puerto " + socket.getLocalPort());
        
        Scanner entrada = new Scanner(socket.getInputStream());
        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
        
        salida.println("hola");
        String respuesta = entrada.nextLine();
        System.out.println(""+respuesta);
        
        socket.close();
    }
    
}
