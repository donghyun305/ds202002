import java.util.Scanner;
import java.util.Random;

class Stack<E> {
    E[] data;
	int top;
	
	Stack(){		 
		data = (E[]) new Object[1000];
		top = -1;
	}
	public void push(E v) {		
		top++;		 
		data[top] = v;
	}
	public void pop() {
        data[top] = null;
		top--;
	}
	public E top() {
		return data[top];
	}
	public boolean empty() {
		return top ==-1;
	}
	public int size() {		 
		return top+1;		
	}
}

class Queue<E>{	
	int front; // ť�� �� ���� �� �ε���(�����͸�������ġ)
	int real; // ť�� �� ���� �� �ε���(�����Ͱ� �߰��� ��ġ)
	E[] data; // ť�� �����Ͱ� �� ����
	int size;
 	Queue(){
 		// 1. �迭�� �ε����� ����Ű�� �� ������ ���� 0�����ʱ�ȭ �����ش�. 
 		front=0;
 		real=0;
 		size=1000;
 		// 2. �迭�� 1000�� �Ҵ��Ѵ�. 
 		data = (E[])new Object[size]; 		
 	} 
 	// ť�������͸� �߰��ϴ� ����
	public void add(E v) {
		// 1.real�� �ش��ϴ� �迭 ������ v���� �ִ´�.
		data[real] = v;
		// 2.real���� 1 �����Ѵ�. 
		// �̶� % �����ڸ� �̿��ؼ� ��� �ε����� �����÷ο���� �ʰ� �Ѵ�. 
	    real = (real+1)%size;
	}
	// ť���������͸� �����ϴ� �Լ�
	public void remove() {
		// 1. front�� �ش��ϴ� �迭 ������ null���� �ִ´�. 
		data[front] = null;
		// 2. front���� 1 ������Ű��.
		//real �� ������� ���������� % �����ڸ� ����Ѵ�. 
		front = (front+1)%size;
	}
	// ť���� �����͸��д� �Լ�
	public E peek() {
		return data[front];
	}
	//ť�� ��������� true, ������� �������� false�� ��ȯ�Ѵ�. 
	public boolean empty() {
		//1. front�� rear���� ������ �迭�� ����ִٴ� �ǹ�.
		return front==real;
	}
	public int size() {
		int s = real - front;
		//if(s>=0) return s;
		//return s+size;
		return (real-front+size)%size;
	}
}

public class Main {
	public static void main (String args[]) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� ���� �Է��Ͻÿ�");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]  = random.nextInt(10000);
			System.out.println(arr[i]);
		}
		Queue<Integer> queue= new Queue();
		for (int i=0; i<n; i++) {
			queue.add(arr[i]);
		}
		
		Stack<Integer> stack = new Stack();		
		/*while(stack.size()==0 || queue.peek()<stack.top()) {
			stack.push(queue.peek());
			queue.remove();
			if (queue.size()==0 || queue.peek() > stack.top()) {break;}
		}
		while(queue.peek() > stack.top()) {
			queue.add(stack.top());
			stack.pop();
			stack.push(queue.peek());
			if(queue.size()==0) {break;}
		}*/
		
		/*while(queue.size()!=0) {
			while(stack.size()!=0 && queue.peek()>stack.top()) {
				queue.add(stack.top());
				stack.pop();				
			}
			while(queue.peek()<stack.top() || stack.size()==0) {
				stack.push(queue.peek());
				queue.remove();				
			}			
		}*/
		
		while(queue.size()!=0) {
			if(stack.size()==0) {
				stack.push(queue.peek());
				queue.remove();
			}
			else if(queue.peek()<stack.top()) {
				queue.add(stack.top());
				stack.pop();
			}
			else if (stack.size()!=0 && queue.peek()>stack.top()) {
				stack.push(queue.peek());
				queue.remove();	
			}			
		} 
		System.out.println(" ");
		System.out.println("���ĵ� ������ ��");
		for (int i=0; i<n; i++) {			
				System.out.println(stack.top());
				stack.pop();			
		}
		
				
	}
}
