package com.bham.pij.assignments.resultchecker;

import java.util.Scanner;

public class ResultChecker {
    public static void main(String[] args) {

        ResultChecker rc = new ResultChecker();

        int[] grades = new int[8];

        for (int i = 0; i <8; i++) {

            Scanner in = new Scanner(System.in);
            System.out.println("pls enter grade");
            if (in != null) {
                grades[i] = in.nextInt();
            }else{
                i -=1;
            }
        }

        Scanner in = new Scanner(System.in);
        System.out.println("pls enter project grade");
        int projectGrade = in.nextInt();

        System.out.print(rc.getResult(grades, projectGrade));
    }
    public String getResult (int[] grades, int projectGrade){

        double sum = 0.0;
        for (int value : grades) {
            if (value >= 0 && value<=100){
                sum += value;
            }else{
                return "ERROR";
            }
        }
        sum /= grades.length;
        System.out.println(sum);
        if(sum >= 40 && projectGrade >= 40){
            if(sum >= 50 && projectGrade >=50){
                return "MERIT";
            }else{
                return "PASS";
            }
        }else{
            return "FAIL";
        }

    }
}
