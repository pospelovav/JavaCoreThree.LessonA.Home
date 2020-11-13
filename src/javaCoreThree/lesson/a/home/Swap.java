package javaCoreThree.lesson.a.home;

import java.util.ArrayList;
import java.util.Collections;

public class Swap<T> {
    private T[] array;

    public T[] getArray() {
        return array;
    }

    public Swap (T[] array){
        this.array = array;
    }

    public void swapElementsArr(int i, int j){  //меняет i-й элемент массива с j-ым местами
        try {
            T buffer = this.array[j];
            this.array[j] = this.array[i];
            this.array[i] = buffer;
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

    }

    public void toArrayList(ArrayList<T> arrList){  //преобразует массив в ArrayList
        Collections.addAll(arrList, this.array);
    }

}
