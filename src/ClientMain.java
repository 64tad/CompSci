
public class ClientMain {
 
	public static void main(String main[]) {
		Window.initWindow();
		Window.appear();
		Window.initGame();
		Window.windowLoop();
		Window.cleanUp();
	}

}
