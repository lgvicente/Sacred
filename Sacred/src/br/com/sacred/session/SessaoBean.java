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
	
	/** variavel de controle de usu�rio corrente**/
	public UserBean currentUser = null;
	
	/** Verifica Sess�o **/
	public String verificaSessao(String user, String password){
		
		//Recupera Sess�o
		SessionMap session = (SessionMap) FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//Recupera atributo verificador de sess�o
		currentUser = (UserBean) session.get("currentSessionUser");
		
        if (currentUser == null){
        	//Coloca na sess�o
    		userBean.setUserName(user);
    		userBean.setPassword(password);	        	
    		userBean = UserDAO.login(userBean);
  		
    		//Se usu�rio v�lido
    		if(userBean.isValid()){
    			//Seta usuario na Sessao
    			session.put("currentSessionUser", userBean);
    			System.out.println("Login efetuado com sucesso!");
    			setMensagemRetorno("Login efetuado com sucesso!");    			
    			return "SacredElement.jsp";
    		}else{
    			//Retorna mensagem: "Usu�rio Inv�lido"
    			System.out.println("Usu�rio Inv�lido!");
    			setMensagemRetorno("Usu�rio Inv�lido!");
    			return "SacredElement.jsp";
    		}    		
        }else{
        	//Retorna mensagem: "Voc� j� est� logado"
        	System.out.println("Voc� j� est� logado!");
        	setMensagemRetorno("Voc� j� est� logado!");
        	return "SacredElement.jsp";
        }

	}
	
	/** Retira usu�rio da Sess�o **/
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
