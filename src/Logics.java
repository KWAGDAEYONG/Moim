
public class Logics {
	
	public static String getter(String num){
		
		if(num.isEmpty()){
			return "0";
		}
		if(num.contains(",|:")){
			return num;
		}
		
		return num;
	}
	
	public static String[] spliter(String num){
		String [] ele = num.split(",|:");
		
		return ele;
	}
	
	public static int[] caster(String[] ele){
		int [] casted = new int [ele.length];
		for(int i = 0; i<ele.length; i++){
			casted[i] = Integer.parseInt(ele[i]);
			minChecker(casted[i]);
		}
		return casted;
	}
	
	public static int adder(int[]casted){
		int result = 0;
		for(int i = 0; i<casted.length; i++){
			result += casted[i];
		}
		return result;
	}
	
	public static void minChecker(int num){
		if(num<0){
			throw new RuntimeException();
		}
	}
}
