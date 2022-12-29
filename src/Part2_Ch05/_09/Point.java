package Part2_Ch05._09;

public class Point<T, V> {

    T x;
    V y;

    Point(T x, V y) {
        this.x = x;
        this.y = y;
    }

    public T getX() { return x; }
    public V getY() { return y; }

}
