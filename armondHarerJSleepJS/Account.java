package armondHarerJSleepJS;


/*
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
/*public class Account
{
    // instance variables - replace the example below with your own
    public String name;
    public String email;
    public String password;
}*/

public class Account
{
    public String name;
    public String email;
    public String password;
    
    public Account(String name, String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString()
    {
        return "Account Information\nName : " + name + "\nEmail Address : " + email  + "\nPassword : " + password;
    }
    
    public Object write(){
        return null;
    }

    public boolean read(String content){
    return false;
    }
}
