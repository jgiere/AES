package de.jgiere.layer;

public class MixColumnLayer implements ILayer {
    @Override
    public byte[][] compute(byte[][] stateMatrix) {

        byte[][] responseMatrix = new byte[4][4];

        for (int c = 0; c < 4; c++) {
            responseMatrix[0][Byte.parseByte("" + c)] = (byte) (GMul((byte) 0x02, stateMatrix[0][c]) ^ GMul((byte) 0x03, stateMatrix[1][c]) ^ stateMatrix[2][c] ^ stateMatrix[3][c]);
            responseMatrix[1][Byte.parseByte("" + c)] = (byte) (stateMatrix[0][c] ^ GMul((byte) 0x02, stateMatrix[1][c]) ^ GMul((byte) 0x03, stateMatrix[2][c]) ^ stateMatrix[3][c]);
            responseMatrix[2][Byte.parseByte("" + c)] = (byte) (stateMatrix[0][c] ^ stateMatrix[1][c] ^ GMul((byte) 0x02, stateMatrix[2][c]) ^ GMul((byte) 0x03, stateMatrix[3][c]));
            responseMatrix[3][Byte.parseByte("" + c)] = (byte) (GMul((byte) 0x03, stateMatrix[0][c]) ^ stateMatrix[1][c] ^ stateMatrix[2][c] ^ GMul((byte) 0x02, stateMatrix[3][c]));
        }

        System.arraycopy(responseMatrix, 0, stateMatrix, 0, responseMatrix.length);

        return stateMatrix;
    }


    private static byte GMul(byte a, byte b) { // Galois Field (256) Multiplication of two Bytes

        byte p = 0;
        for (int counter = 0; counter < 8; counter++) {
            if ((b & 1) != 0) {
                p ^= a;
            }

            boolean hi_bit_set = (a & 0x80) != 0;
            a <<= 1;
            if (hi_bit_set) {
                a ^= 0x1B; /* x^8 + x^4 + x^3 + x + 1 */
            }

            b >>= 1;
        }

        return p;
    }
}
