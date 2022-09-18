import java.util.*;
public class GCD{
    public void GCD(){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int num2 = scan.nextInt();
        scan.close();
        int largest = recursive(num,num2);
        System.out.println("largest number: "+largest);
    }

    public int recursive(int num,int num2)
    {
        System.out.println("Num1: " +num+"num2 "+num2);
        if(num2!=0)
        {
            return recursive(num2,num%num2);
        }else
        {
            return num;
        }
    }
}