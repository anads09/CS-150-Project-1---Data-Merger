
package cs150proj01;

public class Student {
    private final int [] projectScores = new int[6];
    private final int [] testScores = new int [2];
    private final int [] labScores = new int [10];
    private final int [] hwScores = new int [10];
    private int finalExamGrade;   
    private String fname;
    private String lname;
    private String lectureSec;
    private String labSec;
    private String finalGrade;
    private String fullName = fname + "," + lname;
    private static final int MAXP = 6;
    private static final int MAXT = 2;
    private static final int MAXL = 10;
    private static final int MAXHW = 10;        
    
    public Student() {
        
    }
    
    public void setName(String f, String l) {
        fname = f;
        lname = l;        
    }     
    
    public void setFName(String name) {
        fname = name;
    }
    
    public void setLName(String name) {
        lname = name;
    }    
    
    public String getFullName() {
        return fullName;
    }
    
    public String getLName() {
        return lname;
    }
    
    public String getFName() {
        return fname;
    }
    
    public void setLectureSection(String num) {
        lectureSec = num;
    }
    
    public void setLabSection(String num) {
        labSec = num;
    }
    
    public String getLabSection() {
        return labSec;
    }
    
    public String getLectureSection() {
        return lectureSec;
    }
    
    public void setHWScores(int [] array) {
        for(int i = 0; i < MAXHW; i++) {
            hwScores[i] = array[i];
        }
    }
    
    public void setProjectScores(int [] array) {
        for(int i = 0; i < MAXP; i++) {
           projectScores[i] = array[i];
        }
    }
    
    public void setTestScores(int [] array) { 
        for(int i = 0; i < MAXT; i++) {
            testScores[i] = array[i];
        }
    }
    
    public void addLabScore(int score, int labNum) {
        if(labNum < MAXL) {
            labScores[labNum] = score;
        }
    }
    
    public void setFinalExamGrade(int grade) {
        finalExamGrade = grade;
    } 
    
    public int getTestScore(int num) {
        return testScores[num];
    }
    
    public int getProjScore(int num) {
        return projectScores[num];
    }
    
    public int getHWScore(int num) {
        return hwScores[num];
    }
    
    public int getFinalExamGrade() {
        return finalExamGrade;
    }
    
    public int getLabScore(int num) {
        return labScores[num];
    }    
    
    public String getFirstName() {
        return fname;
    }
    
    public String getLastName() {
        return lname;
    }
    
    public double getLabPerc() {
        double labPerc = 0;
        for(int i = 0; i < MAXL; i++) {
            labPerc = labPerc + getLabScore(i);
        }
        return (labPerc/MAXL);
    }
    
    public double getHWPerc() {
        double hwPerc = 0;
        for(int i = 0; i < MAXHW; i++) {
            hwPerc = hwPerc + getHWScore(i);
        }
        return (hwPerc/MAXHW);
    }
    
    public double getProjPerc() {
        double projPerc = 0;
        for(int i = 0; i < MAXP; i++) {
            projPerc = projPerc + getProjScore(i);
        }
        return (projPerc/MAXP) * .30;
    }
    
    public double getTestPerc() {
        double testPerc = 0;
        for(int i = 0; i < MAXT; i++) {
            testPerc = testPerc + getTestScore(i);
        }
        return (testPerc/MAXT)  * .30;
    }
    
    public double getFinalExamGradePerc(double score) {
        double output = score * .20;
        return output;
    }
    
    public double getOverallPerc() {
        double out = getHWPerc() + getLabPerc() + getProjPerc() + getTestPerc() + getFinalExamGradePerc(getFinalExamGrade());        
        return out;
    }
    
    public void setLetterGrade() {
        double percGrade = getOverallPerc();
        if(percGrade >= 90) {
            finalGrade = "A";
        } else if (percGrade >= 80) {
            finalGrade = "B";
        } else if (percGrade >= 70) {
            finalGrade = "C";
        } else if (percGrade >= 59) {
            finalGrade = "D";
        } else {
            finalGrade = "F";
        }
    }
    
     public String calcLetterGrade(double rawGrade) {
        double percGrade = getOverallPerc();
        if(percGrade >= 90) {
            finalGrade = "A";
        } else if (percGrade >= 80) {
            finalGrade = "B";
        } else if (percGrade >= 70) {
            finalGrade = "C";
        } else if (percGrade >= 59) {
            finalGrade = "D";
        } else {
            finalGrade = "F";
        }
        return finalGrade;
    }     
}
