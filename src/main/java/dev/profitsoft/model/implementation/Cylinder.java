package dev.profitsoft.model.implementation;

import dev.profitsoft.model.Shape;

import java.util.Objects;

public class Cylinder implements Shape {
    private int r;
    private int h;

    public Cylinder(int r, int h) {
        setR(r);
        setH(h);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        if (r <= 0) {
            throw new IllegalArgumentException("The radius of Cylinder should be positive");
        }
        this.r = r;
    }

    public int getH() {
        if (h <= 0) {
            throw new IllegalArgumentException("The height of Cylinder should be positive");
        }
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public double getVolume() {
        return Math.PI * r * r * h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cylinder cylinder = (Cylinder) o;
        return r == cylinder.r && h == cylinder.h;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, h);
    }
}
