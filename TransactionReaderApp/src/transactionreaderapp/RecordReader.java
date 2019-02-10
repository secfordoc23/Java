//Program: transactionreaderapp
//This: RecordReader.java
//Date: 
//Author: Jason Welch
//Purpose: 

package transactionreaderapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class RecordReader 
{
    private String filePath;
    private File dataFile;
    BufferedReader fileInput;
    
    //==================== Constructor ===========================
    RecordReader(String filePath)
    {
        this.filePath = filePath;
        this.dataFile = new File(filePath);
    }
    
    //================== testpath ================================
    public boolean testPath()
    {
        boolean isValid = true;
        
        if(!dataFile.exists())
        {
            isValid = false;
        }
        
        return isValid;
    }
    
    //=================== readData ==============================
    public ArrayList<RecordData> readData() throws FileNotFoundException, IOException
    {
        String currentLine = "";
        String newBalance = "";
        int lineCounter = 0;
        RecordData data;
        ArrayList<RecordData> dataList = new ArrayList<>();
        
        fileInput = new BufferedReader(new FileReader(dataFile));
        
        while((currentLine = fileInput.readLine()) != null)
        {
            data = new RecordData();
            lineCounter++;
            if(currentLine.length() != 27)
            {                
                System.out.printf("Record at line %d has an error! Record does not meet length requirements. Record has been Zeroed out.\n", lineCounter);
                data.setAccountNumber("000000");
                data.setDate("000000");
                data.setTransAmt("0000000");
                data.setTransType("0");
                data.setPrevBalance("0000000");
                data.setNewBalance("0000000");
            }
            else
            {
                data.setAccountNumber(currentLine.substring(0, 6));
                data.setDate(currentLine.substring(6, 12));
                data.setTransAmt(currentLine.substring(12, 19));
                data.setTransType(String.valueOf(currentLine.charAt(19)));
                data.setPrevBalance(currentLine.substring(20, currentLine.length()));
                newBalance = calculateTransaction(data.getTransType(), data.getTransAmt(), data.getPrevBalance());
                data.setNewBalance(newBalance);
            }
            dataList.add(data);
        }
        
        return dataList;
    }
    
    //=============== calculateTransaction ===========
    private String calculateTransaction(String tranType, String tranAmount, String prevBalance)
    {
        String newBalance = "0000000";
        int transAmount = 0;
        int prevAmount = 0;
        try
        {
            transAmount = Integer.parseInt(tranAmount);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Error Parsing Transaction Amount.  New Balance has been Zeroed out. ");
            return newBalance;
        }
        try
        {
            prevAmount = Integer.parseInt(prevBalance);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Error Parsing Previous Balance.  New Balance has been Zeroed out. ");
            return newBalance;
        }        
        if(tranType.equalsIgnoreCase("1"))
        {
            //Deposit
             newBalance = String.valueOf(transAmount + prevAmount);
        }
        else if(tranType.equalsIgnoreCase("2"))
        {
            //Debit
            newBalance = String.valueOf(prevAmount - transAmount);
        }
        else if(tranType.equalsIgnoreCase("0"))
        {
            newBalance = prevBalance;
        }
        else
        {
            System.out.println("Error reading Transaction Type.");
            newBalance = prevBalance;
        }
        while(newBalance.length() < 7)
        {
            newBalance = "0" + newBalance;
        }
        return newBalance;
    }
}
