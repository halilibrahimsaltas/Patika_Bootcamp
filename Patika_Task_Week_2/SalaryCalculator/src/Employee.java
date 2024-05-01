public class Employee {
    //Salary Calculator
    String name;
    double salary ;
    int workHours;

    int hireYear;
    Employee (String name, double salary, int workHours, int hireYear){ //Employe's informations
        this.name=name;
        this.salary=salary;
        this.workHours=workHours;
        this.hireYear=hireYear;

    }

    public  double tax(){ // Tax Calculator
        if (this.salary>1000){
            return this.salary*0.03;
        }return 0;
    }
    public  double bonus(){ // Bonus Calculator
        if (this.workHours>40){
            return (this.workHours-40)*30;
        }
        return 0;
    }
    public double riseSalary(){ // Next Salary rise calc.
        if ((2021-this.hireYear)<10){
            return this.salary*0.5;
        }else if ((2021-this.hireYear)<20){
            return this.salary*0.10;
        }else {
            return this.salary*0.15;
        }
    }
    public void toPrint(){ // All informations about employe
        System.out.println("Name: " +this.name); // name
        System.out.println("Salary: " + this.salary); // base salary
        System.out.println("Work Hours: " + this.workHours); // work hours
        System.out.println("Hired Year: " + this.hireYear); // hire year
        System.out.println("Tax: " + tax());// tax
        System.out.println("Bonus: "+ bonus()); // bonus
        System.out.println("Salary Increase: " + riseSalary()); //Salary Increase
        System.out.println("Salary with Tax and Bonuses :" + (this.salary-tax()+bonus()));//Salary with Tax and Bonuses
        System.out.println("Total Salary: " +(this.salary-tax()+bonus()+riseSalary())); // total salary

    }
}
