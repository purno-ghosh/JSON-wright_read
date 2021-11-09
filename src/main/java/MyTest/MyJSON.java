package MyTest;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.J;

public class MyJSON {

    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
        //WriteJSON();
        //readJSONFile();
       // WriteJSONlist();
       readJSONlist(0);
    //for(int i=0;i<2;i++){
    //readJSONlist(i);

// }

    }
    //JSON Write HOW TO ATM WORK JSON
    public static void WriteJSON() throws IOException {
        JSONObject empObj=new JSONObject();
        empObj.put("Customer_Name","Name: Mr.Purno Ghosh");
        empObj.put("Bank_Name","Bank Name : Datch Bangla Bank");    
        empObj.put("Balance","Balance : 5000");
        empObj.put("Balance_Withdrow","Balance Withdrow : 3000");
        empObj.put("Your_Current_Balance","Your New Balance : 2000");

        //System.out.println(empObj);
        FileWriter file = new FileWriter("emp.json");
        file.write(empObj.toJSONString());
        file.flush();
        file.close();
        System.out.print(empObj);
    }
    //JSON READ
    public static void readJSONFile() throws IOException, ParseException, org.json.simple.parser.ParseException {
       JSONParser jsonParser = new JSONParser();
       Object obj = jsonParser.parse(new FileReader("emp.json"));
       JSONObject empObj = (JSONObject) obj;
       //System.out.println(empObj);
       String Customer_Name=(String) empObj.get("Customer_Name");
       System.out.println(Customer_Name);
        String Bank_Name=(String) empObj.get("Bank_Name");
        System.out.println(Bank_Name);
        String Balance=(String) empObj.get("Balance");
        System.out.println(Balance);
        String Balance_Withdrow=(String) empObj.get("Balance_Withdrow");
        System.out.println(Balance_Withdrow);
        String Your_Current_Balance=(String) empObj.get("Your_Current_Balance");
        System.out.println(Your_Current_Balance);

   }
//json multiple data write and read
    public static void WriteJSONlist() throws IOException, org.json.simple.parser.ParseException {

        char ch;
        String fileName="student.json";
        do {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONObject studentObj = new JSONObject();

            Scanner input = new Scanner(System.in);
            System.out.println("What is your question: ");
            studentObj.put("Question", input.nextLine());
            System.out.println("Option-1: ");
            studentObj.put("Option-1", input.nextLine());
            System.out.println("Option-2: ");
            studentObj.put("Option-2", input.nextLine());
            System.out.println("Answer: ");
            studentObj.put("Answer", input.nextLine());

            JSONArray jsonArray = (JSONArray) obj;
            //System.out.print(jsonArray);
            jsonArray.add(studentObj);
            FileWriter file = new FileWriter(fileName);
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Your Answer is Saved!");
            System.out.print(jsonArray);
            System.out.println("\nDo you want to add more Question?[y/n]");
            ch=input.next().charAt(0);

        }
        while(ch!='n');

    }

    public static void  readJSONlist(int pos) throws IOException, org.json.simple.parser.ParseException {
        String fileName="student.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        //System.out.println(json);

        String Question = (String) jsonObject.get("Question");
        String Answer = (String) jsonObject.get("Answer");

        System.out.println(Question);
        System.out.println(Answer);

    }
}

