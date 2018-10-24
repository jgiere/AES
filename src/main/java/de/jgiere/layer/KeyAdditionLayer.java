package de.jgiere.layer;

public class KeyAdditionLayer implements IKeyAdditionLayer {
    @Override
    public byte[][] compute(byte[][] stateMatrix, byte[][] keyMatrix) {

        byte[][] computedResult = new byte[stateMatrix.length][stateMatrix.length];

        for (int i = 0; i < stateMatrix.length; i++) {
            for (int u = 0; u < stateMatrix[i].length; u++) {
                computedResult[i][u] = (byte) (stateMatrix[i][u] ^ keyMatrix[i][u]);
            }
        }
        return computedResult;
    }
}
