public class Main {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("Ozkan","1041","MATH");
        Teacher t2 = new Teacher("Murat","206","TUR");
        Teacher t3 = new Teacher("Serkan","1074","FİZ");

        Course math = new Course("Math","1041","MATH",55,t1);
        Course tur = new Course("Turkce","206","TUR",55,t2);
        Course fiz = new Course("Physics","1074","FİZ",55,t3);

        Student s1 = new Student("İnek Şaban", 4, "140144015", math, tur, fiz);
        s1.math.soz = 10;
        s1.tur.soz = 60;
        s1.fiz.soz =80;
        s1.addBulkExamNote(20,100,65);
        s1.isPass();

        Student s2 = new Student("Güdük Necmi", 4, "2211133", math, tur, fiz);
        s2.math.soz = 40;
        s2.tur.soz = 90;
        s2.fiz.soz =70;
        s2.addBulkExamNote(10,800,600);
        s2.isPass();

        Student s3 = new Student("Hayta İsmail", 4, "221121312",math, tur, fiz);
        s3.math.soz = 50;
        s3.tur.soz = 50;
        s3.fiz.soz =50;
        s3.addBulkExamNote(100,90,40);
        s3.isPass();

        math.addTeacher();
        fiz.addTeacher();
        tur.addTeacher();

    }


}