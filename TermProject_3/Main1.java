import java.util.Random;
import java.math.BigInteger;
import java.util.Scanner;
public class Main1 {	
	// 버블 정렬
	/*
	static void sort(int [] v, int n) {		
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
	 삽입정렬
	static void insertionSort(int[] v, int n) {		
		for(int i=1; i<n; i++) {
			int r = v[i];
			int last = i;	
			while(last>0 && v[last-1] > r) {
				v[last] = v[last-1];
				last--;
			}
			v[last] = r;
		}
	}
	//합병
	static void merge(int[] v, int a, int b, int c) {
		int i=a, j=c+1, k=a;	
		int tv[] = new int[v.length];
		while(i<=c && j<=b) {
			if(v[i] < v[j]) tv[k++] = v[i++];
			else tv[k++]= v[j++];
		}
		while(i<=c) tv[k++] = v[i++];
		while(j<=b) tv[k++] = v[j++];
		for(i=a; i<=b; i++) v[i] = tv[i];
	}
	//합병절렬
	static void mergesort(int[] v, int a, int b) {		 
		if(a >= b) return;		
		int c = Math.round((a+b)/2);		
		mergesort(v,a,c);
		mergesort(v,c+1,b);		
		merge(v,a,b,c);
	}*/
	
	/*static void minmax(int[] arr, int k, int j) {
		int min = arr[k-1];
		int max = arr[k-1];
		for(int i=k; i<j; i++) {
			if (min > arr[i]) min = arr[i];
			if (max < arr[i]) max = arr[i];
		}		
		return min;
	}*/
	/*static int findmin(int a, int b) {
		if(a<b) return a;
		else return b;
	}
	static int findmax(int a, int b) {
		if (a>b) return a;
		else return b;
	}*/
	/*static int min(int[]arr, int low, int high) {
		int mid, left, right;
		mid = (low+high)/2;
		if(low==high) return arr[low];
		left = min(arr, low, mid);
		right = min(arr, mid+1, high);
		return (left< right)?left:right;
	}
	
	static int max(int [] arr, int low, int high) {
		int mid, left, right;
		mid = (low + high)/2;
		if(low == high) return arr[low];		
		left = max(arr, low, mid);
		right = max(arr, mid+1, high);
		return (left > right)?left:right;
	}*/
	
	public static void main (String args[]) {
		Random random = new Random(100);				
		Scanner sc = new Scanner(System.in);		
		
		
		System.out.println("생성할 데이터의 수: ");
		
		int N = sc.nextInt();		
		int arr[] = new int[N];
		System.out.println(" ");		
		for (int i=0; i<N; i++) {
			arr[i]  = random.nextInt();
			//System.out.println(arr[i]);
		}		
		
		System.out.println("생성되는 구간의 수: ");
		
		int k1 = sc.nextInt();	
		long t = System.currentTimeMillis();
		
		long prefixsum[] = new long [arr.length];
		prefixsum[0] = arr[0];	
		for (int i=1; i < arr.length; i++) {
			prefixsum[i] = prefixsum[i-1] + arr[i];
			//System.out.println(prefixsum[i]);
		}
		
		for (int i=0; i<k1; i++) {
			int b = random.nextInt(N)+1;
			//System.out.println(b);
			int a = random.nextInt(N)+1;
			//System.out.println(a);
			if(a>b) {int t1=a; a=b; b=t1;} 
			int min = arr[a-1];
			int max = arr[a-1];
			
			long sum = arr[a-1];
			long sum1 = arr[a-1];
			long sum2 = arr[a-1];
			for (int i1=a; i1<b; i1++) {
				if(min > arr[i1]) min = arr[i1];
				if(max < arr[i1]) max = arr[i1];
				//sum1 += arr[i1];				
			}	
			
			if (a==1) sum = prefixsum[1];
			else sum = prefixsum[b-1] - prefixsum[a-2];		
			//System.out.println(i+1+" 번째 구간 최소값 : "+min);
			//System.out.println(i+1+" 번째 구간 최소값 : "+min(arr, a-1, b-1));
			//System.out.println(i+1+" 번째 구간 최대값 : "+max);
			//System.out.println(i+1+" 번째 구간 최대값 : "+max(arr, a-1,b-1));
			//System.out.println(i+1+" 번째 구간 총합 : "+sum);
			//System.out.println(sum1);
			//System.out.println(" ");
		}
		long f = System.currentTimeMillis();
		System.out.println("작동시간: "+(f-t)+"ms. ");
	
	}
	

}

