import java.util.Scanner;
import javax.swing.JOptionPane;
public class Day2Basic {
    public static boolean isprime(int n){
        for(int i=2;i<n/2;i++){
            if(n%i==0){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        if(!isprime(n)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }


}
