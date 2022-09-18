public class DSAStack
{
    private Object[] stack; 
    private int count;
    private static final int MAXCAPACITY = 100;

    /***************************************************
    * NAME: DSAStack
    * Description: Default Constructor
    ****************************************************/
    public DSAStack()
    {
        stack = new Object[MAXCAPACITY];
        count=0;
    }

    /***************************************************
    * NAME: DSAStack
    * Description: Alternate Constructor
    ****************************************************/
    public DSAStack(int maxCapacity)
    {
        stack = new Object[maxCapacity];
        count=0;
    }

    /***************************************************
    * NAME:getCount
    * Description: Gets the number of item in the stack
    ****************************************************/
    public int getCount()
    {
        return this.count;
    }

    /***************************************************
    * NAME: isEmpty
    * Description: Check if Stack empty
    ****************************************************/
    public boolean isEmpty()
    {
        boolean empty = false;
        //if count is zero or less stack is empty
        if(count<=0)
        {
            empty = true;
        }

        return empty;
    }

    /***************************************************
    * NAME: isFull
    * Description: Check if Stack is full
    ****************************************************/
    public boolean isFull()
    {
        boolean full=false;
        //if count is bigger or equal to array size 
        // then stack full
        if(count>= stack.length)
        {
            full = true;
        }

        return full;
    }

    /***************************************************
    * NAME: push
    * Description: Push item to top of stack
    ****************************************************/
    public void push(Object val)
    {
        //if stack not full push to Stack else throw exception
        if(!isFull())
        {   // push the item to top of stack
            stack[count] = val;
            count++;// increment the count by 1 to for next item
        }else
        {
            throw new IllegalArgumentException("Stack Capacity is reached");
        }
    }

    /***************************************************
    * NAME: pop
    * Description: pop the top item from Stack
    ****************************************************/
    public Object pop()
    {
        Object topVal = top();// returns the current top
        count--;// decrement the count by 1 to remove item from stack
        return topVal;
    }

    /***************************************************
    * NAME: top
    * Description: get the top item from stack 
    ****************************************************/
    public Object top()
    {
        Object topVal;
        //if stack is empty throw exception else return the top item.
        if(!isEmpty())
        {
            topVal = stack[count-1];
        }else
        {
            throw new IllegalArgumentException("nothing in stack");
        }
        return topVal;
    }
}
    /***************************************************
    * NAME: 
    * Description: 
    ****************************************************/