package e2;

import java.util.Stack;

public class SocialDistance {


    public static char[][] seatingPeople(char[][] layout) {

        if (!isValidMatrix(layout)) throw new IllegalArgumentException();

        char[][] originalLayout = copyMatrix(layout);

        do {

            for (int i = 0; i < layout.length; i++) {
                for (int j = 0; j < layout[i].length; j++) {

                    layout[i][j] = checkAround(originalLayout, i, j);

                }

            }

            if (matrixEquals(layout, originalLayout)) break;
            originalLayout = copyMatrix(layout);
        } while (true);



        return layout;

    }


    public static char checkAround(char[][] layout, int fila, int col) {


        switch (layout[fila][col]) {
            case '#':

                int counter = 0;
                for (int i = (fila - 1); i <= (fila + 1); i++) {
                    for (int j = (col - 1); j <= (col + 1); j++) {

                        if (j < 0 || i < 0 || j > (layout[fila].length - 1) || i > (layout.length - 1)) {

                            continue;
                        }
                        if (layout[i][j] == '#') {
                            counter++;
                        }

                    }
                }

                if (counter > 4) { //porque se cuenta a si mismo

                    return 'A';

                } else {
                    return '#';
                }


            case 'A':
                for (int i = (fila - 1); i <= (fila + 1); i++) {
                    for (int j = (col - 1); j <= (col + 1); j++) {

                        if (j < 0 || i < 0 || j > (layout[fila].length - 1) || i > (layout.length - 1)) {

                            continue;
                        }
                        if (layout[i][j] == '#') {

                            return 'A';
                        }

                    }
                }

                return '#';

            case '.':
                return '.';

            default:
                throw new IllegalArgumentException();

        }


    }

    public static boolean isValidMatrix(char[][] matrix) {

        if (matrix == null) {
            return false;

        }
        for (int i = 0; i < matrix.length; i++) {

            if (matrix[i].length != matrix[0].length) {
                return false;
            }
        }
        return true;
    }

    static boolean matrixEquals(char[][] matrix1, char[][] matrix2) {

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {

                if (matrix1[i][j] != matrix2[i][j]) {

                    return false;

                }
            }

        }
        return true;
    }

    static char[][] copyMatrix(char[][] matrix) {


        char[][] newMatrix = new char[matrix.length][matrix[0].length];
        for (int fila = 0; fila < newMatrix.length; fila++) {
            for (int col = 0; col < newMatrix[fila].length; col++) {
                newMatrix[fila][col] = matrix[fila][col];

            }
        }
        return newMatrix;
    }

}
