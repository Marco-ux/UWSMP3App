package marco.uws.projects.UWSMP3App.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.Claim;

public class JwtController {
	
	private String issuer;
	private String secret;
	private String headerUsername = "username";
	
	public JwtController() {
		issuer = "UWSMP3App";
		secret = "secrets_must_be_secrets";
	}
	
	/**
	 * Creates a token for authentication with two payload-elements: 'username' and 'role'
	 * @param username: username of the requesting user.
	 * @param role: role of the requesting user.
	 * @return token used for authentication.
	 */
	public String createToken(String username) {
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put(headerUsername, username);
		
		String token = "";
		
		try {
			token = JWT.create().withIssuer(issuer).withHeader(headerMap).sign(Algorithm.HMAC256(secret));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} /*catch (JWTCreationException e) {
			e.printStackTrace();
		} */catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return token;
	}
	
	/**
	 * Verify send token of user
	 * @param token: token send by user
	 * @return true if verification was successful
	 */
	public boolean verifyToken(String token) {
		JWTVerifier verifier = null;
		try {
			verifier = JWT.require(Algorithm.HMAC256(secret)).withIssuer(issuer).build();
			verifier.verify(token);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		} catch (UnsupportedEncodingException e) {
			return false;
		} catch (SignatureVerificationException e) {
			return false;
		}
	}
	
	/**
	 * Decode the token to get username and role
	 * @param token: token send by user
	 * @return Map with username, role and the corresponding values
	 */
	public Map<String, Object> decodeToken(String token) {
		Map<String, Object> attributes = new HashMap<String, Object>();
		
		JWT jwt = JWT.decode(token);
		
		Claim username = jwt.getHeaderClaim(headerUsername);
		
		attributes.put("username", username.asString());
		
		return attributes;
	}

}
