package com.bham.pij.assignments.meangrade;

import java.util.Scanner;

public class MeanGrade {
	public static void main(String[] args) {

		MeanGrade mg = new MeanGrade();

		int[] grades = new int[4];
 
		for (int i = 0; i < 4; i++) {

			System.out.print(i);
			Scanner in = new Scanner(System.in);
			System.out.println("pls enter an int");
			grades[i] = in.nextInt();
			
			}
			System.out.print(mg.computeMean(grades));
		}
	public double computeMean (int[] grades){
	    for (int i = 0; i<grades.length;i++){
		if (grades[i]<0 || grades[i]>100){
		    return -1.0;
		}
	        }
	    
		double sum = 0.0;
  		for (int value : grades) {
        		sum += value;
    			}
    		sum /= grades.length;
		return sum;
		}
	
		
		
	}
