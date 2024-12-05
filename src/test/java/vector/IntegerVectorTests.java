package vector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.math.linear.algebra.integer.vectors.Int2XVector;
import org.math.linear.algebra.integer.vectors.Int3XVector;
import org.math.linear.algebra.integer.vectors.Int4XVector;

public class IntegerVectorTests {

    // ---- Test Data ---- //

    private Integer scalar = 6;

    private Integer[] vector12X = {
            1, 2
    };

    private Integer[] vector22X = {
            3, 4
    };

    private Integer[] vector13X = {
            1, 2, 3
    };

    private Integer[] vector23X = {
            4, 5, 6
    };

    private Integer[] vector14X = {
            1, 2, 3, 4
    };

    private Integer[] vector24X = {
            5, 6, 7, 8
    };

    private Int2XVector Int2XVector1 = new Int2XVector(vector12X);
    private Int2XVector Int2XVector2 = new Int2XVector(vector22X);

    private Int3XVector Int3XVector1 = new Int3XVector(vector13X);
    private Int3XVector Int3XVector2 = new Int3XVector(vector23X);

    private Int4XVector Int4XVector1 = new Int4XVector(vector14X);
    private Int4XVector Int4XVector2 = new Int4XVector(vector24X);

    // ---- Results ---- //

    private Integer[] resultAddVector2X = {
            4, 6
    };

    private Integer[] resultSubtract2X = {
            -2, -2
    };

    private Integer[] resultMultiplyVector2XByScalar = {
            6, 12
    };

    private Integer[] resultDivideByScalar2X = {
           0, 0
    };

    private Integer[] resultAddVector3X = {
            5, 7, 9
    };

    private Integer[] resultSubtract3X = {
            -3, -3, -3
    };

    private Integer[] resultMultiplyVector3XByScalar = {
            6, 12, 18
    };

    private Integer[] resultDivideByScalar3X = {
            0, 0, 0
    };

    private Integer[] resultAddVector4X = {
            6, 8, 10, 12
    };

    private Integer[] resultSubtract4X = {
            -4, -4, -4, -4
    };

    private Integer[] resultMultiplyVector4XByScalar = {
            6, 12, 18, 24
    };

    private Integer[] resultDivideByScalar4X = {
            0, 0, 0, 0
    };

    private Integer resultDotProduct2X = 11;

    private Integer resultDotProduct3X = 32;

    private Integer resultDotProduct4X = 70;

    // ---- Tests ---- //
    @Test
    public void testAdd2X(){
        Assertions.assertArrayEquals(Int2XVector1.add(Int2XVector2).getComponents(), resultAddVector2X);
    }

    @Test
    public void testSubtract2X(){
        Assertions.assertArrayEquals(Int2XVector1.subtract(Int2XVector2).getComponents(), resultSubtract2X);
    }

    @Test
    public void testMultiplyByScalar2X(){
        Assertions.assertArrayEquals(Int2XVector1.multiplyByScalar(scalar).getComponents(), resultMultiplyVector2XByScalar);
    }

    @Test
    public void testDivideByScalar2X(){
        Assertions.assertArrayEquals(Int2XVector1.divideByScalar(scalar).getComponents(), resultDivideByScalar2X);
    }

    @Test
    public void testDotProduct2X(){
        Assertions.assertEquals(Int2XVector1.dotProduct(Int2XVector2), resultDotProduct2X);
    }

    // 3X

    @Test
    public void testAdd3X(){
        Assertions.assertArrayEquals(Int3XVector1.add(Int3XVector2).getComponents(), resultAddVector3X);
    }

    @Test
    public void testSubtract3X(){
        Assertions.assertArrayEquals(Int3XVector1.subtract(Int3XVector2).getComponents(), resultSubtract3X);
    }

    @Test
    public void testMultiplyByScalar3X(){
        Assertions.assertArrayEquals(Int3XVector1.multiplyByScalar(scalar).getComponents(), resultMultiplyVector3XByScalar);
    }

    @Test
    public void testDivideByScalar3X(){
        Assertions.assertArrayEquals(Int3XVector1.divideByScalar(scalar).getComponents(), resultDivideByScalar3X);
    }

    @Test
    public void testDotProduct3X(){
        Assertions.assertEquals(Int3XVector1.dotProduct(Int3XVector2), resultDotProduct3X);
    }

    // 4X

    @Test
    public void testAdd4X(){
        Assertions.assertArrayEquals(Int4XVector1.add(Int4XVector2).getComponents(), resultAddVector4X);
    }

    @Test
    public void testSubtract4X(){
        Assertions.assertArrayEquals(Int4XVector1.subtract(Int4XVector2).getComponents(), resultSubtract4X);
    }

    @Test
    public void testMultiplyByScalar4X(){
        Assertions.assertArrayEquals(Int4XVector1.multiplyByScalar(scalar).getComponents(), resultMultiplyVector4XByScalar);
    }

    @Test
    public void testDivideByScalar4X(){
        Assertions.assertArrayEquals(Int4XVector1.divideByScalar(scalar).getComponents(), resultDivideByScalar4X);
    }

    @Test
    public void testDotProduct4X(){
        Assertions.assertEquals(Int4XVector1.dotProduct(Int4XVector2), resultDotProduct4X);
    }

}
