import java.lang.Math.*;
import java.util.Scanner;

class CircleArea{
	public static void main(String[] args){
		double dia = 5;
		double rad = 2.5;
		double circum = 5 * Math.PI;

		System.out.println (CalArea(dia,0,0));
		System.out.println (CalArea(0,rad,0));
		System.out.println (CalArea(0,0,circum));
		System.out.println (CalArea(dia,rad,circum));
		System.out.println (CalArea(0,0,0));

	}

	public static double  

	public static double CalArea(double d, double r, double c){
		double area = 0;
		if (d > 0){
			return area = (Math.PI / 4) * (d * d);
		}
					
		else if(r > 0)
			return area = Math.PI * (r * r);

		else if(c > 0)
			return area = (c * c) / (Math.PI * 4);

		else
			System.out.println("No Input");
			return 0;
		}
}