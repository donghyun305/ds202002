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
		//2. top에 해당하는 배열에 v 값을 저장한다.
		data[top] = v;
		System.out.println("+");
	}
	public void push1(E v) {
		top ++; //top = top+1;		
		//2. top에 해당하는 배열에 v 값을 저장한다.
		data[top] = v;		
	}
	public void pop() {
		//0. 만약 기존에 저장된 ㄷ밧을 버려야겠다고 생각한다면, 해당 배열값을 null로 바꿔주면 된다 .
		//null을 저장해주면, 해당 데이터를 삭제하는 것과 같다. 
		data[top]=null;
		//1. top값을 1 감소시킨다.
		top--;	
		System.out.println("-");
	}
	public E top() {
		//1. top가 가르키는 배열값을 반환시킵니다. 
		return data[top];		
	}
	public boolean empty() {
		//1. top가 초기값인 -1이면 스택은 비어있습니다. 
		return top==-1;//==는 값이 같은가? 라고 묻는것임
	}
	public int size() {
		//1. 비어이쓸 때 top는 -1이므로 1 증가시켜서 반환해야한다. 
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


