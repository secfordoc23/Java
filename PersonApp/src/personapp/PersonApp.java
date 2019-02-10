//Program: PersonApp
//This: PersonApp.java
//Date: 1/24/2017
//Author: Jason Welch
//Purpose: To test the Person Class and its sub Clases

package personapp;

public class PersonApp 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;
       
        String[] choices = {"Quit", "Person", "Student", "Employee", "Faculty", "Staff"};
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            System.out.println("*** Test for Default Class Values ***");
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1': Person defaultPerson = new Person();
                    System.out.println(defaultPerson.toString());
                    break;
                case '2': Student defaultStudent = new Student();
                    System.out.println(defaultStudent.toString());
                    break;
                case '3': Employee defaultEmpoyee = new Employee();
                    System.out.println(defaultEmpoyee.toString());
                    break;            
                case '4': Faculty defaultFaculty = new Faculty();
                    System.out.println(defaultFaculty.toString());
                    break;
                case '5': Staff defaultStaff = new Staff();
                    System.out.println(defaultStaff.toString());
                    break;            
            }
                        
        }while(quit == false); 
    }

}
