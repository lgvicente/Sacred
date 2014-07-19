package br.com.sacred.view.helper;


public class InicialViewHelper {

	/**
	 * Beans - Atributos da Tela
	 */	
	
	/** variavel de usuario da tela **/
	private String user = null;
	
	/** variavel de senha da tela **/
	private String password = null;
	
	/** variavel de renderização do grid de login - inicial true**/
	private boolean loginRendered = true;

	/** variavel de renderização do grid de logout - inicial false**/
	private boolean logoutRendered = false;
	
	/**
	 * Getters and Setters
	 */
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
	public boolean isLoginRendered() {
		return loginRendered;
	}

	public void setLoginRendered(boolean loginRendered) {
		this.loginRendered = loginRendered;
	}

	public boolean isLogoutRendered() {
		return logoutRendered;
	}

	public void setLogoutRendered(boolean logoutRendered) {
		this.logoutRendered = logoutRendered;
	}	
	
}
