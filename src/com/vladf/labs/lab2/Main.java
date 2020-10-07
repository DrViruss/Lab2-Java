package com.vladf.labs.lab2;

import com.vladf.labs.lab2.ifaces.IQuad;
import com.vladf.labs.lab2.utils.Inputer;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<IQuad> _tmp= new ArrayList<>();
        Inputer in = new Inputer();
        in.Menu(_tmp);

        /*
        *   com.vladf.labs.lab2.figures.Quadrangle,1.4142135623730951,1.4142135623730951,1.4142135623730951,4.242640687119285
        *   com.vladf.labs.lab2.figures.Trapeze,1.0,1.4142135623730951,3.0,1.4142135623730951
        *
        * */

    }
}
