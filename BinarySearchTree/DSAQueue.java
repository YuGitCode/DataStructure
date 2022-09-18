import java.util.*;
public class DSAQueue implements Iterable
{
    private LinkedList queue;

    /***************************************************
    * NAME: DSAQueue
    * Description: Default Constructor
    ****************************************************/
    public DSAQueue()
    {
        queue = new LinkedList();
    }

    /***************************************************
    * NAME: getCount()
    * Description: get queue count
    ****************************************************/
    public int getCount()
    {
        int count = 0;
        Iterator iter = queue.iterator();
        while(iter.hasNext())
        {
            iter.next();
            count++;
        }
        return count;
    }
    /***************************************************
    * NAME: isEmpty()
    * Description: check if queue is empty
    ****************************************************/
    public boolean isEmpty()
    {
        return queue.isEmpty();
    }

    /***************************************************
    * NAME: enqueue
    * Description: insert item into last of queue
    ****************************************************/
    public void enqueue(Object val)
    {
        queue.insertLast(val);
    }

    /***************************************************
    * NAME: dequeue
    * Description: remove the first item in queue
    ****************************************************/
    public Object dequeue()
    {
        Object val = queue.removeFirst();
        return val;
    }

    /***************************************************
    * NAME: peek
    * Description: peek at the first item in a queue
    ****************************************************/
    public Object peek()
    {
        return queue.peekFirst();
    }


    public Iterator iterator()
    {
        return queue.iterator();
    }
}