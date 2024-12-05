package matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.math.linear.algebra.Matrix;
import org.math.linear.algebra.Vector;
import org.math.linear.algebra.noninteger.matrix.Dou2DMatrix;
import org.math.linear.algebra.noninteger.matrix.Dou3DMatrix;
import org.math.linear.algebra.noninteger.matrix.Dou4DMatrix;
import org.math.linear.algebra.noninteger.matrix.DoubleMatrix;
import org.math.linear.algebra.noninteger.vector.Dou2XVector;
import org.math.linear.algebra.noninteger.vector.Dou3XVector;
import org.math.linear.algebra.noninteger.vector.Dou4XVector;
import org.math.linear.algebra.noninteger.vector.DoubleVector;

public class DoubleMatrixTests {

    // ---- Data for tests ---- //

    private Double[][] mat33D = {
            {5.0, 2.0, 3.0},
            {4.0, 5.0, 6.0},
            {7.0, 8.0, 9.0}
    };

    private Double[][] mat1 = {
            {1.0, 2.0, 3.0, 2.0},
            {4.0, 5.0, 6.0, 4.0},
            {7.0, 8.0, 9.0, 6.0},
            {4.0, 5.0, 6.0, 8.0}
    };

    private Double[][] mat13D = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0},
            {7.0, 8.0, 9.0}
    };

    private Double[][] mat12D = {
            {1.0, 2.0},
            {4.0, 5.0}
    };

    private Double[][] mat2 = {
            {9.0, 8.0, 7.0, 7.0},
            {6.0, 5.0, 4.0, 8.0},
            {3.0, 2.0, 1.0, 0.0},
            {4.0, 3.0, 6.0, 9.0}
    };

    private Double[][] mat23D = {
            {9.0, 8.0, 7.0},
            {6.0, 5.0, 4.0},
            {3.0, 2.0, 1.0}
    };

    private Double[][] mat22D = {
            {9.0, 8.0},
            {6.0, 5.0}
    };

    private Double[] vector = {
            1.0,
            2.0,
            3.0,
            7.0
    };

    private Double[] vector3X = {
            1.0,
            2.0,
            3.0
    };

    private Double[] vector2X = {
            1.0,
            2.0
    };

    private Dou4DMatrix intNonWidthMatrix1 = new Dou4DMatrix(mat1);
    private Dou4DMatrix intNonWidthMatrix2 = new Dou4DMatrix(mat2);
    private Dou4XVector doubleVector = new Dou4XVector(vector);


    private Dou3DMatrix intNonWidthMatrix13D = new Dou3DMatrix(mat13D);
    private Dou3DMatrix intNonWidthMatrix23D = new Dou3DMatrix(mat23D);
    private Dou3XVector doubleVector3X = new Dou3XVector(vector3X);


    private Dou2DMatrix intNonWidthMatrix12D = new Dou2DMatrix(mat12D);
    private Dou2DMatrix intNonWidthMatrix22D = new Dou2DMatrix(mat22D);
    private Dou2XVector doubleVector2X = new Dou2XVector(vector2X);


    // ---- Results ---- //

    private Double[][] resultAddMatrix = {
            {10.0, 10.0, 10.0, 9.0},
            {10.0, 10.0, 10.0, 12.0},
            {10.0, 10.0, 10.0, 6.0},
            {8.0, 8.0, 12.0, 17.0}
    };

    private Double[][] resultSubtractMatrix = {
            {-8.0, -6.0, -4.0, -5.0},
            {-2.0, 0.0, 2.0, -4.0},
            {4.0, 6.0, 8.0, 6.0},
            {0.0, 2.0, 0.0, -1.0}
    };

    private Double[][] resultMultiplyMatrix = {
            {38.0, 30.0, 30.0, 41.0},
            {100.0, 81.0, 78.0, 104.0},
            {162.0, 132.0, 126.0, 167.0},
            {116.0, 93.0, 102.0, 140.0}
    };

    private Double[] resultMultiplyMetrixByVector = {
            28.0,
            60.0,
            92.0,
            88.0
    };

    private Double[][] resultInverseMatrix3D = {
            {0.25, -0.50, 0.25},
            {-0.5, -2.0, 1.5},
            {0.25, 2.1666666666666665, -1.4166666666666667}
    };

    private double detMat1 = 0.0;

    private Double[][] resultTransposeMat1 = {
            {1.0, 4.0, 7.0, 4.0},
            {2.0, 5.0, 8.0, 5.0},
            {3.0, 6.0, 9.0, 6.0},
            {2.0, 4.0, 6.0, 8.0}
    };

    private Double[][] resultInverseMatrix4D = {
            {0.0, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 0.0}
    };

    private Double[][] resultMultiplyMatrix3D = {
            {30.0, 24.0, 18.0},
            {84.0, 69.0, 54.0},
            {138.0, 114.0, 90.0}
    };

    private Double[][] resultAddMatrix3D = {
            {10.0, 10.0, 10.0},
            {10.0, 10.0, 10.0},
            {10.0, 10.0, 10.0}
    };

    private Double[][] resultSubtractMatrix3D = {
            {-8.0, -6.0, -4.0},
            {-2.0, 0.0, 2.0},
            {4.0, 6.0, 8.0}
    };

    private Double[] resultMultiplyMetrixByVector3D = {
            14.0,
            32.0,
            50.0
    };

    private Double[][] resultMultiplyMatrix2D = {
            {21.0, 18.0},
            {66.0, 57.0}
    };

    private Double[][] resultAddMatrix2D = {
            {10.0, 10.0},
            {10.0, 10.0}
    };

    private Double[][] resultSubtractMatrix2D = {
            {-8.0, -6.0},
            {-2.0, 0.0}
    };

    private Double[] resultMultiplyMetrixByVector2D = {
            5.0,
            14.0
    };

    // ---- Tests ---- //

    // ---- 4D and 4X ---- //

    @Test
    public void addMatrixTest() {
        Dou4DMatrix result = intNonWidthMatrix1.addMatrix(intNonWidthMatrix2);
        Double[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultAddMatrix[i],
                    "Testing add matrix on " + i + " line");
        }

    }

    @Test
    public void subtractMatrixTest() {
        Dou4DMatrix result = intNonWidthMatrix1.subtractMatrices(intNonWidthMatrix2);
        Double[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultSubtractMatrix[i],
                    "Testing subtract matrix on " + i + " line");
        }

    }

    @Test
    public void multiplyMatrixTest() {
        Dou4DMatrix result = intNonWidthMatrix1.multiplyMatrix(intNonWidthMatrix2);
        Double[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultMultiplyMatrix[i],
                    "Testing multiply matrix on " + i + " line");
        }

    }

    @Test
    public void multiplyMatrixByVectorTest() {
        Dou4XVector result = intNonWidthMatrix1.multiplyByVector(doubleVector);
        Double[] resultVector = result.getComponents();

        for (int i = 0; i < resultVector.length; i++) {
            Assertions.assertEquals(resultVector[i], resultMultiplyMetrixByVector[i],
                    "Testing multiplyMatrixByVector vector on " + i + " line");
        }

    }

    // ---- 3D and 3X ---- //

    @Test
    public void addMatrixTest3D() {
        Dou3DMatrix result = intNonWidthMatrix13D.addMatrix(intNonWidthMatrix23D);
        Double[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultAddMatrix3D[i],
                    "Testing add matrix on " + i + " line");
        }

    }

    @Test
    public void subtractMatrixTest3D() {
        Dou3DMatrix result = intNonWidthMatrix13D.subtractMatrices(intNonWidthMatrix23D);
        Double[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultSubtractMatrix3D[i],
                    "Testing subtract matrix on " + i + " line");
        }

    }

    @Test
    public void multiplyMatrixTest3D() {
        Dou3DMatrix result = intNonWidthMatrix13D.multiplyMatrix(intNonWidthMatrix23D);
        Double[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultMultiplyMatrix3D[i],
                    "Testing multiply matrix on " + i + " line");
        }

    }

    @Test
    public void multiplyMatrixByVectorTest3D() {
        Dou3XVector result = intNonWidthMatrix13D.multiplyByVector(doubleVector3X);
        Double[] resultVector = result.getComponents();

        for (int i = 0; i < resultVector.length; i++) {
            Assertions.assertEquals(resultVector[i], resultMultiplyMetrixByVector3D[i],
                    "Testing multiplyMatrixByVector vector on " + i + " line");
        }

    }

    // ---- 2D and 2X ---- //

    @Test
    public void addMatrixTest2D() {
        Dou2DMatrix result = intNonWidthMatrix12D.addMatrix(intNonWidthMatrix22D);
        Double[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultAddMatrix2D[i],
                    "Testing add matrix on " + i + " line");
        }

    }

    @Test
    public void subtractMatrixTest2D() {
        Dou2DMatrix result = intNonWidthMatrix12D.subtractMatrices(intNonWidthMatrix22D);
        Double[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultSubtractMatrix2D[i],
                    "Testing subtract matrix on " + i + " line");
        }

    }

    @Test
    public void multiplyMatrixTest2D() {
        Dou2DMatrix result = intNonWidthMatrix12D.multiplyMatrix(intNonWidthMatrix22D);
        Double[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultMultiplyMatrix2D[i],
                    "Testing multiply matrix on " + i + " line");
        }

    }

    @Test
    public void multiplyMatrixByVectorTest2D() {
        Dou2XVector result = intNonWidthMatrix12D.multiplyByVector(doubleVector2X);
        Double[] resultVector = result.getComponents();

        for (int i = 0; i < resultVector.length; i++) {
            Assertions.assertEquals(resultVector[i], resultMultiplyMetrixByVector2D[i],
                    "Testing multiplyMatrixByVector vector on " + i + " line");
        }

    }

}
