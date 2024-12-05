package vector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.math.linear.algebra.noninteger.vector.Dou2XVector;
import org.math.linear.algebra.noninteger.vector.Dou3XVector;
import org.math.linear.algebra.noninteger.vector.Dou4XVector;

public class DoubleVectorTests {

    // ---- Test Data ---- //

    private Double scalar = 6.0;

    private Double[] vector12X = {
            1.0, 2.0
    };

    private Double[] vector22X = {
            3.0, 4.0
    };

    private Double[] vector13X = {
            1.0, 2.0, 3.0
    };

    private Double[] vector23X = {
            4.0, 5.0, 6.0
    };

    private Double[] vector14X = {
            1.0, 2.0, 3.0, 4.0
    };

    private Double[] vector24X = {
            5.0, 6.0, 7.0, 8.0
    };

    private Dou2XVector dou2XVector1 = new Dou2XVector(vector12X);
    private Dou2XVector dou2XVector2 = new Dou2XVector(vector22X);

    private Dou3XVector dou3XVector1 = new Dou3XVector(vector13X);
    private Dou3XVector dou3XVector2 = new Dou3XVector(vector23X);

    private Dou4XVector dou4XVector1 = new Dou4XVector(vector14X);
    private Dou4XVector dou4XVector2 = new Dou4XVector(vector24X);

    // ---- Results ---- //

    private Double[] resultAddVector2X = {
            4.0, 6.0
    };

    private Double[] resultSubtract2X = {
            -2.0, -2.0
    };

    private Double[] resultMultiplyVector2XByScalar = {
            6.0, 12.0
    };

    private Double[] resultDivideByScalar2X = {
            0.16666666666666666, 0.3333333333333333
    };

    private Double[] resultAddVector3X = {
            5.0, 7.0, 9.0
    };

    private Double[] resultSubtract3X = {
            -3.0, -3.0, -3.0
    };

    private Double[] resultMultiplyVector3XByScalar = {
            6.0, 12.0, 18.0
    };

    private Double[] resultDivideByScalar3X = {
            0.16666666666666666, 0.3333333333333333, 0.5
    };

    private Double[] resultAddVector4X = {
            6.0, 8.0, 10.0, 12.0
    };

    private Double[] resultSubtract4X = {
            -4.0, -4.0, -4.0, -4.0
    };

    private Double[] resultMultiplyVector4XByScalar = {
            6.0, 12.0, 18.0, 24.0
    };

    private Double[] resultDivideByScalar4X = {
            0.16666666666666666, 0.3333333333333333, 0.5, 0.6666666666666666
    };


    private Double resultDotProduct2X = 11.0;

    private Double resultDotProduct3X = 32.0;

    private Double resultDotProduct4X = 70.0;

    // ---- Tests ---- //
    @Test
    public void testAdd2X(){
        Assertions.assertArrayEquals(dou2XVector1.add(dou2XVector2).getComponents(), resultAddVector2X);
    }

    @Test
    public void testSubtract2X(){
        Assertions.assertArrayEquals(dou2XVector1.subtract(dou2XVector2).getComponents(), resultSubtract2X);
    }

    @Test
    public void testMultiplyByScalar2X(){
        Assertions.assertArrayEquals(dou2XVector1.multiplyByScalar(scalar).getComponents(), resultMultiplyVector2XByScalar);
    }

    @Test
    public void testDivideByScalar2X(){
        Assertions.assertArrayEquals(dou2XVector1.divideByScalar(scalar).getComponents(), resultDivideByScalar2X);
    }

    @Test
    public void testDotProduct2X(){
        Assertions.assertEquals(dou2XVector1.dotProduct(dou2XVector2), resultDotProduct2X);
    }

    // 3X

    @Test
    public void testAdd3X(){
        Assertions.assertArrayEquals(dou3XVector1.add(dou3XVector2).getComponents(), resultAddVector3X);
    }

    @Test
    public void testSubtract3X(){
        Assertions.assertArrayEquals(dou3XVector1.subtract(dou3XVector2).getComponents(), resultSubtract3X);
    }

    @Test
    public void testMultiplyByScalar3X(){
        Assertions.assertArrayEquals(dou3XVector1.multiplyByScalar(scalar).getComponents(), resultMultiplyVector3XByScalar);
    }

    @Test
    public void testDivideByScalar3X(){
        Assertions.assertArrayEquals(dou3XVector1.divideByScalar(scalar).getComponents(), resultDivideByScalar3X);
    }

    @Test
    public void testDotProduct3X(){
        Assertions.assertEquals(dou3XVector1.dotProduct(dou3XVector2), resultDotProduct3X);
    }

    // 4X

    @Test
    public void testAdd4X(){
        Assertions.assertArrayEquals(dou4XVector1.add(dou4XVector2).getComponents(), resultAddVector4X);
    }

    @Test
    public void testSubtract4X(){
        Assertions.assertArrayEquals(dou4XVector1.subtract(dou4XVector2).getComponents(), resultSubtract4X);
    }

    @Test
    public void testMultiplyByScalar4X(){
        Assertions.assertArrayEquals(dou4XVector1.multiplyByScalar(scalar).getComponents(), resultMultiplyVector4XByScalar);
    }

    @Test
    public void testDivideByScalar4X(){
        Assertions.assertArrayEquals(dou4XVector1.divideByScalar(scalar).getComponents(), resultDivideByScalar4X);
    }

    @Test
    public void testDotProduct4X(){
        Assertions.assertEquals(dou4XVector1.dotProduct(dou4XVector2), resultDotProduct4X);
    }

}
