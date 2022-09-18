public class ShufflingQueue extends DSAQueue
{
    /***************************************************
    * NAME: ShufflingQueue
    * Description: Default Constructor
    ****************************************************/
    public ShufflingQueue()
    {
        super();
    }
    /***************************************************
    * NAME: ShufflingQueue
    * Description: Alternative Constructor
    ****************************************************/
    public ShufflingQueue(int maxCapacity)
    {
        super(maxCapacity);
    }
    /***************************************************
    * NAME: enqueue
    * Description: add item to Queue
    ****************************************************/
    public void enqueue(Object val)
    {
        if(!super.isFull())
        {
            super.queue[count] = val;
            super.count++;
        }else
        {
            throw new IllegalArgumentException("Queue Capacity is reached");
        }
    }
    /***************************************************
    * NAME: dequeue
    * Description: remove item from front of queue
    ****************************************************/
    public Object dequeue()
    {
        Object front = peek();
        if(!super.isEmpty())
        {
            front = super.queue[0];
            for(int i=0;i<count-1;i++)
            {
                super.queue[i]=super.queue[i+1];
            }
            count--; 
        }else
        {
            throw new IllegalArgumentException("No item in Queue to remove");
        }
        return front;
    }
    /***************************************************
    * NAME: peek()
    * Description: Check the front item in the queue
    ****************************************************/
    public Object peek()
    {
        Object front;
        if(!super.isEmpty())
        {
            front = queue[0];
        }else
        {
            throw new IllegalArgumentException("No item in queue to look at");
        }
        return front;
    }
}