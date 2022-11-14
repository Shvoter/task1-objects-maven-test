package dev.profitsoft.model.implementation;

import dev.profitsoft.model.Shape;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Cylinder implements Shape {
    private int r;
    private int h;

    public Cylinder(int r, int h) {
        setR(r);
        setH(h);
    }

    public void setR(int r) {
        if (r <= 0) {
            throw new IllegalArgumentException("The radius of Cylinder should be positive");
        }
        this.r = r;
    }

    public void setH(int h) {
        if (h <= 0) {
            throw new IllegalArgumentException("The height of Cylinder should be positive");
        }
        this.h = h;
    }

    @Override
    public double getVolume() {
        return Math.PI * r * r * h;
    }
}
