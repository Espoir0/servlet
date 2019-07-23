package sort;

import static sort.Choice.choiceSort;
//import static sort.Insertion.InsertSort;

public class Demo {
    public static void main(String[] args) {
        Integer[] arr=new Integer[]{9,8,7,6,4,4,3,2,1};
      //  InsertSort(arr);
        choiceSort(arr);
    }

}
