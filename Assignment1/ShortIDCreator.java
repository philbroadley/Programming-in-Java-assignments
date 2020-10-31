packadge com.bham.pij.assignments.shortidcreator;

import java.util.Scanner;

public class ShortIDCreator {

    public static void main(String[] args){

        ShortIDCreator sc = new ShortIDCreator();

        Scanner scan = new Scanner(System.in);
        System.out.println("pls enter your name");
        String name = scan.nextLine();
        System.out.print(sc.createID(name));

    }

    public String createID(String name){
        name = name.toLowerCase();
        String[] names = name.split(" ");
        String ID = "";
        for (int i = 0; i < names.length; i++) {
            char temp = names[i].charAt(0);
            System.out.println(temp);
            ID = ID + temp;
        }
        if (ID.length()==3) {
            return ID;
        }else if (ID.length()==2){
            ID = ID.substring(0, 1) + "x" + ID.substring(1);
            return ID;
        }else{
            return "error";
        }
        }

}


