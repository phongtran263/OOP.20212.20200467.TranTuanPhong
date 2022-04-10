public class AddMatrix {

	public static void main(String[] args) {
			
		double[][] matrix1 = {	{1,8},
								{3,4},
								{23,324}
							 };
		double[][] matrix2 = {	{1,2},
								{3,4},
								{123, 32}
							 };
		int NumRow = matrix1.length;
		int NumCol = matrix1[0].length;
		
		double[][] result = new double[NumRow][NumCol];
		
		for(int row = 0; row < NumRow; row++) {
			for(int col = 0; col < NumCol; col++) {
				result[row][col] = matrix1[row][col] + matrix2[row][col];
			}
		}

		for(int row = 0; row < NumRow; row++) {
			for(int col = 0; col < NumCol; col++) {
				System.out.print(result[row][col] + "\t");
			}
			System.out.println();
		}		
	}

}
