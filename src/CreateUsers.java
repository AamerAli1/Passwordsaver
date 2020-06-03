import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;


/*
    Creates A User and saves it in serialized file
    checks for password and userName
 */
public class CreateUsers {
    public static void main(String[] args) {
        System.out.println("Please create A User");
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter A name\n'at least 2 characters'");
        String Name = sc.nextLine();

        while (!(Name.matches("[A-Za-z]{2,}"))) {
            System.out.println("Invalid Name\nplease enter another name");
            Name = sc.nextLine();
        }
        System.out.println("Please enter a Password \n at least 6 characters");
        String passWord = sc.nextLine();
        while(!(passWord.matches(".{6,}"))){
            System.out.println("Invalid Password\nplease enter another passoword");
            passWord= sc.nextLine();

        }
        Users s = new Users(Name,passWord);
        System.out.println(s);
        saveSer(s);

    }


public static void saveSer(Users s){
    try {
        FileOutputStream fileOut = new FileOutputStream("Users.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(s);
        out.close();
        fileOut.close();
        System.out.printf("Serialized data is saved in Users.ser");
    } catch (IOException i) {
        i.printStackTrace();
    }
}
}
