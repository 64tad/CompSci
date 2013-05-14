import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Textures {

	public static ArrayList<Texture> textures;
	boolean loaded = false;

	public static void loadTextures() {
		textures = new ArrayList<Texture>();
		
		//Load all textures here
		loadTextureFromString("water");
		loadTextureFromString("texturetest");
	}

	public static Texture getTexture(int id) {
		return textures.get(id);
	}

	static void loadTextureFromString(String file) {
		try {
			textures.add(TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/textures/" + file + ".png")));
		} catch (IOException e) {
			ErrorHandeler.severError(e);
		}
	}

}
