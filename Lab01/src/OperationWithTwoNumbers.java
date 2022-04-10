import javax.swing.JOptionPane;

public class OperationWithTwoNumbers {

	public static void main(String[] args) {

		String strNum1, strNum2;
		
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first nunmer: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "Please input the first nunmer: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
		
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		
		double sum = num1 + num2;
		double difference = (num1 - num2);
		if(difference < 0) {
			difference = difference*(-1);
		}
		double product = num1 * num2;		
		double quotient = num1/num2;		

		
		String strSum = String.valueOf(sum);
		String strDifference = String.valueOf(difference);
		String strProduct = String.valueOf(product);
		String strQuotient = String.valueOf(quotient);
		
		JOptionPane.showMessageDialog(null, "Sum: " + strSum + "\n" + "Difference: " + strDifference + "\n" + "Product: " + strProduct + "\n" + "Quotient: " + strQuotient, "Result", JOptionPane.INFORMATION_MESSAGE);

		
		System.exit(0);
		
	}

}
