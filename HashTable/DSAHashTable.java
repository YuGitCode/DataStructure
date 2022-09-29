import java.util.NoSuchElementException;

public class DSAHashTable{
    private DSAHashEntry[] hashArray;
    private int count;

    //Hash Table Class Constants
    private static final int MAX_STEP = 5;
    private static final double LF = 0.7;



    public DSAHashTable(int size)
    {
        int primeSize = nextPrime(size);
        hashArray = new DSAHashEntry[ primeSize ];
        count = 0;
        for(int i = 0; i < primeSize ; i++ )
        {
            hashArray[i] = new DSAHashEntry();
        }

    }

    public void put(String inKey,Object inValue)
    {
        int hashIdx = hash(inKey);
        int origIdx = hashIdx;
        boolean found = false;
        boolean giveUp = false;
        // System.out.println("put: " + inKey + " " + inValue + " :" + hashIdx);
        while(!found && !giveUp)
        {
            if(hashArray[hashIdx].getState() == 0 || hashArray[hashIdx].getState() == -1)
            {
                found = true;
            }
            else if((hashArray[hashIdx].getState() == 1))
            {
                if(hashArray[hashIdx].getKey().equals(inKey))
                {
                    throw new IllegalArgumentException(inKey + " Already Exist.");
                }

                hashIdx = (hashIdx + stepHash( origIdx) ) % hashArray.length;
                if(hashIdx > hashArray.length)
                {
                    hashIdx = 0 + (hashIdx-hashArray.length);
                }
                if(hashIdx == origIdx)
                {
                    giveUp = true;
                }

            }
        }

        hashArray[hashIdx] = new DSAHashEntry(inKey, inValue);
        count++;
        // System.out.println("loadFactor: "+ getLoadFactor());
        if(getLoadFactor() > LF)
        {
            // System.out.println("put: " + inKey + " " + inValue + " :" + hashIdx);
            resize(hashArray.length * 2);
        }

    }

    public Object get(String inKey)
    {
        int hashIdx = hash(inKey);
        int origIdx = hashIdx;
        boolean found = false;
        boolean giveUp = false;

        while(!found && !giveUp)
        {
            if(hashArray[hashIdx].getState() == 0)
            {
                giveUp = true;
            }
            else if((hashArray[hashIdx].key).equals(inKey))
            {
                //item found
                found = true;

            }else{
                hashIdx = (hashIdx + stepHash( origIdx) ) % hashArray.length;
                if(hashIdx > hashArray.length)
                {
                    hashIdx = 0 + (hashIdx-hashArray.length);
                }
                if(hashIdx == origIdx)
                {
                    giveUp = true;
                }
            }
        }

        if(!found)
        {
            throw new NoSuchElementException(inKey + "Don't exist");
        }
        return hashArray[hashIdx].getValue();
    }

    public void remove(String inKey)
    {
        int hashIdx = hash(inKey);
        int origIdx = hashIdx;
        boolean found = false;
        boolean giveUp = false;

        while( !found && !giveUp)
        {
            if(hashArray[hashIdx].getState() == 0)
            {
                giveUp = true;
            }else if( (hashArray[hashIdx].getKey()).equals(inKey) )
            {
                found = true;
                count--;//decrement item count when removing item out of table.
            }else{
                hashIdx = ( hashIdx + (stepHash(origIdx) % hashArray.length));
                if(hashIdx > hashArray.length)
                {
                    hashIdx = 0 + (hashIdx-hashArray.length);
                }

                if(hashIdx == origIdx)
                {
                    giveUp = true;
                }
            }
        }

        if(!found)
        {
            throw new NoSuchElementException(inKey + " Doesn't Exist");
        }
        //Setting the item slot to empty but its state to being used.
        hashArray[hashIdx].setState(-1);
        hashArray[hashIdx].setKey("");
        hashArray[hashIdx].setValue(null);

    }

    public int getSize()
    {
        return hashArray.length;
    }
    public double getLoadFactor()
    {
        return ( (double)count / (double) hashArray.length);
    }

    public String[] export()
    {
        String[] items = new String[count];
        int ii = 0;
        for(int i = 0; i < hashArray.length;i++)
        {
            if(hashArray[i].getState() == 1)
            {
                items[ii] = (hashArray[i].getKey() + " , " + hashArray[i].getValue());
                ii++;
            }
        }
        return items;
    }

    private void resize(int size)
    {
        DSAHashEntry[] tempArray = hashArray;
        int newSize = nextPrime(size);
        count = 0;//Resting item count to zero.
        int newCount = 0;
        hashArray = new DSAHashEntry[ newSize ];
        //Reinitializing the hashArray with empty HashEntry objects
        for( int i = 0; i < newSize ; i++)
        {
            hashArray[i] = new DSAHashEntry();
        }

        for(int i = 0; i < tempArray.length; i++)
        {
            if(tempArray[i].getState() == 1)
            {
                put(tempArray[i].getKey(),tempArray[i].getValue());
                //increment item count by one each time a value being added back in after resize.
                count++;
                
            }
        }

        // System.out.println("ReSIZE Successfully to: " + newSize);

    }

    private int hash(String inKey)
    {
        int hashIdx = 0;
        for(int ii = 0; ii < inKey.length();ii++)
        {
            hashIdx = (31 * hashIdx) + inKey.charAt(ii);
        }
        return Math.abs(hashIdx % hashArray.length);//hash value cant be negatives.
    }

    private int stepHash(int hashIdx)
    {
        return Math.abs(MAX_STEP - ( hashIdx % MAX_STEP));//hash value cant be negatives.
    }

    public int nextPrime(int inNum)
    {
        int primeVal = 0;
        boolean isPrime = false;
        if(inNum % 2 == 0)//Even numbers can never be prime.
        {
            primeVal = inNum -1;
        }else
        {
            primeVal = inNum;
        }
        //Test if primeVal is a prime number
        do{
            primeVal = primeVal + 2;
            int ii = 3;
            isPrime = true;
            int rootVal =(int)Math.sqrt(primeVal);

            do{
                if(primeVal % ii == 0)
                {
                    isPrime = false;
                }else
                {
                    ii = ii + 2;
                }
            }while( (ii <= rootVal) && isPrime);

        }while(!isPrime);
        

        return primeVal;
    }



    public class DSAHashEntry
    {
        private String key;
        private Object value;
        private int state;

        public DSAHashEntry()
        {
            key = "";
            value = null;
            state = 0;// 0 = never used | 1 = used | -1 = formerly-used;
            
        }

        public DSAHashEntry(String inKey, Object inValue)
        {
            key = inKey;
            value = inValue;
            state = 1;
        }

        //Getter
        public String getKey()
        {
            return this.key;
        }

        public int getState()
        {
            return this.state;
        }

        public Object getValue()
        {
            return this.value;
        }

        //Setters
        public void setState(int state)
        {
            this.state = state;
        }

        public void setKey(String key)
        {
            this.key = key;
        }

        public void setValue(Object value)
        {
            this.value = value;
        }
    }

}