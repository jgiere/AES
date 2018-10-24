package de.jgiere.layer;

public class ShiftRowLayer implements ILayer {
    @Override
    public byte[][] compute(byte[][] stateMatrix) {
        byte[][] matrix = new byte[stateMatrix.length][stateMatrix.length];

        matrix[0][0] = stateMatrix[0][0];
        matrix[0][1] = stateMatrix[0][1];
        matrix[0][2] = stateMatrix[0][2];
        matrix[0][3] = stateMatrix[0][3];

        // Zweite Reihe
        byte nullte = stateMatrix[1][0];
        byte erste = stateMatrix[1][1];
        byte zweite = stateMatrix[1][2];
        byte dritte = stateMatrix[1][3];

        matrix[1][3] = nullte;
        matrix[1][0] = erste;
        matrix[1][1] = zweite;
        matrix[1][2] = dritte;


        // Dritte Reihe
        nullte = stateMatrix[2][0];
        erste = stateMatrix[2][1];
        zweite = stateMatrix[2][2];
        dritte = stateMatrix[2][3];

        matrix[2][2] = nullte;
        matrix[2][3] = erste;
        matrix[2][0] = zweite;
        matrix[2][1] = dritte;


        // Vierte Reihe
        nullte = stateMatrix[3][0];
        erste = stateMatrix[3][1];
        zweite = stateMatrix[3][2];
        dritte = stateMatrix[3][3];

        matrix[3][1] = nullte;
        matrix[3][2] = erste;
        matrix[3][3] = zweite;
        matrix[3][0] = dritte;

        return matrix;
    }
}
