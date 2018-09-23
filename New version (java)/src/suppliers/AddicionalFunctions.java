/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers;

import java.util.Map;

/**
 *
 * @author Matmozaur
 */
public class AddicionalFunctions {
   public static <T> T maxKey(Map<T,Integer> map){
        T t=null;
        int max=1;
        for(Map.Entry<T,Integer> entry: map.entrySet()){
            if(entry.getValue()>max){
                t=entry.getKey();
            }
        }
        return t;
   }
}
