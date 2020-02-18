/*Alex Bowman
 * HW2 Polynomials
 * Prof. Silvestri
 * 2/17/20
 */
package hw2;

public class Poly {
	private double coeff[];

	public Poly() {
		coeff = new double[0]; // degree -1
	}

	public int getDegree() {
		return this.coeff.length - 1;
	}

	public double getCoeff(int n) {
		return (n >= 0 && n <= this.getDegree()) ? this.coeff[n] : 0.0;
	}

	public void setCoeff(int n, double value) {
		if (n < 0)
			throw new ArithmeticException("Negative power: " + n);

		if (n > this.getDegree()) {
			// Make the array bigger!
			double temp[] = new double[n + 1];
			// Copy existing coefficients into temp
			for (int i = 0; i <= this.getDegree(); i++)
				temp[i] = this.coeff[i];
			// Trash old coefficients array
			this.coeff = temp;
		}

		coeff[n] = value;

		// if terms with largest exponents are 0, decrease degree
		int degree = this.getDegree();
		while (degree >= 0 && this.coeff[degree] == 0.0)
			degree--;

		if (degree < this.getDegree()) {
			// Make the array smaller!
			double temp[] = new double[degree + 1];
			// Copy existing coefficients into temp
			for (int i = 0; i <= degree; i++)
				temp[i] = this.coeff[i];
			// Trash old coefficients array
			this.coeff = temp;
		}
	}

	public Poly termMult(double coeff, int exp) {
		Poly newPoly = new Poly();
		for (int i = this.getDegree(); i >= 0; i--) {
			double c = this.getCoeff(i) * coeff;
			int e = i + exp;
			newPoly.setCoeff(e, c);
		}
		return newPoly;
	}

	public Poly add(Poly p2) {
		Poly a = new Poly();
		int greater = (this.getDegree() > p2.getDegree()) ? this.getDegree() : p2.getDegree();
		for (int i = greater; i >= 0; i--) {
			a.setCoeff(i, p2.getCoeff(i) + this.getCoeff(i));
		}
		return a;

	}

	public Poly negative() {
		Poly b = new Poly();
		for (int i = this.getDegree(); i >= 0; i--) {
			b.setCoeff(i, -this.getCoeff(i));
		}
		return b;
	}

	public Poly sub(Poly p2) {
		return this.add(p2.negative());

	}

	public double evaluate(double x) {
		double p = 0;
		for (int i = this.getDegree(); i >= 0; i--)
			p += coeff[i] * Math.pow(x, i);
		return p;
	}

	public String toString() {
		if (getDegree() == -1)
			return "0";
		else if (this.getDegree() == 0)
			return "" + coeff[0];
		else if (getDegree() == 1)
			return coeff[1] + "x + " + coeff[0];
		String p = coeff[getDegree()] + "x^" + getDegree();
		for (int i = getDegree() - 1; i >= 0; i--) {
			if (coeff[i] == 0)
				continue;
			else if (coeff[i] > 0)
				p = p + " + " + (coeff[i]);
			else if (coeff[i] < 0)
				p = p + " - " + (-coeff[i]);
			if (i == 1)
				p = p + "x";
			else if (i > 1)
				p = p + "x^" + i;
		}
		return p;
	}

}
