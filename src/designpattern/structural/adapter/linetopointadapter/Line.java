package designpattern.structural.adapter.linetopointadapter;

import java.util.Objects;

public class Line
{
    Point start, end;

    public Line(Point p1, Point p2)
    {
        this.start = p1;
        this.end = p2;
    }

    @Override public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof Line))
            return false;
        Line line = (Line) o;
        return Objects.equals(start, line.start) && Objects.equals(end, line.end);
    }

    @Override public int hashCode()
    {
        return Objects.hash(start, end);
    }

    @Override public String toString()
    {
        return "Line{" + "start=" + start + ", end=" + end + '}';
    }
}
