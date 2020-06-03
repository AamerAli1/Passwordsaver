import java.io.*;



public class Users  implements Serializable {


    String UserName;
    String PassWord;

    public  Users(String Username,String Password){
        this.UserName=Username;
        this.PassWord=Password;
    }

    @Override
    public String toString() {
        return
                "UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'';
    }
}


