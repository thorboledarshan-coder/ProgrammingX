///////////////////////////
//  Complete Sorting Codes
///////////////////////////

import java.util.*;

interface GetterSetter
{
    void Accept();
    void Display();
}

class ArrayX implements GetterSetter
{
    protected int Arr[]; 
    protected int iSize;

    public ArrayX(int iSize)
    {
        this.iSize = iSize;
        Arr = new int[iSize];
    }

    public void Accept()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the elements of array : ");

        for(int i = 0; i < iSize; i++)
        {
            Arr[i] = sobj.nextInt();
        }
    }

    public void Display()
    {
        System.out.println("Elements of the array are : ");

        for(int i = 0; i < iSize; i++)
        {
            System.out.print(Arr[i]+"\t");
        }

        System.out.println();
    }

}

final class Sorting extends ArrayX
{
    public boolean IsSorted;

    public Sorting(int iSize)
    {
        super(iSize);
        IsSorted = false;
    }

    public void BubbleSort()
    {
        int i = 0, j = 0,temp = 0, pass = 0;

        if(IsSorted == true)
        {
            return;
        }

        for(i = 0,pass = 1; i < iSize-1; i++,pass++)
        {
            for(j = 0; j < iSize-1 -i; j++)
            {
                if(Arr[j] > Arr[j+1])
                {
                    temp = Arr[j];
                    Arr[j] = Arr[j+1];
                    Arr[j+1] = temp;
                }
            }

            System.out.println("Data after pass : "+pass);
            Display();
        }

        IsSorted = true;
    }

    public void BubbleSortEfficient()
    {
        int i = 0, j = 0,temp = 0;
        boolean  bFlag = false;

        bFlag = true;

        if(IsSorted == true)
        {
            return;
        }

        for(i = 0; i < iSize-1; i++) 
        {
            if(bFlag = false) //$
            {
                break;
            }

            bFlag = false;

            for(j = 0; j < iSize-1 -i; j++)
            {
                if(Arr[j] > Arr[j+1])
                {
                    temp = Arr[j];
                    Arr[j] = Arr[j+1];
                    Arr[j+1] = temp;

                    bFlag = true;  //IMP
                }
            }
        }

        IsSorted = true;
    }

    public void SelectionSort()
    {
        int i = 0, j = 0, temp = 0,pass = 0;;

        int min_index = 0;

        if(IsSorted == true)
        {
            return;
        }

        for(i = 0, pass = 1; i < iSize-1; i++,pass++)
        {
            min_index = i;

            for(j = i + 1; j < iSize; j++)
            {
                if(Arr[j] < Arr[min_index])
                {
                    min_index = j;
                }
            }

            temp = Arr[i];
            Arr[i] = Arr[min_index];
            Arr[min_index] = temp;

            System.out.println("Data after pass : "+pass);  //$
            Display();
        }

        IsSorted = true;
    }

    public void InsertionSort() //$
    {
        int i = 0, j = 0;
        int selected = 0;

        if(IsSorted == true)
        {
            return;
        }

        for(i = 1; i < iSize; i++)
        {
            for(j = i - 1,selected = Arr[i]; (j >= 0) && (Arr[j] > selected); j--)
            {
                Arr[j+1] = Arr[j];
            }

            Arr[j+1] = selected;
        }

        IsSorted = true;
    }

    public void mergeSort(int left, int right)
    {
        // Base condition
        if(left >= right)
        {
            return;
        }

        // Find middle index
        int mid = (left + right) / 2;

        // Recursively sort left half
        mergeSort(left, mid);

        // Recursively sort right half
        mergeSort(mid + 1, right);

        // Temporary array
        int temp[] = new int[Arr.length];

        // i points to left half
        int i = left;

        // j points to right half
        int j = mid + 1;

        // k points to temp array
        int k = left;

        // Compare both halves
        while(i <= mid && j <= right)
        {
            if(Arr[i] < Arr[j])
            {
                temp[k] = Arr[i];
                i++;
            }
            else
            {
                temp[k] = Arr[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements from left half
        while(i <= mid)
        {
            temp[k] = Arr[i];

            i++;
            k++;
        }

        // Copy remaining elements from right half
        while(j <= right)
        {
            temp[k] = Arr[j];

            j++;
            k++;
        }

        // Copy temp back to original array
        for(i = left; i <= right; i++)
        {
            Arr[i] = temp[i];
        }
    }

    public void quickSort(int low, int high)
    {
        if(low < high)
        {
            int pivot = Arr[high];
            int i = low - 1;

            // Partition
            for(int j = low; j < high; j++)
            {
                if(Arr[j] < pivot)
                {
                    i++;

                    if(i == j)
                    {
                        continue;
                    }
                    
                    int temp = Arr[i];
                    Arr[i] = Arr[j];
                    Arr[j] = temp;
                }
            }

            // Put pivot at correct position
            i++;

            int temp = Arr[i];
            Arr[i] = Arr[high];
            Arr[high] = temp;

            // Recursion
            quickSort(Arr, low, i - 1);
            quickSort(Arr, i + 1, high);
        }
    }
}

class Sorting
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter number of elements : ");
        int iSize = sobj.nextInt();

        Sorting srobj = new Sorting(iSize);

        srobj.Accept();
        srobj.Display();

        srobj.InsertionSort();
        
        System.out.println("Final sorted array : ");
        srobj.Display();
    }
}