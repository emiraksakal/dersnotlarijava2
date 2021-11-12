package newp;


public class Point {
    double x,y;
    Point next;

    Point(double x, double y) {
        this.x=x;
        this.y=y;
        next=null;
    }
    static double distance(Point a, Point b) {
        double r= Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2);
        return Math.sqrt(r);
    }

    public String toString() {
        double x1 = this.x;
        double y1 = this.y;
        String s = x1 +" "+y1 ;
       return s;
    }




}
