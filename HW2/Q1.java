import java.util.Scanner;

public class Q1 {
	// ���ڿ��� ���� �ùٸ��� true�� �׷��� ������ false�� ��ȯ�Ѵ�.
	public static boolean isValid(String pp) {
		// ������ ���� �������� ��������. 
		char[] stack = new char[1024];
		int top = -1;		
		//��� ���ڵ��� ���ƴٴϸ鼭, ���ð� ó���� �Ѵ�. 
		for(int i=0; i<pp.length(); i++) {
			// 1. ���ڸ� �ϳ� �д´� .
			char ch = pp.charAt(i);
			// 2. �ش� ���ڰ� ��ȣ ���⿡ �ش��Ѵٸ�, ���ؿ� �ش� ���ڸ� �ֽ��ϴ�. 
			if (ch=='(') {
				//top++;
				//stack[top]=ch;�� ���� ������
				stack[++top] = ch;
			}
			// 3. �ش� ���ڰ� ��ȣ �ݱ⿡ �ش��ϸ� ������ �������� �Ͱ� ���Ѵ�. 
			else if(ch==')') {
				//���� ������ ����ְų� (top=-1)
				//������ �ֻ��� �������� ��ȣ���Ⱑ �ƴ϶�� false�� ��ȯ
				if(top==-1 || stack[top] !='(') return false;
				// pop�� �����Ѵ�. �̹� ������ ��� �ִ��� �˻�� ���ؼ� �����߱� ������
				top--;
			}			
		}
		// ��� ���ڸ� �� ó���ϰ� ���� ������ ����ִٸ�, true, �ƴϸ� false�� ��ȯ�ؾ��Ѵ�. 
		return top == -1; //top�� -1�ΰ��� ���� ����.
	}
	
	
	public static void main(String[] args) {
		// TODO 
		// ������ �����ϰ�, ��ȣ�� �˻縦 �޾Ƽ� ó���ϵ��� �Ѵ�. 
		Scanner scan = new Scanner(System.in);
		// ���ڿ��� ������ �Է¹޽��ϴ�. 
		int n = scan.nextInt();
		
		//for ������ ���鼭 ��ȣ���Է��� �ް� ����� ����Ѵ�. 
		for (int i=1; i<=n; i++) {
			String pp = scan.next();		
		// ��ȣ�� �Է��� �޴´�. 		
		// isValid()�� ���̸� Yes�� �����̸� No�� ����ϰ� �����. 
		    if(isValid(pp)) System.out.println("Yes");
		    else System.out.println("No");		
	}

}
}
