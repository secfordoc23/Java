//Program: testtriangleclass
//This: Colors.java
//Date: 2/26/2016
//Author: Jason Welch
//Purpose: Set Colors as Constants

package testtriangleclass;


public enum Colors 
{
    RED(1),
    ORANGE(2),
    YELLOW(3),
    GREEN(4),
    BLUE(5),
    PURPLE(6),
    WHITE(7);
    
    private int value;
    
    Colors(int value)
    {
        this.value = value;
    }
 
}
