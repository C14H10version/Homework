import java.util.Arrays;

public class MergeSort {
    private MergeSort(){}
    //对整个数组进行归并排序
    public static <E extends Comparable<E>> void sort(E[]arr){
    sort(arr,0,arr.length-1);
    }
    //对数组l到r区间进行归并排序
    public static <E extends Comparable<E>> void sort(E[]arr,int l,int r){
        if (l>=r) return;
        int mid =l+(r-l)/2;
        sort(arr, l, mid);
        sort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    public static <E extends Comparable<E>> void sort2(E[]arr){
        sort(arr,0,arr.length-1);
    }
    //对数组l到r区间进行归并排序
    public static <E extends Comparable<E>> void sort2(E[]arr,int l,int r){
        if (l>=r) return;
        int mid =l+(r-l)/2;
        sort2(arr, l, mid);
        sort2(arr,mid+1,r);
        merge(arr,l,mid,r);
        if (arr[mid].compareTo(arr[mid+1])>0)
            merge(arr,l,mid,r);
    }
    //合并两个有序区间arr[l,mid]和arr[mid+1,r]
    private static <E extends Comparable<E>> void merge(E[]arr,int l,int mid,int r){
        E[] temp= Arrays.copyOfRange(arr,l,r+1);
        int i=l,j=mid+1;
        //每轮循环为arr[k]赋值
        for (int k=l;k<=r;k++){
            if (i>mid){arr[k]=temp[j-l];j++;}
            else if (j>r) {arr[k]=temp[i-l];i++;}
            else if(temp[i-l].compareTo(temp[j-l])<=0){arr[k]=temp[i-l];i++;}
            else{arr[k]=temp[j-l];j++;}
        }
    }
    public static void main(String[] args){
        int n=100000;
        Integer[] arr=ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2= Arrays.copyOf(arr,arr.length);
        Integer[] arr3= Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("MergeSort2",arr);
        SortingHelper.sortTest("InsertionSort",arr);
        SortingHelper.sortTest("SelectionSort",arr);
    }
}
