package javaCoreThree.lesson.a.home;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main (String[] args){
        String[] arrStr = {"one", "two", "three"};
        Swap<String> arr1 = new Swap<>(arrStr);
        System.out.println(Arrays.toString(arrStr));
        System.out.println(Arrays.toString(arr1.getArray()));
        arr1.swapElementsArr(0, 2);
        System.out.println(Arrays.toString(arr1.getArray()));

        Integer[] arrInt = {1, 2, 3};
        Swap<Integer> arr2 = new Swap<>(arrInt);
        System.out.println(Arrays.toString(arrInt));
        System.out.println(Arrays.toString(arr2.getArray()));
        arr2.swapElementsArr(0, 2);
        System.out.println(Arrays.toString(arr2.getArray()));

        ArrayList<String> arL = new ArrayList<>();
        arr1.toArrayList(arL);
        arL.add("four");
        System.out.println(arL);

    }
}
