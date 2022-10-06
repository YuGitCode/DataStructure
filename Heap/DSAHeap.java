public class DSAHeap
{
    private DSAHeapEntry[] heap;
    private int count;
    public DSAHeap(int size)
    {
        heap = new DSAHeapEntry[size];
        count = 0;
    }

    public void add(int priority,Object value)
    {
        heap[count] = new DSAHeapEntry(priority, value);
        trickleUp(count);
        count++;
    }

    public DSAHeapEntry remove()
    {
        DSAHeapEntry removed = null;
        if(count > 0)
        {   
            removed = heap[0];
            count--;
            heap[0] = heap[count];
            trickleDown(0);
        }else
        {
            System.out.println("Heap isEmpty ");
        }

        return removed;
    }

    public void display()
    {
        for(int i = 0; i<count;i++)
        {
            System.out.println(heap[i].getPriority()+" "+ heap[i].getValue() + " ");
        }
        System.out.println();

    }

    public void trickleUp(int curIdx)
    {
        int parentIdx = (curIdx - 1) / 2;
        if(curIdx > 0)
        {   
            if( heap[ curIdx ].getPriority() > heap[ parentIdx ].getPriority() )
            {
                DSAHeapEntry temp = heap[ parentIdx ];
                heap[ parentIdx ] = heap[ curIdx ];
                heap[ curIdx ] = temp;
                trickleUp(parentIdx);
            }
        }

    }

    public void trickleDown(int curIdx)
    {
        int lChildIdx = curIdx * 2 + 1;
        int rChildIdx = lChildIdx + 1;

        if(lChildIdx < count)
        {
            int largeIdx = lChildIdx;
            if(rChildIdx < count)
            {
                if(heap[lChildIdx].getPriority() < heap[rChildIdx].getPriority())
                {
                    largeIdx = rChildIdx;
                }
            }

            if(heap[largeIdx].getPriority() > heap[curIdx].getPriority())
            {
                DSAHeapEntry temp = heap[largeIdx];
                heap[largeIdx] = heap[curIdx];
                heap[curIdx] = temp;

                trickleDown(largeIdx);
            }

        }
    }

    public void heapSort()
    {
       
        for(int i = count - 1; i >= 1; i--)
        {
            DSAHeapEntry temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            count = i;
            trickleDown(0);
        }
        count = heap.length;

    }

    private class DSAHeapEntry
    {
        private int priority;
        private Object value;

        public DSAHeapEntry(int priority, Object value)
        {
            this.priority = priority;
            this.value = value;
        }

        public int getPriority()
        {
            return this.priority;
        }

        public Object getValue()
        {
            return this.value;
        }

        public void setPriority(int priority)
        {
            this.priority = priority;
        }

        public void setValue(Object value)
        {
            this.value = value;
        }
    }
}