package com.vladf.labs.lab2.figures;


import lombok.*;

public class Trapeze extends Quadrangle{
    private @Getter double CentLine;

    public Trapeze(double line_a, double line_b, double line_c, double line_d, double perimeter, double area, double centLine) {
        super(line_a, line_b, line_c, line_d, perimeter, area);
        if(line_a==0||line_b==0||line_c==0||line_d==0)
        {
            System.out.println("Currupted data. Skip..");
        }
        else {
            if (centLine != 0)
                CentLine = centLine;
            else
                this.CalcCentLine();
        }
    }

    /**
     * Constructig Trapeze object by coords
     * @param point1
     * @param point2
     * @param point3
     * @param point4
     */
    public Trapeze(double[] point1, double[] point2, double[] point3, double[] point4)
    {
        super(point1, point2, point3, point4);
        this.CalcCentLine();
    }

    /**
     * Constructig Trapeze object by lines
     * @param point1
     * @param point2
     * @param point3
     * @param point4
     */
    public Trapeze(double line_a, double line_b, double line_c, double line_d)
    {
        super(line_a, line_b, line_c, line_d);
        this.CalcCentLine();
    }

    /**
     * Calculating CentralLine of trapeze
     */
    private void CalcCentLine()
    {
        this.CentLine = (this.getLine_a() + this.getLine_c())/2;
    }

    /**
     * What could it be?!
     * @return
     */
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
