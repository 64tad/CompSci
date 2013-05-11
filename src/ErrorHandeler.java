public class ErrorHandeler {

	/**
	 * Exits the game print the error to the console Exits with code -1
	 * 
	 * @param e
	 *            exception thrown with the error
	 */

	public static void severError(Exception e) {
		e.printStackTrace();
		System.exit(-1);
	}

}
