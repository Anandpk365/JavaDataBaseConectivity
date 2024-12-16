
public class BinarySearchUsingRecursiveMethod {
	
	public static int binarySearch(int[] a, int si, int ei,int x) {
		if(si>ei)
			return -1;
		
		int mid=(si+ei)/2;
		
		if(a[mid]==x)
			return mid;
		else if(a[mid]<x) {
			return binarySearch(a,mid+1,ei,x);
		}else {
			return binarySearch(a,si,mid-1,x);
		}
	}

}
