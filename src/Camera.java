import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Camera {

	float x, y, z;
	float rx, ry, rz;

	public static final float FOV = 70;
	public static final float NEAR_CLIP = .3f;
	public static final float FAR_CLIP = 1000;

	public static final float SENSITIVITY = .5f;
	public static final float SPEED = 1;

	/**
	 * Default - Spawns the camera at (0,0,0) and looking at (0,0,0)
	 */
	public Camera() {
		this(0, 0, 0);
	}

	/**
	 * Position - Spawns the player at (x,y,z) and looking at (0,0,0)
	 * 
	 * @param x
	 *            x position of the player
	 * @param y
	 *            y position of the player
	 * @param z
	 *            z position of the player
	 */
	public Camera(float x, float y, float z) {
		this(x, y, z, 0, 0, 0);
	}

	/**
	 * Position and Look - Spawn the player at (x,y,z) and looking at (rx,ry,rz)
	 * 
	 * @param x
	 *            x position of the player
	 * @param y
	 *            y position of the player
	 * @param z
	 *            z position of the player
	 * @param rx
	 *            rotation x of the player
	 * @param ry
	 *            rotation y of the player
	 * @param rz
	 *            rotation z of the player
	 */
	public Camera(float x, float y, float z, float rx, float ry, float rz) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.rx = rx;
		this.ry = ry;
		this.rz = rz;

		LWJGLUtils.init3dProjection(FOV, NEAR_CLIP, FAR_CLIP);
	}

	/**
	 * Move the opengl environment to where the camera is
	 */
	public void useCamera() {
		glRotatef(rx, 1, 0, 0);
		glRotatef(ry, 0, 1, 0);
		glRotatef(rz, 0, 0, 1);
		glTranslatef(x, y, z);
	}

	public void update() {
		checkMouse();
		checkKeyboard();

		if (Keyboard.isKeyDown(Keyboard.KEY_E)) // Debug info id e is pressed
			System.out.println("Camera at (" + x + "," + y + "," + z + ") and looking at (" + rx + "," + ry + "," + rz + ")");

	}

	/**
	 * Checks the keyboard and moves the player as needed
	 */
	void checkKeyboard() {
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			z += -SPEED * Math.sin(Math.toRadians(ry + 90));
			x += -SPEED * Math.cos(Math.toRadians(ry + 90));
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			z += SPEED * Math.sin(Math.toRadians(ry + 90));
			x += SPEED * Math.cos(Math.toRadians(ry + 90));
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			x += -SPEED * Math.sin(Math.toRadians(ry));
			z += -SPEED * Math.cos(Math.toRadians(ry));
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			x += SPEED * Math.sin(Math.toRadians(ry));
			z += SPEED * Math.cos(Math.toRadians(ry));
		}
	}

	/**
	 * Check the mouse for change and moves the camera as needed
	 */
	void checkMouse() {

		while (Mouse.next()) {
			int xDelta = Mouse.getEventDX();
			int yDelta = Mouse.getEventDY();
			ry -= xDelta * SENSITIVITY;
			rx -= yDelta * SENSITIVITY;
		}

		rx %= 360;
		ry %= 360;
	}
}
