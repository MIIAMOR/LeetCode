package com.yubin.part03;

import java.util.LinkedList;

/**
 * @author MIIAMOR
 * @date 2021/6/26 18:50
 * easy
 */
public class AnimalShelf {
    private LinkedList<int[]> animals;

    public AnimalShelf() {
        animals = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        animals.addLast(animal);
    }

    public int[] dequeueAny() {
        if (animals.isEmpty()) return new int[]{-1, -1};
        return animals.removeFirst();
    }

    public int[] dequeueDog() {
        if (animals.isEmpty()) return new int[]{-1, -1};
        return dequeue(1);
    }

    public int[] dequeueCat() {
        if (animals.isEmpty()) return new int[]{-1, -1};
        return dequeue(0);
    }

    private int[] dequeue(int type) {
        for (int[] animal : animals) {
            if (animal[1] == type) {
                animals.remove(animal);
                return animal;
            }
        }
        return new int[]{-1, -1};
    }
}
