//Program: geometricobjectapp
//This: ComparableGeometricObject.java
//Date: 1/26/2017
//Author: Jason Welch
//Purpose: An abstract class for Geometric Objects that allows for comparison

package geometricobjectapp;


public abstract class ComparableGeometricObject extends GeometricObject implements Comparable<ComparableGeometricObject> 
{
    //==================== Default Contructor ======================
    protected ComparableGeometricObject()
    {
        super();
    }

    //==================== Contructor w/ Param =====================
    protected ComparableGeometricObject(String color, boolean filled)
    {
        super(color, filled);
    }
   
    //====================== max ===================================
    public static ComparableGeometricObject max(ComparableGeometricObject obj1, ComparableGeometricObject obj2)
    {
        if(obj1.compareTo(obj2) > 0)
        {
            return obj1;
        }
        else
        {
            return obj2;
        }
    }
    
    //===================== compareTo ===============================
    @Override
    public int compareTo(ComparableGeometricObject that)
    {
        if(this.getArea() > that.getArea())
        {
            return 1;
        }
        else if(this.getArea() > that.getArea())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

}
