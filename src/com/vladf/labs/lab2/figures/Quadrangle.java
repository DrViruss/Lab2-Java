package com.vladf.labs.lab2.figures;

import com.vladf.labs.lab2.ifaces.IQuad;
import lombok.*;

public @ToString class  Quadrangle  implements IQuad {
    private@Getter double Line_a;
    private@Getter double Line_b;
    private@Getter double Line_c;
    private@Getter double Line_d;

    private@Getter double Perimeter;
    private @Getter double Area;


    public Quadrangle(double[] point1, double[]point2,double[] point3,double[]point4)
    {
        this.setLines(point1,point2,point3,point4);
        this.CalcData(this.Line_a,this.Line_b,this.Line_c,this.Line_d);
    }

    /**
     * Calculatig perimeter and area
     * @param Line_a
     * @param Line_b
     * @param Line_c
     * @param Line_d
     */
    private void CalcData(double Line_a, double Line_b, double Line_c, double Line_d)
    {
        this.Perimeter = getPerimetre( Line_a, Line_b, Line_c, Line_d);
        this.Area = getArea( Line_a, Line_b, Line_c, Line_d);
    }

    private void setLines(double[] point1, double[]point2,double[] point3,double[]point4)
    {
        this.Line_a = getSize(point1,point2);
        this.Line_b = getSize(point2,point3);
        this.Line_c = getSize(point3,point4);
        this.Line_d = getSize(point4,point1);
    }

    @Override
    public String toString()
    {
        return "\nQuadrangle:"
                +"\n\tLine A:\t"+this.getLine_a()
                +"\n\tLine B:\t"+this.getLine_b()
                +"\n\tLine C:\t"+this.getLine_c()
                +"\n\tLine D:\t"+this.getLine_d()
                +"\n\tPerimeter:\t"+this.getPerimeter()
                +"\n\tArea:\t"+this.getArea();
    }
}
