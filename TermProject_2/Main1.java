import java.util.Random;
import java.util.Scanner;
public class Main1 {
	static void sort(int [] v, int n) {
		// �迭 v, ũ�� n�� ���� �Լ��� �ۼ��Ѵ�. 
		for(int i=0; i< n; i++) {
			for (int j=i+1; j<n; j++) {
				if(v[i] > v[j]) {
					int k = v[j];
					v[j] = v[i];
					v[i] = k;
				}
			}			
		}
	}
	
	public static void main (String args[]) {
		Random random = new Random();
		Random random1 = new Random();		
		Scanner sc = new Scanner(System.in);		
		long t = System.currentTimeMillis();		
		System.out.println("������ �������� ��: ");
		int N = sc.nextInt();
		int arr[] = new int[N];
		System.out.println(" ");
		System.out.println("������ ������");
		for (int i=0; i<N; i++) {
			arr[i]  = random.nextInt(1000);
			System.out.println(arr[i]);
		}
		
		System.out.println("������ ������ ��: ");
		int K = sc.nextInt();		
		int a1[] = new int[K-1];		
		for(int i=0; i<K-1; i++) {
			a1[i] = random1.nextInt(N-1) + 1;
			for(int j=0; j<i; j++) {
				if(a1[i]== a1[j]) i--;
			}			
		}
		for (int i=0; i<K-1; i++) {
			System.out.println(a1[i]);
		}
		sort(a1,a1.length);	
		
		int arr1 [] = new int [a1[0]];
		for(int i=0; i<a1[0]; i++) {
			arr1[i] = arr[i];
		}
		sort(arr1, arr1.length);
		System.out.println("");
		System.out.println("1 ��° ������ �ּҰ�: "+arr1[0]);
		System.out.println("1 ��° ������ �ִ밪: "+arr1[arr1.length-1]);
		int sum=0;
		for (int i=0; i<arr1.length; i++) {
			sum+=arr1[i];
		}
		System.out.println("1 ��° ������ ����: "+sum);
		System.out.println(" ");
		 
		for(int i=0; i<a1.length-1; i++) {
			if ((a1[i+1]-a1[i])==0) System.out.println("�ߺ��� ���ڰ� ���Խ��ϴ� �ٽ� �õ��ϼ���");
			int arr2[] = new int [a1[i+1]-a1[i]];
			for (int j=0; j<arr2.length; j++) {
				arr2[j] = arr[j+a1[i]];
			}
			sort(arr2, arr2.length);
			System.out.println(i+2+" ��° ������ �ּҰ�: "+arr2[0]);
			System.out.println(i+2+" ��° ������ �ִ밪: "+arr2[arr2.length-1]);
			int sum1 = 0;
			for (int i1=0; i1<arr2.length; i1++) {				
				sum1+=arr2[i1];
			}
			System.out.println(i+2+" ��° ������ ����: "+sum1);
			System.out.println(" ");
		}
		
		int arr3[] = new int[arr.length - a1[a1.length-1]];
		for (int i=0; i<arr3.length; i++) {
			arr3[i] = arr[a1[a1.length-1] + i];		
		}
		sort(arr3, arr3.length);
		System.out.println(a1.length+1+" ��° ������ �ּҰ�: "+arr3[0]);
		System.out.println(a1.length+1+" ��° ������ �ִ밪: "+arr3[arr3.length-1]);
		int sum2 = 0;
		for (int i=0; i<arr3.length; i++) {
			sum2+=arr3[i];		
		}
		System.out.println((a1.length+1)+" ��° ������ ����: "+sum2);
		
		long f = System.currentTimeMillis();
		System.out.println("�۵��ð�: "+(f-t)+"ms. ");	
	}

}
