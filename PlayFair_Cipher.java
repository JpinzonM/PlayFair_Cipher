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
 * @author Jorge
 */
public class PlayFair_Cipher {

    private static String message;
    private static final char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static char[][] KeyMat = new char[5][5];
    private static String[] bigramas;
    private static String[] cipher_bigramas;
    private static String cipher_message;
    private static String decipher_message;

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
                KeyMat[i][j] = abecedario[pos[(k)]];
                k++;
            }
        }
        return KeyMat;

    }

    /**
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

    /**
     * *
     * method that print a matrix
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
        System.out.println("");
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

    /**
     * *
     * method that reemplace the letter J by I
     *
     * @param message
     * @return
     */
    private static String JandI(String message) {
        message = message.replace("j", "i");
        message = message.replace("J", "I");
        return message;
    }

    /**
     * *
     * method uses by separate message and check the rules of the playfair
     * cipher.
     *
     * @param message
     * @return
     */
    private static String[] Separate(String message) {

        String[] part = new String[(message.length() / 2) + 1];
        String Z;
        System.out.println("message.length: " + message.length());
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

            System.out.println("VECTOR CON TODAS LAS PAREJAS: ");
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
            message = "";
            for (int j = 0; j < k; j++) {
                message = message + part[j];

            }

        }
        return part;
    }

    private static String encriptedmessage(char[][] KeyMat, String[] bigramas) {
        String[] newbigramas = new String[bigramas.length];
        System.out.println("bigramas lenght: " + bigramas.length);
        System.out.println("new bigramas lenght:" + newbigramas.length);
        String message_encripted = "";
        for (int k = 0; k < bigramas.length-1; k++) {
            int i = 0, j = 0, i2 = 0, j2 = 0;
            String elem1, elem2;
            char el1_mat, el2_mat;
            if (bigramas[k] == null) {
                System.out.println("null");
            }
            elem1 = bigramas[k].substring(0, 1);
            elem2 = bigramas[k].substring(1, 2);
            el1_mat = KeyMat[i][j];
            el2_mat = KeyMat[i2][j2];

            while (elem1.charAt(0) != el1_mat) {

                if (j == KeyMat.length) {
                    i = i + 1;
                    j = 0;
                    el1_mat = KeyMat[i][j];
                }

                el1_mat = KeyMat[i][j];
                j = j + 1;
            }
            if (j > 0) {
                j = j - 1;
            }

            while (elem2.charAt(0) != el2_mat) {
                if (j2 == KeyMat.length) {
                    i2 = i2 + 1;
                    j2 = 0;
                    el2_mat = KeyMat[i2][j2];
                }
                el2_mat = KeyMat[i2][j2];
                j2 = j2 + 1;
            }
            if (j2 > 0) {
                j2 = j2 - 1;
            }

            System.out.println("el bigrama a cifrar es: " + elem1);
            System.out.println("el bigrama a cifrar es: " + elem2);

            if (i != i2 && j != j2) {
                el1_mat = KeyMat[i][j2];
                el2_mat = KeyMat[i2][j];
                newbigramas[k] = el1_mat + "" + el2_mat;
                System.out.println("el bigrama cifrado es: " + el1_mat);
                System.out.println("el bigrama cifrado es: " + el2_mat);
                System.out.println("");
            }
            if (i == i2) {
                if ((j == KeyMat.length - 1) || (j2 == KeyMat.length - 1)) {
                    if (j == KeyMat.length - 1) {
                        j = 0;
                        j2 = j2 + 1;
                        el1_mat = KeyMat[i][j];
                        el2_mat = KeyMat[i2][j2];
                        newbigramas[k] = el1_mat + "" + el2_mat;
                        System.out.println("el bigrama cifrado es: " + el1_mat);
                        System.out.println("el bigrama cifrado es: " + el2_mat);
                        System.out.println("");
                    }
                    if (j2 == KeyMat.length - 1) {
                        j = j + 1;
                        j2 = 0;
                        el1_mat = KeyMat[i][j];
                        el2_mat = KeyMat[i2][j2];
                        newbigramas[k] = el1_mat + "" + el2_mat;
                        System.out.println("el bigrama cifrado es: " + el1_mat);
                        System.out.println("el bigrama cifrado es: " + el2_mat);
                        System.out.println("");
                    }
                } else {
                    j = j + 1;
                    j2 = j2 + 1;
                    el1_mat = KeyMat[i][j];
                    el2_mat = KeyMat[i2][j2];
                    newbigramas[k] = el1_mat + "" + el2_mat;
                    System.out.println("el bigrama cifrado es: " + el1_mat);
                    System.out.println("el bigrama cifrado es: " + el2_mat);
                    System.out.println("");
                }
            }
            if (j == j2) {
                if ((i == KeyMat.length - 1) || (i2 == KeyMat.length - 1)) {
                    if (i == KeyMat.length - 1) {
                        i = 0;
                        i2 = i2 + 1;
                        el1_mat = KeyMat[i][j];
                        el2_mat = KeyMat[i2][j2];
                        newbigramas[k] = el1_mat + "" + el2_mat;
                        System.out.println("el bigrama cifrado es: " + el1_mat);
                        System.out.println("el bigrama cifrado es: " + el2_mat);
                        System.out.println("");
                    }
                    if (i2 == KeyMat.length - 1) {
                        i = i + 1;
                        i2 = 0;
                        el1_mat = KeyMat[i][j];
                        el2_mat = KeyMat[i2][j2];
                        newbigramas[k] = el1_mat + "" + el2_mat;
                        System.out.println("el bigrama cifrado es: " + el1_mat);
                        System.out.println("el bigrama cifrado es: " + el2_mat);
                        System.out.println("");
                    }

                } else {
                    i = i + 1;
                    i2 = i2 + 1;
                    el1_mat = KeyMat[i][j];
                    el2_mat = KeyMat[i2][j2];
                    newbigramas[k] = el1_mat + "" + el2_mat;
                    System.out.println("el bigrama cifrado es: " + el1_mat);
                    System.out.println("el bigrama cifrado es: " + el2_mat);
                    System.out.println("");
                }
            }
        }

        for (int i = 0; i < newbigramas.length-1; i++) {
            message_encripted = message_encripted + "" + newbigramas[i];
        }
        return message_encripted;
    }

    private static String decriptedmessage(char[][] KeyMat, String[] cipherbigramas) {
        String[] newbigramas = new String[cipherbigramas.length];
        System.out.println("bigramas lenght: " + cipherbigramas.length);
        String message_encripted = "";
        for (int k = 0; k < cipherbigramas.length-1; k++) {
            int i = 0, j = 0, i2 = 0, j2 = 0;
            String elem1, elem2;
            char el1_mat, el2_mat;
            if (cipherbigramas[k] == null) {
                System.out.println("null");
            }
            elem1 = cipherbigramas[k].substring(0, 1);
            elem2 = cipherbigramas[k].substring(1, 2);
            el1_mat = KeyMat[i][j];
            el2_mat = KeyMat[i2][j2];

            while (elem1.charAt(0) != el1_mat) {

                if (j == KeyMat.length) {
                    i = i + 1;
                    j = 0;
                    el1_mat = KeyMat[i][j];
                }

                el1_mat = KeyMat[i][j];
                j = j + 1;
            }
            if (j > 0) {
                j = j - 1;
            }

            while (elem2.charAt(0) != el2_mat) {
                if (j2 == KeyMat.length) {
                    i2 = i2 + 1;
                    j2 = 0;
                    el2_mat = KeyMat[i2][j2];
                }
                el2_mat = KeyMat[i2][j2];
                j2 = j2 + 1;
            }
            if (j2 > 0) {
                j2 = j2 - 1;
            }

            System.out.println("el bigrama a cifrar es: " + elem1 + " Y se encuentra en la posicion " + i + " " + j);
            System.out.println("el bigrama a cifrar es: " + elem2 + " Y se encuentra en la posicion " + i2 + " " + j2);

            if (i != i2 && j != j2) {
                el1_mat = KeyMat[i][j2];
                el2_mat = KeyMat[i2][j];
                newbigramas[k] = el1_mat + "" + el2_mat;
                System.out.println("el bigrama cifrado es: " + el1_mat);
                System.out.println("el bigrama cifrado es: " + el2_mat);
                System.out.println("");
            }
            if (i == i2) {
                if (j == 0 || j2 == 0) {
                    if (j == 0) {
                        j = KeyMat.length - 1;
                        j2 = j2 - 1;
                        el1_mat = KeyMat[i][j];
                        el2_mat = KeyMat[i2][j2];
                        newbigramas[k] = el1_mat + "" + el2_mat;
                        System.out.println("el bigrama cifrado es: " + el1_mat);
                        System.out.println("el bigrama cifrado es: " + el2_mat);
                        System.out.println("");
                    }
                    if (j2 == 0) {
                        j2 = KeyMat.length - 1;
                        j = j - 1;
                        el1_mat = KeyMat[i][j];
                        el2_mat = KeyMat[i2][j2];
                        newbigramas[k] = el1_mat + "" + el2_mat;
                        System.out.println("el bigrama cifrado es: " + el1_mat);
                        System.out.println("el bigrama cifrado es: " + el2_mat);
                        System.out.println("");
                    }
                }

                if ((j == KeyMat.length - 1) || (j2 == KeyMat.length - 1)) {
                    if (j == KeyMat.length - 1) {
                        if (j2 == 0) {
                            j2 = KeyMat.length - 1;
                            j = j - 1;
                            el1_mat = KeyMat[i][j];
                            el2_mat = KeyMat[i2][j2];
                            newbigramas[k] = el1_mat + "" + el2_mat;
                            System.out.println("el bigrama cifrado es: " + el1_mat);
                            System.out.println("el bigrama cifrado es: " + el2_mat);
                            System.out.println("");
                        }
                    } else {
                        j = j - 1;
                        j2 = j2 - 1;
                        el1_mat = KeyMat[i][j];
                        el2_mat = KeyMat[i2][j2];
                        newbigramas[k] = el1_mat + "" + el2_mat;
                        System.out.println("el bigrama cifrado es: " + el1_mat);
                        System.out.println("el bigrama cifrado es: " + el2_mat);
                        System.out.println("");
                    }
                    if (j2 == KeyMat.length - 1) {
                        if (j == 0) {
                            j = KeyMat.length - 1;
                            j2 = j2 - 1;
                            el1_mat = KeyMat[i][j];
                            el2_mat = KeyMat[i2][j2];
                            newbigramas[k] = el1_mat + "" + el2_mat;
                            System.out.println("el bigrama cifrado es: " + el1_mat);
                            System.out.println("el bigrama cifrado es: " + el2_mat);
                            System.out.println("");
                        }
                    } else {
                        j = j - 1;
                        j2 = j2 - 1;
                        el1_mat = KeyMat[i][j];
                        el2_mat = KeyMat[i2][j2];
                        newbigramas[k] = el1_mat + "" + el2_mat;
                        System.out.println("el bigrama cifrado es: " + el1_mat);
                        System.out.println("el bigrama cifrado es: " + el2_mat);
                        System.out.println("");
                    }
                } else {
                    j = j - 1;
                    j2 = j2 - 1;
                    el1_mat = KeyMat[i][j];
                    el2_mat = KeyMat[i2][j2];
                    newbigramas[k] = el1_mat + "" + el2_mat;
                    System.out.println("el bigrama cifrado es: " + el1_mat);
                    System.out.println("el bigrama cifrado es: " + el2_mat);
                    System.out.println("");
                }
            }
            if (j == j2) {
                if (i == 0 || i2 == 0) {
                    if (i == 0) {
                        i = KeyMat.length - 1;
                        i2 = i2 - 1;
                        el1_mat = KeyMat[i][j];
                        el2_mat = KeyMat[i2][j2];
                        newbigramas[k] = el1_mat + "" + el2_mat;
                        System.out.println("el bigrama cifrado es: " + el1_mat);
                        System.out.println("el bigrama cifrado es: " + el2_mat);
                        System.out.println("");
                    }
                    if (i2 == 0) {
                        i2 = KeyMat.length - 1;
                        i = i - 1;
                        el1_mat = KeyMat[i][j];
                        el2_mat = KeyMat[i2][j2];
                        newbigramas[k] = el1_mat + "" + el2_mat;
                        System.out.println("el bigrama cifrado es: " + el1_mat);
                        System.out.println("el bigrama cifrado es: " + el2_mat);
                        System.out.println("");
                    }
                }

                if ((i == KeyMat.length - 1) || (i2 == KeyMat.length - 1)) {
                    if (i == KeyMat.length - 1) {
                        if (i2 == 0) {
                            i2 = KeyMat.length - 1;
                            i = i - 1;
                            el1_mat = KeyMat[i][j];
                            el2_mat = KeyMat[i2][j2];
                            newbigramas[k] = el1_mat + "" + el2_mat;
                            System.out.println("el bigrama cifrado es: " + el1_mat);
                            System.out.println("el bigrama cifrado es: " + el2_mat);
                            System.out.println("");

                        } else {
                            i = i - 1;
                            i2 = i2 - 1;
                            el1_mat = KeyMat[i][j];
                            el2_mat = KeyMat[i2][j2];
                            newbigramas[k] = el1_mat + "" + el2_mat;
                            System.out.println("el bigrama cifrado es: " + el1_mat);
                            System.out.println("el bigrama cifrado es: " + el2_mat);
                            System.out.println("");
                        }
                    }
                    if (i2 == KeyMat.length - 1) {
                        if (i == 0) {
                            i = KeyMat.length - 1;
                            i2 = i2 - 1;
                            el1_mat = KeyMat[i][j];
                            el2_mat = KeyMat[i2][j2];
                            newbigramas[k] = el1_mat + "" + el2_mat;
                            System.out.println("el bigrama cifrado es: " + el1_mat);
                            System.out.println("el bigrama cifrado es: " + el2_mat);
                            System.out.println("");
                        } else {
                            i = i - 1;
                            i2 = i2 - 1;
                            el1_mat = KeyMat[i][j];
                            el2_mat = KeyMat[i2][j2];
                            newbigramas[k] = el1_mat + "" + el2_mat;
                            System.out.println("el bigrama cifrado es: " + el1_mat);
                            System.out.println("el bigrama cifrado es: " + el2_mat);
                            System.out.println("");
                        }
                    }

                } else {
                    i = i - 1;
                    i2 = i2 - 1;
                    el1_mat = KeyMat[i][j];
                    el2_mat = KeyMat[i2][j2];
                    newbigramas[k] = el1_mat + "" + el2_mat;
                    System.out.println("el bigrama cifrado es: " + el1_mat);
                    System.out.println("el bigrama cifrado es: " + el2_mat);
                    System.out.println("");
                }
            }
        }

        for (int i = 0;
                i < newbigramas.length - 1; i++) {
            message_encripted = message_encripted + "" + newbigramas[i];
        }

        return message_encripted;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        InputStreamReader rd = new InputStreamReader(System.in);
        Scanner sc = new Scanner(System.in);

        System.out.println("ingrese el mensaje a cifrar: \n");
        message = readmessage();
        message = message.replaceAll("\\s", "");
        System.out.println("Message sin espacios: " + message);
        System.out.println("Matriz Clave \n");
        KeyMat = createMatKey(alfabeto);
        printingMat(KeyMat);
        message = JandI(message);
        bigramas = Separate(message);
        cipher_message = encriptedmessage(KeyMat, bigramas);
        System.out.println("el mensaje ingresado (luego de cambiar las j por i) fue: " + message);
        System.out.println("el mensaje cifrado es: " + cipher_message);
        System.out.println("");
        System.out.println("ahora desencriptando...");
        cipher_bigramas = Separate(cipher_message);
        decipher_message = decriptedmessage(KeyMat, cipher_bigramas);
        System.out.println("el mensaje cifrado fue: " + cipher_message);
        System.out.println("el mensaje decifrado es: " + decipher_message);
    }

}
