/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado_playfair;

import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import jdk.nashorn.internal.objects.NativeString;
import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 *
 * @author Daniel
 */
public class PlayFair_Cipher {

    private static int opt;
    private static String message;
    private static String readytoencrypt;

    private static final char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
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

    /**
     * *
     * method that create a random pos int[],
     *
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

    private static void printingMat(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * *
     * funtion that read message with some words.
     *
     * @return
     */
    private static String readmessage() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static String JandI(String message) {
        message = message.replace("j", "i");
        message = message.replace("J", "I");
        return message;
    }

    private static String Separate(String message) {

        String[] part = new String[100];
        String Z;

        boolean sw = true;
        while (sw == true) {

            sw = false;
            int N = message.length();
            int k = 0;
            for (int i = 0; i < N; i++) {
                if (i % 2 != 0) {

                    //   System.out.println(message.substring(i-1, i+1));
                    part[k] = message.substring(i - 1, i + 1);
                    k++;
                }
                if (i == N - 1 && message.length() % 2 != 0) {
                    Z = message.substring(i) + "Z";
                    part[k] = Z;
                    k++;
                }

            }

            System.out.println("VECTOR CON TODAS LAS PAREJAS");
            for (int i = 0; i < k; i++) {

                System.out.println(part[i]);
                String par1 = part[i].substring(0, 1);
                String par2 = part[i].substring(1, 2);
                // System.out.println(par1 + " -- " + par2);
                if (par1.equals(par2)) {
                    part[i] = par1 + "Z" + par2;
                    sw = true;
                    message = "";
                  

                    break;
                }

            }
        message="";
          for (int j = 0; j < k; j++) {
                        message = message + part[j];

                    }
        
        }
        return message;
    }

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
                message = message.replaceAll("\\s", "");
                System.out.println("Message sin espacios: " + message);
                System.out.println("Matriz Clave \n");
                KeyMat = createMatKey(alfabeto);
                printingMat(KeyMat);
                message = JandI(message);

                System.out.println(Separate(message));
                // readytoencrypt = config_message(message);
                //System.out.println(readytoencrypt);

                break;
            default:
                break;
        }
    }

}
