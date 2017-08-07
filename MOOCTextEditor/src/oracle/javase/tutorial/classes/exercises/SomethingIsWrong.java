package oracle.javase.tutorial.classes.exercises;

import oracle.javase.tutorial.classes.Rectangle;


public class SomethingIsWrong {
	public static void main(String[] args) {
        Rectangle myRect = new Rectangle();
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.getArea());
    }
}
