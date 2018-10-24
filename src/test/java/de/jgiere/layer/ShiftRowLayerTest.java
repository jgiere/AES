package de.jgiere.layer;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ShiftRowLayerTest {

    @Test
    public void shiftTest() {
        byte[][] stateMatrix = new byte[4][4];
        byte[][] expectedMatrix = new byte[4][4];

        stateMatrix[0][0] = (byte) 0x2B;
        stateMatrix[0][1] = (byte) 0x7E;
        stateMatrix[0][2] = (byte) 0x15;
        stateMatrix[0][3] = (byte) 0x16;

        stateMatrix[1][0] = (byte) 0x28;
        stateMatrix[1][1] = (byte) 0xAE;
        stateMatrix[1][2] = (byte) 0xD2;
        stateMatrix[1][3] = (byte) 0xA6;

        stateMatrix[2][0] = (byte) 0xAB;
        stateMatrix[2][1] = (byte) 0xF7;
        stateMatrix[2][2] = (byte) 0x15;
        stateMatrix[2][3] = (byte) 0x88;

        stateMatrix[3][0] = (byte) 0x09;
        stateMatrix[3][1] = (byte) 0xCF;
        stateMatrix[3][2] = (byte) 0x4F;
        stateMatrix[3][3] = (byte) 0x3C;



        expectedMatrix[0][0] = (byte) 0x2B;
        expectedMatrix[0][1] = (byte) 0x7E;
        expectedMatrix[0][2] = (byte) 0x15;
        expectedMatrix[0][3] = (byte) 0x16;

        expectedMatrix[1][0] = (byte) 0xAE;
        expectedMatrix[1][1] = (byte) 0xD2;
        expectedMatrix[1][2] = (byte) 0xA6;
        expectedMatrix[1][3] = (byte) 0x28;

        expectedMatrix[2][0] = (byte) 0x15;
        expectedMatrix[2][1] = (byte) 0x88;
        expectedMatrix[2][2] = (byte) 0xAB;
        expectedMatrix[2][3] = (byte) 0xF7;

        expectedMatrix[3][0] = (byte) 0x3C;
        expectedMatrix[3][1] = (byte) 0x09;
        expectedMatrix[3][2] = (byte) 0xCF;
        expectedMatrix[3][3] = (byte) 0x4F;

        byte[][] shiftedMatrix = new ShiftRowLayer().compute(stateMatrix);

        assertArrayEquals(shiftedMatrix[0], expectedMatrix[0]);
        assertArrayEquals(shiftedMatrix[1], expectedMatrix[1]);
        assertArrayEquals(shiftedMatrix[2], expectedMatrix[2]);
        assertArrayEquals(shiftedMatrix[3], expectedMatrix[3]);
    }
}
