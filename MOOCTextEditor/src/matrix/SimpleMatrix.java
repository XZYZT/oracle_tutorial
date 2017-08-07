package matrix;

public class SimpleMatrix extends Matrix<Integer>{
	
	private SimpleMatrix(int M, int N) {
		this.M = M;
		this.N = N;
		this.a = (Integer[][]) new Object[M][N];
	}
	
	Matrix<Integer> create(int M, int N) {
		return new SimpleMatrix(M, N);
	}

	int getMaxRow() {
		return M;
	}

	int getMaxCol() {
		return N;
	}

	Integer getEntry(int i, int j) {
		return a[i][j];
	}

	Matrix<Integer> Add(Matrix<Integer> b) {
		int xAxis = b.getMaxRow();
		int yAxis = b.getMaxCol();
		if(xAxis != this.M || yAxis != this.N){
			System.err.println("Not same type matrix! Can't add.");
			System.exit(0);
		}
		int i,j;
		for(i = 0; i < M; i ++){
			for(j = 0; j < N; j ++){
				if(a instanceof Number[][]){
					
				}
			}
		}
		return this;
	}

	Matrix<Integer> Multiply(Matrix<Integer> b) {
		return null;
	}
}
