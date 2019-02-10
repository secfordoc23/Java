//Program: uspresidents
//This: Presidents.java
//Date: 
//Author: Jason Welch
//Purpose: 

package uspresidents;


public class USPrez 
{
    private String name;
    private String homeState;
    private String dob;
    private String party;
    private String termStart;

    //==================== Default Constructor ==========================
    public USPrez()
    {
        this.name = "";
        this.homeState = "";
        this.dob = "";
        this.party = "";
        this.termStart = "";
    }

    //====================== Constructor w/ param =======================
    public USPrez(String name, String homeState, String dob, String party, String termStart)
    {
        this.name = name;
        this.homeState = homeState;
        this.dob = dob;
        this.party = party;
        this.termStart = termStart;
    }
    
    //================= Setters and Getters ============================

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getHomeState()
    {
        return homeState;
    }

    public void setHomeState(String homeState)
    {
        this.homeState = homeState;
    }

    public String getDob()
    {
        return dob;
    }

    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public String getParty()
    {
        return party;
    }

    public void setParty(String party)
    {
        this.party = party;
    }

    public String getTermStart()
    {
        return termStart;
    }

    public void setTermStart(String termStart)
    {
        this.termStart = termStart;
    }
    
    //===================== toString ===========================

    @Override
    public String toString()
    {
        String display =  "President:"
                + "\n\tname=" + name
                + "\n\thomeState=" + homeState
                + "\n\tdob=" + dob 
                + "\n\tparty=" + party 
                + "\n\ttermStart=" + termStart;
        return display;
    }
    
    

}
