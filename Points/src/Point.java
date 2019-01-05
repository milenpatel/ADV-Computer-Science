
public class Point {
private double x,y;


public Point(double x, double y) {this.x=x;this.y=y;}
public Point(Point input) {this.x=input.getx();	this.y=input.gety();}



//getters and setters
public double getx() {	return x; }
public double gety() {	return y; }
public void setx(double x) {this.x=x;}
public void sety(double y) {this.y=y;}

//returns what quadrant the ordered pair is in
public int quadrant() {
if (x>0) {
	if (y>0) {
		return 1;
	} else if (y<0) {
		return 4;
	}
} else if (x<0) {
	if (y>0) {
		return 2;
	} else if (y<0) {
		return 3;
	}
}
return 0;
}
//displays the ordered pair
public String toString() {
	return("("+x+", "+y+")");
}
//displays the ordered pair
public void display() {
	System.out.println(this);
}
//displays distance to origin
public double distToOrigin() {
	return Math.sqrt((x*x)+(y*y));
}


}//End of Class
