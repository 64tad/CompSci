
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.input.Keyboard;

public class TitleScreen implements Screen{
	
	public TitleScreen() {
		LWJGLUtils.init2dProjection();
	}
	
	/**
	 * Renders the title screen
	 */
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT); 
				
		glColor3f(.5f, .5f, 1f);
		
		glBegin(GL_QUADS);
		{
			glVertex2f(10, 10);
			glVertex2f(20, 10);
			glVertex2f(20, 20);
			glVertex2f(10, 20);
		}
		glEnd();
	}

	public void update() {
		//If s is down start the game ;P
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			System.out.println("Game started");
			Window.screen = new GameScreen();
		}
	}

}
