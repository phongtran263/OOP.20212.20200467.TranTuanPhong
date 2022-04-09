public class AddMatrix {

	public static void main(String[] args) {
		
		int NumRow = 2;
		int NumCol = 2;
		
		double[][] matrix1 = {{1,2},{3,4}};
		double[][] matrix2 = {{1,2},{3,4}};
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
