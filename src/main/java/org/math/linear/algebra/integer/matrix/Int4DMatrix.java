package org.math.linear.algebra.integer.matrix;

import org.math.linear.algebra.integer.vectors.Int4XVector;

public class Int4DMatrix extends IntegerMatrix<Int4DMatrix, Int4XVector>{

    public Int4DMatrix() {
        super(4, 4);
    }

    public Int4DMatrix(Integer[][] matrixInt) {
        super(matrixInt);
        if ( matrixInt.length > 4 && matrixInt[0].length > 4) {
            throw new IllegalArgumentException("Matrix must be 4X4.");
        }
    }
    @Override
    public Int4XVector createVector(Integer[] arr) {
        return new Int4XVector(arr);
    }
    @Override
    protected Int4DMatrix createMatrix(Integer[][] matrix) {
        return new Int4DMatrix(matrix);
    }
}
