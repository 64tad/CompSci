import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.input.Mouse;

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
			/*
			 * Click to start
			 */
			glVertex2f(200, 400);
			glVertex2f(600, 400);
			glVertex2f(600, 250);
			glVertex2f(200, 250);
		}
		glEnd();
		
		glBegin(GL_QUADS);
		{
			/*
			 * Click for instructions
			 */
			glVertex2f(100, 150);
			glVertex2f(350, 150);
			glVertex2f(350, 50);
			glVertex2f(100, 50);
		}
		glEnd();
		
		glBegin(GL_QUADS);
		{
			/*
			 * Click to exit
			 */
			glVertex2f(700, 150);
			glVertex2f(450, 150);
			glVertex2f(450, 50);
			glVertex2f(700, 50);
		}
		glEnd();
		
		glBegin(GL_QUADS);
		{
			/*
			 * Title of game
			 */
			glVertex2f(100, 550);
			glVertex2f(700, 550);
			glVertex2f(700, 450);
			glVertex2f(100, 450);
		}
		glEnd();
	}

	public void update() {
		/*
		 * If mouse is over start button and is down, start the game
		 */
		if (Mouse.getY() > 250 && Mouse.getY() < 400 && Mouse.getX() > 200 && Mouse.getX() < 600 && Mouse.isButtonDown(0)) {
			System.out.println("Game started");
			Window.screen = new GameScreen();
		}
		
		/*
		 * If mouse is over exit button and is down, exit the game
		 */
		if (Mouse.getY() > 50 && Mouse.getY() < 150 && Mouse.getX() > 450 && Mouse.getX() < 700 && Mouse.isButtonDown(0)) {
			System.out.println("Game exited");
			Window.cleanUp();
		}
	}

}