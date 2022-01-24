package calculator;

public class test {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        System.out.println(c1.getGradeOfClass(1,1));
        System.out.println(c1.getFinalGPA());
        System.out.println(c1.getGradeOfClass(2,4));
        System.out.println(c1.getGradeOfClass(6, 1));
        System.out.println(c1.getFinalGPA());
    }
}


