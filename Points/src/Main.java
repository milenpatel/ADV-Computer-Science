import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
Scanner userInput = new Scanner(System.in);

System.out.println("Enter X1");
double x1 = userInput.nextInt();
System.out.println("Enter Y1");
double y1 = userInput.nextInt();
System.out.println("Enter X2");
double x2 = userInput.nextInt();
System.out.println("Enter Y2");
double y2 = userInput.nextInt();
Point firstPoint = new Point(x1,y1);
Point secondPoint = new Point(x2,y2);
LineSeg userCreatedLine = new LineSeg(firstPoint,secondPoint);
//Display length, slope and midpoint
System.out.println("Length: " + userCreatedLine.length());
System.out.println("Slope: " + userCreatedLine.slope());
System.out.println("Midpoint: " + userCreatedLine.midpoint());
System.out.println("Enter another x1");
userInput = new Scanner(System.in);
while (userInput.hasNext()){
x1=userInput.nextInt();
System.out.println("Enter another y1");
y1=userInput.nextInt();
System.out.println("Enter another x2");
x2=userInput.nextInt();
System.out.println("Enter another y2");
y2=userInput.nextInt();
Point thirdPoint = new Point(x1,y1);
Point fourthPoint = new Point(x2,y2);
LineSeg secondSeg = new LineSeg(thirdPoint,fourthPoint);
secondSeg.areEqual(userCreatedLine);
secondSeg.areParallel(userCreatedLine);
}

	}
	
}

//The linseg.midpoint function is broken because point is integer but mdpt's usually use decimals