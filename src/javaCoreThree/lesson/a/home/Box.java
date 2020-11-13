package javaCoreThree.lesson.a.home;

import java.util.ArrayList;
import java.util.Collections;

public class Box<T extends Fruit> {
    private ArrayList<T> fruit;
    private float fruitWeight;
    private float maxWeightBox = 20f;

//    public ArrayList<T> getFruit() {
//        return fruit;
//    }

    public void setFruit(T fruit) {                                   //добавление одного фрукта в имеющуюся коробку
        if (fruit.weight > 0 && this.freeWeight() && ((this.maxWeightBox - this.getWeight()) >= fruit.weight)){  //на случай, если этот фрукт уже куда-то клали и есть место
            this.fruit.add(fruit);
            this.fruitWeight = fruit.weight;
            fruit.weight = 0;  //фиксируем, что фрукт положили
        }
    }
    public void setFruit(T[] arrFruits) {                             //добавление массива фруктов в имеющуюся коробку
        float sumWeight = 0;
        for (int i = 0; i < arrFruits.length; i++) {
            sumWeight += arrFruits[i].weight;
        }
        if (sumWeight > 0 && ((this.maxWeightBox - this.getWeight()) >= sumWeight)) {
            Collections.addAll(this.fruit, arrFruits);
            this.fruitWeight = arrFruits[0].weight;
            for (int i = 0; i < arrFruits.length; i++) {
                arrFruits[i].weight = 0;    //фиксируем, что фрукты положили
            }
        }
    }
    private void setFruit(ArrayList<T> arrFruits) {                     //для перебрасывания из одной коробки в другую

        this.fruit = (ArrayList<T>) arrFruits.clone();

    }


    public Box (){                                                      //простое создание коробки
        fruit = new ArrayList<T>();
    }
    public Box (float maxWeightBox){                //простое создание коробки и указываем максимальную грузоподьемность
        fruit = new ArrayList<T>();
        this.maxWeightBox = maxWeightBox;
    }

    public Box (T[] arrFruits){                                    //при создании коробки заполняем массивом из фруктов
        float sumWeight = 0;
        for (int i = 0; i < arrFruits.length; i++) {
            sumWeight += arrFruits[i].weight;
        }
        if (sumWeight > 0 && (this.maxWeightBox >= sumWeight)){
            fruit = new ArrayList<T>();
            Collections.addAll(this.fruit, arrFruits);
            this.fruitWeight = sumWeight / arrFruits.length;
            for (int i = 0; i < arrFruits.length; i++) {
                arrFruits[i].weight = 0;       //фиксируем, что фрукты положили
            }
        }

    }
    public Box (T[] arrFruits, float maxWeightBox){             //при создании коробки заполняем массивом из фруктов
        this.maxWeightBox = maxWeightBox;                       // и указываем максимальную грузоподьемность
        float sumWeight = 0;
        for (int i = 0; i < arrFruits.length; i++) {
            sumWeight += arrFruits[i].weight;
        }
        if (sumWeight > 0 && (this.maxWeightBox >= sumWeight)){
            fruit = new ArrayList<T>();
            Collections.addAll(this.fruit, arrFruits);
            this.fruitWeight = sumWeight / arrFruits.length;
            for (int i = 0; i < arrFruits.length; i++) {
                arrFruits[i].weight = 0;    //фиксируем, что фрукты положили
            }
        }

    }

    public float getWeight(){                               //вес коробки
        return fruit.size() * this.fruitWeight;
    }

    public boolean compare(Box<?> anotherBox){              //сравнение текущейго веса коробок
        return this.getWeight() == anotherBox.getWeight();
    }

    public void removeToNewBox(Box<T> newBox){
        if (newBox.maxWeightBox >= this.getWeight()){       //если содержимое коробки помещается в новую коробку
            newBox.setFruit(this.fruit);
            newBox.fruitWeight = this.fruitWeight;
            this.fruit.removeAll(this.fruit);
        }
    }

    private boolean freeWeight(){           //свободное место в коробке
        return ((this.maxWeightBox - this.getWeight()) > 0);
    }

}
