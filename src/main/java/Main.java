import org.apache.commons.cli.*;
import org.math.linear.algebra.Vector;
import org.math.linear.algebra.Matrix;
import org.math.linear.algebra.integer.matrix.Int2DMatrix;
import org.math.linear.algebra.integer.matrix.Int3DMatrix;
import org.math.linear.algebra.integer.matrix.Int4DMatrix;
import org.math.linear.algebra.integer.matrix.IntegerMatrix;
import org.math.linear.algebra.integer.vectors.Int2XVector;
import org.math.linear.algebra.integer.vectors.Int3XVector;
import org.math.linear.algebra.integer.vectors.Int4XVector;
import org.math.linear.algebra.integer.vectors.IntegerVector;
import org.math.linear.algebra.noninteger.matrix.Dou2DMatrix;
import org.math.linear.algebra.noninteger.matrix.Dou3DMatrix;
import org.math.linear.algebra.noninteger.matrix.Dou4DMatrix;
import org.math.linear.algebra.noninteger.matrix.DoubleMatrix;
import org.math.linear.algebra.noninteger.vector.Dou2XVector;
import org.math.linear.algebra.noninteger.vector.Dou3XVector;
import org.math.linear.algebra.noninteger.vector.Dou4XVector;
import org.math.linear.algebra.noninteger.vector.DoubleVector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
        Dou2DMatrix a = new Dou2DMatrix();
        Dou4DMatrix b = new Dou4DMatrix();
        
        
        /*Matrix<?, ?, ?> c = a.addMatrix(b);*/
        
        Options options = new Options();

        options.addOption("t", "type", true, "Data type: Integer or Double");
        options.addOption("d", "dimension", true, "Dimension: 2x, 3x, 4x for vectors; 2D, 3D, 4D for matrices");
        options.addOption("op", "operation", true, "Operation: add, subtract, multiply, transpose, inverse");
        options.addOption("v1", "vector1", true, "First vector (comma-separated values)");
        options.addOption("v2", "vector2", true, "Second vector (comma-separated values)");
        options.addOption("m1", "matrix1", true, "First matrix (semicolon-separated rows)");
        options.addOption("m2", "matrix2", true, "Second matrix (semicolon-separated rows)");
        options.addOption("s", "scalar", true, "Scalar value for scalar operations");

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {
            CommandLine cmd = parser.parse(options, args);

            String type = cmd.getOptionValue("type");
            String dimension = cmd.getOptionValue("dimension");
            String operation = cmd.getOptionValue("operation");
            String vector1 = cmd.getOptionValue("vector1");
            String vector2 = cmd.getOptionValue("vector2");
            String matrix1 = cmd.getOptionValue("matrix1");
            String matrix2 = cmd.getOptionValue("matrix2");
            String scalar = cmd.getOptionValue("scalar");

            if (dimension.endsWith("x")) {
                executeVectorOperation(type, dimension, operation, vector1, vector2, scalar);
            } else if (dimension.endsWith("D")) {
                executeMatrixOperation(type, dimension, operation, matrix1, matrix2, scalar);
            } else {
                System.out.println("Invalid dimension. Use 2x, 3x, 4x for vectors or 2D, 3D, 4D for matrices.");
            }
        } catch (ParseException e) {
            System.out.println("Error parsing arguments: " + e.getMessage());
            formatter.printHelp("MathLibraryCLI", options);
        }
    }

    private static void executeVectorOperation(String type, String dimension, String operation, String vector1, String vector2, String scalar) {

        Vector<?, ?> v1 = createVector(type, dimension, vector1);
        Vector<?, ?> v2 = vector2 != null ? createVector(type, dimension, vector2) : null;
        Vector<?, ?> scalarValue = scalar != null ? parseScalar(type, scalar) : null;
        if (v1.getComponents() instanceof Integer[]) {
            IntegerVector v1Typed = (IntegerVector) v1;
            IntegerVector v2Typed = (IntegerVector) v2;

            switch (operation) {
                case "add":
                    System.out.println("Result: " + v1Typed.add(v2Typed));
                    break;
                case "subtract":
                    System.out.println("Result: " + v1Typed.subtract(v2Typed));
                    break;
                case "multiply":
                    System.out.println("Result: " + v1Typed.multiplyByScalar((Integer) scalarValue.get(0)));
                    break;
                case "normalize":
                    System.out.println("Result: " + v1Typed.normalize());
                    break;
                case "dot":
                    System.out.println("Result: " + v1Typed.dotProduct(v2Typed));
                    break;
                default:
                    System.out.println("Unsupported vector operation.");
            }
        } else if (v1.getComponents() instanceof Double[]) {
            DoubleVector v1Typed = (DoubleVector) v1;
            DoubleVector v2Typed = (DoubleVector) v2;

            switch (operation) {
                case "add":
                    System.out.println("Result: " + v1Typed.add(v2Typed));
                    break;
                case "subtract":
                    System.out.println("Result: " + v1Typed.subtract(v2Typed));
                    break;
                case "multiply":
                    System.out.println("Result: " + v1Typed.multiplyByScalar((Double) scalarValue.get(0)));
                    break;
                case "normalize":
                    System.out.println("Result: " + v1Typed.normalize());
                    break;
                case "dot":
                    System.out.println("Result: " + v1Typed.dotProduct(v2Typed));
                    break;
                default:
                    System.out.println("Unsupported vector operation.");
            }
        } else {
            System.out.println("Incompatible vector types.");
        }

    }

    private static void executeMatrixOperation(String type, String dimension, String operation, String matrix1, String matrix2, String scalar) {
        Matrix<?, ?, ?> m1 = createMatrix(type, dimension, matrix1);
        Matrix<?, ?, ?> m2 = matrix2 != null ? createMatrix(type, dimension, matrix2) : null;
        Vector<?, ?> scalarValue = scalar != null ? parseScalar(type, scalar) : null;

        if (m1.getMatrix() instanceof Integer[][]) {
             IntegerMatrix m1Typed = (IntegerMatrix) m1;
             IntegerMatrix m2Typed = (IntegerMatrix) m2;
            switch (operation) {
                case "add":
                    System.out.println("Result: " + m1Typed.addMatrix(m2Typed));
                    break;
                case "subtract":
                    System.out.println("Result: " + m1Typed.subtractMatrices(m2Typed));
                    break;
                case "multiply":
                    if (m2 != null) {
                        System.out.println("Result: " + m1Typed.multiplyMatrix(m2Typed));
                    } else if (scalar != null && scalarValue.getComponents() instanceof Integer[]) {
                        System.out.println("Result: " + m1Typed.multiplyByVector((IntegerVector) scalarValue));
                    }
                    break;
                case "transpose":
                    System.out.println("Result: " + m1Typed.transpose());
                    break;
                case "inverse":
                    System.out.println("Result: " + m1.inverse());
                    break;
                default:
                    System.out.println("Unsupported matrix operation.");
            }
        }
    }

    private static Vector<?, ?> createVector(String type, String dimension, String data) {
        String[] components = data.split(",");
        switch (type) {
            case "Integer":
                return createIntegerVector(dimension, components);
            case "Double":
                return createDoubleVector(dimension, components);
            default:
                throw new IllegalArgumentException("Unsupported type for vector: " + type);
        }
    }

    private static Matrix<?, ?, ?> createMatrix(String type, String dimension, String data) {
        String[] rows = data.split(";");
        switch (type) {
            case "Integer":
                return createIntegerMatrix(dimension, rows);
            case "Double":
                return createDoubleMatrix(dimension, rows);
            default:
                throw new IllegalArgumentException("Unsupported type for matrix: " + type);
        }
    }

    private static IntegerVector createIntegerVector(String dimension, String[] components) {
        Integer[] values = parseIntegerArray(components);
        switch (dimension) {
            case "2x":
                return new Int2XVector(values);
            case "3x":
                return new Int3XVector(values);
            case "4x":
                return new Int4XVector(values);
            default:
                throw new IllegalArgumentException("Unsupported vector dimension: " + dimension);
        }
    }

    private static DoubleVector createDoubleVector(String dimension, String[] components) {
        Double[] values = parseDoubleArray(components);
        switch (dimension) {
            case "2x":
                return new Dou2XVector(values);
            case "3x":
                return new Dou3XVector(values);
            case "4x":
                return new Dou4XVector(values);
            default:
                throw new IllegalArgumentException("Unsupported vector dimension: " + dimension);
        }
    }

    private static IntegerMatrix createIntegerMatrix(String dimension, String[] rows) {
        Integer[][] values = parseIntegerMatrix(rows);
        switch (dimension) {
            case "2D":
                return new Int2DMatrix(values);
            case "3D":
                return new Int3DMatrix(values);
            case "4D":
                return new Int4DMatrix(values);
            default:
                throw new IllegalArgumentException("Unsupported matrix dimension: " + dimension);
        }
    }

    private static DoubleMatrix createDoubleMatrix(String dimension, String[] rows) {
        Double[][] values = parseDoubleMatrix(rows);
        switch (dimension) {
            case "2D":
                return new Dou2DMatrix(values);
            case "3D":
                return new Dou3DMatrix(values);
            case "4D":
                return new Dou4DMatrix(values);
            default:
                throw new IllegalArgumentException("Unsupported matrix dimension: " + dimension);
        }
    }

    private static Integer[] parseIntegerArray(String[] components) {
        return Arrays.stream(components)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }

    private static Double[] parseDoubleArray(String[] components) {
        return Arrays.stream(components)
                .map(Double::parseDouble)
                .toArray(Double[]::new);
    }

    private static Integer[][] parseIntegerMatrix(String[] rows) {
        return Arrays.stream(rows)
                .map(row -> parseIntegerArray(row.split(",")))
                .toArray(Integer[][]::new);
    }

    private static Double[][] parseDoubleMatrix(String[] rows) {
        return Arrays.stream(rows)
                .map(row -> parseDoubleArray(row.split(",")))
                .toArray(Double[][]::new);
    }

    private static Vector<?, ?> parseScalar(String type, String scalar) {
        String[] componentsScalar = scalar.split(" ");
        return "Integer".equalsIgnoreCase(type)
                ? new IntegerVector(Arrays.stream(componentsScalar)
                .map(Integer::valueOf)
                .toArray(Integer[]::new))
                : new DoubleVector(Arrays.stream(componentsScalar)
                .map(Double::parseDouble)
                .toArray(Double[]::new));
    }
}
