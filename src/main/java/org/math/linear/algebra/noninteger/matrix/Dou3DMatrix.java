package org.math.linear.algebra.noninteger.matrix;

import org.math.linear.algebra.noninteger.vector.Dou2XVector;
import org.math.linear.algebra.noninteger.vector.Dou3XVector;

public class Dou3DMatrix extends DoubleMatrix<Dou3DMatrix, Dou3XVector>{
    public Dou3DMatrix() {
        super(3, 3);
    }

    @Override
    public Dou3XVector createVector(Double[] arr) {
        return new Dou3XVector(arr);
    }

    @Override
    public Dou3DMatrix createMatrix(Double[][] arr) {
        return new Dou3DMatrix(arr);
    }

    public Dou3DMatrix(Double[][] values) {
        super(values);
        if ( values.length > 3 && values[0].length > 3) {
            throw new IllegalArgumentException("Matrix must be 3X3.");
        }
    }
}
