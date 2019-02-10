//Program: geometricobjectapp
//This: ComparableRectangle.java
//Date: 1/26/2017
//Author: Jason Welch
//Purpose: A class for a Geometric Rectangle that is comparable

package geometricobjectapp;


public class ComparableRectangle extends ComparableGeometricObject
{
    private double width;
    private double length;

    //============= Default Constructor =====================
    public ComparableRectangle(double width, double length)
    {
        super();
        this.width = width;
        this.length = length;
    }

    //====================== Contructor w/ Param ============
    public ComparableRectangle(double width, double length, String color, boolean filled)
    {
        super(color, filled);
        this.width = width;
        this.length = length;
    }
    
    //=========================== Setters and Getters =======
    public double getWidth()
    {
        return width;        
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)    
    {
        this.length = length;
    }
    
    //======================= getArea ==========================
    @Override
    public double getArea()
    {
        return length * width;
    }

    //======================= getPerimeter =====================
    @Override
    public double getPerimeter()
    {
        return 2 * (length + width);
    }

    //======================= toString =========================
    @Override
    public String toString()
    {
        String display = "****** ComparableRectangle ******" + 
                "\nwidth=" + width + 
                "\nlength=" + length;
        return display;
    }
    
    
}
