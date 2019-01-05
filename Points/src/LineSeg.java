public class LineSeg {
//Private instance variables
private Point start, end;
//Class Constructor
public LineSeg (Point p1, Point p2) {
	start=p1;
	end=p2;
}
//returns the length of the line segment
public double length() {
double parta = (end.getx()-start.getx())*(end.getx()-start.getx());
double partb = (end.gety()-start.gety())*(end.gety()-start.gety());
return Math.sqrt(parta+partb);
}
//returns the slope of the line segment
public double slope() {
if (end.getx()==start.getx()) {
	return 9999999;
}
double value = ((double)(end.gety()-start.gety())/(end.getx()-start.getx()));
if (value==0) {return 0.0;}
return value;
}
//returns the midpoint of the line
public Point midpoint() {
double midpointX, midpointY;
if (end.getx()==start.getx()) {
	midpointX=end.getx();
} else{
	midpointX = (end.getx()-start.getx())/2;
}

if (end.gety()==start.gety()) {
	midpointY = end.gety();
} else {
	midpointY = (end.gety()-start.gety())/2;

}

Point finalPoint = new Point(midpointX,midpointY);
return finalPoint;
}
//prints if the two line segments are equal in length
public void areEqual(LineSeg b) {
	if (this.length()==b.length()) {
		System.out.println("The lines are equal in length");
	} else {
		System.out.println("The lines are not equal in length.");
	}
}
//prints if the two line segments are parallel
public void areParallel(LineSeg b) {
	if (this.slope()==b.slope()) {
		System.out.println("The lines are parallel");
	} else {
		System.out.println("The lines are not parallel");
	}
}
}
