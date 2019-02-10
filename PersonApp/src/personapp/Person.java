//Program: personapp
//This: Person.java
//Date: 1/24/2017
//Author: Jason Welch
//Purpose: A class for a Person

package personapp;


public class Person 
{
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected String emailAddress;
    
    // =================== default Constructor ========================
    public Person()
    {
        this.name = "John Doe";
        this.address = "1234 Somewhere Dr.";
        this.phoneNumber = "309-555-1234";
        this.emailAddress = "john.doe@organization.com";
    }
    
    // ======================= Constructor w/ param ==================
    public Person(String name, String address, String phoneNumber, String emailAddress)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    //======================= Setters and Getters ====================
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }
    
    //====================== toString ==================

    @Override
    public String toString()
    {
        String display =  "Person:" 
                + "\n\tname=" + name 
                + "\n\taddress=" + address 
                + "\n\tphoneNumber=" + phoneNumber 
                + "\n\temailAddress=" + emailAddress;
        return display;
    }
    

    
}
