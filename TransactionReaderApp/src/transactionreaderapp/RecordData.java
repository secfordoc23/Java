//Program: transactionreaderapp
//This: Record.java
//Date: 
//Author: Jason Welch
//Purpose: 

package transactionreaderapp;


public class RecordData 
{
    private String accountNumber; //6
    private String date; //6
    private String transAmt; //7
    private String transType; // 0 is no new Transaction, 1 is deposit, 2 is debit
    private String prevBalance; //7
    private String newBalance; //7

    //======================= Default Constructor =======================
    public RecordData()
    {
        this.accountNumber = "";
        this.date = "";
        this.transAmt = "";
        this.transType = "";
        this.prevBalance = "";
        this.newBalance = "";
    }
    
    //======================= Constructors ==============================
    public RecordData(String accountNumber, String date, String transAmt, String transType, String prevBalance, String newBalance)
    {
        this.accountNumber = accountNumber;
        this.date = date;
        this.transAmt = transAmt;
        this.transType = transType;
        this.prevBalance = prevBalance;
        this.newBalance = newBalance;
    }

    //======================= Setters and Getters =======================
    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getTransAmt()
    {
        return transAmt;
    }

    public void setTransAmt(String transAmt)
    {
        this.transAmt = transAmt;
    }

    public String getTransType()
    {
        return transType;
    }

    public void setTransType(String transType)
    {
        this.transType = transType;
    }

    public String getPrevBalance()
    {
        return prevBalance;
    }

    public void setPrevBalance(String prevBalance)
    {
        this.prevBalance = prevBalance;
    }

    public String getNewBalance()
    {
        return newBalance;
    }

    public void setNewBalance(String newBalance)
    {
        this.newBalance = newBalance;
    }
    
}
