import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Model {

	public ArrayList<Vector3f> vertices;
	public ArrayList<Vector3f> normals;
	public ArrayList<Face> faces;
	public ArrayList<Vector2f> textures;
	
	public float scale = 1;

	public Model() {
		vertices = new ArrayList<Vector3f>();
		normals = new ArrayList<Vector3f>();
		faces = new ArrayList<Face>();
		textures = new ArrayList<Vector2f>();
	}

	public void render() {
		glBegin(GL_TRIANGLES);
		{
			for (Face face : faces) {
				Vector3f n1 = normals.get((int) face.normal.x - 1);
				glNormal3f(n1.x * scale, -n1.y * scale, n1.z * scale);
				Vector2f tex1 = textures.get((int)face.texture.x -1);
				glTexCoord2f(tex1.x, tex1.y);
				Vector3f v1 = vertices.get((int) face.vertex.x - 1);
				glVertex3f(v1.x * scale, -v1.y * scale, v1.z * scale);

				Vector3f n2 = normals.get((int) face.normal.y - 1);
				glNormal3f(n2.x * scale, -n2.y * scale, n2.z * scale);
				Vector2f tex2 = textures.get((int)face.texture.y -1);
				glTexCoord2f(tex2.x, tex2.y);
				Vector3f v2 = vertices.get((int) face.vertex.y - 1);
				glVertex3f(v2.x * scale, -v2.y * scale, v2.z * scale);

				Vector3f n3 = normals.get((int) face.normal.z - 1);
				glNormal3f(n3.x * scale, -n3.y * scale, n3.z * scale);
				Vector2f tex3 = textures.get((int)face.texture.z -1);
				glTexCoord2f(tex3.x, tex3.y);
				Vector3f v3 = vertices.get((int) face.vertex.z - 1);
				glVertex3f(v3.x * scale, -v3.y * scale, v3.z * scale);
			}
		}
		glEnd();
	}

	public void renderVertices() {
		glBegin(GL_POINTS);
		{
			for (Vector3f v : vertices) {
				glVertex3f(v.x * scale, -v.y * scale, v.z * scale);
			}
		}
		glEnd();
	}

}
