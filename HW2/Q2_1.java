import java.util.Scanner;

class Stack1<E>{
	E[] data;
	int top;
	Stack1(){
		data = (E[]) new Object[1024];
		top = -1;
	}
	public void push(E v) {
		top ++; //top = top+1;		
		//2. top�� �ش��ϴ� �迭�� v ���� �����Ѵ�.
		data[top] = v;
		System.out.println("+");
	}
	public void push1(E v) {
		top ++; //top = top+1;		
		//2. top�� �ش��ϴ� �迭�� v ���� �����Ѵ�.
		data[top] = v;		
	}
	public void pop() {
		//0. ���� ������ ����� ������ �����߰ڴٰ� �����Ѵٸ�, �ش� �迭���� null�� �ٲ��ָ� �ȴ� .
		//null�� �������ָ�, �ش� �����͸� �����ϴ� �Ͱ� ����. 
		data[top]=null;
		//1. top���� 1 ���ҽ�Ų��.
		top--;	
		System.out.println("-");
	}
	public void pop1() {
		//0. ���� ������ ����� ������ �����߰ڴٰ� �����Ѵٸ�, �ش� �迭���� null�� �ٲ��ָ� �ȴ� .
		//null�� �������ָ�, �ش� �����͸� �����ϴ� �Ͱ� ����. 
		data[top]=null;
		//1. top���� 1 ���ҽ�Ų��.
		top--;			
	}
	public E top() {
		//1. top�� ����Ű�� �迭���� ��ȯ��ŵ�ϴ�. 
		return data[top];		
	}
	public boolean empty() {
		//1. top�� �ʱⰪ�� -1�̸� ������ ����ֽ��ϴ�. 
		return top==-1;//==�� ���� ������? ��� ���°���
	}
	public int size() {
		//1. ����̾� �� top�� -1�̹Ƿ� 1 �������Ѽ� ��ȯ�ؾ��Ѵ�. 
		return top+1;
	}
	
}

public class Q2_1{	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		Stack1<Integer> stack = new Stack1();
		Stack1<Integer> arr = new Stack1();
		
		
		int n = sc.nextInt();				
		for (int i=1; i<=n; i++) {
			arr.push1(i);
		}
		if(arr.empty()) System.out.println("No");
		else {
			for(int j=1; j<=n; j++) {			
				int n1 = sc.nextInt();
				for(int i=1; i<=n1; i++) {				
					stack.push(n1);
					arr.pop1();
				}			
				stack.pop();
			}
			
		}
		
		
					
			
			
}
}


