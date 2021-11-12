package newp;

import static newp.Point.distance;

public class Polygon {
    Point first;
    Point last;
    int size;
    Point array[];
    boolean isClosed;


    Polygon() {
        this.first=null;
        this.last=null;
        this.size=0; }

    Polygon(int x){
        array = new Point[x];
    }


    boolean isEmpty() { return this.size==0;}
    public void close() { this.isClosed = true; }
    int numOfPoints() { return  this.size; }



    void addPoint( double x, double y) { //insertLast
        Point p1 = new Point(x,y);
        if (p1.equals(this.first)) {
            System.out.println("Polygon is closed.");
            this.isClosed = true;
            return; }
        if (isEmpty()) {
            this.first=p1;
            this.last=p1;
        } else {
            this.last.next=p1;
            this.last=p1;
        }
        this.size++;
    }

    Point removeLastPoint(){
        if (isEmpty()) { return null;}
        if (this.isClosed) return null;
        Point tmp;
        Point secondLast = this.first;
        while (secondLast.next.next!=null) {
            secondLast.next= secondLast.next.next;
        }
        tmp=secondLast.next;
        secondLast.next=null;
        this.last=secondLast;
        this.size--;
        return tmp;   //silineni gösterir

    }


    // Polygon reverse() { }

    String printArray() {
        Point array[] = new Point[this.size];
        Point currPoint = this.first;
        String str = "[";
        for (int i=0;i<this.size;i++) {
            array[i]=currPoint;
            currPoint=currPoint.next;
// bir nokta silip print edersen hata veriyor
            str = str +array[i].toString() +" ,";
        } System.out.print("]");
        return str;
    }


    public double calculateTotalLength() {
        double result = 0;
        Point currPoint = this.first;
        for (int i = 0; i < this.size-1; i++) {
            result += distance(currPoint ,currPoint.next);
            if (i != this.size-2) {
                currPoint = currPoint.next;
            }
        }
        if (this.isClosed) {
            result += distance(this.last ,this.first);
        }
        return result;
    }


    double area() throws Exception {
        if(!this.isClosed) throw new Exception("You can't calculate an open polygon's area.");
        double result = 0;
        Point currPoint = this.first;
        for (int i = 0; i < this.size; i++) {
            double d = 0;
            if (i != this.size-1) {
                d = (currPoint.x * currPoint.next.y) - (currPoint.y * currPoint.next.x);
                currPoint = currPoint.next;
            }else {
                d = (currPoint.x * this.first.y) - (currPoint.y * this.first.x);
            }
            result += d;
        }
        return Math.abs(result/2);}
       /* Point array[] = new Point[this.size];
        double result = 0;
        double a=0;
        double b=0;
        double c=0;
        Point currPoint = this.first;
        for (int i = 0; i < this.size; i++) {
            array[i] = currPoint;
            currPoint = currPoint.next;}

            for (int w = 0; w < array.length - 1; w++) {

                a = array[w].x * array[w + 1].y;
                b = array[w + 1].x * array[w].y;
                result = result + ((a - b) / 2) - c;
            }
         return Math.abs(result );
    */

    public void concatenate(Polygon polygon) throws Exception {
        if (this.isClosed || polygon.isClosed) throw new Exception("You can't concatenate a closed polygon.");
        this.last.next=polygon.first;
        this.last = polygon.last;
    }

    @Override
    public String toString() {
        String extraInfo;
        if (isClosed) extraInfo = " closed";
        else extraInfo = "n open";
        String description = "This is a" + extraInfo + " polygon that has " + this.size + " corner and these corner points are: ";
        return description + this.printArray();
    }

}
