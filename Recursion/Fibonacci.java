public class Fibonacci
{
    private int[] arr;
    public Fibonacci(int size)
    {
        this.arr = new int[size+1];
    }
    public int[] getArray()
    {
        return this.arr;
    }
    public void iterative(int n)
    {
        int first = 0;
        int second = 1;
        int result=0;
        for(int i=0; i<n; i++) {

            if(i<=1)
            {
                result = i;
            }else
            {
                result = first+second;
                first = second;
                second = result;
            }

            System.out.println(result);
        }
    }

    public int recursive(int n)
    {
        int result = 0;
        if(n<=1)
        {
            result = n;
        }else
        {
            result = recursive(n-1)+recursive(n-2);
        }
        if(arr[n]==0)
        {
            arr[n] = result;
        }
        return result;
    }
}