import java.util.Scanner;

class Queue1<E>{	
	int front; // 큐의 맨 앞의 값 인덱스(데이터를읽을위치)
	int real; // 큐의 맨 뒤의 값 인덱스(데이터가 추가될 위치)
	E[] data; // 큐의 데이터가 들어갈 공간
	int size;
 	Queue1(){
 		// 1. 배열의 인덱스를 가르키는 두 변수의 값을 0으로초기화 시켜준다. 
 		front=0;
 		real=0;
 		size=1000;
 		// 2. 배열을 1000개 할당한다. 
 		data = (E[])new Object[size]; 		
 	} 
 	// 큐에데이터를 추가하는 과정
	public void add(E v) {
		// 1.real에 해당하는 배열 공간에 v값을 넣는다.
		data[real] = v;
		// 2.real값을 1 증가한다. 
		// 이때 % 연산자를 이용해서 배욜 인덱스가 오버플로우되지 않게 한다. 
	    real = (real+1)%size;
	}
	// 큐에서데이터를 삭제하는 함수
	public void remove() {
		// 1. front에 해당하는 배열 공간에 null값을 넣는다. 
		data[front] = null;
		// 2. front값을 1 증가시키낟.
		//real 값 증가대와 마찬가지로 % 연산자를 사용한다. 
		front = (front+1)%size;
	}
	// 큐에서 데이터를읽는 함수
	public E peek() {
		return data[front];
	}
	//큐가 비어있으면 true, 비어있지 ㅇ낳으면 false를 반환한다. 
	public boolean empty() {
		//1. front와 rear값이 같으면 배열이 비어있다는 의미.
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
		System.out.print("실행할 명령의 수 : ");
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
