/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.suppliers;

import java.util.Map;

/**
 *
 * @author Matmozaur
 */
public class AdditionalFunctions {
   public static <T> T maxKey(Map<T,Integer> map){
        T t=null;
        int max=1;
        for(Map.Entry<T,Integer> entry: map.entrySet()){
            if(entry.getValue()>max){
                t=entry.getKey();
                max=entry.getValue();
            }
        }
        return t;
   }
}
