package com.vladf.labs.lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inputer {
    private static void PrintMenu() {
        System.out.println("1.Add new Figure\n2.Show All\n3.Remove\n4.Exit");
    }

    private static void remove(ArrayList<Quad> arr) throws IOException {
        do {
            Scanner ssc = new Scanner(System.in);
            if(ssc.hasNextInt()) {
                int _tmp = ssc.nextInt();
                if(_tmp>0) {
                    if (_tmp <= arr.size()) {
                        arr.remove(_tmp-1);
                        ClearScreen();
                        System.out.println("Succes!");
                        break;
                    }
                    else {
                        ClearScreen();
                        System.out.println("We dont have figure with that number. Abording...");
                        break;
                    }
                }
                else if(_tmp==0) {
                    ClearScreen();
                    System.out.println("Abording...");
                    break;
                }
            }
            else {
                ClearScreen();
                System.out.println("Unknown number");
            }

        }while (true);
    }

    private static void ClearScreen() throws IOException { //Dont work on IDA
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("/-----------------------------------------/");
    }

    private static double MayError(int i)
    {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (i%2==0)
                System.out.println("x:");
            else
                System.out.println("y:");
            if (scanner.hasNextDouble())
                return scanner.nextDouble();
            else
                System.out.println("ERROR");
        }
    }
    private static void PointInit()
    {
        //Out of order :D
//        ArrayList<ArrayList<Double>> _tmp = new ArrayList<>();
//        for (int i=0;i<_tmp.size();i++)
//            for (int j=0;j<2;j++)
//                _tmp.get(i).add((double)0);


        //seems strange, but works :D
        Quad.A.add((double)0);
        Quad.A.add((double)0);
        //
        Quad.B.add((double)0);
        Quad.B.add((double)0);
        //
        Quad.C.add((double)0);
        Quad.C.add((double)0);
        //
        Quad.D.add((double)0);
        Quad.D.add((double)0);

    }

    private static void Input() {
            PointInit();

            System.out.println("A:");
            for(int i=0; i<2;i++)
                Quad.A.set(i,MayError(i));
            System.out.println("B:");
            for(int i=0; i<2;i++)
                Quad.B.set(i,MayError(i));
            System.out.println("C:");
            for(int i=0; i<2;i++)
                Quad.C.set(i,MayError(i));
            System.out.println("D:");
            for(int i=0; i<2;i++)
                Quad.D.set(i,MayError(i));
    }


public void Menu(ArrayList<Quad> arr) throws IOException {
    PrintMenu();
    do {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            ClearScreen();
            switch (sc.nextInt()) {
                case (1):
                    Input();
                    Quad Q ;
                    if (Quad.isTrapeze(Quad.A,Quad.B,Quad.C,Quad.D))
                        Q = new Trapeze(Quad.A,Quad.B,Quad.C,Quad.D);
                    else
                        Q = new Quadrangle(Quad.A,Quad.B,Quad.C,Quad.D);
                    arr.add(Q);
                    ClearScreen();
                    PrintMenu();
                    break;
                case (2):
                    for (int i = 0; i < arr.size(); i++)
                        System.out.println(i + 1 + ". " + arr.get(i).toString());
                    System.out.println("");
                    PrintMenu();
                    break;
                case (3):
                    System.out.println("Please input number of element (0 - abord)");
                    remove(arr);
                    PrintMenu();
                    break;
                case (4):
                    System.out.println("BYE");
                    System.exit(0);
                default:
                    System.out.println("IDK this command");
            }
        } else
            System.out.println("Unknown command");
    } while (true);
}

}
