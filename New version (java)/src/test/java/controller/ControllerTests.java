package controller;

import controller.suppliers.AdditionalFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ControllerTests {

    @Test
    void maxKeyTest(){
        Map<String,Integer> m=new HashMap<>();
        m.put("A",2);
        m.put("B",22);
        m.put("C",21);
        m.put("D",12);
        m.put("G",2);
        String s= AdditionalFunctions.maxKey(m);
        Assertions.assertEquals("B",s);
    }
}
