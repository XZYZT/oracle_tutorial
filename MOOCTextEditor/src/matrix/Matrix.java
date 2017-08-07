package matrix;
/**
 * �������ƣ�		����(Matrix)
 * ���ݶ��󼯣�	һ��M * N�ľ���A��*��=(a���)(i=1,...,M;j=1,...,N)	��M * N����Ԫ��<a, i, j>���ɣ�
 * 				����a�Ǿ���Ԫ��ֵ��i�������кţ�j��Ԫ�����ڵ��кš�
 * ��������		�����������A,B,C �� Matrix���Լ�����i,j,m,n
 * Matrix create(int M, int N):����һ��M * N�Ŀվ���
 * int getMaxRow(Matrix A):����������
 * int getMaxCol(Matrix A)������������
 * ElementType getEntry(Matrix A, int i, int j):���ؾ���A�ĵ�i�У���j�е�Ԫ�أ�
 * Matrix Add(Matrix A, Matrix B):������ӣ�ȷ������ͬ��
 * Matrix Multiply(Matrix A, Matrix B):������ˣ�ȷ��ColA = RowB��ColB = RowA
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
