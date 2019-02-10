//Program: circle2dapp
//This: Circle2D.java
//Date: 2/15/2016
//Author: Jason Welch
//Purpose: Class to create a 2 Dimensional Circle, show circle Area, show circle perimeter, and compare circles


package circle2dapp;

public class Circle2D 
{
    private double x;
    private double y;
    private double radius;
    private final double pi = 3.14;
    
    
    //============ default Constructor ===============
    public Circle2D()
    {
        x = 0;
        y = 0;
        radius = 1;
    }
    
    //============ Constructor w/ Params ===============
    public Circle2D(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    //============== getArea() ======================
    public double getArea()
    {
        double area;
        
        area = pi * Math.pow(radius, 2);
        
        return area;
    }
    
    //============== getPerimeter() =================
    public double getPerimeter()
    {
        double perimeter;
        
        perimeter = 2 * pi * radius;
        
        return perimeter;
    }
    
    //============== contains(x,y) ==================
    public boolean contains(double x, double y)
    {
        double distance;
        
        distance = getDistance(x, y);
        
        if(distance <= radius)
        {
            return true;
        }
        
        return false;
    }
    
    //============== contains(Circle2D circle)=======
    public boolean contains(Circle2D circle)
    {
        double distance;
        
        distance = getDistance(circle.getX(), circle.getY());
        
        if (this.radius >= circle.getRadius() && distance <= (this.radius - circle.getRadius()))
        {
            return true;
        }
        
        return false;
    }    
    
    //============= overlaps(Circle2D circle) ========
    public boolean overlaps(Circle2D circle)
    {
        double distance;
        
        distance = getDistance(circle.getX(), circle.getY());
        
        if (distance > (this.radius + circle.getRadius()))
        {
            return false;
        }
        return true;
    }     
    private double getDistance(double x, double y)
    {
        double distance;
        
        distance = Math.sqrt(Math.pow((this.x + x), 2)+ Math.pow((this.y + y), 2));
        
        return distance;
    }
    //=========== Setters and Getters ==================
    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    //================ toString =====================
    @Override
    public String toString()
    {
        String display = "Circle2D{" + "x=" + x + ", y=" + y + ", radius=" + radius + '}';
        
        return display;
    }
    
}
