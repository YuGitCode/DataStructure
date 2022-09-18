public abstract class DSAQueue
{
    protected Object[] queue;
    protected int count;
    private static final int MAXCAPACITY = 100;

    /***************************************************
    * NAME: DSAQueue
    * Description: Default Constructor
    ****************************************************/
    public DSAQueue()
    {
        queue = new Object[MAXCAPACITY];
        count = 0;
    }

    /***************************************************
    * NAME: DSAQueue
    * Description: Alternative Constructor
    ****************************************************/
    public DSAQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
        count = 0;
    }
    /***************************************************
    * NAME: getCount()
    * Description: get queue count
    ****************************************************/
    public int getCount()
    {
        return this.count;
    }
    /***************************************************
    * NAME: isEmpty()
    * Description: check if queue is empty
    ****************************************************/
    public boolean isEmpty()
    {
        boolean empty = false;

        if(count<=0)
        {
            empty = true;
        }
        return empty;
    }
    /***************************************************
    * NAME: isFull()
    * Description: Check if queue is full.
    ****************************************************/
    public boolean isFull()
    {
        boolean full = false;
        if(count>=queue.length)
        {
            full = true;
        }
        return full;
    }

    public abstract void enqueue(Object val);
    public abstract Object dequeue();
    public abstract Object peek();

}