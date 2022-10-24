/**
 ** Software Technology 152 Class to hold various static sort methods.
 */
class Sorts {
  // bubble sort
  // descending dont work
  // slow as fk
  public static void bubbleSort(int[] A) {
    boolean sorted;
    int pass = 0, temp = 0;
    do {
      sorted = true;
      for (int ii = 0; ii <= (A.length - 1 - pass) - 1; ii++) {
        if (A[ii] > A[ii + 1]) {
          temp = A[ii];// swap the arrays
          A[ii] = A[ii + 1];
          A[ii + 1] = temp;
          sorted = false;

        }

      }
      pass += 1;// pass increment by one if the number cannot be swaped anymore
    } while (!sorted);
  }// bubbleSort()

  // selection sort
  public static void selectionSort(int[] A) {

    int temp, minIndex;
    for (int nn = 0; nn <= (A.length - 1); nn++) {
      minIndex = nn;
      for (int jj = nn + 1; jj <= (A.length - 1); jj++) {
        if (A[jj] < A[minIndex])// found a slot that contain smaller value and store it index
        {
          minIndex = jj;
        }
      }

      temp = A[minIndex];// swap the slots values
      A[minIndex] = A[nn];
      A[nn] = temp;
    }

  }// selectionSort()

  // insertion sort
  public static void insertionSort(int[] A) {

    for (int nn = 1; nn <= (A.length - 1); nn++) {
      int ii, temp;
      ii = nn;
      while ((ii > 0) && (A[ii - 1] > A[ii])) {
        temp = A[ii];
        A[ii] = A[ii - 1];
        A[ii - 1] = temp;
        ii = ii - 1;
      }
    }
  }// insertionSort()

  // mergeSort - front-end for kick-starting the recursive algorithm
  public static void mergeSort(int[] A) {
    mergeSortRecurse(A, 0,A.length-1);
  }// mergeSort()

  private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx) {
    int midIdx = 0;
    if(leftIdx < rightIdx)
    {
      midIdx = (leftIdx + rightIdx ) / 2;
      mergeSortRecurse(A, leftIdx, midIdx);
      mergeSortRecurse(A, midIdx + 1, rightIdx);
      merge(A, leftIdx, midIdx, rightIdx);//Merge the sub arrays
    }
  }// mergeSortRecurse()
  
  private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx) {
    int[] tempArray = new int[rightIdx - leftIdx + 1];
    int i = leftIdx;
    int j = midIdx + 1;
    int k = 0;
    
    while( (i <= midIdx) && (j <= rightIdx))
    {
      if( A[i] <= A[j])
      {
        tempArray[k] = A[i];
        i++;
      }
      else
      {
        tempArray[k] = A[j];
        j++;
      }
      k++;

    }

    //Flush remainder from left subarray
    //Goes to MidIdx inclusively
    for(int ii = i; i <= midIdx; i++)
    {
      tempArray[k] = A[i];
      k++;
    }

    //Flush remainder from right subarray
    //Goes to rightIdx inclusively from mididx
    for(int jj = j; j <= rightIdx; j++)
    {
      tempArray[k] = A[j];
      k++;
    }

    //Copy the now sorted tempArray back to the actual array
    for(int kk = leftIdx; kk <= rightIdx; kk++)
      A[kk]= tempArray[kk - leftIdx];
  }// merge()

  // quickSort - front-end for kick-starting the recursive algorithm
  public static void quickSort(int[] A) {
    quickSortRecurse(A, 0, A.length - 1);
  }// quickSort()

  private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx) {
    int pivotIdx = 0;
    int newPivIdx = 0;

    if( rightIdx > leftIdx)
    {
        pivotIdx = leftIdx;//Left Most pivot selection
        newPivIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);
        quickSortRecurse(A, leftIdx, newPivIdx - 1 );//Recursive Left
        quickSortRecurse(A, newPivIdx + 1, rightIdx);//Recursive Right
    }
  }// quickSortRecurse()

  private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx) {
    
    int newPivIdx = 0;
    int temp = 0;
    int curIdx = leftIdx;//Start from left.
    int pivVal = A[pivotIdx];

    //Swap the pivotVal with the right most element.
    A[pivotIdx] = A[rightIdx];
    A[rightIdx] = pivVal;

    //Loop at check
    for( int i = leftIdx; i <= rightIdx -1 ; i++)
    {
      //if current value is smaller than pivot value swap
      if(A[i] < pivVal)
      {
          temp = A[i];
          A[i] = A[curIdx];
          A[curIdx] = temp;
          curIdx++;
          //increase left side pointer by 1;
      }

    }

    newPivIdx = curIdx;
    A[rightIdx] = A[newPivIdx];
    A[newPivIdx] = pivVal;

    
    return newPivIdx; // TEMP - Replace this when you implement QuickSort
  }// doPartitioning

}// end Sorts calss
