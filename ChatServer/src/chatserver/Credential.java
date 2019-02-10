//Program: chatclient
//This: Credential.java
//Date: 4/29/2016
//Author: Jason Welch
//Purpose: A class to hold a user's username and password

package chatserver;

public class Credential
{
    private String username;
    private String password;

    //============== Constructor ===================================
    public Credential(String username, String password)
    {
        super();
        this.username = username;
        this.password = password;
    }

    //=================== Setters and Getters =====================
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    @Override
    public boolean equals(Object rhs) {
        boolean result = false;
        if(rhs instanceof Credential) {
            Credential toCompare = (Credential) rhs;
            if(this.username.equals(toCompare.getUsername()) && this.password.equals(toCompare.getPassword())) {
                result = true;
            }
            else if(toCompare.getUsername().equals(this.username) && toCompare.getPassword().equals(this.password)){
                result = true;
            }
        }
        return result;
    }
    
    @Override
    public int hashCode()
    {
        char character;
        int hash = 5;
        for(int i=0; i < username.length(); i++) {
            character = username.charAt(i);
            hash+=(int)character;
        }
        for(int i=0; i < password.length(); i++) {
            character = password.charAt(i);
            hash+=(int)character;
        }
        hash = hash * 7;
        return hash; 
    }
}
