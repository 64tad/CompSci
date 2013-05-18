import java.util.ArrayList;


public class World {

	public ArrayList<Entity> entitys;
	
	public World() {
		entitys = new ArrayList<Entity>();
	}
	
	public void render() {
		
		for (Entity e : entitys) {
			e.render();
		}
	}
	
	public void update() {
		
		for (Entity e : entitys) {
			e.update();
		}
	}
	
}
