package pl.horus;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Wall wallOne = new Wall("yellow", "steel");
        Wall wallTwo = new Wall("white", "wood");
        Wall wallThree = new Wall("black", "steel");
        Wall wallFour = new Wall("black", "stone");

        List<Block> objectsList = wallOne.getBlocks();
        int count = 1;
        for (Block element : objectsList){
            System.out.println(count + " - " + element.getColor() + " " + element.getMaterial());
            count++;
        }

        System.out.println("Number of elements: " + wallOne.count());

        System.out.println("Find block by color: " + wallOne.findBlockByColor("white").toString());

        System.out.println("Find blocks by material: " + wallOne.findBlocksByMaterial("steel").toString());

    }
}