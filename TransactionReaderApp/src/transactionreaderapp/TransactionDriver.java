//Program: transactionreaderapp
//This: TransactionDriver.java
//Date: 4/17/2016
//Author: Jason Welch
//Purpose: 

package transactionreaderapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TransactionDriver 
{
    private Scanner userInput;
    private RecordReader reader;
    
    //================== Default Constructor =====================
    public TransactionDriver()
    {
        userInput = new Scanner(System.in);
    }
    
    //================ run() ===========================
    public void run() throws IOException
    {
        boolean quit = false;
        char choice;
        String filePath;
        String[] options = {"Exit", "Read Record"};
        Menu startMenu = new Menu(options);
        
        do
        {
            choice = startMenu.getChoice();
            switch(choice)
            {
                case '0': quit = true;
                    break;
                case '1': getFilePath();
                    printRecord();
                    break;
            }
        } while(quit == false);
    }
    
    //============== getFilepath =======================
    private void getFilePath()
    {
        String filePath;
        boolean isValid;
        
        do
        {
            System.out.print("Enter the file path of the record you want to read: ");
            filePath = userInput.next();
            reader = new RecordReader(filePath);
            isValid = reader.testPath();
        }while(isValid == false);
    }
    
    //================== header ======================
    private void header()
    {
        System.out.println();
        System.out.println("Acct:\t\tDate\t\tAmt\t\tType\tPrevBal\t\tNewBal");
        System.out.println("===============================================================================");
    }
    
    //================== printRecord =================
    private void printRecord() throws IOException
    {
        ArrayList<RecordData> recordList = reader.readData();
        header();                
        for(RecordData record : recordList)
        {            
            System.out.printf("%s\t\t%s\t\t%s\t\t%s\t%s\t\t%s\n", record.getAccountNumber(),record.getDate(),record.getTransAmt(),record.getTransType(),record.getPrevBalance(),record.getNewBalance());
        }
    }

}
