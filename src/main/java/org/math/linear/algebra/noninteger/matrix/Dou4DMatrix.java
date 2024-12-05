package org.math.linear.algebra.noninteger.matrix;

import org.math.linear.algebra.noninteger.vector.Dou2XVector;
import org.math.linear.algebra.noninteger.vector.Dou4XVector;

public class Dou4DMatrix extends DoubleMatrix<Dou4DMatrix, Dou4XVector>{
    public Dou4DMatrix() {
        super(4, 4);
    }

    @Override
    public Dou4XVector createVector(Double[] arr) {
        return new Dou4XVector(arr);
    }

    @Override
    public Dou4DMatrix createMatrix(Double[][] arr) {
        return new Dou4DMatrix(arr);
    }

    public Dou4DMatrix(Double[][] values) {
        super(values);
        if ( values.length > 4 && values[0].length > 4) {
            throw new IllegalArgumentException("Matrix must be 4X4.");
        }
    }
}
