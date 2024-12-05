package org.math.linear.algebra.noninteger.matrix;

import org.math.linear.algebra.Matrix;
import org.math.linear.algebra.noninteger.vector.DoubleVector;

public class DoubleMatrix<M extends DoubleMatrix<M, V>, V extends DoubleVector<V>> extends Matrix<Double, M, V> {
    private Double[][] matrix;
    private int cols, rows;

    public DoubleMatrix() {
    }

    public DoubleMatrix(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public DoubleMatrix(Double[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    public V createVector(Double[] arr) {
        return null;
    }

    protected M createMatrix(Double[][] matrix) {
        return null;
    }

    @Override
    public M addMatrix(M B) {
        DoubleMatrix<M, V> other = B;
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for addition.");
        }
        Double[][] result = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] + other.matrix[i][j];
            }
        }
        return createMatrix(result);
    }

    @Override
    public M subtractMatrices(M B) {
        DoubleMatrix<M, V> other = B;
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for subtraction.");
        }
        Double[][] result = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] - other.matrix[i][j];
            }
        }
        return createMatrix(result);
    }

    @Override
    public V multiplyByVector(V V) {
        Double[] vector = V.getComponents();
        if (vector.length != cols) {
            throw new IllegalArgumentException("Vector size must match the number of columns.");
        }
        Double[] result = new Double[rows];
        for (int i = 0; i < rows; i++) {
            result[i] = 0.0;
            for (int j = 0; j < cols; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return createVector(result);//(V) new DoubleVector(result);
    }

    @Override
    public M multiplyMatrix(M B) {
        DoubleMatrix<M, V> other = B;
        if (cols != other.rows) {
            throw new IllegalArgumentException("Matrix dimensions must match for multiplication.");
        }
        Double[][] result = new Double[rows][other.cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                result[i][j] = 0.0;
                for (int k = 0; k < cols; k++) {
                    result[i][j] += matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return createMatrix(result);
    }

    @Override
    public void setZeroMatrix() {
        this.matrix = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0.0;
            }
        }
    }

    @Override
    public void setUnitMatrix() {
        if (cols != rows) {
            throw new IllegalArgumentException("Unit matrix must be square.");
        }
        this.matrix = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (i == j) ? 1.0 : 0.0;
            }
        }
    }

    @Override
    public M transpose() {
        Double[][] result = new Double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return createMatrix(result);
    }

    public double computeDeterminant(Double[][] mat) {
        int n = mat.length;
        if (n == 1) {
            return mat[0][0];
        }
        if (n == 2) {
            return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
        }
        double det = 0;
        for (int i = 0; i < n; i++) {
            det += Math.pow(-1, i) * mat[0][i] * computeDeterminant(minor(mat, 0, i));
        }
        return det;
    }

    private Double[][] minor(Double[][] mat, int row, int col) {
        int n = mat.length;
        Double[][] result = new Double[n - 1][n - 1];
        for (int i = 0, r = 0; i < n; i++) {
            if (i == row) continue;
            for (int j = 0, c = 0; j < n; j++) {
                if (j == col) continue;
                result[r][c++] = mat[i][j];
            }
            r++;
        }
        return result;
    }

    @Override
    public M inverse() {
        double det = computeDeterminant(matrix);
        if (det == 0) {
            throw new IllegalArgumentException("Matrix is singular and cannot be inverted.");
        }
        Double[][] adjoint = adjugate(matrix);
        Double[][] inverse = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                inverse[i][j] = adjoint[i][j] / det;
            }
        }
        return createMatrix(inverse);
    }

    @Override
    public Double[][] getMatrix() {
        return matrix;
    }

    private Double[][] adjugate(Double[][] mat) {
        int n = mat.length;
        Double[][] adj = new Double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[j][i] = Math.pow(-1, i + j) * computeDeterminant(minor(mat, i, j));
            }
        }
        return adj;
    }

    public Double[] solveGaussian(Double[] constants) {
        if (rows != cols) {
            throw new IllegalArgumentException("Matrix must be square for Gaussian elimination.");
        }
        Double[][] augmented = new Double[rows][cols + 1];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, augmented[i], 0, cols);
            augmented[i][cols] = constants[i];
        }
        for (int i = 0; i < rows; i++) {
            normalizeRow(augmented, i);
            eliminateBelow(augmented, i);
        }
        return backSubstitute(augmented);
    }

    private void normalizeRow(Double[][] mat, int row) {
        double factor = mat[row][row];
        for (int j = 0; j < mat[row].length; j++) {
            mat[row][j] /= factor;
        }
    }

    private void eliminateBelow(Double[][] mat, int row) {
        for (int i = row + 1; i < rows; i++) {
            double factor = mat[i][row];
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] -= factor * mat[row][j];
            }
        }
    }

    private Double[] backSubstitute(Double[][] mat) {
        Double[] solution = new Double[rows];
        for (int i = rows - 1; i >= 0; i--) {
            solution[i] = mat[i][cols];
            for (int j = i + 1; j < cols; j++) {
                solution[i] -= mat[i][j] * solution[j];
            }
        }
        return solution;
    }
}
