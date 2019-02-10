//Program: DivisibleBy2Or3 
//This: divisibleby2or3.java
//Date: 2/15/2016
//Author: Jason Welch
//Purpose: 

package divisibleby2or3;

import java.math.BigDecimal;

public class DivisibleBy2Or3 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        int count = 0;
        BigDecimal number = new BigDecimal("1");
        number.setScale(50, BigDecimal.ROUND_HALF_UP);       
        
        while(count <= 10)
        {
            BigDecimal byTwo = number.remainder(BigDecimal.valueOf(2));
            BigDecimal byThree = number.remainder(BigDecimal.valueOf(3));
            
            if (BigDecimal.ZERO.compareTo(byTwo) == 0 && BigDecimal.ZERO.compareTo(byThree) != 0)
            {
                System.out.println("The Number is Divisible by 2 and not 3: " + number);
                count++;
            }
            
            else if(BigDecimal.ZERO.compareTo(byThree) == 0 && BigDecimal.ZERO.compareTo(byTwo) != 0)
            {
                System.out.println("The Number is Divisible by 3 and not 2: " + number);
                count++;                
            }
            
            else if(BigDecimal.ZERO.compareTo(byTwo) == 0 && BigDecimal.ZERO.compareTo(byThree) == 0)
            {
                System.out.println("The Number is Divisible by 2 and 3: " + number);
                count++;
            }
            
            number = number.add(new BigDecimal("1"));
        }
                
               
    }

}
