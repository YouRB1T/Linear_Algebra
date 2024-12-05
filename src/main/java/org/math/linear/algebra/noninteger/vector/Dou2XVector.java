package org.math.linear.algebra.noninteger.vector;

import org.math.linear.algebra.noninteger.matrix.Dou2DMatrix;

public class Dou2XVector extends DoubleVector<Dou2XVector>{

    public Dou2XVector(Double[] components) {
        super(components);
    }

    @Override
    public Dou2XVector createVector(Double[] arr) {
        return new Dou2XVector(arr);
    }
}
