package org.math.linear.algebra.noninteger.matrix;

import org.math.linear.algebra.noninteger.vector.Dou2XVector;

public class Dou2DMatrix extends DoubleMatrix<Dou2DMatrix, Dou2XVector>{
    public Dou2DMatrix() {
        super(2, 2);
    }

    @Override
    public Dou2XVector createVector(Double[] arr) {
        return new Dou2XVector(arr);
    }

    @Override
    public Dou2DMatrix createMatrix(Double[][] arr) {
        return new Dou2DMatrix(arr);
    }

    public Dou2DMatrix(Double[][] values) {
        super(values);

        if ( values.length > 2 && values[0].length > 2) {
            throw new IllegalArgumentException("Matrix must be 2X2.");
        }
    }
}
