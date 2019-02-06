/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homofono;

import java.util.HashMap;
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
         HashMap<String, Integer> hmap = new HashMap<String, Integer>();

        for (int i = 0; i < Nsim; i++) {

            simbolos[i] = i;

        }
        simbolos = ShuffleArrayPos(0, Nsim);
       
        int A = 82;
        for (int i = 0; i < A; i++) {
            hmap.put("A",simbolos[i]);
        }
        int B = 15;
        for (int i = A; i < A+B; i++) {
            hmap.put("B",simbolos[i]);
        }
         int C = 27;
        for (int i =A+B ; i < A+B+C; i++) {
            hmap.put("C",simbolos[i]);
        } int D = 42;
        for (int i = A+B+C; i < A+B+C+D; i++) {
            hmap.put("D",simbolos[i]);
        }
        int E = 127;
        for (int i = A+B+C; i < A+B+C+D; i++) {
            hmap.put("D",simbolos[i]);
        }
          int F = 22;
        for (int i = A+B+C+E; i < A+B+C+E+F; i++) {
            hmap.put("F",simbolos[i]);
        }
        int G = 20;
        for (int i = A+B+C+E+F; i < A+B+C+E+F+G; i++) {
            hmap.put("G",simbolos[i]);
        }
         int H = 61;
        for (int i = A+B+C+E+F+G ; i <  A+B+C+E+F+G+H; i++) {
            hmap.put("H",simbolos[i]);
        } int I = 70;
        for (int i = A+B+C+E+F+G+H; i < A+B+C+E+F+G+H+I; i++) {
            hmap.put("I",simbolos[i]);
        }
        int J = 2;
        for (int i = A+B+C+E+F+G+H+I; i < A+B+C+E+F+G+H+I+J; i++) {
            hmap.put("J",simbolos[i]);
        }
          int K = 7 ;
        for (int i = A+B+C+E+F+G+H+I+J; i < A+B+C+E+F+G+H+I+J+K; i++) {
            hmap.put("K",simbolos[i]);
        }
        int L = 40;
        for (int i = A+B+C+E+F+G+H+I+J+K; i < A+B+C+E+F+G+H+I+J+K+L; i++) {
            hmap.put("L",simbolos[i]);
        }
        
        int and = A+B+C+E+F+G+H+I+J+K+L;
         int M = 24;
        for (int i =and ; i < and+M; i++) {
            hmap.put("M",simbolos[i]);
        } int N = 67;
        for (int i = and+M; i < and+M+N; i++) {
            hmap.put("N",simbolos[i]);
        }
        int O = 75;
        for (int i = and+M+N; i < and+M+N+O; i++) {
            hmap.put("O",simbolos[i]);
        }
          int P = 19;
        for (int i = and+M+N+O; i < and+M+N+O+P; i++) {
            hmap.put("P",simbolos[i]);
        }
        int Q = 1;
        for (int i = and+M+N+O+P; i < and+M+N+O+P+Q; i++) {
            hmap.put("Q",simbolos[i]);
        }
         int R = 60;
        for (int i =and+M+N+O+P+Q ; i < and+M+N+O+P+Q+R; i++) {
            hmap.put("R",simbolos[i]);
        } int S = 63;
        for (int i = and+M+N+O+P+Q+R; i <and+M+N+O+P+Q+R+S; i++) {
            hmap.put("S",simbolos[i]);
        }
        int T = 90;
        for (int i = and+M+N+O+P+Q+R+S; i < and+M+N+O+P+Q+R+S+T; i++) {
            hmap.put("T",simbolos[i]);
        }
        int and2 =and+M+N+O+P+Q+R+S+T;
          int U = 27;
        for (int i = and2; i < and2+U; i++) {
            hmap.put("U",simbolos[i]);
        }
        int V = 10;
        for (int i = and2+U; i < and2+U+V; i++) {
            hmap.put("V",simbolos[i]);
        }
         int W = 23;
        for (int i =and2+U+V ; i < and2+U+V+W; i++) {
            hmap.put("W",simbolos[i]);
        } int X = 10;
        for (int i = and2+U+V+W; i < and2+U+V+W+X; i++) {
            hmap.put("X",simbolos[i]);
        }
        int Y = 19;
        for (int i = and2+U+V+W+X; i < and2+U+V+W+X+Y; i++) {
            hmap.put("Y",simbolos[i]);
        }
        int Z = 19;
        for (int i = and2+U+V+W+X; i < and2+U+V+W+X+Y+Z; i++) {
            hmap.put("Z",simbolos[i]);
        }
        
        
        for (int i = 0; i < Nsim; i++) {
            
        
       // System.out.println(simbolos[i]);
        
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
