import Models.Message;


import java.util.*;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Message p = new Message(1, "HALLO", "KEY",1,2);
        encrypt(String_to_array(p.getMessage()));



    }

    public static char[] String_to_array(String message){

        // Creating array of string length
        char[] ch = new char[message.length()];

        // Copy character by character into array
        for (int i = 0; i < message.length(); i++) {
            ch[i] = message.charAt(i);
        }

        // Printing content of array
        //for (char c : ch) {
          //  System.out.println(c);


        //}
        return ch;
    }

    public static Character[] encrypt (char[] to_encrypt) {
        Character[] encrypted = new Character[to_encrypt.length];
        int i = 0;
        int dispo = 6;
        int structure = 3;

        HashMap<Character, Character> MAP = new HashMap<Character, Character>();
        Character cara = 'A';
        Character cara1 = 'A';

        for (int x = 0; x < dispo; x++) {
            cara1++;
        }


        for (int z = 0; z < 52; z++) {

            if(z%structure ==structure-1){

                for(int x = 0; x<structure-1;x++){cara1++;}


            }

             if(z%structure ==1){

               for(int x = 0; x<structure-1;x++){cara1--;}}




            MAP.put(cara, cara1);

                 if(z%structure ==1){

                     for(int x = 0; x<structure-1;x++){cara1++;}}

            if(z%structure ==structure-1){

               for(int x = 0; x<structure-1;x++){cara1--;}


            }


            cara++;
            // System.out.println(cara);
            cara1++;
            // System.out.println(cara1);
        }



        /*MAP.put('b','b');
        MAP.put('c','c');
        MAP.put('d','d');
        MAP.put('e','e');
        MAP.put('f','f');
        MAP.put('g','g');
        MAP.put('h','h');
        MAP.put('i','i');
        MAP.put('j','j');
        MAP.put('k','k');
        MAP.put('l','l');
        MAP.put('m','m');
        MAP.put('n','n');
        MAP.put('o','o');
        MAP.put('p','p');
        MAP.put('q','q');
        MAP.put('r','r');
        MAP.put('s','s');
        MAP.put('t','t');
        MAP.put('u','u');
        MAP.put('v','v');
        MAP.put('w','w');
        MAP.put('x','x');
        MAP.put('y','y');
        MAP.put('z','z');
        MAP.put('A','a');
        MAP.put('B','b');
        MAP.put('C','c');
        MAP.put('D','d');
        MAP.put('E','e');
        MAP.put('F','f');
        MAP.put('G','g');
        MAP.put('H','h');
        MAP.put('I','i');
        MAP.put('J','j');
        MAP.put('K','k');
        MAP.put('L','l');
        MAP.put('M','m');
        MAP.put('N','n');
        MAP.put('O','o');
        MAP.put('P','p');
        MAP.put('Q','q');
        MAP.put('R','r');
        MAP.put('S','s');
        MAP.put('T','t');
        MAP.put('U','u');
        MAP.put('V','v');
        MAP.put('W','w');
        MAP.put('X','x');
        MAP.put('Y','y');
        MAP.put('Z','z');

         */

            for (char ca : to_encrypt) {
                Character x = MAP.get(ca);


                encrypted[i] = x;

                i++;

            }
            for (Character c : encrypted) {
                System.out.println(c);

            }




        return encrypted;}
}



