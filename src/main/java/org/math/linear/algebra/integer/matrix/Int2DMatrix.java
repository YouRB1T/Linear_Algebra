package org.math.linear.algebra.integer.matrix;

import org.math.linear.algebra.integer.vectors.Int2XVector;

public class Int2DMatrix extends IntegerMatrix<Int2DMatrix, Int2XVector>{

    public Int2DMatrix() {
        super(2, 2);
    }

    public Int2DMatrix(Integer[][] matrixInt) {
        super(matrixInt);
        if ( matrixInt.length > 2 && matrixInt[0].length > 2) {
            throw new IllegalArgumentException("Matrix must be 2X2.");
        }
    }

    @Override
    public Int2XVector createVector(Integer[] arr) {
        return new Int2XVector(arr);
    }

    @Override
    protected Int2DMatrix createMatrix(Integer[][] matrix) {
        return new Int2DMatrix(matrix);
    }
}
