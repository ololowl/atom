package ru.atom.geometry;

/**
 * Template class for
 */
public class Bar implements Collider {
    // fields
    // and methods
    Point leftBottom;
    Point rigthTop;

    public Bar(Point x, Point y) {
        this.leftBottom = x;
        this.rigthTop = y;
    }
    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Bar bar = (Bar) o;

        return this.leftBottom.equals(bar.leftBottom) && this.rigthTop.equals(bar.rigthTop);
    }

    @Override
    public boolean isColliding(Collider other) {
        if (other instanceof Point) {
            Point point = (Point) other;
            boolean flag = false;
            return this.leftBottom.x <= point.x && point.x <= this.rigthTop.x
                    && this.leftBottom.y <= point.y && point.y <= this.rigthTop.y;
        }
        if (other instanceof Bar) {
            Bar bar = (Bar) other;
            return this.equals(bar);
        }
        return false;
    }
}
