package org.math.linear.algebra.noninteger.vector;

import org.math.linear.algebra.Vector;

import java.util.Arrays;

public class DoubleVector<V extends DoubleVector<V>> extends Vector<Double, V> {
    private final Double[] components;

    public DoubleVector(Double[] components) {
        this.components = components;
    }

    public V createVector(Double[] arr) {
        return null;
    }

    @Override
    public int size() {
        return components.length;
    }

    @Override
    public Double get(int component) {
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
        Double[] result = new Double[size()];
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
        Double[] result = new Double[size()];
        for (int i = 0; i < size(); i++) {
            result[i] = this.get(i) - other.get(i);
        }
        return createVector(result);
    }

    @Override
    public V multiplyByScalar(Double scalar) {
        Double[] result = new Double[size()];
        for (int i = 0; i < size(); i++) {
            result[i] = this.get(i) * scalar;
        }
        return createVector(result);
    }

    @Override
    public V divideByScalar(Double scalar) {
        if (scalar == 0.0) {
            throw new ArithmeticException("Division by zero.");
        }
        Double[] result = new Double[size()];
        for (int i = 0; i < size(); i++) {
            result[i] = this.get(i) / scalar;
        }
        return createVector(result);
    }

    @Override
    public double length() {
        double sum = 0;
        for (double value : components) {
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
        Double[] result = new Double[size()];
        for (int i = 0; i < size(); i++) {
            result[i] = this.get(i) / len;
        }
        return createVector(result);
    }

    @Override
    public Double dotProduct(V other) {
        if (other.size() != size()) {
            throw new IllegalArgumentException("Vectors must be of the same size.");
        }
        double product = 0;
        for (int i = 0; i < size(); i++) {
            product += this.get(i) * other.get(i);
        }
        return product;
    }

    @Override
    public Double[] getComponents() {
        return Arrays.copyOf(components, components.length);
    }

    @Override
    public String toString() {
        return "DoubleVector: " + Arrays.toString(components);
    }
}
