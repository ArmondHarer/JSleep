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

public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;
    
    public Account(int id, String name, String email, String password)
    {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString()
    {
        return "Account Information\nID :  " + super.id + "\nName : " + name + "\nEmail Address : " + email  + "\nPassword : " + password;
    }
}
