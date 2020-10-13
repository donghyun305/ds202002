import java.util.Scanner;

class Stack<E>{
	E[] data;
	int top;
	Stack(){
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

public class Q2_2{	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack();	
		
		int n = sc.nextInt();
		
		for(int j=1; j<=n; j++) {
			int num = sc.nextInt();
			int [] arr = new int[num];
			if(j==1) {
				for(int i=1;i<=num;i++) {
					stack.push(i);									
				}
				int a = stack.top();				
				stack.pop();				
			}
			
			else {
				if(stack.top() < num){
					
				}
				else if(stack.top()==num){
					stack.pop();
				}
			}
		}	
}
}


