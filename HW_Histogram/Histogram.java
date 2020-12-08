// 분할정복을 이용하여 히스토그램에서 가장 큰 넓이의 직사각형 넓이 구하기
// 입력
// 처음에 히스토그램의 샘플 갯수 N이 입력 된다. 
// 다음에 각 샘플들의 도수들이 N개 입력된다.
// 예를 들어 (3,2,6,7)의 도수를 가지는 4개의 샘플이 있는 히스토그램은
// 4 3 2 6 7 
// 로 입력이 주어진다. 
// 이에 대한 답변을 직사각형의 넓이로 출력하면 된다. 
// ex) 12
import java.util.Scanner;
public class Histogram {
	// 분할 정복을 위한 함수
	// 배열 v에서 범위 (a,b) 구간에서 최대 크기의 직사각형 넓이 반환
	static int histo(int[] v, int a, int b) {
		if(a==b) {
			return v[a]; 
		}
		int result;
		int c = (a+b)/2;
		int left = histo(v,a,c);
		int right = histo(v,c+1,b);
		result = max(left, right);		
		int i=c, j=c+1, min;
		min = min(v[i], v[j]);
		result = max(result, min*(j-i+1));
		while(i > a || j < b) {
			if(j < b && (i==a || v[i-1] < v[j+1])) {
				min = min(min, v[++j]);
			}
			else min = min(min, v[--i]);
			result = max(result, min*(j-i+1));
		}
		return result;				
	}
	static int max(int a, int b) {
		if (a>b) return a;
		else return b;
	}
	static int min(int a, int b) {
		if (a>b) return b;
		else return a;
	}
	// 히스토그램에서 최대의 직사각형 넓이를 계산해서 출력하는 함수
	// v : 히스토그램의 샘플들의 도수들의 배열 (0 이상의 자연수)
	// n : 샘플들의 개수 
	static int histo(int[] v, int n) {	
		// v[0,,,n-1] 구간의 넓이를 구해서 그값을 반환한다. 
		return histo(v,0,n-1);
	}
	
	public static void main (String args[]) {
		// 입력을 위해서 스캐너 오브젝트 생성해주기
		Scanner sc = new Scanner(System.in);
		
		// 샘플 개수 n을 입력
		int n = sc.nextInt();
		
		// n개의 공간을 갖는 배열 생성
		int [] v = new int[n];
		
		// n개의 배열 공간에 입력되는 값을 넣어준다. 
		for (int i=0; i<n; i++) {
			v[i] = sc.nextInt();
		}
		
		// histogram() 함수를 호출해서 그 결과 저장
		int r = histo(v,n);
		
		//결과 출력
		System.out.println(r);		
	}

}
