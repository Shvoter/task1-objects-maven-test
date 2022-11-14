package dev.profitsoft.model.implementation;

import dev.profitsoft.model.Shape;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Cube implements Shape {
    private int a;

    public Cube(int a) {
        setA(a);
    }

    public void setA(int a) {
        if (a <= 0) {
            throw new IllegalArgumentException("The side of cube should be positive");
        }
        this.a = a;
    }

    @Override
    public double getVolume() {
        return a^3;
    }
}
