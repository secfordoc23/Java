//Program: Baby Names
//This: BabyRank.java
//Date: 3/1/2016
//Author: Jason Welch, Kyle Bloyd, Brandon Onken
//Purpose: a class used to define a BabyRank object

package babynames;


public class BabyRank 
{
    //class variables
    private int rank;
    private String maleName;
    private String femaleName;

    //======================================================================
    public BabyRank()
    {
        //Default constructor
       rank = 0;
       maleName = "";
       femaleName = "";
    }
    
    //====================================================================
    public BabyRank(int rank, String maleName, String femaleName)
    {
        //parameterized constructor
        this.rank = rank;
        this.maleName = maleName;
        this.femaleName = femaleName;
    }

    //========================= Getters and Setters =======================
    public int getRank() 
    {
        return rank;
    }

    public void setRank(int rank) 
    {
        this.rank = rank;
    }

    public String getMaleName() 
    {
        return maleName;
    }

    public void setMaleName(String maleName) 
    {
        this.maleName = maleName;
    }

    public String getFemaleName() 
    {
        return femaleName;
    }

    public void setFemaleName(String femaleName) 
    {
        this.femaleName = femaleName;
    }
    
    //=================toString()========================================
    @Override
    public String toString()
    {
        //returns nicely formatted string of a BabyRank object
        String display = "Rank: " + rank
                + "\nMale Name: " + maleName
                + "\nFemale Name: " + femaleName;
        
        return display;
    }
    
}
