package marco.uws.projects.UWSMP3App.exceptions;

public class NotAuthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3406021210016519791L;
	
	public NotAuthorizedException() {
		super("You are not allowed to use this method");
	}

}
