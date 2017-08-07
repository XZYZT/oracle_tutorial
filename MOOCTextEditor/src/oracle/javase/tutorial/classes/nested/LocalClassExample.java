package oracle.javase.tutorial.classes.nested;

public class LocalClassExample {
	static String regularExpression = "[^0-9]";
	
	public static void validatePhoneNumber(
			String phoneNumber1, String phoneNumber2){
		final int numberLength = 10;
		
		class PhoneNumber{
			String formattedPhoneNumber = null;
			
			PhoneNumber(String phoneNumber) {
				String currentNumber = phoneNumber.replaceAll(regularExpression, "");
				if(currentNumber.length() == numberLength)
					formattedPhoneNumber = currentNumber;
				else
					formattedPhoneNumber = null;
			}
			
			public String getNumber(){
				return formattedPhoneNumber;
			}
			
			/**
			 * Starting in Java SE 8, if you declare the local class in a method, 
			 * it can access the method's parameters.
			 */
			@SuppressWarnings("unused")
			public void printOriginalNumbers(){
				System.out.println("Original numbers are " + phoneNumber1 + 
						" and " + phoneNumber2);
			}
		}//end inner PhoneNumber class
		
		PhoneNumber myNum1 = new PhoneNumber(phoneNumber1);
		PhoneNumber myNum2 = new PhoneNumber(phoneNumber2);
		
		if (myNum1.getNumber() == null) 
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + myNum1.getNumber());
        if (myNum2.getNumber() == null)
            System.out.println("Second number is invalid");
        else
            System.out.println("Second number is " + myNum2.getNumber());
	}//end validatePhoneNumber function
	
	interface HelloThere {
        public void greet();
	}
	
	public void greetInEnglish() {
        String name = System.getProperty("os.name");
        class EnglishHelloThere implements HelloThere {
            public void greet() {
                System.out.println("Hello " + name);
            }
        }
        HelloThere myGreeting = new EnglishHelloThere();
        myGreeting.greet();
    }
	
	public void sayGoodbyeInEnglish() {
        class EnglishGoodbye {
            public static final String farewell = "Bye bye";
            public void sayGoodbye() {
                System.out.println(farewell);
            }
        }
        EnglishGoodbye myEnglishGoodbye = new EnglishGoodbye();
        myEnglishGoodbye.sayGoodbye();
    }
	
	public static void main(String[] args) {
		validatePhoneNumber("123-456-7890", "456-7890");
	}
}
