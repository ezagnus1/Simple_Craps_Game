package craps;

import javax.swing.JFrame;


public class Tester {
	public static void main(String[] args) {
		CrapsGame gamer=new CrapsGame();
		gamer.GUImethod();
		gamer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
