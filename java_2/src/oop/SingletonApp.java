package oop;

public class SingletonApp {
	public static void main(String[] args) {
		//new로 생성자를 객체로 호출x
		//Singleton singleton1=new Singleton();
		//Singleton singleton2=new Singleton();
		Singleton singleton1 =Singleton.getInstance();
		Singleton singleton2 =Singleton.getInstance();
		
		System.out.println("singleton1 = "+singleton1);
		System.out.println("singleton2 = "+singleton2);
		
		singleton1.display();
		singleton2.display();
		System.out.println("===================================");
		Singleton.getInstance().display();
		Singleton.getInstance().display();
		
	}
}
