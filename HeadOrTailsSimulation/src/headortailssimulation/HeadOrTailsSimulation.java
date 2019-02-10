//Program: HeadOrTailsSimulation
//This: headortailssimulation.java
//Date: 9/29/2015
//Author: Jason Welch
//Purpose: To run a simulation to see how many head or tails after a million flips

package headortailssimulation;

import java.util.Random;

public class HeadOrTailsSimulation 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        int heads = 0;
        int tails = 0;
        int flipResult = 0;
        final int NUMBER_OF_FLIPS = 1000000;
        
        // Random numver Generator
        Random flip = new Random();
        
        for(int index = 0; index < NUMBER_OF_FLIPS; index++)
        {
            flipResult = flip.nextInt(2);
            if(flipResult == 1)
            {
                heads++;
            }
            else
            {
                tails++;
            }
        }
        System.out.println("The Results after " + NUMBER_OF_FLIPS + " flips: ");
        System.out.println("Number of Heads: " + heads);
        System.out.println("Number of Tails: " + tails);
    }

}
