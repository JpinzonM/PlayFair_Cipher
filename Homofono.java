/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homofono;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Homofono {

    /**
     * @param args the command line arguments
     */
    private static String readmessage() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void GenerarSimbolos(int Nsim) {
        int[] simbolos = new int[Nsim];

        for (int i = 0; i < Nsim; i++) {

            simbolos[i] = i;

        }
        simbolos = ShuffleArrayPos(0, Nsim);
        for (int i = 0; i < Nsim; i++) {
            
        
        System.out.println(simbolos[i]);
        
        }
        
    }

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

    public static void main(String[] args) {
        String message = "";
        int NSim;
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el mensaje a cifrar: \n");
        message = readmessage();
        System.out.println("Diginite el numero de simbolos");
        NSim = sc.nextInt();
        GenerarSimbolos(NSim);

        //System.out.println(message);
        // TODO code application logic here
    }

}
