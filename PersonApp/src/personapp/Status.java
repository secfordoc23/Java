//Program: personapp
//This: Status.java
//Date: 1/24/2017
//Author: Jason Welch
//Purpose: An enum class to replace constants in at the class level for status

package personapp;


public enum Status 
{
    FRESHMAN(1),
    SOPHMORE(2),
    JUNIOR(3),
    SENIOR(4);
    
    private int value;
    
    Status(int value)
    {
        this.value = value;
    }
}
