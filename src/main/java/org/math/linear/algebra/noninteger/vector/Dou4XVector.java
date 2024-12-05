package org.math.linear.algebra.noninteger.vector;

public class Dou4XVector extends DoubleVector<Dou4XVector>{
    public Dou4XVector(Double[] components) {
        super(components);
    }

    @Override
    public Dou4XVector createVector(Double[] arr) {
        return new Dou4XVector(arr);
    }
}
