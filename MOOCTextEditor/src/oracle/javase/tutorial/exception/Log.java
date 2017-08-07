package oracle.javase.tutorial.exception;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
	public static void main(String[] args){
		try {
			Handler handler = new FileHandler("oracle_tutorial/Log.log");
			Logger.getLogger("getLogger").addHandler(handler);
		} catch (Exception e){
			Logger logger = Logger.getLogger("package.name"); 
		    StackTraceElement elements[] = e.getStackTrace();
		    for (int i = 0, n = elements.length; i < n; i++) {
		        logger.log(Level.WARNING,elements[i].getMethodName() + elements[i].getMethodName());
		        logger.log(Level.WARNING,"isNativeMethod = " + elements[i].isNativeMethod());
		    }
		}
	}
	
	/**
	 * 
    What happens if the file can't be opened?
    What happens if the length of the file can't be determined?
    What happens if enough memory can't be allocated?
    What happens if the read fails?
    What happens if the file can't be closed?
	 * @return
	 */
	/*traditional error-management techniques*/
	int readFile() {
		int errorCode = 0;
		boolean theFileIsOpen = false, gotTheFileLength = false, gotEnoughMemory = false, 
				readFailed = false, theFileDidntClose = false;
		//open the file;
		if(theFileIsOpen){
			//determine the length if the file;
			if(gotTheFileLength){
				//allocate that much memory
				if(gotEnoughMemory){
					//read the file into memory
					if(readFailed){
						errorCode = -1;
					}
				}else{
					errorCode = -2;
				}
			}else{
				errorCode = -3;
			}
			//close the file
			if (theFileDidntClose && errorCode == 0) {
	            errorCode = -4;
	        } else {
	            errorCode = errorCode & -4;
	        }
		}else{
	        errorCode = -5;
	    }
		
		return errorCode;
	}
	/*java error-management techniques*/
	void readFile2(){
		try {
			openFile();
			determineFileSize();
			allocateMemory();
			readFileIntoMemory();
			closeFile();
	    } catch (fileOpenFailed e) {
//	       doSomething;
	    } catch (sizeDeterminationFailed e) {
//	        doSomething;
	    } catch (memoryAllocationFailed e) {
//	        doSomething;
	    } catch (readFailed e) {
//	        doSomething;
	    } catch (fileCloseFailed e) {
//	        doSomething;
	    }
	}
	
	public void openFile() throws fileOpenFailed{}
	public void determineFileSize() throws sizeDeterminationFailed{}
	public void allocateMemory() throws memoryAllocationFailed{}
	public void readFileIntoMemory() throws readFailed{}
	public void closeFile() throws fileCloseFailed{}
}
class ErrorCodeType{}
class fileOpenFailed extends Exception{}
class sizeDeterminationFailed extends Exception{}
class memoryAllocationFailed extends Exception{}
class readFailed extends Exception{}
class fileCloseFailed extends Exception{}

