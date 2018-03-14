package post;

public class User {

    private boolean emailConfirmed;
    private String email;
    private String fullName;
    private String password;
    private String emailConfirmationCode;

    public User(boolean emailConfirmed, String email, String fullName, String password, String emailConfirmationCode) {
        this.emailConfirmed = emailConfirmed;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.emailConfirmationCode = emailConfirmationCode;
    }
   

    public boolean getEmailConfirmed() {
        return this.emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    

    public String getEmailConfirmationCode() {
        return this.emailConfirmationCode;
    }

    public void setEmailConfirmationCode(String emailConfirmationCode) {
        this.emailConfirmationCode = emailConfirmationCode;
    }

      public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return  "emailConfirmed: " + emailConfirmed + "\nemail: " + email + "\nfullName: " + fullName + "\npassword: " + password + "\nemailConfirmationCode: " + emailConfirmationCode + "\n";
    }

    
   

}
