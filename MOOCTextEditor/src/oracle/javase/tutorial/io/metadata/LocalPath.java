package oracle.javase.tutorial.io.metadata;

import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * 获取本地文件路径
 * @author ShaQuan
 *
 */
public enum LocalPath {
	DESPTOP_A("C:/Users/ShaQuan/Desktop/a/"),
	DESPTOP_B("C:/Users/ShaQuan/Desktop/b/"),
	DESPTOP_C("C:/Users/ShaQuan/Desktop/c/"),
	DESPTOP_D("C:/Users/ShaQuan/Desktop/d/"),
	DESPTOP_E("C:/Users/ShaQuan/Desktop/e/"),
	DESPTOP_A_FILE("C:/Users/ShaQuan/Desktop/a/a.txt"),
	DESPTOP_B_FILE("C:/Users/ShaQuan/Desktop/a/b.txt"),
	E_MYDIR("E:/MyDir"),
	USER_DIR(getUserDir());
	
	private String path;
	LocalPath(String path){
		this.path = path;
	}
	
	public String getPath(){ return path; }
	public Path path(){
		return Paths.get(path);
	}
	
	public static String getUserDir(){
		return System.getProperty("user.dir");
	}
	
	public static void main(String[] args) {
		System.out.println(DESPTOP_A.getPath());
	}
}
