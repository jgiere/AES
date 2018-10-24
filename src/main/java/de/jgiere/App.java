package de.jgiere;

import de.jgiere.layer.*;

public class App {
    public static void main(String[] args) {
        byte[][] matrix = new byte[4][4];
        byte[][] keyMatrixOne = new byte[4][4];
        byte[][] keyMatrixTwo = new byte[4][4];

        matrix[0][0] = (byte) 0x00;
        matrix[0][1] = (byte) 0x00;
        matrix[0][2] = (byte) 0x00;
        matrix[0][3] = (byte) 0x00;

        matrix[1][0] = (byte) 0x00;
        matrix[1][1] = (byte) 0x00;
        matrix[1][2] = (byte) 0x00;
        matrix[1][3] = (byte) 0x00;

        matrix[2][0] = (byte) 0x00;
        matrix[2][1] = (byte) 0x00;
        matrix[2][2] = (byte) 0x00;
        matrix[2][3] = (byte) 0x00;

        matrix[3][0] = (byte) 0x00;
        matrix[3][1] = (byte) 0x00;
        matrix[3][2] = (byte) 0x00;
        matrix[3][3] = (byte) 0x00;


        keyMatrixOne[0][0] = (byte) 0x2B;
        keyMatrixOne[0][1] = (byte) 0x7E;
        keyMatrixOne[0][2] = (byte) 0x15;
        keyMatrixOne[0][3] = (byte) 0x16;

        keyMatrixOne[1][0] = (byte) 0x28;
        keyMatrixOne[1][1] = (byte) 0xAE;
        keyMatrixOne[1][2] = (byte) 0xD2;
        keyMatrixOne[1][3] = (byte) 0xA6;

        keyMatrixOne[2][0] = (byte) 0xAB;
        keyMatrixOne[2][1] = (byte) 0xF7;
        keyMatrixOne[2][2] = (byte) 0x15;
        keyMatrixOne[2][3] = (byte) 0x88;

        keyMatrixOne[3][0] = (byte) 0x09;
        keyMatrixOne[3][1] = (byte) 0xCF;
        keyMatrixOne[3][2] = (byte) 0x4F;
        keyMatrixOne[3][3] = (byte) 0x3C;


        keyMatrixTwo[0][0] = (byte) 0xA0;
        keyMatrixTwo[0][1] = (byte) 0xFA;
        keyMatrixTwo[0][2] = (byte) 0xFE;
        keyMatrixTwo[0][3] = (byte) 0x17;

        keyMatrixTwo[1][0] = (byte) 0x88;
        keyMatrixTwo[1][1] = (byte) 0x54;
        keyMatrixTwo[1][2] = (byte) 0x2C;
        keyMatrixTwo[1][3] = (byte) 0xB1;

        keyMatrixTwo[2][0] = (byte) 0x23;
        keyMatrixTwo[2][1] = (byte) 0xA3;
        keyMatrixTwo[2][2] = (byte) 0x39;
        keyMatrixTwo[2][3] = (byte) 0x39;

        keyMatrixTwo[3][0] = (byte) 0x2A;
        keyMatrixTwo[3][1] = (byte) 0x6C;
        keyMatrixTwo[3][2] = (byte) 0x76;
        keyMatrixTwo[3][3] = (byte) 0x05;


        ILayer.printStateMatrix(matrix, "Start");

        matrix = new KeyAdditionLayer().compute(matrix, keyMatrixOne);
        ILayer.printStateMatrix(matrix, "First key addition");

        matrix = new ByteSubstitutionLayer().compute(matrix);
        ILayer.printStateMatrix(matrix, "Byte substitution layer");

        matrix = new ShiftRowLayer().compute(matrix);
        ILayer.printStateMatrix(matrix, "Shift rows");

        matrix = new MixColumnLayer().compute(matrix);
        ILayer.printStateMatrix(matrix, "Mix column");

        matrix = new KeyAdditionLayer().compute(matrix, keyMatrixTwo);
        ILayer.printStateMatrix(matrix, "End: Second key addition");

    }
}
