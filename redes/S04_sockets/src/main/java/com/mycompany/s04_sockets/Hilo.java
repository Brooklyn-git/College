/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.s04_sockets;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author brooklyn
 */
public class Hilo implements Runnable {
    private Socket cliente;
    
    
    public Hilo (Socket cliente){
        this.cliente = cliente;
    }
    
    public void run(){
        try{
            String hilo = Thread.currentThread().getName();
            System.out.println(hilo + " atiende el cliente " + cliente.getPort());
            
            Scanner entrada = new Scanner(cliente.getInputStream());
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            
            while (entrada.hasNextLine()){
                String mensaje = entrada.nextLine();
                System.out.println(hilo + "-cliente " + cliente.getPort() + " -escribio: " + mensaje);
                salida.println("ECO>"+ mensaje);
            }
            
            System.out.println(hilo + " termino con el cliente del puerto: " + cliente.getPort());
        } catch (Exception e){
            System.out.println("Error con un cliente: " + e.getMessage());
        } finally {
            try {
                cliente.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar el cliente: " + e.getMessage());
            }
        }
    }
}
