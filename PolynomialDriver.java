/*Alex Bowman
 * HW2 Polynomials
 * Prof. Silvestri
 * 2/17/20
 */
package hw2;
import java.util.Scanner;

public class PolynomialDriver {
	private final static String TITLE = "Polynomial Expression Manipulator V1.0";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	
	
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner sc, String args[]) {
		System.out.print("Enter order of first polynomial: ");
		Poly p1 = new Poly();
		int p1Degree = sc.nextInt();
		System.out.print("Enter coefficients (high order first): ");
		for (int i = p1Degree; i >= 0; i--)
			p1.setCoeff(i, sc.nextDouble());

		System.out.print("Enter order of second polynomial: ");
		Poly p2 = new Poly();
		int p2Degree = sc.nextInt();
		System.out.print("Enter coefficients (high order first): ");
		for (int i = p2Degree; i >= 0; i--)
			p2.setCoeff(i, sc.nextDouble());

		Poly pAdd = p1.add(p2);
		Poly p1Neg = p1.negative();
		Poly pSub = p1.sub(p2);
		Poly p2Neg = p2.negative();
		
		System.out.printf("P1 = %s\n", p1);
		System.out.printf("-P1 = %s\n", p1Neg);
		System.out.printf("P2 = %s\n", p2);
		System.out.printf("-P2 = %s\n", p2Neg);
		System.out.printf("P1 + P2 = %s\n", pAdd);
		System.out.printf("P1 - P2 = %s\n", pSub);
		
		System.out.print("Enter x to evaluate p1 and p2: ");
		double x = sc.nextDouble();
		System.out.printf("P1(%s) = %.4f\n", x, p1.evaluate(x));
		System.out.printf("P2(%s) = %.4f\n", x, p2.evaluate(x));
		
		sc.nextLine();  // Clear Keyboard
	}
	
	//**********************************************
	// Do not change the doThisAgain method
	private static boolean doThisAgain(Scanner sc, String prompt) {
		System.out.print(prompt); 
		String doOver = sc.nextLine();
		return doOver.trim().equalsIgnoreCase("Y");
	}
	
	//**********************************************
	// Do not change the main method
	public static void main(String args[]) {
		System.out.println("Welcome to " + TITLE);
		Scanner sc = new Scanner(System.in);
		do {
			process(sc, args);
		} while (doThisAgain(sc, CONTINUE_PROMPT));
		sc.close();
		System.out.println("Thank you for using " + TITLE);
	}

}