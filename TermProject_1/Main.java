import java.util.Random;
import java.util.Scanner;
public class Main {
	public static void main (String args[]) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);		
		long t = System.currentTimeMillis();		
		System.out.println("생성할 데이터의 수: ");
		int N = sc.nextInt();
		int arr[] = new int[N];
		System.out.println(" ");
		System.out.println("생성된 데이터");
		for (int i=0; i<N; i++) {
			arr[i]  = random.nextInt();
			System.out.println(arr[i]);
		}
		System.out.println(" ");		
		System.out.println("구간의 시작값 : ");
		int a = sc.nextInt();		
		System.out.println("구간의 마지막값 : ");
		int b = sc.nextInt();
		System.out.println(" ");
		
		System.out.println("선택된 구간의 데이터");
		int arr_chosen[] = new int[b-a+1];
		for (int i=a-1; i<b; i++) {
			arr_chosen[i-a+1] = arr[i];
			System.out.println(arr_chosen[i-a+1]);
		}
		int n = arr_chosen.length;
		System.out.println("");
		System.out.println("정렬된 데이터");
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
		System.out.println("구간 최소값 : "+arr_chosen[0]);
		System.out.println("구간 최대값 : "+arr_chosen[arr_chosen.length-1]);
		int sum=0;
		for (int r=0; r<arr_chosen.length; r++) {
			sum+=arr_chosen[r];
		}
		System.out.println("구간의 총합: "+sum);
		
		long f = System.currentTimeMillis();
		System.out.println("작동시간: "+(f-t)+"ms. ");
	}

}
