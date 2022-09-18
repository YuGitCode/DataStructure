import java.util.*;
public class DSAStack
{
    private LinkedList stack; 


    /***************************************************
    * NAME: DSAStack
    * Description: Default Constructor
    ****************************************************/
    public DSAStack()
    {
        stack = new LinkedList();
    }

    /***************************************************
    * NAME:getCount
    * Description: Gets the number of item in the stack
    ****************************************************/
    public int getCount()
    {
        int count = 0;
        Iterator iter = stack.iterator();
        while(iter.hasNext())
        {
            //System.out.println(iter.next());
            iter.next();
            count++;
        }
        return count;
    }

    /***************************************************
    * NAME: isEmpty
    * Description: Check if Stack empty
    ****************************************************/
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    /***************************************************
    * NAME: push
    * Description: Push item to top of stack
    ****************************************************/
    public void push(Object val)
    {
        stack.insertLast(val);
    }

    /***************************************************
    * NAME: pop
    * Description: pop the top item from Stack
    ****************************************************/
    public Object pop()
    {
        return stack.removeLast();
    }

    /***************************************************
    * NAME: top
    * Description: get the top item from stack 
    ****************************************************/
    public Object top()
    {
        return stack.peekLast();
    }
}
