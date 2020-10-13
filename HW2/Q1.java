import java.util.Scanner;

public class Q1 {
	// 문자열이 쌍이 올바르면 true를 그렇지 않으면 false를 반환한다.
	public static boolean isValid(String pp) {
		// 스택을 간단 버전으로 구현하자. 
		char[] stack = new char[1024];
		int top = -1;		
		//모든 글자들을 돌아다니면서, 스택과 처리를 한다. 
		for(int i=0; i<pp.length(); i++) {
			// 1. 문자를 하나 읽는다 .
			char ch = pp.charAt(i);
			// 2. 해당 문자가 괄호 열기에 해당한다면, 스텍에 해당 문자를 넣습니다. 
			if (ch=='(') {
				//top++;
				//stack[top]=ch;와 같은 내용임
				stack[++top] = ch;
			}
			// 3. 해당 문자가 괄호 닫기에 해당하면 스택의 가장위의 것과 비교한다. 
			else if(ch==')') {
				//만약 스택이 비어있거나 (top=-1)
				//스택의 최상위 아이템이 괄호열기가 아니라면 false를 반환
				if(top==-1 || stack[top] !='(') return false;
				// pop을 수행한다. 이미 스텍이 비어 있는지 검사는 위해서 실행했기 때문에
				top--;
			}			
		}
		// 모든 문자를 다 처리하고 나서 스택이 비어있다면, true, 아니면 false를 반환해야한다. 
		return top == -1; //top가 -1인가를 묻는 거임.
	}
	
	
	public static void main(String[] args) {
		// TODO 
		// 스텍을 구현하고, 괄호쌍 검사를 받아서 처리하도록 한다. 
		Scanner scan = new Scanner(System.in);
		// 문자열의 갯수를 입력받습니다. 
		int n = scan.nextInt();
		
		//for 루프를 돌면서 괄호쌍입력을 받고 결과를 출력한다. 
		for (int i=1; i<=n; i++) {
			String pp = scan.next();		
		// 괄호쌍 입력을 받는다. 		
		// isValid()가 참이면 Yes를 거짓이면 No를 출력하게 만든다. 
		    if(isValid(pp)) System.out.println("Yes");
		    else System.out.println("No");		
	}

}
}
