package com.vladf.labs.lab2.utils;

import com.vladf.labs.lab2.ifaces.IQuad;
import com.vladf.labs.lab2.figures.Quadrangle;
import com.vladf.labs.lab2.figures.Trapeze;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inputer {


    /**
     * Just text. Nothing interesting
     */
    private static void PrintMenu() {
        System.out.println("1.Add new Figure\n2.Show All\n3.Remove\n4.Export\n5.Import\n6.Exit");
    }

    /**
     * Removing object from array
     * @param Figure array
     * @throws IOException
     */
    private static void remove(ArrayList<IQuad> arr) throws IOException
    {
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

    /**
     * Lets cler screen!
     * (Works only in terminal and command prompt)
     * @throws IOException
     */
    private static void ClearScreen() throws IOException
    { //Dont work on IDA
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("/-----------------------------------------/");
    }

    /**
     * Lets make way without exeptions
     * @param Array index
     * @return digit
     */
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

    /**
     * Input coords
     */
    private static void Input()
    {

            System.out.println("A:");
            for(int i=0; i<2;i++)
                IQuad.A[i] = MayError(i);
            System.out.println("B:");
            for(int i=0; i<2;i++)
                IQuad.B[i] = MayError(i);
            System.out.println("C:");
            for(int i=0; i<2;i++)
                IQuad.C[i] = MayError(i);
            System.out.println("D:");
            for(int i=0; i<2;i++)
                IQuad.D[i] = MayError(i);
    }

    /**
     * Getting results
     * @param Figures array
     * @return result :D
     */
    private String FinalResult(ArrayList<IQuad> arr)
    {
    String result="";
    //Quadrangle result
    byte _tmp =(byte)IQuad.QWBA(arr);
    if(_tmp!=-1)
        result+="\nQuadrangle with smallest area\t-\t #" + (_tmp+1);
    else
        result+="\nThere are no quadrangles in list. So I cant find smallest area";
    //Trapeze result
    _tmp =(byte)IQuad.TWBCL(arr);
    if(_tmp!=-1)
        result+="\nTrapeze with biggest centralline\t-\t #" + (_tmp+1);
    else
        result+="\nThere are no trapezes in list. So I cant find biggest CL";


    return result;
}

    /**
     * Define object and add it to ArrayList
     * @param arr
     * @return
     */
    public boolean WWO(ArrayList<IQuad> arr)
    {
        if(!IQuad.isDot()) {
            IQuad Q;
            if (IQuad.isTrapeze(IQuad.A, IQuad.B, IQuad.C, IQuad.D))
                Q = new Trapeze(IQuad.A, IQuad.B, IQuad.C, IQuad.D);
            else
                Q = new Quadrangle(IQuad.A, IQuad.B, IQuad.C, IQuad.D);
            arr.add(Q);
            return true;
        }
        return false;
    }

    /**
     * Try to write data to file.
     * @param arr
     * @param sc
     * @throws IOException
     */
    private void WritingToFile(ArrayList<IQuad>arr, Scanner sc) throws IOException
    {
        FileWorker fw = new FileWorker();
        System.out.println("Do you want to use serialization?([Y]es/[N]o/[A]bort)");
        while (true)
        {
            String _choise = sc.next();
            if(_choise.charAt(0)=='Y'||_choise.charAt(0)=='y')
            {
                if(fw.SerializeWrite(arr))
                    System.out.println("All data has been saved succesfully!");
                else {
                    System.out.println("Seems like saving has been failed.\nIf you want to reset file press 'Y' else press 'N'");
                    String __tmp =" ";
                    while(true) {
                        __tmp = sc.next();
                        if (__tmp.charAt(0) =='Y' || __tmp.charAt(0)=='y') {
                            if (fw.RecreateFile())
                            {
                                if(fw.SerializeWrite(arr))
                                    System.out.println("All data has been saved succesfully!");
                                else
                                    System.out.println("We cant fix this error. Please create issue on GitHub.");
                            }
                            else
                                System.out.println("Permission ERROR. You must to fix it manually \\uD83D\\uDE1B");
                            break;
                        }
                        else if (__tmp.charAt(0) =='N' || __tmp.charAt(0)=='n')
                        {
                            //DO SOMETHING
                            PrintMenu();
                            break;
                        }
                        else
                            continue;
                    }
                }
                break;
            }
            else if(_choise.charAt(0)=='N'||_choise.charAt(0)=='n')
            {
                if(fw.Write(arr))
                    System.out.println("All data has been saved succesfully!");
                else {
                    System.out.println("Seems like saving has been failed.\nIf you want to reset file press 'Y' else press 'N'");
                    String __tmp =" ";
                    while(true) {
                        __tmp = sc.next();
                        if (__tmp.charAt(0) =='Y' || __tmp.charAt(0)=='y') {
                            if (fw.RecreateFile())
                            {
                                if(fw.Write(arr))
                                    System.out.println("All data has been saved succesfully!");
                                else
                                    System.out.println("We cant fix this error. Please create issue on GitHub.");
                            }
                            else
                                System.out.println("Permission ERROR. You must to fix it manually \\uD83D\\uDE1B");
                            break;
                        }
                        else if (__tmp.charAt(0) =='N' || __tmp.charAt(0)=='n')
                        {
                            //DO SOMETHING
                            PrintMenu();
                            break;
                        }
                        else
                            continue;
                    }
                }
                break;
            }
            else if(_choise.charAt(0)=='A'||_choise.charAt(0)=='a')
            {
                System.out.println("Aborting..");
                break;
            }

        }

    }


    /**
     * Main menu
     * @param Figures array
     * @throws IOException
     */
    public void Menu(ArrayList<IQuad> arr) throws IOException
    {
    PrintMenu();
    do {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            ClearScreen();
            switch (sc.nextInt()) {
                case (1):
                    boolean _tmp = false;
                    do {
                        Input();
                        _tmp = !WWO(arr);
                        ClearScreen();
                        if(_tmp)
                            System.out.println("Nice try \uD83D\uDE09 \nLets try again!");
                    }while (_tmp);
                    PrintMenu();
                    break;
                case (2):
                    if(arr.size()!=0)
                    {
                        for (int i = 0; i < arr.size(); i++)
                            System.out.println(i + 1 + ". " + arr.get(i).toString());
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~Main Result~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                                +FinalResult(arr));
                    }
                    else
                        System.out.println("List is empty");
                    System.out.println("");
                    PrintMenu();
                    break;
                case (3):
                    System.out.println("Please input number of element (0 - abord)");
                    remove(arr);
                    PrintMenu();
                    break;
                case (4):
                    WritingToFile(arr,sc);
                    ClearScreen();
                    PrintMenu();
                    break;
                case (5):
                    arr = ReadFromFile(arr,sc);
                    ClearScreen();
                    PrintMenu();
                    break;

                case (6):
                    System.out.println("BYE");
                    System.exit(0);
                    break;

                default:
                    System.out.println("IDK this command");
            }
        } else
            System.out.println("Unknown command");
    } while (true);
}

    private ArrayList<IQuad> ReadFromFile(ArrayList<IQuad> arr, Scanner sc) throws IOException,NullPointerException {
        FileWorker fw = new FileWorker();
        System.out.println("Do you want to use serialization?([Y]es/[N]o/[A]bort)");
        while (true)
        {
            String _choise = sc.next();
            if(_choise.charAt(0)=='Y'||_choise.charAt(0)=='y')
            {
                arr = fw.SerializeRead();
                for (int i = 0; i < arr.size(); i++) {
                    String s= null;
                    try {
                        s=arr.get(i).toString();

                        if(s.contains("\n\tLine A:\t0.0"))
                        {
                            arr.remove(i);
                            i-=1;
                            continue;
                        }
                    }
                    catch (Exception e)
                    {}
                }
                for (int i = arr.size()-1; i >-1; i--)
                    if (arr.get(i)==null)
                        arr.remove(i);

                return arr;
            }
            else if(_choise.charAt(0)=='N'||_choise.charAt(0)=='n')
            {
                arr = fw.Read();
                if(arr == null)
                    arr=new ArrayList<>();
                return arr;
            }
            else if(_choise.charAt(0)=='A'||_choise.charAt(0)=='a')
            {
                System.out.println("Aborting..");
                arr=new ArrayList<>();
                return arr;
            }

        }
    }
}
