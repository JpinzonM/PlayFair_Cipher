/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado_playfair;

import java.util.Scanner;

/**
 *
 * @author apinzonj
 */
public class PlayFair_Cipher {

    /**
     * @param args the command line arguments
     */
    private String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "K", "L",
        "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static String message;
    private static String encript_message;
    private static String Desencrypt_message;
    private static int opt;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Bienvenido, que desea hacer:\n" + "ingrese:\n" + "1. Encriptar mensaje por el metodo PlayFair.\n"
                + "2. Desencriptar el mensaje encriptado por Playfair.\n" + "3. para finalizar el cifrador.\n");
        opt = sc.nextInt();
        System.out.println("ingrese su elección: "+ opt);
        
        while (opt != 3) {

            switch (opt) {
                case 1:
                    System.out.println("Ingrese el mensaje a Cifrar: \n");
                    message = sc.nextLine(); 
                   
                    break;
                case 2:
                    break;
                default:
                    break;
            }

        }

    }

    

}

