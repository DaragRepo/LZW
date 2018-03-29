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

        String s = "ababababa";
      
        LZW lz = new LZW (s);
        System.out.println(lz);


    }

}
