import javax.swing.JOptionPane;

public class LinearSolver {

	public static void main(String[] args) {

		Double a, b, c;
		Double a11, a12, a21, a22, b1, b2;
		Integer NumOfEq;
		Integer Degree;
		String result = null;
		
		Degree = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the degree (1 or 2)", "Number of degrees", JOptionPane.INFORMATION_MESSAGE));
		
		if(Degree ==1) {
			NumOfEq = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of equations (1 or 2)", "Number of equations", JOptionPane.INFORMATION_MESSAGE));
			
			if(NumOfEq == 1) {
				a = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter a", "Input a", JOptionPane.INFORMATION_MESSAGE));
				while(a == 0) {
					a = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter a again\na should be difference from 0", "Input a", JOptionPane.INFORMATION_MESSAGE));
				}
				b = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter b", "Input b", JOptionPane.INFORMATION_MESSAGE));			
				
				result = "" + -b/a;
			}
			
			if(NumOfEq == 2) {
				a11 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter a11", "Input a11", JOptionPane.INFORMATION_MESSAGE));
				a12 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter a12", "Input a12", JOptionPane.INFORMATION_MESSAGE));
				b1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter b1", "Input b1", JOptionPane.INFORMATION_MESSAGE));
				a21 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter a21", "Input a21", JOptionPane.INFORMATION_MESSAGE));
				a22 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter a22", "Input a22", JOptionPane.INFORMATION_MESSAGE));
				b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter b2", "Input b2", JOptionPane.INFORMATION_MESSAGE));
	
				Double D = a11*a22 - a21*a12;
				Double D1 = b1*a22 - b2*a12;
				Double D2 = a11*b2 - a21*b1;
				
				if(D == 0) {
					if(D1 != 0) {
						result = "No solution";
					}
					
					else {
						result = "Infinite number of solutions";
					}
				}
				
				else {
					result = "x1 = " + D1/D + "\n" + "x2 = " + D2/D;
				}
			}
		}
		
		else {
			a = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter a", "Input a", JOptionPane.INFORMATION_MESSAGE));
			while(a == 0) {
				a = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter a again\na should be difference from 0", "Input a", JOptionPane.INFORMATION_MESSAGE));
			}
			b = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter b", "Input b", JOptionPane.INFORMATION_MESSAGE));			
			c = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter c", "Input c", JOptionPane.INFORMATION_MESSAGE));			

			Double Delta = b*b - 4*a*c;
			if(Delta < 0) {
				result = "No solution";
			}
			
			else if(Delta == 0) {
				result = "The equation has a double root x = " + -b/(2*a);
			}
			
			else {
				result = "The equation has two roots:\n" + "x1 = " + (-b - Math.sqrt(Delta))/(2*a) + "\nx2 = " + (-b + Math.sqrt(Delta))/(2*a); 
			}
		}
		
		JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
