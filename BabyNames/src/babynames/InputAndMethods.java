//Program: Baby Names
//This: InputAndMethods.java
//Date: 3/1/2016
//Author: Jason Welch, Kyle Bloyd, Brandon Onken
//Purpose: a class used to get input from user, to create a list of 
//          BabyRank objects, and to display the rank of a name

package babynames;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class InputAndMethods 
{
    //Scanner for input
    private Scanner getInput = new Scanner(System.in);
    //Instantiate a new array list of BabyRank objects
    private ArrayList<BabyRank> myList = new ArrayList<BabyRank>();
    
    //class variables    
    private int year;
    private int rank;
    private char sex;
    private String name;
    
    //=======================================================================
    public InputAndMethods()
    {
        //default constructor
        name = "";
        sex = ' ';
        year = 0;
        rank = 0;
    }
    
    public InputAndMethods(int year, char sex, String name)
    {
        //parameterized constructor
        this.year = year;
        this.sex = sex;
        this.name = name;
    }
    
    //============================sets and gets=============================
    public int getYear() 
    {
        return year;
    }

    public void setYear(int year) 
    {
        this.year = year;
    }

    public int getRank() 
    {
        return rank;
    }

    public char getSex() 
    {
        return sex;
    }

    public void setSex(char sex) 
    {
        this.sex = sex;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    //===================end of sets and gets===============================
    
    //=========================yearInput()=================================
    public void yearInput()
    {               
        do
        {
            //prompt user for a year and stores it in class variable year
            System.out.printf("Enter a year (2001 - 2010): ");
            while(!getInput.hasNextInt())
            {
                System.out.printf("Please enter a valid year "
                        + "(2001 - 2010): ");
                getInput.next();
            }
            year = getInput.nextInt();
        } while(year < 2001 || year > 2010);
    }
    
    //========================genderInput()===================================
    public void genderInput()
    {
        boolean quit = false;
                
        do
        {
            //prompt user for gender and stores it in class variable sex
            System.out.printf("Enter the gender M for male, F for female: ");
                this.sex = getInput.next().toUpperCase().charAt(0);
                if ( sex == 'M' || sex == 'F')
                {                    
                    quit = true;
                }                
                else
                {
                    System.out.println("Invalid entry");
                }            
        } while (quit == false); 
    }
        
    
    //=====================nameInput()=====================================
    public void nameInput()
    {
        //prompt user for a name and stores it in class variable name
        System.out.print("Enter a name: ");
        name = getInput.next();
    }
        
    public int getIndex()
    {
        int index = -1;
        
        index = myList.indexOf(name);
        
        return index;
    }
    //===================makeList()========================================
    public void makeList()
    {
        String fileName = ".\\babynameranking" + year + ".txt";
        
        try 
        {
            //open the file that has the given year in the name
            File file = new File(fileName);

            Scanner input = new Scanner(file);            

            //keep reading info as long as there is another word
            while (input.hasNextLine()) 
            {
                //instantiate new BabyRank object
                BabyRank myNames = new BabyRank();
                //set the rank, male name, and female name
                myNames.setRank(input.nextInt());
                myNames.setMaleName(input.next());
                myNames.setFemaleName(input.next());

                myList.add(myNames);
            }
            //close the input file
            input.close();
        } catch (Exception ex) 
            {
                System.out.println("\nUnable to find valid file.");
            }
    }
    
    
    //=================checkName()==========================================
    public boolean checkName()
    {
        //checks to see if name is in the list
        if (sex == 'M')
        {
            for (int index = 0; index < 1000; index++)
            {
                if (myList.get(index).getMaleName().equalsIgnoreCase(name))
                {
                    rank = index + 1;
                    return true;
                }            
            }   
        }

        if (sex == 'F')
        {
            for (int index = 0; index < 1000; index++)
            {
               if (myList.get(index).getFemaleName().equalsIgnoreCase(name))
               {
                   rank = index + 1;
                   return true;
               }            
            }
        }        
        return false;
    }
    
    
    //============================toString()===============================
    @Override /** returns a nicely formatted String showing the rank **/
    public String toString()
    {
        String showRank = "\n" + name + " is ranked #" + rank + " in the year "
                + year + "\n";       
        
        return showRank;
    }
    
    //===================================notInList()=========================
    public String notInList()
    {
        //returns a nicely formatted String stating that given name is not 
        //          in the list
        String display = "\nThe name " + name + " is not ranked in year " 
                + year + "\n";
        
        return display;        
    }
                
}
