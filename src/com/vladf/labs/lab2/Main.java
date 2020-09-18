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

    }
}
