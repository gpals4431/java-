package oop;


public class RuntimeApp {
	public static void main(String[] args) {
		//Runtime runtime = new Runtime();
		//Runtime.getRuntime() : runtime 객체를 반환하는 메소드
		// => 정적 메소드이므로 클래스를 이용해 호출 가능
		// => getRuntime() 메소드를 여러번 호출해도 같은 객체를 반환
		Runtime runtime1=Runtime.getRuntime();
		Runtime runtime2=Runtime.getRuntime();
		
		System.out.println("runtime1 = "+runtime1);
		System.out.println("runtime2 = "+runtime2);
		System.out.println("================================================");
		System.out.println("메모리를 정리하기 전 JVM사용 메모리의 크기 >>");
		System.out.println(runtime1.totalMemory()-runtime1.freeMemory()+"Byte");
		
		//runtime1.gc : 메모리를 정리하는 가비지 컬렉터를 실행하는 메소드
		
		runtime1.gc();//System.gc();
		System.out.println("메모리를 정리한 후 JVM사용 메모리의 크기 >>");
		System.out.println(runtime1.totalMemory()-runtime1.freeMemory()+"Byte");
		
		
		}
}
