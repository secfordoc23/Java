//Program: TransactionReaderApp
//This: TransactionReaderApp.java
//Date: 4/16/2016
//Author: Jason Welch
//Purpose: An application to read Banking transactions that a user selects.

package transactionreaderapp;

import java.io.IOException;

public class TransactionReaderApp 
{
    //===========  main ==========================
    public static void main(String[] args) throws IOException 
    {
        TransactionDriver tranDriver = new TransactionDriver();
        tranDriver.run();
    }

}
