public class CircularQueue extends DSAQueue
{

    private int end;
    private int front;
    /***************************************************
    * NAME: CircularQueue()
    * Description: Default Constructor
    ****************************************************/
    public CircularQueue()
    {
        super();
        end = 0;
        front = 0;
    }
    /***************************************************
    * NAME: CircularQueue()
    * Description: Alternate Constructor
    ****************************************************/
    public CircularQueue(int maxCapacity)
    {
        super(maxCapacity);
        end = 0;
        front = 0;
    }
    /***************************************************
    * NAME: enqueue
    * Description: add item to queue
    ****************************************************/
    public void enqueue(Object val)
    {
        if(!super.isFull())
        {   //if end is length of array but queue is not full, 
            //point tail to index 0
            if(end >= super.queue.length)
            {
                end = 0;
            }
            super.queue[end] = val;
            super.count++;
            end++;

        }else
        {
            throw new IllegalArgumentException("Queue is Full");
        }
    }
    /***************************************************
    * NAME: dequeue
    * Description: Remove item from queue
    ****************************************************/
    public Object dequeue()
    {
        Object frontVal = peek();
        if(!super.isEmpty())
        {   
            super.count--;
            if(front==super.queue.length-1)
            {
                front = 0;
            }else
            {
                front++;
            }
            

        }else
        {
            throw new IllegalArgumentException("Queue is empty");
        }
        return frontVal;
    }
    /***************************************************
    * NAME: peek
    * Description: look at the front of the queue 
    ****************************************************/
    public Object peek()
    {
        Object frontVal;
        if(!super.isEmpty())
        {
            frontVal = queue[front];
        }else
        {
            throw new IllegalArgumentException("Queue is Empty");
        }
        return frontVal;
    }
}