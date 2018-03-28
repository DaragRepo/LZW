/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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

    public static int getKeyFromValue(Map<Integer, String> hm, String value) {
        for (int o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return 0;

    }

    public static void main(String[] args) {

        /*
         Steps 
        
         1. first check if this character exists in the dictionary if it does add the next character to it and check again till you don't find it 
        
         2. if it does then get it's ascii and then iterate through the string till you don't find it and then add it to the dictionary 
       
       
         */
        String s = "ababababa";
        int count = 0;
        Map m = new HashMap<Integer, String>();
        List l = new LinkedList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!m.containsValue(String.valueOf(s.charAt(i)))) {
                m.put(count, String.valueOf(s.charAt(i)));
                count++;
            }
        }
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                break;
            }

            if (m.values().contains(String.valueOf(s.charAt(i)))) {
                String history = "";
                history += s.charAt(i);
                j = i + 1;

                while (j != s.length() - 1 && m.values().contains(history)) {
                    history += s.charAt(j);
                    j++;
                }
                String special = "";
                special += s.charAt(i);
                special += s.charAt(i + 1);
//                System.out.println(history+ " "+ i);

                // this is cause if the character before the last one contained something in the dictionary 
               
                if (j == s.length()-1 ){
                    history += s.charAt(j);
                }
                if (m.values().contains(history)){
                     int index = getKeyFromValue(m, history);
                     l.add(index);
                } else {
                     int index = getKeyFromValue(m, history.substring(0, history.length() - 1));
                     l.add(index);
                     m.put(count, history);
                     count++;
                }
                
                
//                if (i == s.length() - 2 && m.values().contains(special)) {
//
//                    int index = getKeyFromValue(m, special);
//                    l.add(index);
//                } else {
//                    // cause i made the a condition in the while to avoid an out of range so it doesn't consider the last character
//                    if (j == s.length() - 1) {
//                        String unique = history + s.charAt(j);
//                        int index = getKeyFromValue(m, history.substring(0, unique.length() - 1));
//                        l.add(index);
//                        m.put(count, unique);
//                        count++;
//                    } else {
//                        int index = getKeyFromValue(m, history.substring(0, history.length() - 1));
//                        l.add(index);
//                        m.put(count, history);
//                        count++;
//                    }
//                }

            }

        }

        System.out.println(m);
        System.out.println(l);

    }

}
