public class UnitTestLinkedList
{
    public static void main(String []args)
    {
        int testPassed = 0;
        int numTest = 0;
        String sTest;
        Object nodeValue;
        DSAStack stack = new DSAStack();
        DSAQueue queue = new DSAQueue();

//------------------------------------------------------------------------------
        //Test 1
        System.out.println("Testing Stack");
        System.out.println("=======================================");

        try{
            System.out.print("Test push(): ");
            numTest++;
            
            stack.push("abc");
            stack.push("xyz");
            stack.push("jkl");
            testPassed++;
            System.out.println("PASSED");

        }catch(Exception e){
            System.out.println("FAILED");
        }
        System.out.println("=======================================");
        //Test 2
        System.out.print("Test getCount(): ");
        numTest++;
        if(stack.getCount() == 3 )
        {
            System.out.println("PASSED");
            testPassed++;
        }else
        {
            System.out.println("FAILED");
        }
//------------------------------------------------------------------------------
        //top
        //Test 3
        try{
            numTest++;
            System.out.print("Test top(): ");
            sTest = (String)stack.top();
            if(!sTest.equals("jkl"))
            {
                throw new IllegalArgumentException("FAILED");
            }
            testPassed++;
            System.out.println("PASSED");

        }catch(Exception e){
            System.out.println("FAILED");
        }

        //pop
        //Test 4
        try{
            numTest++;
            System.out.print("Test pop: ");
            sTest = (String)stack.pop();
            if(!sTest.equals("jkl"))
            {
                throw new IllegalArgumentException("FAILED");
            }

            sTest = (String)stack.pop();
            if(!sTest.equals("xyz"))
            {
                throw new IllegalArgumentException("FAILED");
            }

            sTest = (String)stack.pop();
            if(!sTest.equals("abc"))
            {
                throw new IllegalArgumentException("FAILED");
            }
            testPassed++;
            System.out.println("PASSED");

        }catch(Exception e){
            System.out.println("FAILED");
        }

        //isEmpty()
        //Test 5
        try{
            numTest++;
            System.out.print("Test isEmpty(): ");
            sTest = (String)stack.pop();
            System.out.println("FAILED");
        }catch(Exception e)
        {
            testPassed++;
            System.out.println("PASSED");
        }
        //Test 6
        System.out.println("=======================================");
        System.out.print("Test getCount(): ");
        numTest++;
        if(stack.getCount() == 0 )
        {
            System.out.println("PASSED");
            testPassed++;
        }else
        {
            System.out.println("FAILED");
        }

//------------------------------------------------------------------------------
        System.out.println("Testing Queue");
        System.out.println("=======================================");
        //insertLast
        //Test 7
        try{
            numTest++;
            System.out.print("Test enqueue(): ");
            queue.enqueue("abc");
            queue.enqueue("jkl");
            queue.enqueue("xyz");
            testPassed++;
            System.out.println("PASSED");

        }catch(Exception e){
            System.out.println("FAILED");
        }
        //Test 8
        System.out.println("=======================================");
        System.out.print("Test getCount(): ");
        numTest++;
        if(queue.getCount() == 3 )
        {
            System.out.println("PASSED");
            testPassed++;
        }else
        {
            System.out.println("FAILED");
        }
        //Peek
        //Test 9
        try{
            numTest++;
            System.out.print("Test peek(): ");
            if(!queue.peek().equals("abc"))
            {
                throw new IllegalArgumentException("FAILED");
            }
            testPassed++;
            System.out.println("PASSED");

        }catch(Exception e){
            System.out.println("FAILED");
        }

        //dequeue
        //Test 10
        try{
            numTest++;
            System.out.print("Test removeLast(): ");
            sTest = (String)queue.dequeue();
            if(!sTest.equals("abc"))
            {
                throw new IllegalArgumentException("FAILED");
            }

            sTest = (String)queue.dequeue();
            if(!sTest.equals("jkl"))
            {
                throw new IllegalArgumentException("FAILED");
            }

            sTest = (String)queue.dequeue();
            if(!sTest.equals("xyz"))
            {
                throw new IllegalArgumentException("FAILED");
            }
            testPassed++;
            System.out.println("PASSED");

        }catch(Exception e){
            System.out.println("FAILED");
        }

        //isEmpty()
        //Test 11
        try{
            numTest++;
            System.out.print("Test isEmpty(): ");
            sTest = (String)queue.dequeue();
            System.out.println("FAILED");
        }catch(Exception e)
        {
            testPassed++;
            System.out.println("PASSED");
        }
        //Test 12
        System.out.println("=======================================");
        System.out.print("Test getCount(): ");
        numTest++;
        if(queue.getCount() == 0 )
        {
            System.out.println("PASSED");
            testPassed++;
        }else
        {
            System.out.println("FAILED");
        }
        
//---------------------------------------------------------------------------
        System.out.println("=======================================");
        // PRINT TEST SUMMARY
        System.out.print("Number PASSED: " + testPassed + "/" + numTest);
        System.out.print(" -> " + (int)(double)testPassed/numTest*100 + "%\n");
    
//---------------------------------------------------------------------------

    }
}