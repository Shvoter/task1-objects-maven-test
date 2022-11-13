package dev.profitsoft.model.implementation;

import dev.profitsoft.model.Shape;

import java.util.Objects;

public class Cube implements Shape {
    private int a;

    public Cube(int a) {
        setA(a);
    }

    public int getA() {
        return a;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return a == cube.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}
