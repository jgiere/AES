package de.jgiere.layer;

public class ByteSubstitutionLayer implements ILayer {

    @Override
    public byte[][] compute(byte[][] stateMatrix) {
        final byte[][] matrix = new byte[stateMatrix.length][stateMatrix.length];

        for (int i = 0; i < stateMatrix.length; i++) {
            for (int u = 0; u < stateMatrix[i].length; u++) {
                matrix[i][u] = (byte) ILayer.affineMappinMap.get(stateMatrix[i][u]);
            }
        }

        return matrix;
    }
}
