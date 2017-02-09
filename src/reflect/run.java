package reflect;

import java.lang.reflect.Method;

public class run {
	public static void main(String []args){
		
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		
		for(Method method:declaredMethods){
			if(method.isAnnotationPresent(PrintAnnotation.class)){
				PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
				
				System.out.println(method.getName());
				System.out.println(printAnnotation.value());
				System.out.println(printAnnotation.number());
				
			}
			
		}
	}
}
