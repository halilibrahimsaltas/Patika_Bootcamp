import java.util.Scanner;

public class Student {
    String name;
    int stuNO;
    String classes;
    Course math;
    Course tur;
    Course fiz;

    boolean isPass;

    double average;

    Student (String name, int stuNo, String classes,Course math, Course tur, Course fiz){
        this.name =name;
        this.stuNO=stuNo;
        this.classes=classes;
        this.math=math;
        this.tur=tur;
        this.fiz=fiz;
    }
    public void addBulkExamNote (int math, int tur ,int fiz){

        if (math>= 0 && math <= 100) {
            this.math.note = math;
        }

        if (tur >= 0 && tur <= 100) {
            this.tur.note = tur;
        }

        if (fiz >= 0 && fiz <= 100) {
            this.fiz.note = fiz;
        }

    }
    public void isPass(){
        if (this.math.note==0 || this.tur.note==0 ||this.fiz.note==0 ){
            System.out.println("ERROR: Note's block is empty!");
        }else {
            calcAverage();
            printNote();
            if (this.average > 55){
                System.out.println("Passed ");
            }else{
                System.out.println("Failed");
            }
        }
    }
    public void calcAverage() {
        double mathort = (this.math.note*0.8+this.math.soz*0.2);
        double turort = (this.tur.note*0.8+this.tur.soz*0.2);
        double fizort = (this.fiz.note*0.8+this.fiz.soz*0.2);

        this.average = ( mathort   + turort + fizort) / 3.0;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.math.note);
        System.out.println("Fizik Notu : " + this.fiz.note);
        System.out.println("Türkçe Notu : " + this.tur.note);
    }


}
