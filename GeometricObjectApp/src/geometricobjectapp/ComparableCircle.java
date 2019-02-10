//Program: geometricobjectapp
//This: ComparableCircle.java
//Date: 1/26/2017
//Author: Jason Welch
//Purpose: A class for a Geometric Circle that is comparable

package geometricobjectapp;


public class ComparableCircle extends ComparableGeometricObject
{
    private double radius;
    
    //================== Default Constructor ============
    public ComparableCircle(double radius)
    {
        super();
        this.radius = radius;
    }

    //================== Constructor w/ Param ============
    public ComparableCircle(double radius, String color, boolean filled)    
    {
        super(color, filled);
        this.radius = radius;
    }

    //================= Setters and Getters =============
    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }   
    
    //================== getArea ========================
    @Override
    public double getArea()
    {
        return Math.PI * Math.pow(this.radius, 2);
    }

    //================= getPerimeter ====================
    @Override
    public double getPerimeter()
    {
        return 2* Math.PI * this.radius;
    }

    //================= toString =======================
    @Override
    public String toString()
    {
        String display = "***** ComparableCircle *****" + 
                "\nradius=" + radius;
        return display;
    }

    
}
