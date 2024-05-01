public class Teacher {
    String name;
    String code;
    String branch;

    Teacher (String name, String code, String branch){
        this.name =name;
        this.code =code;
        this.branch = branch;
    }
    void print(){
        System.out.println("Name: " + this.name);
        System.out.println("Code: " + this.code);
        System.out.println("Branch: " + this.branch);

    }




}
