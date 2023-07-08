package pl.horus;


import pl.horus.interfaces.Block;
import pl.horus.interfaces.CompositeBlock;
import pl.horus.interfaces.Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure, CompositeBlock {

    private final String color;
    private final String material;
    private static int count = 0;
    private static List<Block> blocks = new ArrayList<>();


    public Wall(String color, String material){
        this.color = color;
        this.material = material;
        count++;
        blocks.add(this);
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
            return getBlocks().stream()
                    .filter(element -> element.getColor().equalsIgnoreCase(color))
                    .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return getBlocks().stream()
                .filter(element -> element.getMaterial().equalsIgnoreCase(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
            return count;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public List<Block> getBlocks() {
        List<Block> blocksCopy = new ArrayList<>(blocks);
        return blocksCopy;
    }

    @Override
    public String toString(){
        return getColor()+ " " + getMaterial();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return Objects.equals(color, wall.color) && Objects.equals(material, wall.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, material);
    }

}
