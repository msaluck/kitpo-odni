package indooptik.main;

public class Test {

	public static void main(String[] args) {
		int x = 0;
		int y = 600;
		for (int i = 0; i < 24; i++) {
			x = x + 25;
			if (Math.signum(x)==1) {
				System.out.println("+"+x);
			}
			else if(Math.signum(x)==-1) {
				System.out.println(x);
			}
			else {
				System.out.println(x);
			}
		}
	}
}
