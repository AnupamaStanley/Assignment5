
public class Test {
	public static void main(String args[]) {
		String value = new String( "Samsung|Optima|14|Madhya Pradesh|132401|14200" );
		String [] words = value.split("\\|");
		System.out.println( words[0] );
		System.out.println( words[1] );
		System.out.println( words[2] );
		System.out.println( words[3] );
		System.out.println( words[4] );
		System.out.println( words[5] );
		
	}
}
