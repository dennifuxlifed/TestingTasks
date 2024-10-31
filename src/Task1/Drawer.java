package Task1;

import java.util.Arrays;

public class Drawer {
    private final String[][] handmandrawmatrix = new String[8][6];

    public Drawer() {
        clearDrawing();
    }

    public void printHangman() {
        for (String[] drawInMatrixRaw : handmandrawmatrix) {
            for (int i = 0; i < drawInMatrixRaw.length; i++) {
                System.out.print(drawInMatrixRaw[i]);
                if (i == drawInMatrixRaw.length - 1) System.out.println("\n");
            }
        }
    }

    public void updateHangmanDrawingMatrix(int numberOfMistakes) {
        switch (numberOfMistakes) {
            case (1) -> {
                handmandrawmatrix[7][0] = "/";
                handmandrawmatrix[7][1] = "-";
                handmandrawmatrix[7][2] = "\\";
                handmandrawmatrix[6][1] = "|";
                handmandrawmatrix[5][1] = "|";
                handmandrawmatrix[4][1] = "|";
                handmandrawmatrix[3][1] = "|";
            }
            case (2) -> {
                handmandrawmatrix[2][1] = "|";
                handmandrawmatrix[1][1] = "|";
                handmandrawmatrix[0][2] = "_";
            }
            case (3) -> {
                handmandrawmatrix[0][3] = "_";
                handmandrawmatrix[0][4] = "_";
                handmandrawmatrix[0][5] = "_";
                handmandrawmatrix[1][4] = "|";
            }
            case (4) -> {
                handmandrawmatrix[2][4] = "(";
                handmandrawmatrix[2][5] = ")";
                handmandrawmatrix[3][4] = "/";
                handmandrawmatrix[3][5] = "\\";
            }
            case (5) -> {
                handmandrawmatrix[4][4] = "|";
                handmandrawmatrix[5][4] = "/";
                handmandrawmatrix[5][5] = "\\";
            }
        }
    }
    public void clearDrawing() {
        for (String[] drawInMatrixRaw : handmandrawmatrix) {
            Arrays.fill(drawInMatrixRaw, " ");
        }
    }
}



