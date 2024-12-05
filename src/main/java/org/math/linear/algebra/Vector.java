package org.math.linear.algebra;

public abstract class Vector<T, V extends Vector<T, V>> {
    protected T[] components;

    public abstract int size();
    public abstract T get(int component);
    public abstract V add(V other);
    public abstract V subtract(V other);
    public abstract V multiplyByScalar(T scalar);
    public abstract V divideByScalar(T scalar);
    public abstract double length();
    public abstract V normalize();
    public abstract T dotProduct(V other);
    public abstract T[] getComponents();
}
