/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado_playfair;

import java.util.Scanner;
import javax.swing.text.Keymap;

/**
 *
 * @author Daniel
 */
public class Cifrado_playfair {

    private static int opt;
    private static String message;
    private static final char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'y', 'Z'};
    private static char[][] KeyMat = new char[5][5];

    /**
     * *
     * Method that creat a random Matrix key
     *
     * @param abecedario
     * @return
     */
    private static char[][] createMatKey(char[] abecedario) {
        int randompos = (int) (Math.random()*25);
        int[] pos_abc = new int[25];
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                randompos = (int) (Math.random() * 25);
                
                KeyMat[i][j] = alfabeto[randompos];
            }
        }
        return KeyMat;
    }

    /**
     * 
     * funtion that read message with some words.
     *
     * @return
     */
    private static String readmessage() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     *funtion that print on console log a matrix of string
     * 
     * @param mat 
     */
    private static void printingMat(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido, que desea hacer:\n" + "ingrese:\n" + "1. Encriptar mensaje por el metodo PlayFair.\n"
                + "2. Desencriptar el mensaje encriptado por Playfair.\n" + "3. para finalizar el cifrador.\n");
        System.out.println("ingrese su elección: ");
        opt = sc.nextInt();
        switch (opt) {
            case 1:
                System.out.println("ingrese el mensaje a cifrar en mayuscula: \n");
                message = readmessage();
                message = message.replaceAll("\\s", "");
                System.out.println("message: " + message);
                KeyMat = createMatKey(alfabeto);
                printingMat(KeyMat);
                
                break;
            default:
                break;
        }
    }

}
