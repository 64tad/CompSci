
import static org.lwjgl.opengl.GL11.*;

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
		
	}

}
