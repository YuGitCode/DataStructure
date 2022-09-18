public class StackUnitTest
{

    public static void main(String[] args)
    {

        System.out.println("Creating Stack size of 5");
        DSAStack stack = new DSAStack(5);
        //Test for full Capacity
        System.out.println("========================");
        System.out.print("Adding 6 item into stack");
        try{
            for(int i = 0; i<=5;i++)
            {
                stack.push(i);
            }
            System.out.println("Capacity Test: FAILED");
        }catch(IllegalArgumentException e)
        {
            System.out.println("...5 item added");
            System.out.println("Capacity Test: PASSED");
        }

        System.out.println("========================");
        System.out.println("Testing top()");
        if(stack.top().equals(4))
        {
            System.out.println("top item: "+stack.top());
            System.out.println("top() Test: PASSED");
        }else
        {
            System.out.println("top() Test:FAILED");
        }

        System.out.println("========================");
        System.out.println("Testing pop()");
        System.out.println("Total item in stack: "+stack.getCount());
        Object val = stack.pop();
        System.out.println(val+" popped off | Item left in stack: " + stack.getCount() );
        if(val.equals(4)&&stack.getCount()==4)
        {
            System.out.println("pop() Test: PASSED");
        }else
        {
            System.out.println("pop() Test: FAILED");
        }
        System.out.println("========================");
        try{
            System.out.print("Popping item off stack: ");
            for(int i=0;i<=5;i++)
            {
                System.out.print(stack.pop()+" ");
            }
            System.out.println("isEmpty() Test: FAILED");
        }catch(IllegalArgumentException e)
        {
            System.out.println("isEmpty() Test: PASSED");
        }
        System.out.println("========================");
        
    
    }
}