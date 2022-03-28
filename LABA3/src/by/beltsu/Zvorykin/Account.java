package by.beltsu.Zvorykin;

import org.apache.log4j.Logger;

public class Account {
    private static final Logger LOG = Logger.getLogger(Account.class);
    private String Name;
    private String Passport;

    public Account(String name, String passport) {
        Name = name;
        Passport = passport;
    }

    public  Account()
    {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getPassport() {
        return Passport;
    }

    public void setPassport(String passport) {
        this.Passport = passport;
    }


}
