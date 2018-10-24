package de.jgiere.layer;

public interface IKeyAdditionLayer {
    byte[][] compute(byte[][] stateMatrix, byte[][] keyMatrix);
}
