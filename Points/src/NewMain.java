import java.util.Scanner;
public class NewMain {

	public static void main(String[] args) {
Scanner userInput = new Scanner(System.in);
double[] userDefinedPoints = new double[8];
System.out.println("Enter X Coordinate of Top Left Point");
userDefinedPoints[0]=userInput.nextDouble();
System.out.println("Enter Y Coordinate of Top Left Point");
userDefinedPoints[1]=userInput.nextDouble();
System.out.println("Enter X Coordinate of Bottom Left Point");
userDefinedPoints[2]=userInput.nextDouble();
System.out.println("Enter Y Coordinate of Bottom Left Point");
userDefinedPoints[3]=userInput.nextDouble();
System.out.println("Enter X Coordinate of Bottom Right Point");
userDefinedPoints[4]=userInput.nextDouble();
System.out.println("Enter Y Coordinate of Bottom Right Point");
userDefinedPoints[5]=userInput.nextDouble();
System.out.println("Enter X Coordinate of Top Right Point");
userDefinedPoints[6]=userInput.nextDouble();
System.out.println("Enter Y Coordinate of Top Right Point");
userDefinedPoints[7]=userInput.nextDouble();
Q Shape = new Q(userDefinedPoints);
Shape.slopesAndSides();
System.out.println("The Shape is: " + Shape.classify());
	}

}
