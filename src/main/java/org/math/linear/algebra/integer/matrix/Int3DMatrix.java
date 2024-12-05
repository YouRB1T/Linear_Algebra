package org.math.linear.algebra.integer.matrix;

import org.math.linear.algebra.integer.vectors.Int3XVector;

public class Int3DMatrix extends IntegerMatrix<Int3DMatrix, Int3XVector>{

    public Int3DMatrix() {
        super(3, 3);
    }

    public Int3DMatrix(Integer[][] matrixInt) {
        super(matrixInt);
        if ( matrixInt.length > 3 && matrixInt[0].length > 3) {
            throw new IllegalArgumentException("Matrix must be 3X3.");
        }
    }
    @Override
    public Int3XVector createVector(Integer[] arr) {
        return new Int3XVector(arr);
    }
    @Override
    protected Int3DMatrix createMatrix(Integer[][] matrix) {
        return new Int3DMatrix(matrix);
    }
}
