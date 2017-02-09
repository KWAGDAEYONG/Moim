package Account;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	static int k = 0;

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("---------------------------------------");
			System.out.println("선택>");

			int selectNo = scanner.nextInt();

			switch (selectNo) {
			case 1:
				createAccount();
				break;
			case 2:
				showAccountList();
				break;
			case 3:
				save();
				break;
			case 4:
				out();
				break;
			case 5:
				System.out.println("종료합니다.");
				run = false;
				break;
			}

		}
	}

	private static void out() {
		String tempAno = "";
		int outputMoney = 0;
		System.out.println("출금할 계좌번호를 입력하세요");
		tempAno = scanner.next();
		System.out.println("얼마나 출금하시겠습니까?");
		outputMoney = scanner.nextInt();

		if (findAccount(tempAno).getBalance() - outputMoney < 0) {
			System.out.println("잔액이 부족합니다.");
		} else {
			findAccount(tempAno).setBalance(findAccount(tempAno).getBalance() - outputMoney);
		}
		System.out.println(findAccount(tempAno).getOwner() + " 님의 현재잔액 : "+ findAccount(tempAno).getBalance());

	}

	private static void save() {
		String tempAno = "";
		int inputMoney = 0;
		System.out.println("입금할 계좌번호를 입력하세요");
		tempAno = scanner.next();
		System.out.println("얼마나 입급하시겠습니까?");

		inputMoney = scanner.nextInt();
		findAccount(tempAno).setBalance(findAccount(tempAno).getBalance() + inputMoney);

		System.out.println(findAccount(tempAno).getOwner() + " 님의 현재잔액 : " + findAccount(tempAno).getBalance());

	}

	private static void showAccountList() {
		for (int i = 0; i < k; i++) {
			System.out.println("계좌번호 : " + accountArray[i].getAno());
			System.out.println("이름 : " + accountArray[i].getOwner());
			System.out.println("잔액 : " + accountArray[i].getBalance());
			System.out.println("==========================================");
		}
	}

	private static void createAccount() {
		String tempName;
		int tempAno;
		String finalAno = "";

		System.out.println("이름을 입력하세요");
		tempName = scanner.next();
		System.out.println("계좌번호를 발급합니다.");
		for (int i = 0; i < 3; i++) {
			tempAno = (int) (Math.random() * 10);
			if (i < 2) {
				finalAno += tempAno + "-";
			}
			finalAno += tempAno + "";
		}
		accountArray[k] = new Account(finalAno, tempName, 0);

		System.out.println("계좌가 생성되었습니다. 정보는 다음과 같습니다.");
		System.out.println("계좌번호 : " + accountArray[k].getAno());
		System.out.println("이름 : " + accountArray[k].getOwner());
		System.out.println("잔액 : " + accountArray[k].getBalance());

		k++;
	}

	private static Account findAccount(String ano) {
		for (int i = 0; i < k; i++) {
			if (ano.equals(accountArray[i].getAno())) {
				return accountArray[i];
			} else {
				System.out.println("해당 계좌가 없습니다.");
			}
		}
		return accountArray[0];
	}
}
