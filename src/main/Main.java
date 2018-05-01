/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author moh
 */
public class Main {

    public static void main(String[] args) {

        String s = "ABAABABBAABAABAAAABABBBBBBBB";
         LZW lz = new LZW (s);
        System.out.println(lz);
//     String s =  "TOBEORNOTTOBEORTOBEORNOT" ;
       
//        HashMap<Integer, String> initialDictionary = new HashMap();
//
//        for (char c = 'A'; c <= 'Z'; c++) {
//            initialDictionary.put((int) c, String.valueOf(c));
//        }
//
////        int[] compressed = {84, 79, 66, 69, 79, 82, 78, 79, 84, 128, 130, 132, 137, 131, 133, 135};
//        int[] compressed = {65, 66, 65, 128, 128, 129, 131, 134, 130, 129, 66, 138, 139, 138};
//
//        String output = "";
//
//        int start = 128;
//
//        for (int i = 0; i < compressed.length; i++) {
//
//            // if you found it in the dictionary 
//            /*
//            
//             then add it to the ouput then check if the dictionary doesn't have this char + the next if it doesn't add it to the dictionary 
//            
//            
//             */
//            // 
//            // if i know the number  is in the dictionary 
//            if (initialDictionary.containsKey(compressed[i])) {
//
//                String current = initialDictionary.get(compressed[i]);
//                output += current;
//                // dealing with the dictionary 
//                // if i don't know the next character 
//                if (i != compressed.length - 1 && initialDictionary.get(compressed[i + 1]) == null) {
//
//                    String sub = initialDictionary.get(compressed[i]);
////                    System.out.println(sub);
//                    initialDictionary.put(start, sub + sub.charAt(0));
//                    start++;
//
//                } else {
//                    // if i know the next character and the dictionary doesn't contains it just put it 
//
//                    if (i != compressed.length - 1 && !initialDictionary.containsKey(i)) {
//                        String s = initialDictionary.get(compressed[i]) + initialDictionary.get(compressed[i + 1]).charAt(0);
//                        initialDictionary.put(start, s);
//
//                        start++;
//
//                    }
//
//                }
//
//            }
//
//        }
//
//        System.out.println("String After Decompression is " +output);

    }

}
