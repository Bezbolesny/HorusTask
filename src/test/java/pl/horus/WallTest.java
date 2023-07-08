package pl.horus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private Wall wallOne;
    private Wall wallTwo;
    private Wall wallThree;
    private Wall wallFour;

    @BeforeEach
    public void initializeList(){
        wallOne = new Wall("orange", "brick");
        wallTwo = new Wall("blue", "stone");
        wallThree = new Wall("green", "brick");
        wallFour = new Wall("blue", "plastic");
    }



    @Test
    public void findBlockByColorHappyPath(){
        // when
        Optional<Block> blockFoundedByColor = wallOne.findBlockByColor("blue");

        // then
        assertTrue(blockFoundedByColor.isPresent());
        assertEquals(Optional.of(wallTwo), blockFoundedByColor);

    }

    @Test
    public void findBlockByColorUnhappyPath() {
        // when
        Optional<Block> blockFoundedByColor = wallOne.findBlockByColor("gray");

        // then
        assertFalse(blockFoundedByColor.isPresent());
        assertNotEquals(wallTwo, blockFoundedByColor);

    }

    @Test
    public void findBlocksByMaterialHappyPath(){
        //given
        List<Block> expectedBlocks = new ArrayList<>(List.of(wallOne, wallThree));

        // when
        List<Block> blocksFoundedByMaterial = wallOne.findBlocksByMaterial("brick");

        // then
        assertTrue(!blocksFoundedByMaterial.isEmpty());
        assertEquals(expectedBlocks, blocksFoundedByMaterial);

    }

    @Test
    public void findBlocksByMaterialUnhappyPath(){
        //given
        List<Block> expectedBlocks = new ArrayList<>(List.of(wallOne, wallThree));

        // when
        List<Block> blocksFoundedByMaterial = wallOne.findBlocksByMaterial("glass");

        // then
        assertTrue(blocksFoundedByMaterial.isEmpty());
        assertNotEquals(expectedBlocks, blocksFoundedByMaterial);

    }

}