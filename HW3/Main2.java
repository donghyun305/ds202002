import java.util.Scanner;

class Queue1<E>{	
	int front; // ť�� �� ���� �� �ε���(�����͸�������ġ)
	int real; // ť�� �� ���� �� �ε���(�����Ͱ� �߰��� ��ġ)
	E[] data; // ť�� �����Ͱ� �� ����
	int size;
 	Queue1(){
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
	public E back() {
		return data[size()-1];
	}
	public int size() {
		int s = real - front;
		//if(s>=0) return s;
		//return s+size;
		return (real-front+size)%size;
	}
}

public class Main2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Queue1<Integer> queue= new Queue1();
		System.out.print("������ ����� �� : ");
		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			String a = sc.next();
			if (a.equals("push")) {
				queue.add(sc.nextInt());
			}
			else if(a.equals("pop")) {				
				if(queue.size()==0) {
					System.out.println("-1");
				}
				else {
					System.out.println(queue.peek());
					queue.remove();
				}				
			}
			else if(a.equals("size")) {
				System.out.println(queue.size());
			}
			else if (a.equals("empty")) {
				if(queue.empty()) {
					System.out.println("1");
				}
				else System.out.println("0");
			}
			else if(a.equals("front")) {
				System.out.println(queue.peek());
				if(queue.size()==0) {
					System.out.println("-1");
				}
			}
			else if(a.equals("back")) {
				System.out.println(queue.back());
				if(queue.size()==0) {
					System.out.println("-1");
				}
			}
			
		}
		
		
	}
}
