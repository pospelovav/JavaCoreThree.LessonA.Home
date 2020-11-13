package javaCoreThree.lesson.a.home;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main (String[] args){
        String[] arrStr = {"one", "two", "three"};
        Swap<String> arr1 = new Swap<>(arrStr);
        System.out.println("String array: " + Arrays.toString(arrStr));
        System.out.println("Swap array: " + Arrays.toString(arr1.getArray()));
        arr1.swapElementsArr(0, 2);
        System.out.println("Array after swap elements: " + Arrays.toString(arr1.getArray()));

        Integer[] arrInt = {1, 2, 3};
        Swap<Integer> arr2 = new Swap<>(arrInt);
        System.out.println("String array: " + Arrays.toString(arrInt));
        System.out.println("Swap array: " + Arrays.toString(arr2.getArray()));
        arr2.swapElementsArr(0, 2);
        System.out.println("Array after swap elements: " + Arrays.toString(arr2.getArray()));

        ArrayList<String> arL = new ArrayList<>();
        arr1.toArrayList(arL);
        arL.add("four");
        System.out.println("ArrayList from Swap array + elements \"four\": " + arL);

        System.out.println();

        Apple[] apples = new Apple[4];
        for (int i = 0; i < apples.length; i++) {
            apples[i] = new Apple();
        }
        Apple apple5 = new Apple();

        Orange[] oranges = new Orange[3];
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] = new Orange();
        }
        Orange orange4 = new Orange();
        Orange orange5 = new Orange();

        Box<Apple> box1 = new Box();
        box1.setFruit(apples);
        box1.setFruit(apple5);

        Box<Orange> box2 = new Box(oranges);   //box2.setFruit(oranges);
        box2.setFruit(orange4);
        box2.setFruit(orange5);
        System.out.println("Box with apples weight: " + box1.getWeight());
        System.out.println("Box with oranges weight: " + box2.getWeight());
        System.out.println("Box with apples weight = Box with oranges weight: " + box1.compare(box2));
        Box<Apple> box3 = new Box();
        box1.removeToNewBox(box3);
        System.out.println("New Box with apples weight: " + box3.getWeight());
        System.out.println("Box1 with apples weight: " + box1.getWeight());
        box1.setFruit(apples);
        System.out.println("Box1 with apples weight: " + box1.getWeight());
        Apple[] apples2 = new Apple[12];
        for (int i = 0; i < apples2.length; i++) {
            apples2[i] = new Apple();
        }
        box1.setFruit(apples2);
        System.out.println("Box1 with apples weight: " + box1.getWeight());
        Apple[] apples3 = new Apple[7];
        for (int i = 0; i < apples3.length; i++) {
            apples3[i] = new Apple();
        }
        box1.setFruit(apples3);
        Apple apple6 = new Apple();
        box1.setFruit(apple6);
        Apple apple7 = new Apple();
        box1.setFruit(apple7);
        System.out.println("Box1 with apples weight: " + box1.getWeight());


    }
}
