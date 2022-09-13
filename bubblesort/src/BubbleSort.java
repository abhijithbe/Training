import java.util.stream.IntStream;

public class BubbleSort {
    /**
     * To swap two indexes x and y of an array
     * @param x-> Index of first Number
     * @param y -> Index of Second Number
     * @param array -> The array in which elements are swapped
     */
    static void swap(int x,int y,int array[])
    {
        int temp=array[x];
        array[x]=array[y];
        array[y]=temp;
    }

    /**
     * BubbleSort is a function to sort elements in an array
     * it sorts elements using swapping method
     * the function also displays array that is sorted
     * @param array -> array to be sorted
     */
    void BubbleSort(int array[])
    {
        IntStream.range(0,array.length-1).forEach( i ->
                {
                    IntStream.range(0,array.length-i-1).forEach( j ->
                            {
                                if (array[j]>array[j+1])
                                {
                                    swap(j,j+1,array);
                                }
                            }
                    );
                }
        );
        IntStream.range(0,array.length).forEach( i ->
                {
                    System.out.println(array[i]);
                }
        );
    }

    public static void main(String[] args) {
        int array[]={6,2,3,5,1};
        BubbleSort sortingObject=new BubbleSort();
        sortingObject.BubbleSort(array);
    }
}