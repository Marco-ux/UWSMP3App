package marco.uws.projects.UWSMP3App.controller;

import marco.uws.projects.UWSMP3App.exceptions.NotRegisteredException;
import marco.uws.projects.UWSMP3App.model.User;

public class LoginController {
	
	private JwtController jwtController = new JwtController();
	
	UserSessionController userSessionController = new UserSessionController();
	
	/**
	 * Log-In user based on username
	 * @param username
	 * @param password
	 * @return generated token
	 * @throws NotRegisteredException
	 */
	public String getLogin(long username, String password) throws NotRegisteredException{
		User u = userSessionController.read(username);
		
		String usernameAsString = String.valueOf(username);
		
		if (u != null && u.getPassword().equals(password)) {		
			String token = jwtController.createToken(usernameAsString);
			return token;
		}
		
		throw new NotRegisteredException();
	}
}
