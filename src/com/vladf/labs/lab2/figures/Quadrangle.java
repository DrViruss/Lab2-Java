package com.vladf.labs.lab2.figures;

import com.vladf.labs.lab2.ifaces.IQuad;
import lombok.*;

public @ToString class  Quadrangle  implements IQuad {
    private @Getter double Line_a;
    private @Getter double Line_b;
    private @Getter double Line_c;
    private @Getter double Line_d;

    private@Getter double Perimeter;
    private @Getter double Area;

    /**
     * Constructig Quadrangle object by coords
     * @param point1
     * @param point2
     * @param point3
     * @param point4
     */
    public Quadrangle(double[] point1, double[]point2,double[] point3,double[]point4)
    {
        this.setLines(point1,point2,point3,point4);
        this.CalcData(this.Line_a,this.Line_b,this.Line_c,this.Line_d);
    }

    /**
     * Constructig Quadrangle object by lines
     * @param point1
     * @param point2
     * @param point3
     * @param point4
     */
    public Quadrangle(double line_a, double line_b, double line_c, double line_d) {
        Line_a = line_a;
        Line_b = line_b;
        Line_c = line_c;
        Line_d = line_d;
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

    /**
     * Just setting lines sizes
     * @param point1
     * @param point2
     * @param point3
     * @param point4
     */
    private void setLines(double[] point1, double[]point2,double[] point3,double[]point4)
    {
        this.Line_a = getSize(point1,point2);
        this.Line_b = getSize(point2,point3);
        this.Line_c = getSize(point3,point4);
        this.Line_d = getSize(point4,point1);
    }

    /**
     * What could it be?!
     * @return
     */
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

    @Override
    public String Export()
    {return this.getClass().getName()+","+getLine_a()+","+getLine_b()+","+getLine_c()+","+getLine_d();}

}
