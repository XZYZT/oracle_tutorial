package oracle.javase.tutorial.datetime.iso.date;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.junit.Test;
/**
 * 执行其它操作系统的程序
 * @author ShaQuan
 *
 */
public class OSExecute {
	public static void command(String command){
		boolean havaError = false;
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();
			BufferedReader results = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			String s;
			while((s = results.readLine()) != null){
				System.out.println(s);
			}
			BufferedReader havaErrorors = new BufferedReader(
					new InputStreamReader(process.getErrorStream()));
			while((s = havaErrorors.readLine()) != null){
				System.out.println(s);
				havaError = true;
			}
		} catch (Exception e) {
			if(command.startsWith("CMD /C")){
				command("CMD /C" + command);
			}else{
				throw new RuntimeException(e);
			}
		}
//		if(havaError){
//			throw new OSExecuteException("Errors executing " + command);
//		}
	}
	public static void command(String path, String...command){
		boolean havaError = false;
		try {
			Process process = new ProcessBuilder(command).directory(new File(path)).start();
			BufferedReader results = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			String s;
			while((s = results.readLine()) != null){
				System.out.println(s);
			}
			BufferedReader havaErrorors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while((s = havaErrorors.readLine()) != null){
				System.out.println(s);
				havaError = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
