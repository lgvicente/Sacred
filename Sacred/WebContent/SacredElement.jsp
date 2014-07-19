<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html version="-//W3C//DTD HTML 4.01 Transitional//EN" 
		xmlns:a4j="http://richfaces.org/a4j"
		xmlns:rich="http://richfaces.org/rich">
<meta http-equiv="Content-type" content="text/html;charset=ISO-8859-1" />
<head>
<title>Sacred</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css" />
<script language="javascript" src="js/jquery.js"></script>
</head>

<f:view>
<body>

<h:panelGrid id="todo" >

	<!-- Início Topo -->
	<h:panelGrid id="topo" >

	<h:panelGrid id="logo">Sacred Element</h:panelGrid>

	<!-- Formulário de Login -->
	<h:form id="formLogin" >
	
		<h:panelGrid columns="5" id="login" rendered="#{inicialBean.loginRendered}"> 
	       		<h:panelGroup>
	       			<h:outputLabel>Usuário:</h:outputLabel>
					<h:inputText value="#{inicialBean.user}" />
	       		</h:panelGroup>
	       		<h:panelGroup>
	       			<h:outputLabel>Senha:</h:outputLabel>
					<h:inputSecret value="#{inicialBean.password}" />
	       		</h:panelGroup> 
				<h:panelGroup> 
		            <h:commandButton value="Login" action="#{inicialBean.fazLogin}" >     
		            </h:commandButton>
	       		</h:panelGroup>	       		
		</h:panelGrid>
		
		<h:panelGrid columns="1" id="logout" rendered="#{inicialBean.logoutRendered}">
	       		<h:panelGroup>
	       			<h:outputLabel value="#{inicialBean.userDetail}" />
		            <h:commandButton value="Logout" action="#{inicialBean.fazLogout}" >
		            </h:commandButton>	       			
	       		</h:panelGroup>		
		</h:panelGrid>
						       		           
	</h:form>
	<!-- Fim Formulário de Login -->
	</h:panelGrid>
	<!-- Fim Topo -->

	<!-- Início Menu -->
	<h:panelGrid id="meio" >	
		<h:panelGrid id="esquerda" >
			<h:panelGrid id="menu" >
 				<h:panelGroup><a href="#">Home</a></h:panelGroup>
				<h:panelGroup><a href="#register.jsp" onclick="executa('register');">Register</a></h:panelGroup>
				<h:panelGroup><a href="#" onclick="executa('createhero');">Create Hero</a></h:panelGroup>
				<h:panelGroup><a href="#" onclick="executa('createitem');">Create Item</a></h:panelGroup>
				<h:panelGroup><a href="#" onclick="executa('createenemy');">Create Enemy</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('createloot');">Create Loot</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('profile');">Profile</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('skill');">Skills</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('mail');">Mail</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('ranking');">Ranking</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('alliance');">Alliance</a></h:panelGroup>
                <hr>
                <h:panelGroup><a href="#" onclick="executa('quest');">Red World</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('dungeons');">Dungeons</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('battleground');">BattleGround</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('arena');">Arena</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('church');">Church</a></h:panelGroup>
                <hr> 
                <h:panelGroup><a href="#" onclick="executa('herbalist');">Herbalist</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('armorsmith');">Armorsmith</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('weaponsmith');">Weaponsmith</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('enchanter');">Enchanter</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('alchemist');">Alchemist</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('jewelry');">Jelwery</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('pettrainer');">Pet Trainer</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('auctionhouse');">Auction House</a></h:panelGroup>
                <hr>
                <h:panelGroup><a href="#" onclick="executa('support');">Support</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('faq');">FAQ</a></h:panelGroup>
                <h:panelGroup><a href="#" onclick="executa('help');">Help</a></h:panelGroup>
			</h:panelGrid>
		</h:panelGrid>			
		
	<!-- Início Miolo -->
	<h:panelGrid id="miolo">
			<h:panelGroup >
	                 <h:outputLabel>1 - Crie um usuário no menu Register</h:outputLabel>
			</h:panelGroup>			                 
			<h:panelGroup >                 
	                 <h:outputLabel>2 - Crie um herói na tela seguinte</h:outputLabel>
			</h:panelGroup>			                 
			<h:panelGroup >                   
	                 <h:outputLabel>3 - Faça o login</h:outputLabel> 
	        </h:panelGroup>	                        
			<h:panelGroup >  
	                 <h:outputLabel>4 - Inicie sua busca e explore o mundo através do menu</h:outputLabel>           
			</h:panelGroup>	
	</h:panelGrid>
	<!-- Fim Miolo -->
	
	<div style="clear: both;"></div>
	
	</h:panelGrid>
	<!-- Fim Menu -->		

	<h:panelGrid id="rodape">
		<h:panelGrid id="rodape_direita" columns="1">
			<h:outputLabel>Av. xxx yyy zzz, No 765</h:outputLabel>
			<h:outputLabel>São Paulo - AM - CEP: 89000-000</h:outputLabel>
			<h:outputLabel>Email: <a href="mailto:seuemail@seudominio.com.br">relacionamento@sacredelement.com.br</a></h:outputLabel>
		</h:panelGrid>
	</h:panelGrid>

</h:panelGrid>

</body>
</f:view>        
        
