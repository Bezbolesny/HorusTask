package pl.horus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.horus.interfaces.Block;

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
        assertEquals(Optional.of(wallTwo), blockFoundedByColor);

    }

    @Test
    public void findBlockByColorExist(){
        // when
        Optional<Block> blockFoundedByColor = wallOne.findBlockByColor("blue");

        // then
        assertTrue(blockFoundedByColor.isPresent());

    }

    @Test
    public void findBlockByColorUnhappyPath() {
        // when
        Optional<Block> blockFoundedByColor = wallOne.findBlockByColor("gray");

        // then
        assertNotEquals(wallTwo, blockFoundedByColor);

    }

    @Test
    public void findBlockByColorDoesntExist() {
        // when
        Optional<Block> blockFoundedByColor = wallOne.findBlockByColor("gray");

        // then
        assertFalse(blockFoundedByColor.isPresent());

    }

    @Test
    public void findBlocksByMaterialHappyPath(){
        // when
        List<Block> blocksFoundedByMaterial = wallOne.findBlocksByMaterial("Stone");

        // then
        assertEquals(List.of(wallTwo), blocksFoundedByMaterial);

    }

    @Test
    public void findBlocksByMaterialExist(){
        //given
        List<Block> expectedBlocks = new ArrayList<>(List.of(wallOne, wallThree));

        // when
        List<Block> blocksFoundedByMaterial = wallOne.findBlocksByMaterial("brick");

        // then
        assertTrue(!blocksFoundedByMaterial.isEmpty());

    }

    @Test
    public void findBlocksByMaterialUnhappyPath(){
        //given
        List<Block> expectedBlocks = new ArrayList<>(List.of(wallOne, wallThree));

        // when
        List<Block> blocksFoundedByMaterial = wallOne.findBlocksByMaterial("glass");

        // then
        assertNotEquals(expectedBlocks, blocksFoundedByMaterial);

    }

    @Test
    public void findBlocksByMaterialDoesntExist(){
        //given
        List<Block> expectedBlocks = new ArrayList<>(List.of(wallOne, wallThree));

        // when
        List<Block> blocksFoundedByMaterial = wallOne.findBlocksByMaterial("glass");

        // then
        assertTrue(blocksFoundedByMaterial.isEmpty());

    }

    @Test
    public void referencesToTheSameObjectShouldBeEqual() {
        // given
        Wall wallFive = wallTwo;

        // then
        assertSame(wallTwo, wallFive);

    }

    @Test
    public void referencesToTheSameObjectShouldNotBeEqual() {
        // given
        Wall wallFive = new Wall("gray", "stone");

        // then
        assertNotSame(wallTwo, wallFive);

    }

    @Test
    public void twoBlocksShouldBeEqualWhenColorAndMaterialAreTheSame() {
        // given
        Wall wallFive = new Wall("blue", "stone");

        // then
        assertEquals(wallTwo, wallFive);

    }

}