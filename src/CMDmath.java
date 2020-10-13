package orbitSpeed;

public class CMDmath {
	public static double calculateResultant(double F1angle,double F2angle,double Force1,double Force2)
	{
		double angleBetweenF2F1=Math.toRadians(F2angle-F1angle);
		double resultant=Math.sqrt(Force1*Force1+Force2*Force2+2*Force1*Force2*Math.cos(angleBetweenF2F1));
		return resultant;
	}
	public static double calculateResultantAngle(double F1angle,double F2angle,double Force1,double Force2)
	{
		double angleBetweenF2F1=Math.toRadians(F2angle-F1angle);
		double resultant=Math.sqrt(Force1*Force1+Force2*Force2+2*Force1*Force2*Math.cos(angleBetweenF2F1));
		double resultantAngle=Math.toDegrees(Math.acos((Force1*Force1+resultant*resultant-Force2*Force2)/(2*resultant*Force1)));
		return resultantAngle;
	}
	public static double calculateUG(double M1,double M2,double distance)
	{
		double G=0.0000000000667259;
		return (G*M1*M2)/(distance*distance);
	}
	public static double returnXofResultant(double resultant,double angle) {
		return Math.cos(Math.toRadians(angle))*resultant;
	}
	public static double returnYofResultant(double resultant,double angle) {
		return Math.sin(Math.toRadians(angle))*resultant;
	}
	public static double angleToPlanet(double positionX,double positionY,double planetX,double planetY)
	{
		return Math.toDegrees(Math.atan2(planetY-positionY, planetX-positionX));
	}
	public static double distanceToPlanet(double positionX,double positionY,double planetX,double planetY)
	{
		return Math.sqrt((planetY-positionY)*(planetY-positionY)+(planetX-positionX)*(planetX-positionX));
	}
}
