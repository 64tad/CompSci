import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.lwjgl.util.vector.Vector3f;

public class ModelLoder {

	public static Model loadModel(String file) {

		try {
			BufferedReader r = new BufferedReader(new FileReader(new File("res/" + file)));

			Model m = new Model();

			String line;
			while ((line = r.readLine()) != null) {
				if (line.startsWith("v ")) {
					float x = Float.valueOf(line.split(" ")[1]);
					float y = Float.valueOf(line.split(" ")[2]);
					float z = Float.valueOf(line.split(" ")[3]);
					m.vertices.add(new Vector3f(x, y, z));
				} else if (line.startsWith("vn ")) {
					float x = Float.valueOf(line.split(" ")[1]);
					float y = Float.valueOf(line.split(" ")[2]);
					float z = Float.valueOf(line.split(" ")[3]);
					m.normals.add(new Vector3f(x, y, z));
				} else if (line.startsWith("f ")) {
					Vector3f vertexIndices = new Vector3f(Float.valueOf(line.split(" ")[1].split("/")[0]), Float.valueOf(line.split(" ")[2].split("/")[0]), Float.valueOf(line.split(" ")[3].split("/")[0]));
					Vector3f normalIndices = new Vector3f(Float.valueOf(line.split(" ")[1].split("/")[2]), Float.valueOf(line.split(" ")[2].split("/")[2]), Float.valueOf(line.split(" ")[3].split("/")[2]));
					m.faces.add(new Face(vertexIndices, normalIndices));
				}
			}

			r.close();

			return m;
		} catch (Exception e) {
			ErrorHandeler.severError(e);
		}

		return null;

	}

}
