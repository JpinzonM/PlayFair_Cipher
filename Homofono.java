/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homofono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static HashMap<String, List<Integer>> GenerarSimbolos(int Nsim) {
        int[] simbolos = new int[Nsim];
        HashMap<String,List<Integer>> hmap = new HashMap<String, List<Integer>>();
         List<Integer> CA = new ArrayList<Integer>();
         List<Integer> CB = new ArrayList<Integer>();
         List<Integer> CC = new ArrayList<Integer>();
         List<Integer> CD = new ArrayList<Integer>();
         List<Integer> CE = new ArrayList<Integer>();
         List<Integer> CF = new ArrayList<Integer>();
         List<Integer> CG = new ArrayList<Integer>();
         List<Integer> CH = new ArrayList<Integer>();
         List<Integer> CI = new ArrayList<Integer>();
         List<Integer> CJ = new ArrayList<Integer>();
         List<Integer> CK = new ArrayList<Integer>();
         List<Integer> CL = new ArrayList<Integer>();
         List<Integer> CM = new ArrayList<Integer>();
         List<Integer> CN = new ArrayList<Integer>();
         List<Integer> CO = new ArrayList<Integer>();
         List<Integer> CP = new ArrayList<Integer>();
         List<Integer> CQ = new ArrayList<Integer>();
         List<Integer> CR = new ArrayList<Integer>();
         List<Integer> CS = new ArrayList<Integer>();
         List<Integer> CT = new ArrayList<Integer>();
         List<Integer> CU = new ArrayList<Integer>();
         List<Integer> CV = new ArrayList<Integer>();
         List<Integer> CW = new ArrayList<Integer>();
         List<Integer> CX = new ArrayList<Integer>();
         List<Integer> CY = new ArrayList<Integer>();
         List<Integer> CZ = new ArrayList<Integer>();
        for (int i = 0; i < Nsim; i++) {

            simbolos[i] = i;
          
        }
        simbolos = ShuffleArrayPos(0, Nsim);
      
        float A = (0.082f)*Nsim;
        for (int i = 0; i < A; i++) {
          
           CA.add(simbolos[i]);
        }
        
         hmap.put("A", CA);
        // System.out.println(hmap);
      float B = 0.015f*Nsim;
        for (int i = (int) A; i < A + B; i++) {
           CB.add(simbolos[i]);
          
        }
          hmap.put("B", CB);
      float C = 0.027f*Nsim;
        for (int i = (int) (A + B); i < A + B + C; i++) {
           CC.add(simbolos[i]);
          
        }
          hmap.put("C", CC);
        float D = 0.042f*Nsim;
        for (int i = (int) (A + B + C); i < A + B + C + D; i++) {
             CD.add(simbolos[i]);
          
        }
          hmap.put("D", CD);
        float E = 0.12f*Nsim;
        for (int i = (int) (A + B + C); i < A + B + C + D; i++) {
               CE.add(simbolos[i]);
          
        }
          hmap.put("E", CE);
        float F = 0.022f*Nsim;
        for (int i = (int) (A + B + C + E); i < A + B + C + E + F; i++) {
              CF.add(simbolos[i]);
          
        }
          hmap.put("F", CF);
        float G = 0.020f*Nsim;
        for (int i = (int) (A + B + C + E + F); i < A + B + C + E + F + G; i++) {
           CG.add(simbolos[i]);
          
        }
          hmap.put("G", CG);
        float H = 0.060f*Nsim;
        for (int i = (int) (A + B + C + E + F + G); i < A + B + C + E + F + G + H; i++) {
              CH.add(simbolos[i]);
          
        }
          hmap.put("H", CH);
        float I = 0.069f*Nsim;
        for (int i = (int) (A + B + C + E + F + G + H); i < A + B + C + E + F + G + H + I; i++) {
              CI.add(simbolos[i]);
          
        }
          hmap.put("I", CI);
        float J = 0.0015f*Nsim;
        for (int i = (int) (A + B + C + E + F + G + H + I); i < A + B + C + E + F + G + H + I + J; i++) {
               CJ.add(simbolos[i]);
          
        }
          hmap.put("J", CJ);
        float K = 0.007f*Nsim;
        for (int i = (int) (A + B + C + E + F + G + H + I + J); i < A + B + C + E + F + G + H + I + J + K; i++) {
                CK.add(simbolos[i]);
          
        }
          hmap.put("K", CK);
        float L = 0.040f*Nsim;
        for (int i = (int) (A + B + C + E + F + G + H + I + J + K); i < A + B + C + E + F + G + H + I + J + K + L; i++) {
              CL.add(simbolos[i]);
          
        }
          hmap.put("L", CL);

        float and = A + B + C + E + F + G + H + I + J + K + L;
        float M = 0.024f*Nsim;
        for (int i = (int) and; i < and + M; i++) {
                CM.add(simbolos[i]);
          
        }
          hmap.put("M", CM);
        float N = 0.067f*Nsim;
        for (int i = (int) (and + M); i < and + M + N; i++) {
             CN.add(simbolos[i]);
          
        }
          hmap.put("N", CN);
        float O = 0.075f*Nsim;
        for (int i = (int) (and + M + N); i < and + M + N + O; i++) {
               CO.add(simbolos[i]);
          
        }
          hmap.put("O", CO);
        float P = 0.02f*Nsim;
        for (int i = (int) (and + M + N + O); i < and + M + N + O + P; i++) {
              CP.add(simbolos[i]);
          
        }
          hmap.put("P", CP);
        float Q = 0.001f*Nsim;
        for (int i = (int) (and + M + N + O + P); i < and + M + N + O + P + Q; i++) {
               CQ.add(simbolos[i]);
          
        }
          hmap.put("Q", CQ);
        float R = 0.060f*Nsim;
        for (int i = (int) (and + M + N + O + P + Q); i < and + M + N + O + P + Q + R; i++) {
              CR.add(simbolos[i]);
          
        }
          hmap.put("R", CR);
        float S = 0.063f* Nsim;
        for (int i = (int) (and + M + N + O + P + Q + R); i < and + M + N + O + P + Q + R + S; i++) {
               CS.add(simbolos[i]);
          
        }
          hmap.put("S", CS);
        float T = 0.090f*Nsim;
        for (int i = (int) (and + M + N + O + P + Q + R + S); i < and + M + N + O + P + Q + R + S + T; i++) {
               CT.add(simbolos[i]);
          
        }
          hmap.put("T", CH);
        float and2 = and + M + N + O + P + Q + R + S + T;
        float U = 0.027f*Nsim;
        for (int i = (int) and2; i < and2 + U; i++) {
               CU.add(simbolos[i]);
          
        }
          hmap.put("U", CU);
        float V = 0.010f*Nsim;
        for (int i = (int) (and2 + U); i < and2 + U + V; i++) {
               CV.add(simbolos[i]);
          
        }
          hmap.put("V", CV);
        float W = 0.023f*Nsim;
        for (int i = (int) (and2 + U + V); i < and2 + U + V + W; i++) {
             CW.add(simbolos[i]);
          
        }
          hmap.put("W", CW);
        float X = 0.010f*Nsim;
        for (int i = (int) (and2 + U + V + W); i < and2 + U + V + W + X; i++) {
               CX.add(simbolos[i]);
          
        }
          hmap.put("X", CX);
        float Y = 0.019f*Nsim;
        for (int i = (int) (and2 + U + V + W + X); i < and2 + U + V + W + X + Y; i++) {
               CY.add(simbolos[i]);
          
        }
          hmap.put("Y", CY);
        float Z = 0.00074f*Nsim;
        for (int i = (int) (and2 + U + V + W + X+Y); i < and2 + U + V + W + X + Y + Z; i++) {
               CH.add(simbolos[i]);
          
        }
          hmap.put("Z", CZ);
     
         System.out.println("LOS CONJUNTOS SON LOS SIGUIENTES");
         System.out.println(hmap);
       
           return hmap;

    }

    public static String codificacion(String message, int Nsim, HashMap hmap) {
       Random rn = new Random();
       
       // hmap = GenerarSimbolos(Nsim);
        String mensaje = message;
        int n = message.length();
        String[] Caracter = new String[n];
        String [] encript = new String [n];
        int [] aa = new int [n];
        List<Integer> list = new ArrayList<Integer>();
        String result ="";

        for (int i = 0; i < n; i++) {
            Caracter[i] = mensaje.substring(i, i + 1);
           // System.out.println(Caracter[i]);
        }
        System.out.println("La codificacion estara dada por un elemento random de cada conjunto");
        for (int i = 0; i < Caracter.length; i++) {
            if (hmap.containsKey(Caracter[i])) {
               encript[i]= hmap.get(Caracter[i]).toString(); // como obtener la key (?) 
             //   System.out.println(encript[i]); // COMO SEPERARLOOOOS :C
                
            }
            result += encript[i];
        }

        System.out.println("MENSAJE CIFRADO (ESTA DADO QUE CADA LETRA FUE REMPLAZA POR SU CONJUNTOS ) :");
        System.out.println(result);
        return result;
    }
    
    public static String decodificacion(String Result, HashMap hmap){
      String deco=""; 
      int n = Result.length();
        String[] Caracter = new String[n];
        String [] encript = new String [n];
        String result ="";

        for (int i = 0; i < n; i++) {
            Caracter[i] = Result.substring(i, i + 1);
            System.out.println(Caracter[i]);
        }
        for (int i = 0; i < Caracter.length; i++) {
            if (hmap.containsValue(Caracter[i])) {
                encript[i]= hmap.get(Caracter[i]).toString(); // como obtener la key (?) 
                System.out.println(encript[i]);
            }
            result += encript[i];
        }

        
        System.out.println(result);
    
    
    
     return deco;
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
        message = readmessage().toUpperCase();
         message = message.replaceAll("\\s", "");
        System.out.println("Diginite el numero de simbolos");
        NSim = sc.nextInt();
        //GenerarSimbolos(NSim);
        HashMap<String, List<Integer>> Hash = GenerarSimbolos(NSim);
        codificacion(message, NSim,Hash);
        //System.out.println(message);
        // TODO code application logic here
    }

}
