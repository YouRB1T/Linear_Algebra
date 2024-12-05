package matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.math.linear.algebra.Matrix;
import org.math.linear.algebra.Vector;
import org.math.linear.algebra.integer.matrix.Int2DMatrix;
import org.math.linear.algebra.integer.matrix.Int3DMatrix;
import org.math.linear.algebra.integer.matrix.Int4DMatrix;
import org.math.linear.algebra.integer.matrix.IntegerMatrix;
import org.math.linear.algebra.integer.vectors.Int2XVector;
import org.math.linear.algebra.integer.vectors.Int3XVector;
import org.math.linear.algebra.integer.vectors.Int4XVector;
import org.math.linear.algebra.integer.vectors.IntegerVector;

public class IntegerMatrixTests {

    // ---- Data for tests ---- //

    private Integer[][] mat33D = {
            {5, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    private Integer[][] mat1 = {
            {1, 2, 3, 2},
            {4, 5, 6, 4},
            {7, 8, 9, 6},
            {4, 5, 6, 8}
    };

    private Integer[][] mat13D = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    private Integer[][] mat12D = {
            {1, 2},
            {4, 5}
    };

    private Integer[][] mat2 = {
            {9, 8, 7, 7},
            {6, 5, 4, 8},
            {3, 2, 1, 0},
            {4, 3, 6, 9}
    };

    private Integer[][] mat23D = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
    };

    private Integer[][] mat22D = {
            {9, 8},
            {6, 5}
    };

    private Integer[] vector = {
            1,
            2,
            3,
            7
    };

    private Integer[] vector3X = {
            1,
            2,
            3
    };

    private Integer[] vector2X = {
            1,
            2
    };

    private Int4DMatrix intNonWidthMatrix1 = new Int4DMatrix(mat1);
    private Int4DMatrix intNonWidthMatrix2 = new Int4DMatrix(mat2);
    private Int4XVector IntegerVector = new Int4XVector(vector);


    private Int3DMatrix intNonWidthMatrix13D = new Int3DMatrix(mat13D);
    private Int3DMatrix intNonWidthMatrix23D = new Int3DMatrix(mat23D);
    private Int3XVector IntegerVector3X = new Int3XVector(vector3X);


    private Int2DMatrix intNonWidthMatrix12D = new Int2DMatrix(mat12D);
    private Int2DMatrix intNonWidthMatrix22D = new Int2DMatrix(mat22D);
    private Int2XVector IntegerVector2X = new Int2XVector(vector2X);


    // ---- Results ---- //

    private Integer[][] resultAddMatrix = {
            {10, 10, 10, 9},
            {10, 10, 10, 12},
            {10, 10, 10, 6},
            {8, 8, 12, 17}
    };

    private Integer[][] resultSubtractMatrix = {
            {-8, -6, -4, -5},
            {-2, 0, 2, -4},
            {4, 6, 8, 6},
            {0, 2, 0, -1}
    };

    private Integer[][] resultMultiplyMatrix = {
            {38, 30, 30, 41},
            {100, 81, 78, 104},
            {162, 132, 126, 167},
            {116, 93, 102, 140}
    };

    private Integer[] resultMultiplyMetrixByVector = {
            28,
            60,
            92,
            88
    };

    private Integer[][] resultInverseMatrix3D = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    private Integer detMat1 = 0;

    private Integer[][] resultTransposeMat1 = {
            {1, 4, 7, 4},
            {2, 5, 8, 5},
            {3, 6, 9, 6},
            {2, 4, 6, 8}
    };

    private Integer[][] resultInverseMatrix4D = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    private Integer[][] resultMultiplyMatrix3D = {
            {30, 24, 18},
            {84, 69, 54},
            {138, 114, 90}
    };

    private Integer[][] resultAddMatrix3D = {
            {10, 10, 10},
            {10, 10, 10},
            {10, 10, 10}
    };

    private Integer[][] resultSubtractMatrix3D = {
            {-8, -6, -4},
            {-2, 0, 2},
            {4, 6, 8}
    };

    private Integer[] resultMultiplyMetrixByVector3D = {
            14,
            32,
            50
    };

    private Integer[][] resultMultiplyMatrix2D = {
            {21, 18},
            {66, 57}
    };

    private Integer[][] resultAddMatrix2D = {
            {10, 10},
            {10, 10}
    };

    private Integer[][] resultSubtractMatrix2D = {
            {-8, -6},
            {-2, 0}
    };

    private Integer[] resultMultiplyMetrixByVector2D = {
            5,
            14
    };

    // ---- Tests ---- //

    // ---- 4D and 4X ---- //

    @Test
    public void addMatrixTest() {
        Int4DMatrix result = intNonWidthMatrix1.addMatrix(intNonWidthMatrix2);
        Integer[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultAddMatrix[i],
                    "Testing add matrix on " + i + " line");
        }

    }

    @Test
    public void subtractMatrixTest() {
        Int4DMatrix result = intNonWidthMatrix1.subtractMatrices(intNonWidthMatrix2);
        Integer[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultSubtractMatrix[i],
                    "Testing subtract matrix on " + i + " line");
        }

    }

    @Test
    public void multiplyMatrixTest() {
        Int4DMatrix result = intNonWidthMatrix1.multiplyMatrix(intNonWidthMatrix2);
        Integer[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultMultiplyMatrix[i],
                    "Testing multiply matrix on " + i + " line");
        }

    }

    @Test
    public void multiplyMatrixByVectorTest() {
        Int4XVector result = intNonWidthMatrix1.multiplyByVector(IntegerVector);
        Integer[] resultVector = result.getComponents();

        for (int i = 0; i < resultVector.length; i++) {
            Assertions.assertEquals(resultVector[i], resultMultiplyMetrixByVector[i],
                    "Testing multiplyMatrixByVector vector on " + i + " line");
        }

    }

    // ---- 3D and 3X ---- //

    @Test
    public void addMatrixTest3D() {
        Int3DMatrix result = intNonWidthMatrix13D.addMatrix(intNonWidthMatrix23D);
        Integer[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultAddMatrix3D[i],
                    "Testing add matrix on " + i + " line");
        }

    }

    @Test
    public void subtractMatrixTest3D() {
        Int3DMatrix result = intNonWidthMatrix13D.subtractMatrices(intNonWidthMatrix23D);
        Integer[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultSubtractMatrix3D[i],
                    "Testing subtract matrix on " + i + " line");
        }

    }

    @Test
    public void multiplyMatrixTest3D() {
        Int3DMatrix result = intNonWidthMatrix13D.multiplyMatrix(intNonWidthMatrix23D);
        Integer[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultMultiplyMatrix3D[i],
                    "Testing multiply matrix on " + i + " line");
        }

    }

    @Test
    public void multiplyMatrixByVectorTest3D() {
        Int3XVector result = intNonWidthMatrix13D.multiplyByVector(IntegerVector3X);
        Integer[] resultVector = result.getComponents();

        for (int i = 0; i < resultVector.length; i++) {
            Assertions.assertEquals(resultVector[i], resultMultiplyMetrixByVector3D[i],
                    "Testing multiplyMatrixByVector vector on " + i + " line");
        }

    }

    // ---- 2D and 2X ---- //

    @Test
    public void addMatrixTest2D() {
        Int2DMatrix result = intNonWidthMatrix12D.addMatrix(intNonWidthMatrix22D);
        Integer[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultAddMatrix2D[i],
                    "Testing add matrix on " + i + " line");
        }

    }

    @Test
    public void subtractMatrixTest2D() {
        Int2DMatrix result = intNonWidthMatrix12D.subtractMatrices(intNonWidthMatrix22D);
        Integer[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultSubtractMatrix2D[i],
                    "Testing subtract matrix on " + i + " line");
        }

    }

    @Test
    public void multiplyMatrixTest2D() {
        Int2DMatrix result = intNonWidthMatrix12D.multiplyMatrix(intNonWidthMatrix22D);
        Integer[][] resultMat = result.getMatrix();

        for (int i = 0; i < resultMat.length; i++) {
            Assertions.assertArrayEquals(resultMat[i], resultMultiplyMatrix2D[i],
                    "Testing multiply matrix on " + i + " line");
        }

    }

    @Test
    public void multiplyMatrixByVectorTest2D() {
        Int2XVector result = intNonWidthMatrix12D.multiplyByVector(IntegerVector2X);
        Integer[] resultVector = result.getComponents();

        for (int i = 0; i < resultVector.length; i++) {
            Assertions.assertEquals(resultVector[i], resultMultiplyMetrixByVector2D[i],
                    "Testing multiplyMatrixByVector vector on " + i + " line");
        }

    }

}
