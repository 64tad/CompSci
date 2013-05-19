import static org.lwjgl.opengl.GL11.*;

public class IslandWorld extends World {

	public IslandWorld() {
		super();
	}
	
	public void render() {
		//TODO render ocean here
		Textures.getTexture(0).bind();
		glBegin(GL_QUADS);
		{
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
		
		glColor3f(150, 150, 150);
		glBegin(GL_TRIANGLES);
		{
			glVertex3f(10, 0, 10);
			glVertex3f(20, 20, 10);
			glVertex3f(10, 10, 20);
		}
		glEnd();
		
		super.render();
	}
}
