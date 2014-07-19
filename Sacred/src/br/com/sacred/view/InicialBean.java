package br.com.sacred.view;

import br.com.sacred.HeroItemDAO;
import br.com.sacred.HeroItemsBean;
import br.com.sacred.UserBean;
import br.com.sacred.UserDAO;
import br.com.sacred.session.SessaoBean;
import br.com.sacred.view.helper.InicialViewHelper;

public class InicialBean extends InicialViewHelper{
	
	/** objeto Sessao **/
	private static SessaoBean sessao = new SessaoBean();
	
	/** objeto de detalhe do Hero **/
	private HeroItemsBean heroItemsBean = new HeroItemsBean();
	
	/** detalhes do usuário exibidos no topo **/
	public String userDetail = null;
	
	/** Método para efetuar Login **/
	public String fazLogin(){
		//Verifica o retorno da Sessao
		String retorno = sessao.verificaSessao(getUser(), getPassword());
		//Monta detalhe do usuário para tela SacredElement.jsp - se logado!
		preparaUserDetail();
		//Seta Grid de Login Invisível
		setLoginRendered(false);
		//Seta Grid de Logout Invisível
		setLogoutRendered(true);		
		//Chama proxima pagina ou action
		return retorno;		
	}
	
	/** Método para efetuar Logout **/
	public String fazLogout(){
		//Seta Grid de Login Visível
		setLoginRendered(true);
		//Seta Grid de Logout Invisível
		setLogoutRendered(false);		
		//Deleta sessão do usuário
		sessao.logout();
		return "";
	}	
	
	/** Método para preparar detalhes de usuário mostrados na tela **/
	private void preparaUserDetail() {
		//Recupera usuário da sessão
		UserBean userBean = sessao.getUserBean();
		//Recupera retorno do Bean e seta no heroItemsBean
		heroItemsBean = HeroItemDAO.getHeroItens(userBean.getUsername());
		//Seta detalhes do usuário para mostrar na tela
		setUserDetail("Hero: "+heroItemsBean.getHeroName()+", Level: "
						+heroItemsBean.getHeroLevel()+", "
						+heroItemsBean.getHeroHP()+" HP, "
						+heroItemsBean.getHeroMana()+" Mana, "
						+heroItemsBean.getQtdItem()+" Moedas ");
		
	}

	/** Método para habilitar/desabilitar Login/Logout **/
	public void habilitarCampos(){
		
	}

	public String getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(String userDetail) {
		this.userDetail = userDetail;
	}	
}
