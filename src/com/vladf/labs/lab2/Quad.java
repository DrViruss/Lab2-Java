package com.vladf.labs.lab2;

import java.util.ArrayList;

public  interface Quad {
public ArrayList<Double>A = new ArrayList<>(2);
public ArrayList<Double>B = new ArrayList<>(2);
public ArrayList<Double>C = new ArrayList<>(2);
public ArrayList<Double>D = new ArrayList<>(2);

public default double getSize(ArrayList<Double> point1,ArrayList<Double>point2)
{
    return Math.sqrt(Math.pow(point2.get(0)-point1.get(0),2)+Math.pow(point2.get(1)-point1.get(1),2));
}

public default double getPerimetre(double Line_a,double Line_b,double Line_c,double Line_d)
{
    return Line_a+Line_b+Line_c+ Line_d;
}

public default double getArea(double Line_a,double Line_b,double Line_c,double Line_d)
{
    return Line_a*Line_b*Line_c* Line_d;
}

public static boolean isTrapeze(ArrayList<Double> point1, ArrayList<Double> point2, ArrayList<Double> point3, ArrayList<Double> point4)
{

        //pointX.get(n) dont work. so lets create temp vars
        double a1=point1.get(0);
        double a2=point1.get(1);
        double b1=point2.get(0);
        double b2=point2.get(1);
        double c1=point3.get(0);
        double c2=point3.get(1);
        double d1=point4.get(0);
        double d2=point4.get(1);

        if((a1 == b1 || a2 == b2)&&(c1 == d1 || c2 == d2)&&(a1 != c1 || a2 != c2)&&(b1 != d1 ||b2 != d2))
        {
            return true;
        }
        else
            return false;
    }


}
