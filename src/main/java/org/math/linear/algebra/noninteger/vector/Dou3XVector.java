package org.math.linear.algebra.noninteger.vector;

public class Dou3XVector extends DoubleVector<Dou3XVector>{
    public Dou3XVector(Double[] components) {
        super(components);
    }

    @Override
    public Dou3XVector createVector(Double[] arr) {
        return new Dou3XVector(arr);
    }
}
