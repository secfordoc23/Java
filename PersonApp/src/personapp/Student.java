//Program: personapp
//This: Student.java
//Date: 1/24/2017
//Author: Jason Welch
//Purpose: A class for a Student

package personapp;


public class Student extends Person
{
    private String classStatus;

    //================= default Constructor =============================
    public Student()
    {
        super();
        this.classStatus = Status.FRESHMAN.name();
    }

    //================== Constructor w/ SubClass param ==================
    public Student(String classStatus)
    {
        super();
        this.classStatus = classStatus;
    }
    
    //================== Constructor w/ Sub and Super Class param ==================
    public Student(String classStatus, String name, String address, String phoneNumber, String emailAddress)
    {
        super(name, address, phoneNumber, emailAddress);
        this.classStatus = classStatus;
    }
    
    //================= Setters and Getters ==========================
    public String getClassStatus()
    {
        return classStatus;
    }

    public void setClassStatus(String classStatus)
    {
        this.classStatus = classStatus;
    }

    //===================== toString ================================
    @Override
    public String toString()
    {
        String display =  "Student:" 
                + "\n\tname=" + name 
                + "\n\taddress=" + address 
                + "\n\tphoneNumber=" + phoneNumber 
                + "\n\temailAddress=" + emailAddress
                + "\n\tclassStatus=" + classStatus;
        return display;        
    }
    
}
