package armondHarerJSleepJS;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    public static final String REGEX_EMAIL = "^([a-zA-Z0-9]+)@(([[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.)|(([a-zA-Z0-9-]+.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(]?)$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\s+$) .{8,}$";
    
    public Account(String name, String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public boolean validate() {

        Pattern emailPattern = Pattern.compile(REGEX_EMAIL);
        Matcher emailMatcher = emailPattern.matcher(this.email);

        Pattern passwordPattern = Pattern.compile(REGEX_PASSWORD);
        Matcher passwordMatcher = passwordPattern.matcher(this.password);

        return emailMatcher.matches() && passwordMatcher.matches();
        
    }
    
    public String toString()
    {
        return "Account Information\nName : " + name + "\nEmail Address : " + email  + "\nPassword : " + password;
    }
    
    /*
    
    
    public Object write(){
        return null;
    }

    public boolean read(String content){
    return false;
    }
    */
}
