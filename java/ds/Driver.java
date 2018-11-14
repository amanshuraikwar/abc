package ds;

public class Driver {
	
	public static void main(String[] args) {
		
		try {
			Vector<Integer> vector = new Vector();
			vector.add(1);
			vector.add(2);
			vector.add(3);
			vector.add(4);
			vector.delete(5);
			System.out.println(vector);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}