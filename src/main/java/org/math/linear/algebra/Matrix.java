package org.math.linear.algebra;

public abstract class Matrix<T, M extends Matrix<T, M, V>, V extends Vector<T, V>> {
    protected T[][] matrix;

    public abstract M addMatrix(M B);

    public abstract M subtractMatrices(M B);

    public abstract V multiplyByVector(V V);

    public abstract M multiplyMatrix(M B);

    public abstract void setZeroMatrix();

    public abstract void setUnitMatrix();

    public abstract M transpose();

    public abstract M inverse();

    public abstract T[][] getMatrix();
}
