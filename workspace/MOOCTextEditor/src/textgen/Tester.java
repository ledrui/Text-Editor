package textgen;

public class Tester {

		
		public static void main(){
			MyLinkedList<String> list1 = new MyLinkedList();
			try{
			list1.add("A");
			}catch(Exception e){
				
			}
			list1.add("B");
			list1.toStirng();
			// get
			try{
			String a = list1.get(0);
			System.out.println(a);
			}
			catch(IndexOutOfBoundsException e){
				
			}
			// size
			System.out.println("list1 size: "+ list1.size());
		}

	
}
