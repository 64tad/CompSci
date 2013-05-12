import java.util.ArrayList;

import org.lwjgl.util.vector.Vector3f;
import static org.lwjgl.opengl.GL11.*;

public class Model {

	public ArrayList<Vector3f> vertices;
	public ArrayList<Vector3f> normals;
	public ArrayList<Face> faces;
	
	public float scale = 1;

	public Model() {
		vertices = new ArrayList<Vector3f>();
		normals = new ArrayList<Vector3f>();
		faces = new ArrayList<Face>();
	}

	public void render() {
		glBegin(GL_TRIANGLES);
		{
			for (Face face : faces) {
				Vector3f n1 = normals.get((int) face.normal.x - 1);
				glNormal3f(n1.x * scale, -n1.y * scale, n1.z * scale);
				Vector3f v1 = vertices.get((int) face.vertex.x - 1);
				glVertex3f(v1.x * scale, -v1.y * scale, v1.z * scale);

				Vector3f n2 = normals.get((int) face.normal.y - 1);
				glNormal3f(n2.x * scale, -n2.y * scale, n2.z * scale);
				Vector3f v2 = vertices.get((int) face.vertex.y - 1);
				glVertex3f(v2.x * scale, -v2.y * scale, v2.z * scale);

				Vector3f n3 = normals.get((int) face.normal.z - 1);
				glNormal3f(n3.x * scale, -n3.y * scale, n3.z * scale);
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
