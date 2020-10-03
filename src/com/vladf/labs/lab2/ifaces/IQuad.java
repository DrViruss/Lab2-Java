package com.vladf.labs.lab2.ifaces;

import com.vladf.labs.lab2.figures.Quadrangle;
import com.vladf.labs.lab2.figures.Trapeze;

import java.util.ArrayList;
import java.util.Arrays;

public  interface IQuad {
public double[] A = new double[2];
public double[] B = new double[2];
public double[] C = new double[2];
public double[] D = new double[2];

    public default double getSize(double[] point1,double[]point2)
    {
    return Math.sqrt(Math.pow(point2[0]-point1[0],2)+Math.pow(point2[1]-point1[1],2));
}

    public default double getPerimetre(double Line_a,double Line_b,double Line_c,double Line_d)
    {
    return Line_a+Line_b+Line_c+ Line_d;
}

    public default double getArea(double Line_a,double Line_b,double Line_c,double Line_d)
    {
    return Line_a*Line_b*Line_c* Line_d;
}

    /**
     * Lets check it!
     * @param point1
     * @param point2
     * @param point3
     * @param point4
     * @return any guesses? -_-
     */
    public static boolean isTrapeze(double[] point1, double[] point2, double[] point3, double[] point4)
    {
boolean _tmp1=false;
boolean _tmp2 =false;
    if(((point2[1]-point1[1])/(point2[0]-point1[0])==((point3[1]-point4[1])/(point3[0]-point4[0]))))
        _tmp1=true;
    if(((point1[1]-point4[1])/(point1[0]-point4[0])==((point3[1]-point2[1])/(point3[0]-point2[0]))))
        _tmp2=true;
    if(_tmp1==_tmp2)
        return false;
    else
        return true;
    }

    /**
     * Trapeze With Biggest Central Line
     * @param Figure array
     * @return figure number
     */
    public static int TWBCL(ArrayList<IQuad> arr)
    {
        Trapeze _t0;
        Trapeze _t1;
        int _tmp = -1;
        if(arr.get(0).getClass() == Trapeze.class)
        _tmp=0;
        for(int i=1;i<arr.size();i++)
            if(arr.get(i).getClass() == Trapeze.class) {
                _tmp=0;
                if(arr.get(i-1).getClass() == Trapeze.class) {
                    _t1 = (Trapeze) arr.get(i);
                    _t0 = (Trapeze) arr.get(i - 1);
                    if (_t1.getCentLine() > _t0.getCentLine())
                        _tmp = i;
                }
                else
                    _tmp=i;
            }

        return _tmp;
    }

    /**
     * Quadrangle With Biggest Area
     * @param Figure array
     * @return figure number
     */
    public static int QWBA(ArrayList<IQuad> arr)
    {
        Quadrangle  _q0;
        Quadrangle _q1;
        int _tmp = -1;
        if(arr.get(0).getClass() == Quadrangle.class)
            _tmp=0;
        for(int i=1;i<arr.size();i++)
            if(arr.get(i).getClass() == Quadrangle.class) {
                _tmp=0;
                if(arr.get(i-1).getClass() == Quadrangle.class) {
                    _q1 = (Quadrangle) arr.get(i);
                     _q0 = (Quadrangle) arr.get(i - 1);
                    if (_q1.getArea() <  _q0.getArea())
                        _tmp = i;
                }
                else
                    _tmp=i;
            }

        return _tmp;
    }

    /**
     * Is it dot?! Lets check it ;)
     * @return
     */
    public static boolean isDot()
    {
        return Arrays.equals(A , B) ||Arrays.equals(A , C)||Arrays.equals(A , D) || Arrays.equals(C , B)||Arrays.equals(D , B)||Arrays.equals(D , C );
    }

    /**
     * Export
     * @return string: type,lineA,lineB,lineC,lineD
     */
    public default String Export() {
        return null;
    }
}
