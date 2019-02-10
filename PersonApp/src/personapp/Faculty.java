//Program: personapp
//This: Faculty.java
//Date: 1/24/2017
//Author: Jason Welch
//Purpose: A class for a Faculty Member

package personapp;

public class Faculty extends Employee
{
    private String rank;
    private String officeHours;

    //=================== Default Constructor =======================
    public Faculty()
    {
        super();
        this.rank = "Dean";
        this.officeHours = "9:00am - 5:00pm";
    }
    
    //==================Constructor w/ Param ========================
    public Faculty(String rank, String officeHours, String office, double salary, MyDate hireDate, String name, String address, String phoneNumber, String emailAddress)
    {
        super(office, salary, hireDate, name, address, phoneNumber, emailAddress);
        this.rank = rank;
        this.officeHours = officeHours;
    }
    
    //================== Setters and Getters ========================
    public String getRank()
    {
        return rank;
    }

    public void setRank(String rank)
    {
        this.rank = rank;
    }

    public String getOfficeHours()
    {
        return officeHours;
    }

    public void setOfficeHours(String officeHours)
    {
        this.officeHours = officeHours;
    }

    //=================== toString =============================
    @Override
    public String toString()
    {
        return "Faculty:" 
                + "\n\tname=" + name 
                + "\n\taddress=" + address 
                + "\n\tphoneNumber=" + phoneNumber 
                + "\n\temailAddress=" + emailAddress
                + "\n\toffice=" + office 
                + "\n\tsalary=" + salary 
                + "\n\thireDate=" + hireDate.getMonth() + "/" + hireDate.getDay() + "/" + hireDate.getYear()
                + "\n\trank=" + rank 
                + "\n\tofficeHours=" + officeHours;
    }
    
}
