public class Factorial
{
    public void iterative(int n)
    {
        int result = 1;
        for(int i = 1 ;i<=n;i++)
        {
            result = result*i;
        }
        System.out.println(result);
    }

    public int recursive(int n)
    {
        int result=0;
        if(n==1)
        {
            result = 1;
        }else
        {
            result = recursive(n-1)*n;
        }
        return result;
    }
}