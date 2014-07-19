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
	
	/** detalhes do usu�rio exibidos no topo **/
	public String userDetail = null;
	
	/** M�todo para efetuar Login **/
	public String fazLogin(){
		//Verifica o retorno da Sessao
		String retorno = sessao.verificaSessao(getUser(), getPassword());
		//Monta detalhe do usu�rio para tela SacredElement.jsp - se logado!
		preparaUserDetail();
		//Seta Grid de Login Invis�vel
		setLoginRendered(false);
		//Seta Grid de Logout Invis�vel
		setLogoutRendered(true);		
		//Chama proxima pagina ou action
		return retorno;		
	}
	
	/** M�todo para efetuar Logout **/
	public String fazLogout(){
		//Seta Grid de Login Vis�vel
		setLoginRendered(true);
		//Seta Grid de Logout Invis�vel
		setLogoutRendered(false);		
		//Deleta sess�o do usu�rio
		sessao.logout();
		return "";
	}	
	
	/** M�todo para preparar detalhes de usu�rio mostrados na tela **/
	private void preparaUserDetail() {
		//Recupera usu�rio da sess�o
		UserBean userBean = sessao.getUserBean();
		//Recupera retorno do Bean e seta no heroItemsBean
		heroItemsBean = HeroItemDAO.getHeroItens(userBean.getUsername());
		//Seta detalhes do usu�rio para mostrar na tela
		setUserDetail("Hero: "+heroItemsBean.getHeroName()+", Level: "
						+heroItemsBean.getHeroLevel()+", "
						+heroItemsBean.getHeroHP()+" HP, "
						+heroItemsBean.getHeroMana()+" Mana, "
						+heroItemsBean.getQtdItem()+" Moedas ");
		
	}

	/** M�todo para habilitar/desabilitar Login/Logout **/
	public void habilitarCampos(){
		
	}

	public String getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(String userDetail) {
		this.userDetail = userDetail;
	}	
}
