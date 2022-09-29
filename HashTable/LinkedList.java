import java.util.*;
//Single - Ended Linked List
public class LinkedList implements Iterable
{
    private ListNode head;
    private ListNode tail;
    private int count;

    public LinkedList(){
        head = null;
        tail = null;
        count = 0;
    }

    public void insertFirst(Object newValue)
    {
        ListNode newNode = new ListNode(newValue);
        if(isEmpty())
        {
            head = newNode;
            tail = newNode;
        }else
        {
            head.setPrev(newNode);//set the head previous node to the new node
            newNode.setNext(head);//set the current head as the adjacent node to new node 
            head = newNode;//set the new node as head.
        }

        count++;
    }

    public void insertLast(Object newValue)
    {
        ListNode newNode = new ListNode(newValue);
        if(isEmpty())
        {
            head = newNode;
            tail = newNode;
        }else
        {
            newNode.setPrev(tail);//set the current tail as previous node for the new node
            tail.setNext(newNode);//set the new node as the next node for current tail 
            tail = newNode;// set the new node as the new tail.
        }
        count++;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public Object peekFirst()
    {
        Object val;
        if(isEmpty())
        {
            throw new IllegalArgumentException(" List is empty ");
        }else
        {
            val = head.getValue();
        }

        return val;
    }

    public Object peekLast()
    {
        Object val;
        if(isEmpty())
        {
            throw new IllegalArgumentException(" List is empty ");
        }else
        {
            val = tail.getValue();
        }

        return val;
    }

    public Object removeFirst()
    {
        Object val;
        if(isEmpty())
        {
            throw new IllegalArgumentException(" List is Empty ~ Nothing to Remove ");
        }else
        {
            val = head.getValue();
            if(head == tail)
            {
                head = null;
                tail = null;
            }else
            {   
                head = head.getNext();
                head.setPrev(null);
            }
            count--;

        }

        return val;
    }

    public Object removeLast()
    {
        Object val;
        ListNode prevNode = null; 
        if(isEmpty())
        {
            throw new IllegalArgumentException(" List is empty ~ Nothing to Remove ");
        }else 
        {
            val = tail.getValue();
            if( head == tail)
            {
                head = null;
                tail = null;
            }else
            {
                tail = tail.getPrev();
                tail.setNext(null);
            }
            count--;
           
        }
        
        return val;
    }

    public int getCount()
    {
        return this.count;
    }
    private class ListNode
    {
        private Object value;
        private ListNode next;
        private ListNode prev;

        public ListNode(Object inValue){
            value = inValue;
            next = null;
            prev = null;
        }

        public void setPrev(ListNode prevNode)
        {
            prev = prevNode;
        }

        public ListNode getPrev()
        {
            return prev;
        }

        public Object getValue()
        {
            return value;
        }

        public void setValue(Object inValue)
        {
            value = inValue;
        }

        public ListNode getNext()
        {
            return next;
        }

        public void setNext(ListNode nextNode)
        {
            next = nextNode;
        }
    }

    public Iterator iterator()
    {
        return new LinkedListIterator(this);
    }

    private class LinkedListIterator implements Iterator{
        private ListNode iterNext;
        public LinkedListIterator(LinkedList list)
        {
            iterNext = list.head;
        }

        public boolean hasNext()
        {
            return iterNext !=null;
        }

        public Object next()
        {
            Object value;
            if(iterNext==null)
            {
                value = null;
            }else
            {
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return value;
        }

        
    }
}