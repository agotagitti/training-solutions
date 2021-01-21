package week12d02;

public class Site {

    private int side;
    private int length;
    private Fence fence;

    public Site(int side, int length, Fence fence) {
        if (side < 0 || side > 1) {
            throw new IllegalArgumentException("Wrong side");
        }
        this.side = side;
        this.length = length;
        this.fence = fence;
    }

    public int getSide() {
        return side;
    }

    public int getLength() {
        return length;
    }

    public Fence getFence() {
        return fence;
    }
}
