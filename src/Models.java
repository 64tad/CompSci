import java.util.ArrayList;

public class Models {

	public static ArrayList<Model> models;
	boolean loaded = false;

	public static void loadModels() {
		models = new ArrayList<Model>();

		// Load all textures here
		loadModelFromString("texturetest");
	}

	public static Model getTexture(int id) {
		return models.get(id);
	}

	static void loadModelFromString(String file) {
		models.add(ModelLoder.loadModel(file + ".obj"));
	}

}
