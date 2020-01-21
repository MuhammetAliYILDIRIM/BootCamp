package Forest;

public abstract class Tree {
	String name;
	double height;
	private int age = 0;


	private void grow() {
		System.out.println("grow");
		height += 2.3;
		age += 1;
	}

	public void cut() {
		System.out.println( name +" was Cutted");
		if(height>0.7) {
			height -= 0.7;
		}else {
			height=0;
		}
		
	}
}
