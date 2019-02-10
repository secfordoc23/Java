//Program: studentapp
//This: Students.java
//Date: 1/28/2016
//Author: Jason Welch
//Purpose: Class for storing Student Information

package studentapp;

import java.util.Random;

public class Students 
{
    private String firstName;
    private String lastName;
    private String studentID;
    private String semesterEnrolled;


    //================ Default Constructor ==========================
    public Students()
    {
        super();
    }
    
    //================ Constructor w/ Param =========================
    public Students(String firstName, String lastName, String studentID, String semesterEnrolled)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.semesterEnrolled = semesterEnrolled;
    }
    
    //=============== createUsername ==========================
    public String createUsername()
    {
        String userName;
        
        Random myRand = new Random();
        
        userName = this.firstName.charAt(0) + "" + this.lastName.charAt(0) + (myRand.nextInt(9) + 1) + (myRand.nextInt(9) + 1) + (myRand.nextInt(9) + 1);
        
        return userName;
    }
    //=============== Setters and Getters ==========================
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getStudentID()
    {
        return studentID;
    }

    public void setStudentID(String studentID)
    {
        this.studentID = studentID;
    }

    public String getSemesterEnrolled()
    {
        return semesterEnrolled;
    }

    public void setSemesterEnrolled(String semesterEnrolled)
    {
        this.semesterEnrolled = semesterEnrolled;
    }

    //================= toString ======================
    @Override
    public String toString()
    {
        String display = "\n=== Students Data ===" +
        "\nFirstname=" + firstName +
        "\nLastname=" + lastName +
        "\nStudent ID=" + studentID +
        "\nSemester Enrolled=" + semesterEnrolled + 
        "\n================\n";
        return display;
    }
    
}
