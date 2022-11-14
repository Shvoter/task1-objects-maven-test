package dev.profitsoft.model.implementation;

import dev.profitsoft.model.Shape;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Sphere implements Shape {
    private int r;

    public Sphere(int r) {
        setR(r);
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
}
