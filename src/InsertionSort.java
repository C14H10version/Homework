public class InsertionSort {
    private InsertionSort(){}
    public static <E extends Comparable<E>> void sort(E[] arr){
        for(int i=0;i<arr.length;i++){
            //将arr[i]插入到合适的位置
            for ( i=0;i<arr.length;i++){
                int j=i;
                if (arr[j].compareTo(arr[j-1])<0)
                    swap(arr,j,j-1);
                else break;
            }

        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr){
        for (int i=0;i<arr.length;i++){
            E t=arr[i];
            int j;
            for (j=i;j-1>0&&t.compareTo(arr[j-1])<0;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=t;
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] arr){
        for(int i = arr.length - 1; i >= 0; i --){
            // 将 arr[i] 插入到合适的位置
            E t = arr[i];
            int j;
            for(j = i; j + 1 < arr.length && t.compareTo(arr[j + 1]) > 0; j ++){
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
    }

    public static <E> void swap(E[]arr,int i,int j){
        E t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    public static void main(String[] args){
        int[] dataSize={10000,100000};
        for (int n: dataSize){
            Integer [] arr=ArrayGenerator.generateRandomArray(n,n);
            SortingHelper.sortTest("InsertionSort",arr);
        }
    }
}
