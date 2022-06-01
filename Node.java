public class Node {
    private int x;
    private int y;
    public Node previous = null;

    Node() {
    }

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Node(int x, int y, Node previous) {
        this.x = x;
        this.y = y;
        this.previous = previous;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
