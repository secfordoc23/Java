/*Program: Test Triangle Class
*This: GeometricObject.java
*Date:2/15/16
*Author: Kyle Bloyd, Jason Welch, Brandon Onken
*Purpose: A class to define a geometric object 
*           
*/
package testtriangleclass;

//========================================================================
public abstract class GeometricObject 
{
  private String color = Colors.WHITE.name();
  private boolean filled;
  private java.util.Date dateCreated;

  /** Construct a default geometric object */
  protected GeometricObject() 
  {
    dateCreated = new java.util.Date();
  }

  /** Construct a geometric object with color and filled value */
  protected GeometricObject(String color, boolean filled) 
  {
    dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }

  
//=========================sets and gets=================================  
  /** Return color */
  public String getColor() 
  {
    return color;
  }

  /** Set a new color */
  public void setColor(String color) 
  {
    this.color = color;
  }

  /** Return filled. Since filled is boolean,
   *  the get method is named isFilled */
  public boolean isFilled()
  {
    return filled;
  }

  /** Set a new filled */
  public void setFilled(boolean filled)
  {
    this.filled = filled;
  }

  /** Get dateCreated */
  public java.util.Date getDateCreated()
  {
    return dateCreated;
  }
//===================end of sets and gets=================================  
  
  @Override   // returns a nicely formatted String describing the object
  public String toString() 
  {
      //reworked the wording a bit to look better
    return "Created on " + dateCreated + "\nColor: " + color +
      "\nFilled: " + filled;
  }

  /** Abstract method getArea */
  public abstract double getArea();

  /** Abstract method getPerimeter */
  public abstract double getPerimeter();
}