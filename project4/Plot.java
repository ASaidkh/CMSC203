/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Description: Class that creates a plot given x and y coordinates along with width and depth
 * Due: 04/07/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Alim Saidkhodjaev M21111105
 */

public class Plot {

    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        this(otherPlot.getX(), otherPlot.getY(), otherPlot.getWidth(), otherPlot.getDepth());
    }

    public boolean overlaps(Plot plot) {
        if (this.x + this.width <= plot.getX() || plot.getX() + plot.getWidth() <= this.x) {
            return false;
        }
        if (this.y + this.depth <= plot.getY() || plot.getY() + plot.getDepth() <= this.y) {
            return false;
        }
        return true;
    }

    public boolean encompasses(Plot plot) {
        if (plot.getX() < this.x || plot.getY() < this.y) {
            return false;
        }
        if (plot.getX() + plot.getWidth() > this.x + this.width) {
            return false;
        }
        if (plot.getY() + plot.getDepth() > this.y + this.depth) {
            return false;
        }
        return true;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getDepth() {
        return this.depth;
    }

    public String toString() {
        return this.x + "," + this.y + "," + this.width + "," + this.depth;
    }
}
