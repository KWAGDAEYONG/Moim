
public class MemberService {
	Member user1 = new Member("ȫ�浿", "hong");
	Member user2 = new Member("���ڹ�", "java");
	boolean isLogin = false;
	
	public boolean login(String id, String password){
		if(!id.equals("hong")||!password.equals("12345")){
			return isLogin;
		}
		isLogin = true;
		return  isLogin;
	}
	public void logout(String id){
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
	}
}
