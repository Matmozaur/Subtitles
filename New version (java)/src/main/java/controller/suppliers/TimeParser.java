package controller.suppliers;

import model.Line;
import model.MicroDVDTime;
import model.Type;
import java.util.HashMap;
import java.util.Map;

public class TimeParser {
    public static MicroDVDTime parseTime(String s){
        Type t=getType(s);
        switch (t){
            case MicroDVD:
                return toMicroDVDTime(s);
            default: return null;
        }
    }

    private static Type getType(String s){
        Map<Type,Integer> types= new HashMap<>();
        types.put(Type.MicroDVD,0);
        types.put(Type.SubRip,0);
        int i=0;
        while (i<s.length()){
            char c=s.charAt(i);
            if(c=='{') types.put(Type.MicroDVD, types.get(Type.MicroDVD)+1);
            if(c=='>') types.put(Type.SubRip, types.get(Type.SubRip)+1);
            i++;
        }
        return AdditionalFunctions.maxKey(types);
    }
    private static MicroDVDTime toMicroDVDTime(String s){
        MicroDVDTime time=new MicroDVDTime();
        int i=0,state=0;
        StringBuilder current=new StringBuilder();
        int start=0;
        int end=0;

        while (i<s.length()){
            char c=s.charAt(i);
            if(c=='{'){
                if(state==0){
                    state=1;
                }
                if(state==2){
                    state=3;
                }
                if(state==4){
                    time.subs.add(new Line(start,end,current.toString()));
                    current.setLength(0);
                    state=1;
                }
            }
            else if(c=='}'){
                if(state==1){
                    start=Integer.parseInt(current.toString());
                    current.setLength(0);
                    state=2;
                }
                if(state==3){
                    end=Integer.parseInt(current.toString());
                    current.setLength(0);
                    state=4;
                }
            }
            else{
                current=current.append(c);
            }
            i++;
            if(i==s.length()) time.subs.add(new Line(start,end,current.toString()));
        }
        return time;
    }

}
