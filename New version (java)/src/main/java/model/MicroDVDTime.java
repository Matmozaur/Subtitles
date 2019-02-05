
package model;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public void changeByAproximatePolynomial(Map<Integer,Integer> points){
        Set<Integer> XS=points.keySet();
        Integer[] XD = XS.toArray(new Integer[XS.size()]);
        Integer[] YD=points.values().toArray(new Integer[XS.size()]);
        double[] X=new double[XD.length];
        double[] Y=new double[YD.length];
        int i=0;
        for(Integer d:XD){
            X[i++]=d.doubleValue();
        }
        i=0;
        for(Integer d:YD){
            Y[i++]=d.doubleValue();
        }
        PolynomialFunctionLagrangeForm p=new PolynomialFunctionLagrangeForm(X,Y);
        double[] w=p.getCoefficients();
        int degree=p.degree();
        for(Line l:subs){
            double x=0;
            for(i=0;i<=degree;i++){
                x=x+Math.pow(l.getStart(),i)*w[i];
            }
            System.out.println(x);
            l.setStart(l.getStart()+(int)x);
            x=0;
            for(i=0;i<=degree;i++){
                x=x+Math.pow(l.getEnd(),i)*w[i];
            }
            l.setEnd(l.getEnd()+(int)x);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(Line l:subs){
            sb.append(l.toString());
        }
        return sb.toString();
    }
}
