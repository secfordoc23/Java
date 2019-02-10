//Program: personapp
//This: Employee.java
//Date: 1/24/2017
//Author: Jason Welch
//Purpose: A class for an Employee

package personapp;


public class Employee extends Person
{
    protected String office;
    protected double salary;
    protected MyDate hireDate;
    
    //=============== Default Constructor ==============================
    public Employee()
    {
        super();
        this.office = "210";
        this.salary = 50000.00;
        this.hireDate = new MyDate();        
    }
    
    //=============== Constructor w/ Param ==============================
    public Employee(String office, double salary, MyDate hireDate, String name, String address, String phoneNumber, String emailAddress)
    {
        super(name, address, phoneNumber, emailAddress);
        this.office = office;
        this.salary = salary;
        this.hireDate = hireDate;
    }
    
    //=============== Setters and Getters ==============================
    public String getOffice()
    {
        return office;
    }

    public void setOffice(String office)
    {
        this.office = office;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public MyDate getHireDate()
    {
        return hireDate;
    }

    public void setHireDate(MyDate hireDate)
    {
        this.hireDate = hireDate;
    }

    //=============== toString ==============================
    @Override
    public String toString()
    {
        return "Employee:"
                + "\n\tname=" + name 
                + "\n\taddress=" + address 
                + "\n\tphoneNumber=" + phoneNumber 
                + "\n\temailAddress=" + emailAddress
                + "\n\toffice=" + office 
                + "\n\tsalary=" + salary 
                + "\n\thireDate=" + hireDate.getMonth() + "/" + hireDate.getDay() + "/" + hireDate.getYear();
    }
    
}
