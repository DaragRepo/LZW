/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author moh
 */
public class LZW {

    private String s;
    private Map m = new HashMap<Integer, String>();
    private int count = 0;

    public LZW(String s) {
        this.s = s;
    }

    private Map initialDictionary() {
        for (int i = 0; i < this.s.length(); i++) {
            if (!this.m.containsValue(String.valueOf(this.s.charAt(i)))) {
                this.m.put((int) this.s.charAt(i), String.valueOf(this.s.charAt(i)));
            }
        }
        return this.m;
    }

    private List compress() {
        initialDictionary();
        this.count = 128;
        List l = new LinkedList<Integer>();
        for (int i = 0; i < this.s.length(); i++) {
            if (!m.containsValue(String.valueOf(this.s.charAt(i)))) {
                m.put(this.count, String.valueOf(this.s.charAt(i)));
                this.count++;
            }
        }

        int j = 0;
        for (int i = 0; i < this.s.length(); i++) {
            if (i == this.s.length() - 1) {
                break;
            }

            if (m.values().contains(String.valueOf(this.s.charAt(i)))) {
                String history = "";
                history += this.s.charAt(i);
                j = i + 1;

                while (j != this.s.length() - 1 && this.m.values().contains(history)) {
                    history += this.s.charAt(j);
                    j++;
                }
                if (j == this.s.length() - 1 && this.m.values().contains(history)) {
                    history += this.s.charAt(j);
                }
                if (m.values().contains(history)) {
                    int index = getKeyFromValue(this.m, history);
                    l.add(index);
                } else {
                    int index = getKeyFromValue(this.m, history.substring(0, history.length() - 1));
                    l.add(index);
                    this.m.put(this.count, history);
                    this.count++;
                    i = i + history.length() - 2;
                }
                //ababababa
                //{2=ab,3=ba,4=aba,5=bab,6=abab,7=baba} 
                //{2=ab, 3=ba, 4=aba, 5=bab, 6=abab, 7=baba}
                //[0, 1, 2, 3, 4, 5, 4, 3]
                //[0,    1,    2,    3,     4,     5, 4, 3]
            }

        }
//        System.out.println(initialDictionary());
        return l;

    }


    private int getKeyFromValue(Map<Integer, String> hm, String value) {
        for (int o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return 0;

    }

    @Override
    public String toString() {
        return "The String " + this.s + " After Compression is ===> " + compress();
    }

}
