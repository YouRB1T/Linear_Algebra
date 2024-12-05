package org.math.linear.algebra.integer.vectors;

import org.math.linear.algebra.Vector;
import org.math.linear.algebra.noninteger.vector.DoubleVector;

import java.util.Arrays;

public class IntegerVector<V extends IntegerVector<V>> extends Vector<Integer, V> {
    private final Integer[] components;

    public IntegerVector(Integer[] components) {
        this.components = components;
    }

    public IntegerVector(int size) {
        components = new Integer[size];
    }

    public V createVector(Integer[] arr) {
        return null;
    }

    @Override
    public int size() {
        return components.length;
    }

    @Override
    public Integer get(int component) {
        if (component < 0 || component >= size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + component);
        }
        return components[component];
    }

    @Override
    public V add(V other) {
        if (other.size() != size()) {
            throw new IllegalArgumentException("Vectors must be of the same size.");
        }
        Integer[] result = new Integer[size()];
        for (int i = 0; i < size(); i++) {
            result[i] = this.get(i) + other.get(i);
        }
        return createVector(result);
    }

    @Override
    public V subtract(V other) {
        if (other.size() != size()) {
            throw new IllegalArgumentException("Vectors must be of the same size.");
        }
        Integer[] result = new Integer[size()];
        for (int i = 0; i < size(); i++) {
            result[i] = this.get(i) - other.get(i);
        }
        return createVector(result);
    }

    @Override
    public V multiplyByScalar(Integer scalar) {
        Integer[] result = new Integer[size()];
        for (int i = 0; i < size(); i++) {
            result[i] = this.get(i) * scalar;
        }
        return createVector(result);
    }

    @Override
    public V divideByScalar(Integer scalar) {
        if (scalar == 0) {
            throw new ArithmeticException("Division by zero.");
        }
        Integer[] result = new Integer[size()];
        for (int i = 0; i < size(); i++) {
            result[i] = this.get(i) / scalar;
        }
        return createVector(result);
    }

    @Override
    public double length() {
        double sum = 0;
        for (int value : components) {
            sum += Math.pow(value, 2);
        }
        return Math.sqrt(sum);
    }

    @Override
    public V normalize() {
        double len = length();
        if (len == 0) {
            throw new ArithmeticException("Cannot normalize a zero vector.");
        }
        Integer[] result = new Integer[size()];
        for (int i = 0; i < size(); i++) {
            result[i] = (int) Math.round(this.get(i) / len);
        }
        return createVector(result);
    }

    @Override
    public Integer dotProduct(V other) {
        if (other.size() != size()) {
            throw new IllegalArgumentException("Vectors must be of the same size.");
        }
        int product = 0;
        for (int i = 0; i < size(); i++) {
            product += this.get(i) * other.get(i);
        }
        return product;
    }

    @Override
    public Integer[] getComponents() {
        return Arrays.copyOf(components, components.length);
    }

    @Override
    public String toString() {
        return "IntegerVector: " + Arrays.toString(components);
    }
}
