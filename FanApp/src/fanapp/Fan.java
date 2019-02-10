//Program: FanApp
//This: fan.java
//Date: 11/17/2015
//Author: Jason Welch
//Purpose: Class for setting a fan

package fanapp;

//======================= Fan ==========================
public class Fan 
{
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;
    
    //================ Fan default ================
    public Fan()
    {
        this.speed = this.SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";        
    }
    
    //================ Fan default ================
    public Fan(int speed, boolean on, double radius, String color)
    {
        fanSpeed(speed);
        this.on = on;
        this.radius = radius;
        this.color = color;
        
    }
    
    //================ fanSpeed ================
    private void fanSpeed(int speed)
    {
        switch(speed)
        {
            case 1: this.speed = SLOW;
                break;
            case 2: this.speed = MEDIUM;
                break;
            case 3: this.speed = FAST;
                break;
            default: this.speed = SLOW;
        }
    }
 
    //================ Setters and Getters ====================
    public void setSpeed(int speed)
    {
        fanSpeed(speed);
    }
    public int getSpeed()
    {
        return this.speed;
    }
    public void setOn(boolean on)
    {
        this.on = on;
    }
    public boolean getOn()
    {
        return this.on;
    }
    public void setRadius(double radius)
    {
        this.radius = radius;
    }
    public void setColor(String color)
    {
        this.color = color;
    }
    public String getColor()
    {
        return this.color;
    }
    //================ toString ================
    public String toString()
    {
               String display = "\n=== Fan Data ===" +
                "\nSpeed: " + this.speed +
                "\nOn: " + this.on +
                "\nRadius: " + this.radius +
                "\nColor: " + this.color +
                "\n================\n";       
        return display; 
    }
}
