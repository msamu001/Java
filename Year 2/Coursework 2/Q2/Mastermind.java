import javax.swing.*;

public class Mastermind{
	public static void main(String[] args) {
		try{ // Peverts errors on different operating systems
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		GUI gui = new GUI(10,4);
	}
}