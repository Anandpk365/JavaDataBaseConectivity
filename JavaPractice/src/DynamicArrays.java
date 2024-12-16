
public class DynamicArrays {
	private int arr[];
	private int nextIndex;
	
	public DynamicArrays() {
		arr = new int[5];
		nextIndex=0;
	}
	
	public int size() {
		return nextIndex;
	}
	
	public int get(int i) {
		if(i>=nextIndex)
			return -1;
		return arr[i];
	}
	
	public boolean isEmpty() {
	    return nextIndex==0;
	    }

	
	public void set(int i, int elem) {
		if(i>=nextIndex) {
			return ;
		}
		
		arr[i]=elem;
	}
	
	public void add(int elem) {
		
		if(nextIndex==arr.length) {
			doubleCapacity();
		}
		arr[nextIndex]=elem;
		nextIndex++;
	}
	
	public void add(int index, int elem) {
		if(nextIndex==arr.length) {
			doubleCapacity();
		}
		
		for(int i=nextIndex-1;i>=index;i--) {
			arr[i+1]=arr[i];
		}
		arr[index]=elem;
		nextIndex++;
	}
	
	public void remove(int index) {
		if(isEmpty())
			return;
		
		for(int i=index;i<nextIndex-1;i++) {
			arr[i]=arr[i+1];
		}
		
		nextIndex--;
	}
	
	private void doubleCapacity() {
		int temp[]=arr;
		arr =  new int[nextIndex*2];
		
		for(int i=0;i<temp.length;i++) {
			arr[i]=temp[i];
		}
	}
	
	public void removeLast() {
		if(isEmpty()) {
			return;
		}
//		arr[nextIndex-1]=0;
		nextIndex--;
	}
	
	public void display() {
		for(int i=0;i<nextIndex;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
