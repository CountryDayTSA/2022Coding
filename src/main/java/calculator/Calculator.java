package calculator;
import java.text.DecimalFormat;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Calculator {
    final double AP = 1.15;
    final double Honors = 1.1;
    final double CollegeOthers = 1.0;
    final double Elective = 1.0;
    private ArrayList<Double> allGrades;
    public Calculator(){
        this.allGrades = new ArrayList<>();
    }
    public double getGradeOfClass(double grade,int weighting){

        if(grade == 1){
            grade = 4.0;
        }
        else if(grade == 2){
            grade = 3.67;
        }
        else if(grade == 3){
            grade = 3.33;
        }
        else if(grade == 4){
            grade = 3.00;
        }
        else if(grade == 5){
            grade = 2.67;
        }
        else if(grade == 6){
            grade = 2.33;
        }
        else if(grade == 7){
            grade = 2.00;
        }
        else if(grade == 8){
            grade = 1.67;
        }
        else if(grade == 9){
            grade = 1.33;
        }
        else if(grade == 10){
            grade = 1.00;
        }
        else{
            grade = 0;
        }
        if(weighting == 1){
            grade *= AP;
        }
        else if(weighting == 2){
            grade *= Honors;

        }
        else if(weighting  == 3){
            grade *= CollegeOthers;
        }
        else{
            grade *= Elective;
        }
        allGrades.add(grade);
         DecimalFormat df = new DecimalFormat("#.##");
         df.format(grade);
        return grade;
    }

    public double getFinalGPA(){
        double result = 0;
        for(int i = 0; i <= allGrades.size()-1; i++){
          result += allGrades.get(i);
      }
      return result/allGrades.size();
    }
}

