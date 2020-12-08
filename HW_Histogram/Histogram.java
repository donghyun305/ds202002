// ���������� �̿��Ͽ� ������׷����� ���� ū ������ ���簢�� ���� ���ϱ�
// �Է�
// ó���� ������׷��� ���� ���� N�� �Է� �ȴ�. 
// ������ �� ���õ��� �������� N�� �Էµȴ�.
// ���� ��� (3,2,6,7)�� ������ ������ 4���� ������ �ִ� ������׷���
// 4 3 2 6 7 
// �� �Է��� �־�����. 
// �̿� ���� �亯�� ���簢���� ���̷� ����ϸ� �ȴ�. 
// ex) 12
import java.util.Scanner;
public class Histogram {
	// ���� ������ ���� �Լ�
	// �迭 v���� ���� (a,b) �������� �ִ� ũ���� ���簢�� ���� ��ȯ
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
	// ������׷����� �ִ��� ���簢�� ���̸� ����ؼ� ����ϴ� �Լ�
	// v : ������׷��� ���õ��� �������� �迭 (0 �̻��� �ڿ���)
	// n : ���õ��� ���� 
	static int histo(int[] v, int n) {	
		// v[0,,,n-1] ������ ���̸� ���ؼ� �װ��� ��ȯ�Ѵ�. 
		return histo(v,0,n-1);
	}
	
	public static void main (String args[]) {
		// �Է��� ���ؼ� ��ĳ�� ������Ʈ �������ֱ�
		Scanner sc = new Scanner(System.in);
		
		// ���� ���� n�� �Է�
		int n = sc.nextInt();
		
		// n���� ������ ���� �迭 ����
		int [] v = new int[n];
		
		// n���� �迭 ������ �ԷµǴ� ���� �־��ش�. 
		for (int i=0; i<n; i++) {
			v[i] = sc.nextInt();
		}
		
		// histogram() �Լ��� ȣ���ؼ� �� ��� ����
		int r = histo(v,n);
		
		//��� ���
		System.out.println(r);		
	}

}
