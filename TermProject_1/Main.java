import java.util.Random;
import java.util.Scanner;
public class Main {
	public static void main (String args[]) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);		
		long t = System.currentTimeMillis();		
		System.out.println("������ �������� ��: ");
		int N = sc.nextInt();
		int arr[] = new int[N];
		System.out.println(" ");
		System.out.println("������ ������");
		for (int i=0; i<N; i++) {
			arr[i]  = random.nextInt();
			System.out.println(arr[i]);
		}
		System.out.println(" ");		
		System.out.println("������ ���۰� : ");
		int a = sc.nextInt();		
		System.out.println("������ �������� : ");
		int b = sc.nextInt();
		System.out.println(" ");
		
		System.out.println("���õ� ������ ������");
		int arr_chosen[] = new int[b-a+1];
		for (int i=a-1; i<b; i++) {
			arr_chosen[i-a+1] = arr[i];
			System.out.println(arr_chosen[i-a+1]);
		}
		int n = arr_chosen.length;
		System.out.println("");
		System.out.println("���ĵ� ������");
		for (int i1=0; i1<n; i1++) {
			for(int i2=i1+1; i2<n; i2++) {
				if (arr_chosen[i1]>arr_chosen[i2]) {
					int k1 = arr_chosen[i2];
					arr_chosen[i2] = arr_chosen[i1];
					arr_chosen[i1] = k1;
				}
			}
			System.out.println(arr_chosen[i1]);
		}
		System.out.println("");
		System.out.println("���� �ּҰ� : "+arr_chosen[0]);
		System.out.println("���� �ִ밪 : "+arr_chosen[arr_chosen.length-1]);
		int sum=0;
		for (int r=0; r<arr_chosen.length; r++) {
			sum+=arr_chosen[r];
		}
		System.out.println("������ ����: "+sum);
		
		long f = System.currentTimeMillis();
		System.out.println("�۵��ð�: "+(f-t)+"ms. ");
	}

}
