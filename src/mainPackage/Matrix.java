package mainPackage;

public class Matrix {
    private int rows;
    private int columns;
    private double[][] matrixData;

    public Matrix(double[][] data) {
        this.matrixData = data;
        this.rows = data.length;
        this.columns = data[0].length;
    }

    public double[][] getMatrixData() {
        return matrixData;
    }

    static int changeSign(int number){
        if(number % 2 == 0){
            return 1;
        }
        else{
            return -1;
        }
    }

    public Matrix multiplyMatrixByConstant(double Const) {
        for (int row = 0; row < rows; row = row + 1){
            for (int column = 0; column < columns; column = column + 1){
                matrixData[row][column] = Const * matrixData[row][column];
            }
        }
        return new Matrix(matrixData);
    }

    public static Matrix matrixMultiplication(Matrix matrix1, Matrix matrix2){
        if (matrix1.columns == matrix2.rows){
            double sum = 0;
            double[][] newMatrixData = new double[matrix1.rows][matrix2.columns];
            for (int row = 0; row < matrix1.rows; row = row + 1){
                for (int column = 0; column < matrix2.columns; column = column + 1){
                    for (int k = 0; k < matrix2.rows; k = k + 1){
                        sum = sum + (matrix1.matrixData[row][k]
                                * matrix2.matrixData[k][column]);
                    }
                    newMatrixData[row][column] = sum;
                    sum = 0;
                }
            }
            return new Matrix(newMatrixData);
        }
        else{
            return null;
        }
    }

    public static Matrix matrixTranspose(Matrix matrix) {
        double[][] newMatrixData = new double[matrix.columns][matrix.rows];
        for (int row = 0; row < matrix.rows; row = row + 1) {
            for (int column = 0; column < matrix.columns; column = column + 1) {
                newMatrixData[column][row] = matrix.matrixData[row][column];
            }
        }
        return new Matrix(newMatrixData);
    }

    public static double matrixDeterminant(Matrix matrix){
        if (matrix.rows == 1) {
            return matrix.matrixData[0][0];
        }
        if (matrix.rows == 2) {
            return (matrix.matrixData[0][0] * matrix.matrixData[1][1])
                    - (matrix.matrixData[0][1] * matrix.matrixData[1][0]);
        }
        double total = 0.0;
        for (int column = 0; column < matrix.columns; column = column + 1) {
            total = total + (changeSign(column) * matrix.matrixData[0][column]
                    * matrixDeterminant(createSubMatrix(matrix, 0, column)));
        }
        return total;
    }

    public static Matrix createSubMatrix(Matrix matrix,
                                         int excludingRow, int excludingColumn) {
        double[][] newMatrixData = new double[matrix.rows - 1][matrix.columns - 1];
        int k = -1;
        for (int row = 0; row < matrix.rows; row = row + 1) {
            if (row == excludingRow) {
                continue;
            }
            k = k + 1;
            int l = -1;
            for (int column = 0; column < matrix.columns; column = column + 1) {
                if (column == excludingColumn) {
                    continue;
                }
                l = l + 1;
                newMatrixData[k][l] = matrix.matrixData[row][column];
            }
        }
        return new Matrix(newMatrixData);
    }

    public static Matrix matrixCofactor(Matrix matrix){
        double[][] newMatrixData = new double[matrix.rows][matrix.columns];
        for (int row = 0; row < matrix.rows; row = row + 1) {
            for (int column = 0; column < matrix.columns; column = column + 1) {
                newMatrixData[row][column] = changeSign(row) * changeSign(column)
                        * matrixDeterminant(createSubMatrix(matrix, row, column));
            }
        }
        return new Matrix(newMatrixData);
    }

    public static Matrix matrixInverse(Matrix matrix) {
        if (matrix.rows == matrix.columns) {
            double determinant = matrixDeterminant(matrix);
            if (determinant != 0){
                return (matrixTranspose(matrixCofactor(matrix)).
                        multiplyMatrixByConstant(1 / determinant));
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
}
