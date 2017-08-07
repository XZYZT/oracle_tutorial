package matrix;
/**
 * 类型名称：		矩阵(Matrix)
 * 数据对象集：	一个M * N的矩阵AＭ*Ｎ=(aｉｊ)(i=1,...,M;j=1,...,N)	由M * N个三元组<a, i, j>构成，
 * 				其中a是矩阵元素值，i是所在行号，j是元素所在的列号。
 * 操作集：		对于任意矩阵A,B,C ∈ Matrix，以及整数i,j,m,n
 * Matrix create(int M, int N):返回一个M * N的空矩阵；
 * int getMaxRow(Matrix A):返回总行数
 * int getMaxCol(Matrix A)：返回总列数
 * ElementType getEntry(Matrix A, int i, int j):返回矩阵A的第i行，第j列的元素；
 * Matrix Add(Matrix A, Matrix B):矩阵相加，确保矩阵同型
 * Matrix Multiply(Matrix A, Matrix B):矩阵相乘，确保ColA = RowB，ColB = RowA
 * 
 * @author ShaQuan
 */
public abstract class Matrix<T> {
	int M;
	int N;
	T[][] a;
	
	abstract Matrix<T> create(int M, int N);
	abstract int getMaxRow();
	abstract int getMaxCol();
	abstract T getEntry(int i, int j);
	abstract Matrix<T> Add(Matrix<T> b);
	abstract Matrix<T> Multiply(Matrix<T> b);
}
