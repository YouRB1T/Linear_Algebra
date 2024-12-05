package org.math.linear.algebra.integer.vectors;

public class Int3XVector extends IntegerVector<Int3XVector>{
    public Int3XVector() {
        super(3);
    }

    public Int3XVector(Integer[] vector) {
        super(vector);
        if (vector.length > 3) {
            throw new RuntimeException("It's not 3x vector");
        }
    }

    @Override
    public Int3XVector createVector(Integer[] arr) {
        return new Int3XVector(arr);
    }
}
