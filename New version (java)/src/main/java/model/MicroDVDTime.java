
package model;

import java.util.LinkedList;
import java.util.List;

public class MicroDVDTime {
    public List<Line> subs=new LinkedList<>();

    public void changeByConst(int k){
        for(Line l:subs){
            l.setStart(l.getStart()+k);
            l.setEnd(l.getEnd()+k);
        }
    }

    public void changeByFunction(double a,int b){
        for(Line l:subs){
            l.setStart((int) (l.getStart()*a+b));
            l.setEnd((int) (l.getEnd()*a+b));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(Line l:subs){
            sb.append(l.toString()).append("\n");
        }
        return sb.toString();
    }
}
