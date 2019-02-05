package controller.manipulators;

import controller.suppliers.TimeParser;
import model.MicroDVDTime;

import javax.swing.*;
import java.util.Map;

public class Manipulator {
    public static void changeByConst(JTextArea ta,int t){
        MicroDVDTime time= TimeParser.parseTime(ta.getText());
        time.changeByConst(t);
        ta.setText(time.toString());
    }

    public static void changeByFunction(JTextArea ta,double a,int b){
        MicroDVDTime time= TimeParser.parseTime(ta.getText());
        time.changeByFunction(a,b);
        ta.setText(time.toString());
    }

    public static void changeByAproximatePolynomial(JTextArea ta, Map<Integer,Integer> points){
        MicroDVDTime time= TimeParser.parseTime(ta.getText());
        time.changeByAproximatePolynomial(points);
        ta.setText(time.toString());
    }
}
