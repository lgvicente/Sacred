package br.com.sacred.session;

import javax.faces.context.FacesContext;

import org.apache.myfaces.context.servlet.SessionMap;

import br.com.sacred.HeroItemsBean;
import br.com.sacred.UserBean;
import br.com.sacred.UserDAO;

public class SessaoBean {
	
	String mensagemRetorno = "";
	
	UserBean userBean = new UserBean();
	
	HeroItemsBean heroitemBean = new HeroItemsBean();
	
	/** variavel de controle de usuário corrente**/
	public UserBean currentUser = null;
	
	/** Verifica Sessão **/
	public String verificaSessao(String user, String password){
		
		//Recupera Sessão
		SessionMap session = (SessionMap) FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//Recupera atributo verificador de sessão
		currentUser = (UserBean) session.get("currentSessionUser");
		
        if (currentUser == null){
        	//Coloca na sessão
    		userBean.setUserName(user);
    		userBean.setPassword(password);	        	
    		userBean = UserDAO.login(userBean);
  		
    		//Se usuário válido
    		if(userBean.isValid()){
    			//Seta usuario na Sessao
    			session.put("currentSessionUser", userBean);
    			System.out.println("Login efetuado com sucesso!");
    			setMensagemRetorno("Login efetuado com sucesso!");    			
    			return "SacredElement.jsp";
    		}else{
    			//Retorna mensagem: "Usuário Inválido"
    			System.out.println("Usuário Inválido!");
    			setMensagemRetorno("Usuário Inválido!");
    			return "SacredElement.jsp";
    		}    		
        }else{
        	//Retorna mensagem: "Você já está logado"
        	System.out.println("Você já está logado!");
        	setMensagemRetorno("Você já está logado!");
        	return "SacredElement.jsp";
        }

	}
	
	/** Retira usuário da Sessão **/
	public void logout(){
		currentUser = null;
	}
	
	public UserBean getUserBean() {
		return userBean;
	}


	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}	

	
	public String getMensagemRetorno() {
		return mensagemRetorno;
	}

	public void setMensagemRetorno(String mensagemRetorno) {
		this.mensagemRetorno = mensagemRetorno;
	}	

}
