import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {

	static Screen screen;

	public static final int FPS_CAP = 60;

	/**
	 * Initialization Window
	 * 
	 * Do all outside game initialization here
	 * 
	 * Exits with -1 for an error
	 */
	public static void initWindow() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
		} catch (LWJGLException e) {
			ErrorHandeler.severError(e);
		}
	}

	/**
	 * Shows the window to the user
	 */
	public static void appear() {
		try {
			Display.create();
		} catch (LWJGLException e) {
			ErrorHandeler.severError(e);
		}
	}

	/**
	 * Starts up the screen controller
	 */
	public static void initGame() {
		screen = new TitleScreen();
	}

	/**
	 * Main game loop
	 * 
	 * Loops until the user wants to exit
	 */
	public static void windowLoop() {

		while (!Display.isCloseRequested()) {
			screen.update();
			screen.render();
			Display.update();
			Display.sync(FPS_CAP);
		}
	}

	/**
	 * Last minute cleanup
	 */
	public static void cleanUp() {
		Display.destroy();
	}

}
