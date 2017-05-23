package modelos;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class User {

	public enum Authority{
		ROLE_ADMIN,ROLE_USER
	}
	
	private String username;
	private Authority authority;
	
	public User(){
		
	}
	
	public User(String username,Authority authority){
		this.username=username;
		this.authority=authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	
	
	
}
