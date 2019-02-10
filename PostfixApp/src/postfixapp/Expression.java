//Program: postfixapp
//This: Expression.java
//Date: 
//Author: Jason Welch
//Purpose: 

package postfixapp;


public enum Expression 
{
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVID('/'),
    DECIMAL('.'),
    EQUALS('=');
    
    private char expression;
    
    private Expression(char expression)
    {
        this.expression = expression;
    }
    
    public char valueOf()
    {
        return this.expression;
    }
}
