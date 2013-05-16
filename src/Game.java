import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Mouse;

//TODO MAKE THE GAME REALLY CLOSE!!!

public class Game {

	static Camera camera;

	static Model test;
	static Model test2;
	static Model test3;

	static float spin = 0;

	public static void init() {
		camera = new Camera(0, 10, 0);
		Mouse.setGrabbed(true);
		Textures.loadTextures();

		test = ModelLoder.loadModel("texturetest.obj");

		glEnable(GL_POINT_SMOOTH);
		// glPointSize(1.5f);
	}

	public static void update() {
		camera.update();
		spin+=20;
	}

	public static void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		camera.useCamera();

		// Do all game rendering here

		glPushMatrix();
		{

			//glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);

			Textures.getTexture(1).bind();
			glColor3f(1, 1, 1);
			test.render();

			Textures.getTexture(0).bind();
			glBegin(GL_QUADS);
			{
				glColor3f(0, 0, 1);
				
				glTexCoord2f(0, 0);
				glVertex3f(0, 0, 0);
				glTexCoord2f(10, 0);
				glVertex3f(100, 0, 0);
				glTexCoord2f(10, 10);
				glVertex3f(100, 0, 100);
				glTexCoord2f(0, 10);
				glVertex3f(0, 0, 100);
			}
			glEnd();
		}
		glPopMatrix();
	}

}
