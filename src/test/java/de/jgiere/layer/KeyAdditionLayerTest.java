package de.jgiere.layer;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class KeyAdditionLayerTest {

    @Test
    public void keyAdditionLayerTest() {

        byte[][] stateMatrix = new byte[4][4];
        byte[][] keyMatrix = new byte[4][4];
        byte[][] expectedMatrix = new byte[4][4];

        stateMatrix[0][0] = (byte) 0x01;
        stateMatrix[0][1] = (byte) 0x00;
        stateMatrix[0][2] = (byte) 0x00;
        stateMatrix[0][3] = (byte) 0x00;

        stateMatrix[1][0] = (byte) 0x00;
        stateMatrix[1][1] = (byte) 0x00;
        stateMatrix[1][2] = (byte) 0x00;
        stateMatrix[1][3] = (byte) 0x00;

        stateMatrix[2][0] = (byte) 0x00;
        stateMatrix[2][1] = (byte) 0x00;
        stateMatrix[2][2] = (byte) 0x00;
        stateMatrix[2][3] = (byte) 0x00;

        stateMatrix[3][0] = (byte) 0x00;
        stateMatrix[3][1] = (byte) 0x00;
        stateMatrix[3][2] = (byte) 0x00;
        stateMatrix[3][3] = (byte) 0x00;

        keyMatrix[0][0] = (byte) 0x2B;
        keyMatrix[0][1] = (byte) 0x7E;
        keyMatrix[0][2] = (byte) 0x15;
        keyMatrix[0][3] = (byte) 0x16;

        keyMatrix[1][0] = (byte) 0x28;
        keyMatrix[1][1] = (byte) 0xAE;
        keyMatrix[1][2] = (byte) 0xD2;
        keyMatrix[1][3] = (byte) 0xA6;

        keyMatrix[2][0] = (byte) 0xAB;
        keyMatrix[2][1] = (byte) 0xF7;
        keyMatrix[2][2] = (byte) 0x15;
        keyMatrix[2][3] = (byte) 0x88;

        keyMatrix[3][0] = (byte) 0x09;
        keyMatrix[3][1] = (byte) 0xCF;
        keyMatrix[3][2] = (byte) 0x4F;
        keyMatrix[3][3] = (byte) 0x3C;



        expectedMatrix[0][0] = (byte) 0x2A;
        expectedMatrix[0][1] = (byte) 0x7E;
        expectedMatrix[0][2] = (byte) 0x15;
        expectedMatrix[0][3] = (byte) 0x16;

        expectedMatrix[1][0] = (byte) 0x28;
        expectedMatrix[1][1] = (byte) 0xAE;
        expectedMatrix[1][2] = (byte) 0xD2;
        expectedMatrix[1][3] = (byte) 0xA6;

        expectedMatrix[2][0] = (byte) 0xAB;
        expectedMatrix[2][1] = (byte) 0xF7;
        expectedMatrix[2][2] = (byte) 0x15;
        expectedMatrix[2][3] = (byte) 0x88;

        expectedMatrix[3][0] = (byte) 0x09;
        expectedMatrix[3][1] = (byte) 0xCF;
        expectedMatrix[3][2] = (byte) 0x4F;
        expectedMatrix[3][3] = (byte) 0x3C;

        byte[][] shiftedMatrix = new KeyAdditionLayer().compute(stateMatrix, keyMatrix);

        assertArrayEquals(shiftedMatrix[0], expectedMatrix[0]);
        assertArrayEquals(shiftedMatrix[1], expectedMatrix[1]);
        assertArrayEquals(shiftedMatrix[2], expectedMatrix[2]);
        assertArrayEquals(shiftedMatrix[3], expectedMatrix[3]);
    }
}
