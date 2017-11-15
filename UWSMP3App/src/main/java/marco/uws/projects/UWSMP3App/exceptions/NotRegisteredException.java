package marco.uws.projects.UWSMP3App.exceptions;

public class NotRegisteredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7267117043551027497L;

	public NotRegisteredException() {
		super("You can not be logged in. Please check your input or register");
	}
}
