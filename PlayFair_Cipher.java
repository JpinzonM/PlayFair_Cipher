/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado_playfair;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class PlayFair_Cipher {

    private static int opt;
    private static String message;
    private static final char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'y', 'Z'};
    private static char[][] KeyMat = new char[5][5];
    private static Object rnd;

    /**
     * *
     * Method that creat a random Matrix key 
     *
     * @param abecedario
     * @return
     */
    private static char[][] createMatKey(char[] abecedario) {

        int[] pos = new int[24];
        pos = ShuffleArrayPos(0, 24);

        //llenado de la matrix
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                KeyMat[i][j] = alfabeto[pos[(k)]];
                k++;
            }
        }
        return KeyMat;

    }

    /***
     * method that create a random pos int[], 
     * @param a min value for range of array
     * @param b max value for range of array
     * @return int[] 
     */
    public static int[] ShuffleArrayPos(int a, int b) {
        Random Ramdpos = new Random();  // Random number generator		
        int tam = b - a + 1;
        int[] newposshuffle = new int[tam];

        for (int i = 0; i < tam; i++) {
            newposshuffle[i] = a + i;
        }

        for (int i = 0; i < newposshuffle.length; i++) {
            int randomPosition = Ramdpos.nextInt(newposshuffle.length);
            int temp = newposshuffle[i];
            newposshuffle[i] = newposshuffle[randomPosition];
            newposshuffle[randomPosition] = temp;
        }
        return newposshuffle;
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
     * funtion that print on console log a matrix of string
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
                System.out.println("message: " + message + "\n");
                KeyMat = createMatKey(alfabeto);
                printingMat(KeyMat);
                
                

                break;
            default:
                break;
        }
    }

}
