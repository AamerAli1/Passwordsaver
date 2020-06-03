import java.io.Serializable;

public class Passwords implements Serializable ,Comparable{
    String userName;
    String passWord;
    String email;
    String website;

    public Passwords(){

    }

    public Passwords(String userName, String passWord,String email,String website ){
        this.userName=userName;
        this.passWord=passWord;
        this.email=email;
        this.website=website;

    }

    @Override
    public String toString() {
        return "User Name : " + userName + " , Password: " + passWord + " ,  Email:" + email +
                " , Website : "  + website;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
