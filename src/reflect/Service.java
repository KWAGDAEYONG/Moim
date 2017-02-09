package reflect;

public class Service {
	
	@PrintAnnotation
	public void method1(){
		System.out.println("11");
	}
	@PrintAnnotation("*")
	public void method2(){
		System.out.println("22");
	}
	@PrintAnnotation(value="#", number=20)
	public void method3(){
		System.out.println("33");
	}
	
	
}
