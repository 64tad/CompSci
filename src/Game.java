import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Mouse;

//TODO MAKE THE GAME REALLY CLOSE!!!

public class Game {

	static Camera camera;
	static World curWorld;

	public static void init() {
		camera = new Camera(0, 10, 0);
		Mouse.setGrabbed(true);
		//TODO load textures and models in loading screen
		Textures.loadTextures();
		Models.loadModels();
		
		curWorld = new IslandWorld();
	}

	public static void update() {
		camera.update();
		curWorld.update();
	}

	public static void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		camera.useCamera();
		glPushMatrix();
		{
			curWorld.render();
		}
		glPopMatrix();
	}

}
