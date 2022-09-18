public class QueueUnitTest
{

    public static void main(String[] args)
    {
        System.out.println("========================");
        System.out.println("Testing Shuffling Queue");
        System.out.println("========================");
        System.out.println("Creating Queue size of 5");
        DSAQueue shufflingQueue = new ShufflingQueue(5);
        //Test for full Capacity
        System.out.println("========================");
        System.out.print("Adding 6 item into Queue");
        try{
            for(int i = 0; i<=5;i++)
            {
                shufflingQueue.enqueue(i);
            }
            System.out.println("Capacity Test: FAILED");
        }catch(IllegalArgumentException e)
        {
            System.out.println("...5 item added");
            System.out.println("Capacity Test: PASSED");
        }

        System.out.println("========================");
        System.out.println("Testing peek()");
        if(shufflingQueue.peek().equals(0))
        {
            System.out.println("front item: "+shufflingQueue.peek());
            System.out.println("peek() Test: PASSED");
        }else
        {
            System.out.println("peek() Test:FAILED");
        }

        System.out.println("========================");
        System.out.println("Testing dequeue()");
        System.out.println("Total item in Queue: "+shufflingQueue.getCount());
        Object shufVal = shufflingQueue.dequeue();
        System.out.println(shufVal+" removed | Item left in Queue: " + shufflingQueue.getCount() );
        if(shufVal.equals(0)&&shufflingQueue.getCount()==4)
        {
            System.out.println("dequeue() Test: PASSED");
        }else
        {
            System.out.println("dequeue() Test: FAILED");
        }
        System.out.println("========================");
        try{
            System.out.print("Remove item from Queue: ");
            for(int i=0;i<=5;i++)
            {
                System.out.print(shufflingQueue.dequeue()+" ");
            }
            System.out.println("\nisEmpty() Test: FAILED");
        }catch(IllegalArgumentException e)
        {
            System.out.println("\nisEmpty() Test: PASSED");
        }

        System.out.println("========================");


        System.out.println("\n\n========================");
        System.out.println("Testing Circular Queue");
        System.out.println("========================");
        System.out.println("Creating Queue size of 5");
        DSAQueue circularQueue = new CircularQueue(5);
        //Test for full Capacity
        System.out.println("========================");
        System.out.print("Adding 6 item into Queue");
        try{
            for(int i = 0; i<=5;i++)
            {
                circularQueue.enqueue(i);
            }
            System.out.println("Capacity Test: FAILED");
        }catch(IllegalArgumentException e)
        {
            System.out.println("...5 item added");
            System.out.println("Capacity Test: PASSED");
        }

        System.out.println("========================");
        System.out.println("Testing peek()");
        if(circularQueue.peek().equals(0))
        {
            System.out.println("front item: "+circularQueue.peek());
            System.out.println("peek() Test: PASSED");
        }else
        {
            System.out.println("peek() Test:FAILED");
        }

        System.out.println("========================");
        System.out.println("Testing dequeue()");
        System.out.println("Total item in Queue: "+circularQueue.getCount());
        Object val = circularQueue.dequeue();
        System.out.println(val+" removed | Item left in Queue: " + circularQueue.getCount() );
        if(val.equals(0)&& circularQueue.getCount()==4)
        {
            System.out.println("dequeue() Test: PASSED");
        }else
        {
            System.out.println("dequeue() Test: FAILED");
        }
        System.out.println("========================");
        try{
            System.out.print("Remove item from Queue: ");
            for(int i=0;i<=5;i++)
            {
                System.out.print(circularQueue.dequeue()+" ");
            }
            System.out.println("\nisEmpty() Test: FAILED");
        }catch(IllegalArgumentException e)
        {
            System.out.println("\nisEmpty() Test: PASSED");
        }
        System.out.println("========================");
        
    
    }
}