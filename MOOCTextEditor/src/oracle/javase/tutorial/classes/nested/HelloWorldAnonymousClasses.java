package oracle.javase.tutorial.classes.nested;

public class HelloWorldAnonymousClasses {
	interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }
	public void sayHello(){
		class EnglishGreeting implements HelloWorld{
			String name = "world";
			public void greet() {
				greetSomeone("sha quan");
			}
			@Override
			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hello " + name);
			}
		}//end EnglishGreeting class
		
		HelloWorld englishGreeting = new EnglishGreeting();
		
		HelloWorld frenchGreeting = new HelloWorld() {
			String name = "tout le monde";
			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Salut " + name);
			}
			
			@Override
			public void greet() {
				greetSomeone("tout le monde");
			}
		};//end frenchGreeting
		
		HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };//end spanishGreeting
        
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
	}//end sayHello()
	
	public static void main(String[] args) {
		HelloWorldAnonymousClasses myApp =
	            new HelloWorldAnonymousClasses();
       	myApp.sayHello();
	}
	
	public static void launch(String[] args){
		main(args);
	}
}
