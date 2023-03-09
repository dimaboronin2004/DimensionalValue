package org.example;

public final class DimensionalValue {
    private final double value;
    private final String dimension;
    DimensionalValue(double value, String dimension) {
        this.value = value;
        this.dimension = dimension;
    }

    public String toString() {
        return this.value + " " + this.dimension;
    }

    public DimensionalValue toDimensionalValue(String string) {
        if (!string.matches("\\d+(\\.\\d+)? [A-zА-я]+"))
            throw new IllegalArgumentException("String inconvertible to dimensional value.");

        double val = Double.parseDouble(string.split(" ")[0]);
        String dim = string.split(" ")[1];
        return new DimensionalValue(val, dim);
    }

    public DimensionalValue plus(DimensionalValue other) {
        if (!this.dimension.equals(other.dimension))
            throw new IllegalArgumentException("Unable to sum different dimensions");

        return new DimensionalValue(this.value + other.value, this.dimension);
    }

    public DimensionalValue minus(DimensionalValue other) {
        if (!this.dimension.equals(other.dimension))
            throw new IllegalArgumentException("Unable to subtract different dimensions");

        return new DimensionalValue(this.value - other.value, this.dimension);
    }

    public DimensionalValue unaryMinus() {
        return new DimensionalValue(-this.value, this.dimension);
    }

    public DimensionalValue times(double n) {
        return new DimensionalValue(n * this.value, this.dimension);
    }

    public DimensionalValue div(double n) {
        return new DimensionalValue(n / this.value, this.dimension);
    }

    public DimensionalValue divOther(DimensionalValue other) {
        if (!this.dimension.equals(other.dimension))
            throw new IllegalArgumentException("Unable to divide different dimensions");
        return new DimensionalValue(this.value / other.value, this.dimension);
    }

    public boolean equals(DimensionalValue other) {
        return this.value == other.value && this.dimension.equals(other.dimension);
    }

    public Integer compareTo(DimensionalValue other) {
        if (!this.dimension.equals(other.dimension))
            throw new IllegalArgumentException("Unable to compare different dimensions");
        return Double.compare(this.value, other.value);
    }

    public double getValue() {
        return value;
    }

    public String getDimension() {
        return dimension;
    }

}
