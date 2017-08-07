package oracle.javase.tutorial.classes.nested;

public class ShadowTest {
	public int x = 0;
	class FirsetLevel{
		public int x = 1;
		void methodInFirstLevel(int x){
			System.out.println("x = " + x);
			System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
		}
	}
	public static void main(String[] args) {
		ShadowTest st = new ShadowTest();
		ShadowTest.FirsetLevel fl = st.new FirsetLevel();
		fl.methodInFirstLevel(23);
	}
}
