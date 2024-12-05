package org.math.linear.algebra.integer.matrix;

import org.math.linear.algebra.Matrix;
import org.math.linear.algebra.Vector;
import org.math.linear.algebra.integer.vectors.IntegerVector;
import org.math.linear.algebra.noninteger.matrix.DoubleMatrix;
import org.math.linear.algebra.noninteger.vector.DoubleVector;

import java.lang.reflect.Array;
import java.util.Arrays;

public class IntegerMatrix<M extends IntegerMatrix<M, V>, V extends IntegerVector<V>> extends Matrix<Integer, M, V> {
    private Integer[][] matrix;
    private int cols, rows;

    public IntegerMatrix() {
    }

    public IntegerMatrix(Integer[][] matrix) {
        this.matrix = matrix;
        int[][] men = new int[2][2];
        rows = matrix.length;
        cols = matrix[0].length;
    }

    public IntegerMatrix(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public V createVector(Integer[] arr) {
        return null;
    }

    protected M createMatrix(Integer[][] matrix) {
        return null;
    }

    @Override
    public M addMatrix(M B) {
        Integer[][] other = B.getMatrix();
        Integer[][] result = new Integer[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.matrix[i][j] + other[i][j];
            }
        }
        return createMatrix(result);
    }

    @Override
    public M subtractMatrices(M B) {
        Integer[][] other = B.getMatrix();
        Integer[][] result = new Integer[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.matrix[i][j] - other[i][j];
            }
        }
        return createMatrix(result);
    }

    @Override
    public V multiplyByVector(V V) {
        if (V.size() != cols) {
            throw new IllegalArgumentException("Vector size must match matrix column count.");
        }
        Integer[] result = new Integer[rows];
        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += this.matrix[i][j] * V.get(j);
            }
            result[i] = sum;
        }
        return createVector(result);
    }

    @Override
    public M multiplyMatrix(M B) {
       Integer[][] other = B.getMatrix();
        Integer[][] result = new Integer[rows][other[0].length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += this.matrix[i][k] * other[k][j];
                }
                result[i][j] = sum;
            }
        }
        return createMatrix(result);
    }

    @Override
    public void setZeroMatrix() {
        this.matrix = new Integer[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.matrix[i][j] = 0;
            }
        }
    }

    @Override
    public void setUnitMatrix() {
        if (cols != rows) {
            throw new IllegalArgumentException("Unit matrix must be square.");
        }
        this.matrix = new Integer[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.matrix[i][j] = (i == j) ? 1 : 0;
            }
        }
    }

    @Override
    public M transpose() {
        Integer[][] transposed = new Integer[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = this.matrix[i][j];
            }
        }
        return createMatrix(transposed);
    }

    // Method to calculate determinant
    public int determinant() {
        if (rows != cols) {
            throw new IllegalArgumentException("Determinant can only be calculated for square matrices.");
        }
        return computeDeterminant(matrix);
    }

    protected int computeDeterminant(Integer[][] mat) {
        int n = mat.length;
        if (n == 1) return mat[0][0];
        if (n == 2) return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];

        int det = 0;
        for (int col = 0; col < n; col++) {
            Integer[][] subMatrix = new Integer[n - 1][n - 1];
            for (int i = 1; i < n; i++) {
                for (int j = 0, subCol = 0; j < n; j++) {
                    if (j == col) continue;
                    subMatrix[i - 1][subCol++] = mat[i][j];
                }
            }
            det += mat[0][col] * computeDeterminant(subMatrix) * (col % 2 == 0 ? 1 : -1);
        }
        return det;
    }

    @Override
    public M inverse() {
        if (rows != cols) {
            throw new IllegalArgumentException("Inverse can only be calculated for square matrices.");
        }
        int det = determinant();
        if (det == 0) {
            throw new IllegalArgumentException("Matrix is singular and cannot be inverted.");
        }
        Integer[][] adjoint = adjugate();
        Integer[][] inverse = new Integer[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                inverse[i][j] = adjoint[i][j] / det;
            }
        }
        return createMatrix(inverse);
    }

    @Override
    public Integer[][] getMatrix() {
        return matrix;
    }

    private Integer[][] adjugate() {
        Integer[][] adjoint = new Integer[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Integer[][] subMatrix = new Integer[rows - 1][cols - 1];
                for (int m = 0, subRow = 0; m < rows; m++) {
                    if (m == i) continue;
                    for (int n = 0, subCol = 0; n < cols; n++) {
                        if (n == j) continue;
                        subMatrix[subRow][subCol++] = matrix[m][n];
                    }
                    subRow++;
                }
                adjoint[j][i] = computeDeterminant(subMatrix) * ((i + j) % 2 == 0 ? 1 : -1);
            }
        }
        return adjoint;
    }

    public Integer[] solveGaussian(Integer[] constants) {
        if (rows != cols || constants.length != rows) {
            throw new IllegalArgumentException("Matrix must be square and match constants length.");
        }
        Integer[][] augmented = new Integer[rows][cols + 1];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, augmented[i], 0, cols);
            augmented[i][cols] = constants[i];
        }
        for (int i = 0; i < rows; i++) {
            int maxRow = i;
            for (int k = i + 1; k < rows; k++) {
                if (Math.abs(augmented[k][i]) > Math.abs(augmented[maxRow][i])) {
                    maxRow = k;
                }
            }
            Integer[] temp = augmented[i];
            augmented[i] = augmented[maxRow];
            augmented[maxRow] = temp;

            for (int k = i + 1; k < rows; k++) {
                int factor = augmented[k][i] / augmented[i][i];
                for (int j = i; j <= cols; j++) {
                    augmented[k][j] -= factor * augmented[i][j];
                }
            }
        }

        Integer[] solution = new Integer[rows];
        for (int i = rows - 1; i >= 0; i--) {
            int sum = augmented[i][cols];
            for (int j = i + 1; j < cols; j++) {
                sum -= augmented[i][j] * solution[j];
            }
            solution[i] = sum / augmented[i][i];
        }
        return solution;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IntegerMatrix: \n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(matrix[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
