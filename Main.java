
package datamerger;

import java.util.*;
import java.io.*;

public class Main {
    static PrintWriter toCSV = null;
    static Scanner fin = null;
    static ArrayList <Student> allStuds = new ArrayList();
    static final double FINALEXAMPERC = .20;
    static final int MAXP = 6;
    static final int MAXT = 2;
    static final int MAXL = 10;
    static final int MAXHW = 10;
    
    public static void main(String [] args) {
        loadLectureInfo("CS140-001.txt","CS140-001");
        loadLectureInfo("CS140-002.txt","CS140-002");
        loadLectureInfo("CS140-003.txt","CS140-003");
        loadLectureInfo("CS140-004.txt","CS140-004"); 
        
        loadLabInfo("CS140-021.txt","CS140-021");
        loadLabInfo("CS140-022.txt","CS140-022");
        loadLabInfo("CS140-023.txt","CS140-023");
        loadLabInfo("CS140-024.txt","CS140-024");
        loadLabInfo("CS140-025.txt","CS140-025");
        
        printResult();       
    }
    
    public static void printResult() {        
        try {
            toCSV = new PrintWriter ("CS140FinalGradeReport.csv");
        } catch (FileNotFoundException e) {
            System.out.println("File Already Exists!");
            System.exit(1);
        }        
        toCSV.println("First Name,Last Name,Lecture Section,Lab Section,Lab1,Lab2,Lab3,Lab4,Lab5,Lab6,Lab7,Lab8,Lab9,Lab10,Lab Points,Homework,Homework,Homework,Homework,Homework,Homework,Homework,Homework,Homework,Homework,Homework Points,Program1,Program2,Program3,Program4,Program5,Program6,Program Points,Test1,Test2,Test Points,Final Exam,Final Exam Points,Overall Percent,Final Grade");
        
        for(int i = 0; i < allStuds.size(); i++) {
            toCSV.print(allStuds.get(i).getFirstName() +"," + allStuds.get(i).getLastName() + "," + allStuds.get(i).getLectureSection() + "," + allStuds.get(i).getLabSection() +"," );
            for(int j = 0; j < MAXL; j++) {
                 toCSV.print(allStuds.get(i).getLabScore(j) + ",");
            }
            toCSV.printf("%.2f,",allStuds.get(i).getLabPerc());
            for(int j = 0; j < MAXHW; j++) {
                toCSV.print(allStuds.get(i).getHWScore(j) + ",");
            }
            toCSV.printf("%.2f,",allStuds.get(i).getHWPerc());
            for(int j = 0; j < MAXP; j++) {
                toCSV.print(allStuds.get(i).getProjScore(j) + ",");
            }
            toCSV.printf("%.2f,",allStuds.get(i).getProjPerc());
            for(int j = 0; j < MAXT; j++) {
                toCSV.print(allStuds.get(i).getTestScore(j) + ",");
            }
            toCSV.printf("%.2f",allStuds.get(i).getTestPerc());
            toCSV.print("," + allStuds.get(i).getFinalExamGrade()+",");
            toCSV.print(allStuds.get(i).getFinalExamGradePerc(allStuds.get(i).getFinalExamGrade()) +",");
            toCSV.print(allStuds.get(i).getOverallPerc() + ",");
            toCSV.print(allStuds.get(i).calcLetterGrade(allStuds.get(i).getOverallPerc()));
            toCSV.println();
        }
        toCSV.close();        
    }
    
    public static void loadLabInfo(String fileName, String labSection) {
        Scanner fin = null;      
              
        try {
            fin = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(1);
        }
        
        while (fin.hasNext()) {
            Student stud = new Student();
            String fname = fin.next();
            String lname = fin.next();
            
            int index = 0;
            for (int i = 0; i < allStuds.size(); i++) {     
                if (allStuds.get(i).getFirstName().equals(fname) && allStuds.get(i).getLastName().equals(lname)) {
                    index = i;                    
                }
            }
            allStuds.get(index).setLabSection(labSection);                    
            
            for(int i = 0; i < MAXL; i++) {
                allStuds.get(index).addLabScore(fin.nextInt(),i);
            }            
            stud.setLabSection(labSection);
        }
    }
    
    public static void loadLectureInfo(String fileName,String lectureSec) {
        try {
            fin = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);            
        } 
        
        while (fin.hasNext()) {                       
            Student stud = new Student();
            stud.setName(fin.next(), fin.next());
            stud.setLectureSection(lectureSec); 
            int numStuds = allStuds.size();
            int [] hw = new int [MAXHW];
            for(int i = 0; i < MAXHW; i++) {
                hw[i] = fin.nextInt();
            }            
            stud.setHWScores(hw);
                
            int [] projects = new int [MAXP];
            for(int i = 0; i < MAXP; i++) {
                projects[i] = fin.nextInt();
            }
            stud.setProjectScores(projects);
                
            int [] tests = new int [MAXT];
            for(int i = 0; i < MAXT; i++) {
                tests[i] = fin.nextInt();
            }
            stud.setTestScores(tests);
                
            int finalExamGrade = fin.nextInt();   
            stud.setFinalExamGrade(finalExamGrade);
            allStuds.add(stud);  
        }
    }
}
    
