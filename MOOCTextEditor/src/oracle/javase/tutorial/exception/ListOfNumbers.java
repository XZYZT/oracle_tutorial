package oracle.javase.tutorial.exception;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.oracle.tutorial.jdbc.JDBCTutorialUtilities;

public class ListOfNumbers {
    private static final int SIZE = 10;
    private Vector<Number> vector;
    public ListOfNumbers () {
        vector = new Vector<Number>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            vector.add(new Integer(i));
        }
        this.readList("grader_output/module1.part2.out");
        this.writeList();
    }
    
    private RandomAccessFile raf;
    public void readList(String fileName){
    	String line = null;
    	try {
			raf = new RandomAccessFile(fileName, "r");
			while((line = raf.readLine()) != null && line.length() != 0){
				Number i = new Double(Double.parseDouble(line));
                System.out.println(i);
                vector.addElement(i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + " not found.");
		} catch (IOException io) {
			System.out.println(io.toString());
		}
    }

    public void writeList() {
        PrintWriter out = null;
		try{
			System.out.println("Entering try statement");
			out = new PrintWriter(new FileWriter("oracle_tutorial/writeList.txt"));
			for (int i = 0; i < vector.size(); i++) 
	            out.println("Value at: " + i + " = " + vector.get(i));
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());
		} finally {
			if(out != null){
				System.out.println("Closing PrintWriter");
				out.close();
			} else {
				System.out.println("PrintWriter not open");
			}
		}
    }
    
    
    public static void cat(File file) {
        RandomAccessFile input = null;
        String line = null;

        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
            if (input != null) {
                try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
    }
    
    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
    
    static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			return br.readLine();
		} finally {
			if (br != null) br.close();
		}
	}
    public static void writeToFileZipFileContents(String zipFileName, 
    		String outputFileName) throws IOException{
        Charset charset = StandardCharsets.US_ASCII;
	    Path outputFilePath = Paths.get(outputFileName);
	    
	    try (ZipFile zf = new ZipFile(zipFileName);
	        BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset)){
	        // Enumerate each entry
	        for (Enumeration<? extends ZipEntry> entries = zf.entries(); entries.hasMoreElements();) {
	            // Get the entry name and write it to the output file
	            String newLine = System.getProperty("line.separator");
	            String zipEntryName =
	                 ((ZipEntry)entries.nextElement()).getName() + newLine;
	            writer.write(zipEntryName, 0, zipEntryName.length());
	        }
	    }
    }
    
    public static void viewTable(Connection con) throws SQLException {
        String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String coffeeName = rs.getString("COF_NAME");
                int supplierID = rs.getInt("SUP_ID");
                float price = rs.getFloat("PRICE");
                int sales = rs.getInt("SALES");
                int total = rs.getInt("TOTAL");

                System.out.println(coffeeName + ", " + supplierID + ", " + 
                                   price + ", " + sales + ", " + total);
            }
        } catch (SQLException e) {
            JDBCTutorialUtilities.printSQLException(e);
        }
    }

    public static void main(String[] args) throws IOException {
		writeToFileZipFileContents("E:/ShaQuan-PC/ÎÄµµ£¨E£º£©/Share/bak.doc/Doc - API/jdk-8u131-docs-all.zip", "oracle_tutorial/ZipFileContents.txt");
		ListOfNumbers lon = new ListOfNumbers();
	}
}
