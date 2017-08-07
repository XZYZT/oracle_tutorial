package oracle.javase.tutorial.collections.implementations;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

/**
 * Java Collection Framework implementations
 * http://docs.oracle.com/javase/tutorial/collections/implementations/index.html
 * @author ShaQuan
 *
 */
public class FileList {
	
	public static List<String> readLine(String path){
		File file = new File(path);
		List<String> fileList = new ArrayList<String>((int)file.length());
		BufferedReader reader = null;
		try {
            reader = new BufferedReader(new FileReader(file));
            for (String line = reader.readLine(); line != null;
        		line = reader.readLine()) {
                fileList.add(line);
            }
        } catch (IOException e) {
            System.err.format("Could not read %s: %s%n You can try again.", file, e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {}
            }
        }
		return fileList;
	}
	
	public static void randomReadLine(String path, int repeats){
		final int assumedLineLength = 50;
        File file = new File(path);
        List<String> fileList = 
            new ArrayList<String>((int)(file.length() / assumedLineLength) * 2);
        BufferedReader reader = null;
        int lineCount = 1;
        try {
            reader = new BufferedReader(new FileReader(file));
            for (String line = reader.readLine(); line != null;
                    line = reader.readLine()) {
                fileList.add(line);
                lineCount++;
            }
        } catch (IOException e) {
            System.err.format("Could not read %s: %s%n You can try again.", file, e);
            randomReadLine(path, repeats);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {}
            }
        }
        
        Random random = new Random();
        for (int i = 0; i < repeats; i++) {
        	int randomLineCount = random.nextInt(lineCount);
            System.out.format("randomLineCount:%d  %d: %s%n", randomLineCount, i,
                    fileList.get(randomLineCount - 1));
        }
	}
	
	public static String read(String fileName) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new FileReader(
				new File(fileName).getAbsoluteFile()));
		String s;
		while((s = in.readLine()) != null){
			sb.append(s);
			sb.append("\n");
		}
		in.close();
		return sb.toString();
	}
	
	public static String path = "C:/Users/ShaQuan/Desktop/JDBCTutorial/build.xml";
	public static void main(String[] args) throws IOException {
//		randomReadLine(path, 2);
//		List<String> fileList = readLine(path);
//		System.out.println(listToString(fileList));
		
		String fileContent = read(path);
		
		System.out.println(fileContent);
		
	}
	public static String listToString(List<String> list){
		return list.stream().collect(Collectors.joining("\n"));
	}
}

