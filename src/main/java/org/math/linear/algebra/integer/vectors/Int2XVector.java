package org.math.linear.algebra.integer.vectors;

public class Int2XVector extends IntegerVector<Int2XVector> {
    public Int2XVector() {
        super(2);
    }

    public Int2XVector(Integer[] vector) {
        super(vector);
        if (vector.length > 2) {
            throw new RuntimeException("It's not 2x vector");
        }
    }

    @Override
    public Int2XVector createVector(Integer[] arr) {
        return new Int2XVector(arr);
    }
}
