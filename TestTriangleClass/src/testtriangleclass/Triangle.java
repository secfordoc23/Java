/*Program: Test Triangle Class
*This: Triangle.java
*Date:2/15/16
*Author: Kyle Bloyd, Jason Welch, Brandon Onken
*Purpose: A class to define a triangle object 
*           
*/
package testtriangleclass;


///=========================================================================
public class Triangle extends GeometricObject
{
    //sides lengths of the triangle
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    
    
  //==================default constructor==================================  
    public Triangle()  
    {
        super();
    }
    
  //====================parameterized constructor==========================  
    public Triangle(String color, boolean filled, double side1, double side2, double side3)
    {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    
   
  //===========================sets and gets===============================  
    public double getSide1() //returns length of side1
    {
        return side1;
    }

    public void setSide1(double side1) //sets the length of side1
    {
        this.side1 = side1;
    }

    public double getSide2() //returns length of side2
    {
        return side2;
    }

    public void setSide2(double side2)  //sets the length of side2
    {
        this.side2 = side2;
    }

    public double getSide3() //returns length of side3
    {
        return side3;
    }

    public void setSide3(double side3)   //sets the length of side3
    {
        this.side3 = side3;
    }
  //======================end of sets and gets=============================  
    
    //====================== triangleSumTheorem =============================
    public boolean triangleSumTheorem()
    {
        // Validate the the sum of 2 sides is greater than the 3rd
        return side1 + side2 > side3 
                && side2 + side3 > side1
                && side1 + side3 > side2;
    }
    
    @Override /** Return area */
    public double getArea() 
    {
        double halfPerimeter = (side1 + side2 + side3) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - side1) 
                * (halfPerimeter - side2) * (halfPerimeter - side3));
    }
    
    @Override /** Return perimeter */
    public double getPerimeter()
    {
        return side1 + side2 + side3;
    }
    
    @Override /** returns a nicely formatted String describing the triangle */
    public String toString()
    {
        //reworked the wording a bit to look better
        return super.toString() + "\nThe area is: " + getArea() 
                                + "\nThe perimeter is: " + getPerimeter();
    }
    
}
