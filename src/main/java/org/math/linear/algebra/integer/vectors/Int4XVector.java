package org.math.linear.algebra.integer.vectors;

public class Int4XVector extends IntegerVector<Int4XVector> {
    public Int4XVector() {
        super(4);
    }

    public Int4XVector(Integer[] vector) {
        super(vector);
        if (vector.length > 4) {
            throw new RuntimeException("It's not 4x vector");
        }
    }

    @Override
    public Int4XVector createVector(Integer[] arr) {
        return new Int4XVector(arr);
    }
}
