/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado_playfair;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Cifrado_playfair {

     private static int opt;
    private static String message;
    private static String readytoencrypt;

    public static void main(String[] args) {
        // TODO code application logic here
        InputStreamReader rd = new InputStreamReader(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido, que desea hacer:\n" + "ingrese:\n" + "1. Encriptar mensaje por el metodo PlayFair.\n"
                + "2. Desencriptar el mensaje encriptado por Playfair.\n" + "3. para finalizar el cifrador.\n");
        System.out.println("ingrese su elección: ");
        opt = sc.nextInt();
        switch (opt) {
            case 1:
                System.out.println("ingrese el mensaje a cifrar: \n");
                message = readmessage();
                message = message.replaceAll("\\s","" );
                System.out.println("message: " + message);
              
                 // readytoencrypt = config_message(message);
                //System.out.println(readytoencrypt);
                
                break;
            default:
                break;
        }
    }
    /***
     * funtion that read message with some words.
     * @return 
     */
    private static String readmessage() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

   /***
    * funtiont that clean and prepare message for encript 
    * @param message
    * @return 
    */
    /* private static String config_message(String message) {
        String[] messagec;
        String encript_message="";
        messagec = message.split(" ");
        
    
        
        for (int i = 0; i < messagec.length; i++) {
           
            encript_message += encript_message.concat(messagec[i]);
          
        }
        
        System.out.println(encript_message);
        return message;
    }*/
    
}
