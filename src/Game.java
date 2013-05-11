import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;

import org.lwjgl.input.Mouse;

public class Game {

	static Camera camera;

	static Model test;
	static Model test2;

	public static void init() {
		camera = new Camera(0, 10, 0);
		Mouse.setGrabbed(true);

		test = ModelLoder.loadModel("bunny.obj");
		test2 = ModelLoder.loadModel("test1.obj");
		test2.scale = 0.1f;
	}

	public static void update() {
		camera.update();
	}

	public static void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		camera.useCamera();

		// Do all game rendering here

		glPushMatrix();
		{

			// glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);

			glColor3f(1, 0, 1);
			glTranslatef(10, 10, 10);
			test.renderVertices();
			glTranslatef(10, 10, 10);
			test2.renderVertices();

			glBegin(GL_QUADS);
			{
				glColor3f(0, 0, 1);
				glVertex3f(0, 0, 0);
				glVertex3f(100, 0, 0);
				glVertex3f(100, 0, 100);
				glVertex3f(0, 0, 100);
			}
			glEnd();
		}
		glPopMatrix();

		// Stop all game rendering here

	}

}
