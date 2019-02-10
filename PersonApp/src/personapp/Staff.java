//Program: personapp
//This: Staff.java
//Date: 1/24/2017
//Author: Jason Welch
//Purpose: A class for a Staff Member

package personapp;


public class Staff extends Employee 
{
    private String title;

    //========================= Default Constructor ===========================
    public Staff()
    {
        super();
        this.title = "Janitor";
    }

    //========================= Constructor w/ Param ===========================
    public Staff(String title, String office, double salary, MyDate hireDate, String name, String address, String phoneNumber, String emailAddress)
    {
        super(office, salary, hireDate, name, address, phoneNumber, emailAddress);
        this.title = title;
    }

    //==================== Setters and Getters ================================
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    //=================== toString =======================================
    @Override
    public String toString()
    {
        return "Staff:" 
                + "\n\tname=" + name 
                + "\n\taddress=" + address 
                + "\n\tphoneNumber=" + phoneNumber 
                + "\n\temailAddress=" + emailAddress
                + "\n\toffice=" + office 
                + "\n\tsalary=" + salary 
                + "\n\thireDate=" + hireDate.getMonth() + "/" + hireDate.getDay() + "/" + hireDate.getYear()
                + "\n\ttitle=" + title;
    }
    
    
}
