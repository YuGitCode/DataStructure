import java.util.*;
//Single - Ended Linked List
public class LinkedList implements Iterable
{
    private ListNode head;
    private ListNode tail;

    public LinkedList(){
        head = null;
        tail = null;
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
            //Get the first item in list
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
            //Get the Last item in list
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
            //if there only one item in list.
            if(head == tail)
            {   //Set head and tail to null.
                head = null;
                tail = null;
            }else
            {   //point the head cursor to the next item inline.
                head = head.getNext();
                head.setPrev(null);
            }

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
        {   //if there only one item in list.
            val = tail.getValue();
            if( head == tail)
            {   //set head and tail to null.
                head = null;
                tail = null;
            }else
            {
                //point the head cursor to the previous item inline.
                tail = tail.getPrev();
                tail.setNext(null);
            }
           
        }
        
        return val;
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