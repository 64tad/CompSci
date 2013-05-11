import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.opengl.Display;

public class LWJGLUtils {

	/**
	 * Sets up opengl for 2d only rendering
	 */
	public static void init2dProjection() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}

	/**
	 * Sets up opengl for 3d rendering
	 * 
	 * @param fov
	 *            screen fov
	 * @param nearClip
	 *            point that objects stop rendering when they get near the
	 *            player
	 * @param farClip
	 *            point that objects stop rendering when they go further away
	 *            from the player
	 */
	public static void init3dProjection(float fov, float nearClip, float farClip) {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(fov, (float) Display.getWidth() / (float) Display.getHeight(), nearClip, farClip);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_DEPTH_TEST);
		glDisable(GL_TEXTURE_2D);
	}

}
