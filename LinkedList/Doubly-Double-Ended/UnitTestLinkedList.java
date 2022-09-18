public class UnitTestLinkedList
{
    public static void main(String []args)
    {
        int testPassed = 0;
        int numTest = 0;
        LinkedList ll = null;
        String sTest;
        Object nodeValue;

//------------------------------------------------------------------------------
        //Test 1
        System.out.println("Testing Constructor");
        System.out.println("=======================================");

        try{
            numTest++;
            ll = new LinkedList();
            System.out.print("Test isEmpty(): ");
            if(!ll.isEmpty())
            {
                throw new IllegalArgumentException("List should be empty upon creation");
            }
            testPassed++;
            System.out.println("PASSED");

        }catch(Exception e){
            System.out.println("FAILED");
        }
        System.out.println("=======================================");

//------------------------------------------------------------------------------
        System.out.println("Testing Insert First,peekFirst and remove First");
        System.out.println("=======================================");
        //Insert First
        //Test 2
        try{
            numTest++;
            System.out.print("Test insertFirst(): ");
            ll.insertFirst("abc");
            ll.insertFirst("jkl");
            ll.insertFirst("xyz");
            testPassed++;
            System.out.println("PASSED");

        }catch(Exception e){
            System.out.println("FAILED");
        }

        //Peek First
        //Test 3
        try{
            numTest++;
            System.out.print("Test peekFirst(): ");
            if(!ll.peekFirst().equals("xyz"))
            {
                throw new IllegalArgumentException("FAILED");
            }
            testPassed++;
            System.out.println("PASSED");

        }catch(Exception e){
            System.out.println("FAILED");
        }
        //RemoveFirst
        //Test 4
        try{
            numTest++;
            System.out.print("Test removeFirst(): ");
            sTest = (String)ll.removeFirst();
            if(!sTest.equals("xyz"))
            {
                throw new IllegalArgumentException("FAILED");
            }

            sTest = (String)ll.removeFirst();
            if(!sTest.equals("jkl"))
            {
                throw new IllegalArgumentException("FAILED");
            }

            sTest = (String)ll.removeFirst();
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
            sTest = (String)ll.removeFirst();
            System.out.println("FAILED");
        }catch(Exception e)
        {
            testPassed++;
            System.out.println("PASSED");
        }

        System.out.println("=======================================");

//------------------------------------------------------------------------------
        System.out.println("Testing InsertLast,peekLast and RemoveLast");
        System.out.println("=======================================");
        //insertLast
        //Test 6
        try{
            numTest++;
            System.out.print("Test insertFirst(): ");
            ll.insertLast("abc");
            ll.insertLast("jkl");
            ll.insertLast("xyz");
            testPassed++;
            System.out.println("PASSED");

        }catch(Exception e){
            System.out.println("FAILED");
        }

        //Peek Last
        //Test 7
        try{
            numTest++;
            System.out.print("Test peekLast(): ");
            if(!ll.peekLast().equals("xyz"))
            {
                throw new IllegalArgumentException("FAILED");
            }
            testPassed++;
            System.out.println("PASSED");

        }catch(Exception e){
            System.out.println("FAILED");
        }

        //RemoveFirst
        //Test 8
        try{
            numTest++;
            System.out.print("Test removeLast(): ");
            sTest = (String)ll.removeLast();
            if(!sTest.equals("xyz"))
            {
                throw new IllegalArgumentException("FAILED");
            }

            sTest = (String)ll.removeLast();
            if(!sTest.equals("jkl"))
            {
                throw new IllegalArgumentException("FAILED");
            }

            sTest = (String)ll.removeLast();
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
        //Test 9
        try{
            numTest++;
            System.out.print("Test isEmpty(): ");
            sTest = (String)ll.removeLast();
            System.out.println("FAILED");
        }catch(Exception e)
        {
            testPassed++;
            System.out.println("PASSED");
        }
        
        
//---------------------------------------------------------------------------
        System.out.println("=======================================");
        // PRINT TEST SUMMARY
        System.out.print("Number PASSED: " + testPassed + "/" + numTest);
        System.out.print(" -> " + (int)(double)testPassed/numTest*100 + "%\n");
    
//---------------------------------------------------------------------------

    }
}