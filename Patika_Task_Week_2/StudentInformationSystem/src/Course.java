import java.util.Scanner;

public class Course {
    String name;
    String code;
    String prefix;
    int note;

    int soz;
    Teacher teacher;

    Course(String name, String code, String prefix, int note, Teacher teacher) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.note = note;
        this.teacher = teacher;

    }

    public void addTeacher() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the course name:");
        this.name = input.nextLine();
        switch (name) {
            case "fiz":
                System.out.println("Enter the course code:");
                this.code = input.nextLine();
                if (code.equals("1074")) {
                    System.out.println("Enter the teacher name:");
                    this.teacher.name=input.nextLine();
                    break;
                }else {
                System.out.println("Course code is wrong!");
                }

                break;
            case "math":
                System.out.println("Enter the course code:");
                this.code = input.nextLine();
                if (code.equals("1041")) {
                    System.out.println("Enter the teacher name:");
                    this.teacher.name = input.nextLine();
                    break;
                }else{
                System.out.println("Course code is wrong!");}
                break;

            case "tur":
                System.out.println("Enter the course code:");
                this.code = input.nextLine();
                if (code.equals("206")) {
                    System.out.println("Enter the teacher name:");
                    this.teacher.name=input.nextLine();
                }else {
                    System.out.println("Course code is wrong!");
                }
                break;

            default:
                System.out.println("Course name is wrong!");

        }
    }
    public void printTeacher() {
        if (teacher != null) {
            System.out.println(this.name + " dersinin Akademisyeni : " + teacher.name);
        } else {
            System.out.println(this.name + " dersine Akademisyen atanmamıştır.");
        }
    }


}