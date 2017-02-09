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
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.����");
			System.out.println("---------------------------------------");
			System.out.println("����>");

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
				System.out.println("�����մϴ�.");
				run = false;
				break;
			}

		}
	}

	private static void out() {
		String tempAno = "";
		int outputMoney = 0;
		System.out.println("����� ���¹�ȣ�� �Է��ϼ���");
		tempAno = scanner.next();
		System.out.println("�󸶳� ����Ͻðڽ��ϱ�?");
		outputMoney = scanner.nextInt();

		if (findAccount(tempAno).getBalance() - outputMoney < 0) {
			System.out.println("�ܾ��� �����մϴ�.");
		} else {
			findAccount(tempAno).setBalance(findAccount(tempAno).getBalance() - outputMoney);
		}
		System.out.println(findAccount(tempAno).getOwner() + " ���� �����ܾ� : "+ findAccount(tempAno).getBalance());

	}

	private static void save() {
		String tempAno = "";
		int inputMoney = 0;
		System.out.println("�Ա��� ���¹�ȣ�� �Է��ϼ���");
		tempAno = scanner.next();
		System.out.println("�󸶳� �Ա��Ͻðڽ��ϱ�?");

		inputMoney = scanner.nextInt();
		findAccount(tempAno).setBalance(findAccount(tempAno).getBalance() + inputMoney);

		System.out.println(findAccount(tempAno).getOwner() + " ���� �����ܾ� : " + findAccount(tempAno).getBalance());

	}

	private static void showAccountList() {
		for (int i = 0; i < k; i++) {
			System.out.println("���¹�ȣ : " + accountArray[i].getAno());
			System.out.println("�̸� : " + accountArray[i].getOwner());
			System.out.println("�ܾ� : " + accountArray[i].getBalance());
			System.out.println("==========================================");
		}
	}

	private static void createAccount() {
		String tempName;
		int tempAno;
		String finalAno = "";

		System.out.println("�̸��� �Է��ϼ���");
		tempName = scanner.next();
		System.out.println("���¹�ȣ�� �߱��մϴ�.");
		for (int i = 0; i < 3; i++) {
			tempAno = (int) (Math.random() * 10);
			if (i < 2) {
				finalAno += tempAno + "-";
			}
			finalAno += tempAno + "";
		}
		accountArray[k] = new Account(finalAno, tempName, 0);

		System.out.println("���°� �����Ǿ����ϴ�. ������ ������ �����ϴ�.");
		System.out.println("���¹�ȣ : " + accountArray[k].getAno());
		System.out.println("�̸� : " + accountArray[k].getOwner());
		System.out.println("�ܾ� : " + accountArray[k].getBalance());

		k++;
	}

	private static Account findAccount(String ano) {
		for (int i = 0; i < k; i++) {
			if (ano.equals(accountArray[i].getAno())) {
				return accountArray[i];
			} else {
				System.out.println("�ش� ���°� �����ϴ�.");
			}
		}
		return accountArray[0];
	}
}
