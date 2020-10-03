package com.vladf.labs.lab2.utils;

import com.vladf.labs.lab2.figures.Quadrangle;
import com.vladf.labs.lab2.figures.Trapeze;
import com.vladf.labs.lab2.ifaces.IQuad;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWorker {
    private final File file = new File("DATA.lab2");

    /**
     * Read data from file
     * @return
     * @throws IOException
     */
    public ArrayList<IQuad> Read() throws IOException {
        ArrayList<IQuad> result = new ArrayList<>();
        if(!file.exists())
            return null;
        else {
            FileReader fr = new FileReader(file);
            Scanner scanner = new Scanner(fr);
            IQuad q;
            int line =0;
                while (scanner.hasNextLine()) {
                    line +=1;
                    String[] _tmp = scanner.nextLine().split(",");

                    double a = 0;
                    double b = 0;
                    double c = 0;
                    double d = 0;

                    try {
                         a = Double.valueOf(_tmp[1]);
                         b = Double.valueOf(_tmp[2]);
                         c = Double.valueOf(_tmp[3]);
                         d = Double.valueOf(_tmp[4]);
                    }catch (Exception e)
                    {

                        System.out.println("FATAL ERROR in " + line + "s line. Skipping...");
                    }

                    if (_tmp[0].contains("Quadrangle")) {
                        q = new Quadrangle(a,b ,c ,d );
                        result.add(q);
                    } else if (_tmp[0].contains("Trapeze")) {
                        q = new Trapeze(a, b, c,d);
                        result.add(q);
                    } else
                        System.out.println("FATAL ERROR in " + line + "s line. Skipping...");
                }
                scanner.close();
                fr.close();
            return result;
        }
    }

    /**
     * Write list objects to file
     * @param List IQuad
     * @return success?
     * @throws IOException
     */
    public boolean Write(ArrayList<IQuad> List) throws IOException {
        HowIsThere();
        FileWriter fw ;
        String _tmp=" ";
        for (int i=0;i<List.size();i++)
            _tmp += List.get(i).Export()+"\n";
        try{
            file.setWritable(true);
            fw =  new FileWriter(file);
            fw.write(_tmp);
            //FINALEs
            fw.close();
        }
        catch (Exception e)
        {
            System.out.println("ERROR: "+e.getMessage()+".\n"+"Aborting...");
            return false;
        }
        file.setReadOnly();
        return true;
    }

    /**
     * If file not exist - create it
     * @throws IOException
     */
    private void HowIsThere() throws IOException {
        if(!file.exists())
            file.createNewFile();
    }

    /**
     * If we cant write - try to remove and create again
     * @return success
     */
    public boolean RecreateFile()
    {
        if(file.canWrite())
            return false;
        else {
            file.delete();
            return true;
        }
    }
}