package oracle.javase.tutorial.datetime.iso.date;

public class TwoDFormat {
	/**
	 * 数据列数
	 */
	int numberOfColumns = 0;
	/**
	 * 数据行数
	 */
	int numberOfRows = 0;
	int[] colMaxSize;
	String[][] value;
	
	public TwoDFormat(String[]...value) {
		if(value.length <= 0){
			System.err.println("No value!");
			return;
		}
		this.value = value;
		this.numberOfRows = value.length;
		this.numberOfColumns = value[0].length;
		this.colMaxSize = new int[numberOfColumns];
		getColMaxSize();
	}
	
	private transient int maxRowLength = 0;
	private void getColMaxSize(){
		for(int x = 0; x < this.numberOfColumns; x ++){
			for(int y = 0; y < numberOfRows; y ++){
				String col = this.value[y][x];
				int fieldLength = col.length();
				if(fieldLength > maxRowLength)
					this.maxRowLength = fieldLength;
			}
			colMaxSize[x] = maxRowLength + 2;
		}
	}
	
	public String format(){
		StringBuilder out = new StringBuilder();
		for(int x = 0; x < numberOfRows; x ++){
			for(int y = 0; y < numberOfColumns; y ++){
				String s = this.value[x][y];
				out.append(String.format("%" + colMaxSize[y] + "s", s));
			}
			out.append("\n");
		}
		return out.toString();
	}
	
	
	public static void main(String[] args) {
		String[][] value = new String[][]{{"x", "y"}, {"xxx", "yy"}, {"ssdx", "yddddd"}};
		
		TwoDFormat sf = new TwoDFormat(value);
		String s = sf.format();
		System.out.println(s);
		
		System.out.println(System.currentTimeMillis() / 1000 / 60 / 60 / 24 / 365 + 1970);
	}
}
