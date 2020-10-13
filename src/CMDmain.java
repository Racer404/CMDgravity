package orbitSpeed;
import java.util.Scanner;

public class CMDmain extends CMDmath{
static double objectForce;
static double objectMass;
static double positionX;
static double positionY;
static double initAngle;
static double planetX;
static double planetY;
static double planetMass;

	public static void main(String[] args)throws InterruptedException {
		init();	
		double velocityX;
		double velocityY;
		double angle=initAngle;
		double UC;
		double resultant;
		CMDgraphics cmd = new CMDgraphics(100, 100);
		while(true)
		{
			Thread.sleep(1000);
			UC=calculateUG(planetMass, objectMass, CMDmath.distanceToPlanet(positionX,positionY,planetX,planetY));
			resultant=calculateResultant(angle, angleToPlanet(positionX, positionY,planetX,planetY), objectForce, UC);
			angle=angle+calculateResultantAngle(angle, angleToPlanet(positionX, positionY,planetX,planetY), objectForce, UC);
			velocityX=returnXofResultant(resultant, angle)/objectMass;
			velocityY=returnYofResultant(resultant, angle)/objectMass;
			positionX=positionX+velocityX*1;
			positionY=positionY+velocityY*1;
			cmd.updateFrames(positionX, positionY, planetX, planetY);
		}
	}

	private static void init()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("[Gravity Simulator] its Canvas Width&Height=1000*1000,beyond this range will cause FATALS");
		System.out.println("Please Input Pushing Force:(ENTER for default=30)");
		String objectForceInput=scanner.nextLine();
		if (objectForceInput.isEmpty()) {
			objectForce=30;
		}
		else {
			objectForce=Double.parseDouble(objectForceInput);
		}
		
		System.out.println("Please Input Object Mass:(ENTER for default=2)");
		String objectMassInput=scanner.nextLine();
		if (objectMassInput.isEmpty()) {
			objectMass=2;
		}
		else {
			objectMass=Double.parseDouble(objectMassInput);
		}
		
		System.out.println("Please Input Pushing-Angle:(ENTER for default=10.0)");
		String initAngleInput=scanner.nextLine();
		if (initAngleInput.isEmpty()) {
			initAngle=10.0;		
		}
		else {
			initAngle=Double.parseDouble(initAngleInput);
		}
		
		positionX=0;
		positionY=0;
		planetX=500;
		planetY=500;
		
		System.out.println("Please Input Planet Mass:(ENTER for default=5.965E14)");
		String planetMassInput=scanner.nextLine();
		if (planetMassInput.isEmpty()) {
			planetMass=5.965E14;
		}
		else {
			planetMass=Double.parseDouble(planetMassInput);
		}
		scanner.close();
	}
}
