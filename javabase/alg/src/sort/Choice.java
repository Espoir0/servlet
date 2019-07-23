package sort;

public class Choice {
    public static void choiceSort(Comparable[] arr){

        for (int i = 0; i < arr.length; i++) {
            int min=i;
            for(int j=i;j<arr.length;j++)
                if (less(arr[j],arr[min])) min=j;
            exch(arr,i,min);

        }

        for (Comparable comparable : arr) {
            System.out.print(comparable+" ");
        }
        System.out.println();
    }

    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] arr,int i,int j){
        Comparable temp=arr[i];
        arr[i] =arr[j];
        arr[j]=temp;
    }
}
