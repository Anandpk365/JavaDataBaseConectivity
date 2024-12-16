
public class DynamicArraysUsers {

	public static void main(String[] args) {
		DynamicArrays d =  new DynamicArrays();
		
		for(int i=0;i<100;i++) {
			d.add(1+i);
		}
		
		System.out.println(d.size());
		System.out.println(d.get(5));
		d.add(3,121);
		System.out.println(d.get(3));
		d.set(5,120);
		System.out.println(d.get(5));
		d.add(7,564);
		d.add(d.size(),12981);
		
		
//		if(!d.isEmpty()) {
//			d.remove(5);
//		d.removeLast();
//		}
		System.out.println(d.size());
		
		d.display();

	}

}
