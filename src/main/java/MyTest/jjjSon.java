package MyTest;
import netscape.javascript.JSObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class jjjSon {

    public static void main(String[] args) throws IOException {
            fileRead();
    }

    public static void fileWrite() throws IOException {
    FileWriter fw = new FileWriter("MyFile.txt",true);
        fw.write("Hello purno this is purno computer \n i want to be a software testing engeneer ");
        fw.close();
    }

    public static void fileRead() throws IOException {
        FileReader reader = new FileReader("MyFile.txt");
        int character;
        while ((character = reader.read()) != -1) {

            System.out.print((char) character);

        }

        System.out.println(reader.read());
        reader.close();
    }

    }




