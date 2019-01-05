
public class Q {
Point TopLeft, BottomLeft, BottomRight, TopRight;
LineSeg Left, Bottom, Right, Top;

//Constructor
public Q(double[] userInput) {
TopLeft = new Point(userInput[0],userInput[1]);
BottomLeft = new Point(userInput[2],userInput[3]);
BottomRight = new Point(userInput[4],userInput[5]);
TopRight = new Point(userInput[6],userInput[7]);
Left = new LineSeg(TopLeft,BottomLeft);
Bottom = new LineSeg(BottomLeft,BottomRight);
Right = new LineSeg(BottomRight,TopRight);
Top = new LineSeg(TopRight,TopLeft);
}

//Check if two doubles are close enough to be equal
private static boolean equals(double a, double b) {
double difference = Math.abs(a-b);
if (difference < 0.01) {
	return true;
} else {
	return false;
}

}
public void slopesAndSides() {
	System.out.println("Slope of the Left side: " + Left.slope());
	System.out.println("Slope of the Right side: " + Right.slope());
	System.out.println("Slope of the Bottom side: " + Bottom.slope());
	System.out.println("Slope of the Top side: " + Top.slope());

	System.out.println("Length of Left Side: " + Left.length());
	System.out.println("Length of Right Side: " + Right.length());
	System.out.println("Length of Bottom Side: " + Bottom.length());
	System.out.println("Length of Top Side: " + Top.length());
	
}
//Change return type*
public String classify() {
boolean isEitherSlopeParallel = (equals(Top.slope(),Bottom.slope())) || (equals(Left.slope(),Right.slope()));
boolean areBothSlopesParallel = (equals(Top.slope(),Bottom.slope())) && (equals(Left.slope(),Right.slope()));
boolean areAllSidesEqual = (equals(Top.length(),Left.length())) && (equals(Left.length(),Bottom.length())) && (equals(Bottom.length(),Right.length())) && (equals(Right.length(),Top.length()));

boolean verticalSlopesInfiniteAndHorizontalSlopesZero = (equals(Left.slope(),9999999)) && (equals(Right.slope(),9999999)) && (equals(Top.slope(),0)) && (equals(Bottom.slope(),0));
boolean areOppositeSidesEqualButNotAllFourEquation = (areBothSlopesParallel) && (equals(Top.length(),Bottom.length())) && (equals(Left.length(),Right.length())) && !(equals(Top.length(),Left.length())) && !(equals(Bottom.length(),Right.length()));
boolean SlopesHaveValues = !(equals(Top.slope(),0)) && !(equals(Left.slope(),0)) && !(equals(Bottom.slope(),0)) && !(equals(Right.slope(),0));
boolean JustOneSlopesHaveValues = (!(equals(Top.slope(),0)) && !(equals(Bottom.slope(),0))) || (!(equals(Left.slope(),0)) && !(equals(Right.slope(),0)));

boolean fourRightAngles = (equals(Top.slope(),(-1/(Left.slope())))) && (equals(Bottom.slope(),(-1/(Right.slope()))));

System.out.println(areBothSlopesParallel);
System.out.println(fourRightAngles);
System.out.println(areOppositeSidesEqualButNotAllFourEquation);


if (areBothSlopesParallel && areAllSidesEqual && (fourRightAngles)) {return "Square";}
if (areBothSlopesParallel && areOppositeSidesEqualButNotAllFourEquation) {return "Rectangle";}
if (areBothSlopesParallel && areAllSidesEqual) {return "Rhombus";};
if (areBothSlopesParallel && areOppositeSidesEqualButNotAllFourEquation) {return "Parallelogram";}
if (isEitherSlopeParallel && !(areBothSlopesParallel)) {return "Trapezoid!!";}
return "Shape";
}//End of Classify method


}//End of class
