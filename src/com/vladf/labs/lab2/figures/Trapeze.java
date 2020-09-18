package com.vladf.labs.lab2.figures;


import lombok.*;

public class Trapeze extends Quadrangle{
    private @Getter double CentLine;

    public Trapeze(double[] point1, double[] point2, double[] point3, double[] point4)
    {
        super(point1, point2, point3, point4);
        this.CalcCentLine();
    }

    private void CalcCentLine()
    {
        this.CentLine = (this.getLine_a() + this.getLine_c())/2;
    }

    @Override
    public String toString()
    {
        return "\nTrapeze:"
                +"\n\tLine A:\t"+this.getLine_a()
                +"\n\tLine B:\t"+this.getLine_b()
                +"\n\tLine C:\t"+this.getLine_c()
                +"\n\tLine D:\t"+this.getLine_d()
                +"\n\tPerimeter:\t"+this.getPerimeter()
                +"\n\tArea:\t"+this.getArea()
                +"\n\tCentraLine:\t"+this.CentLine;
    }


}
