package dev.profitsoft.model.implementation;

import dev.profitsoft.model.Shape;

import java.util.Objects;

public class Sphere implements Shape {
    private int r;

    public Sphere(int r) {
        setR(r);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        if (r <= 0) {
            throw new IllegalArgumentException("The radius of Sphere should be positive");
        }
        this.r = r;
    }

    @Override
    public double getVolume() {
        return (4/3.) * Math.PI * r * r * r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return r == sphere.r;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r);
    }
}
