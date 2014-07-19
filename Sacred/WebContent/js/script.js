/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function getNewHttpRequest() {
	try {
		xmlhttp = new XMLHttpRequest();
	} catch(ee) {
		try {
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			try {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(E) {
				xmlhttp = false;
			}
		}
	}

	return(xmlhttp);
}

oAjax = getNewHttpRequest();

//Fila de conexões
fila = [];
ifila = 0;

// funcao para altear o conteudo do miolo
function ajaxHTMLmiolo(id, conteudo) {
	ajaxHTML(id, 'conteudo.jsp?conteudo='+conteudo);
}
function ajaxHTMLmessage(id, from, msgid) {
        var url = "message.jsp?mailfrom="+from+"&mailid="+msgid;

        //Carregando...
	document.getElementById(id).innerHTML="<span class='carregando'>"+"Carregando...</span>";
	//Adiciona à fila
	fila[fila.length] = [id, url];
	//Se não há conexões pendentes, executa
	if((ifila+1) == fila.length) ajaxRun();

}

//Executa a próxima conexão da fila
function ajaxRun() {
	//Abre a conexão
	oAjax.open("GET", fila[ifila][1], true);
	//Função para tratamento do retorno
	oAjax.onreadystatechange = function() {
		if (oAjax.readyState == 4) {
			//Mostra o HTML recebido
			retorno = unescape(oAjax.responseText.replace(/\+/g, " "));
			document.getElementById(fila[ifila][0]).innerHTML = retorno;
			//Roda o próximo
			ifila++;
			if(ifila < fila.length) setTimeout("ajaxRun()", 20);
		}
	};

	//Executa
	oAjax.send(null);
}

function ajaxHTML(id, url) {
	//Carregando...
	document.getElementById(id).innerHTML="<span class='carregando'>"+"Carregando...</span>";
	//Adiciona à fila
	fila[fila.length] = [id, url];
	//Se não há conexões pendentes, executa
	if((ifila+1) == fila.length) ajaxRun();
}

var keepgoin=true;
var currentsec=0;
var currentmil=0;
var church=0;
var url=null;

function timer(time,dmgtaken,enemyid,indchurch){

if(keepgoin){
    if(time!=0 || currentsec!=0 || currentmil!=0){
        if(currentmil==0){
            currentmil=10;
                if(currentsec==0){
                currentsec=60;
                time-=1;
                }
            currentsec-=1;
        }
        currentmil-=1;
    }
}
    if(time==0){
        if(currentsec==0){
            if(currentmil==0){
                if(indchurch!=1)
                    {
                        url = "resultado.jsp?enemyid="+enemyid+"&dmgtaken="+dmgtaken;
                    }
                else
                    {
                        url = "churchok.jsp?regen=1";
                    }
                    //Adiciona à fila
                    fila[fila.length] = ["miolo", url];
                    //Se não há conexões pendentes, executa
                    if((ifila+1) == fila.length) ajaxRun();
                    return 0;
            }
        }
    }
Strsec=""+currentsec;
Strmin=""+time;
if (Strsec.length!=2){
Strsec="0"+currentsec;
}
if (Strmin.length!=2){
Strmin="0"+time;
}
document.display.seconds.value=Strsec
document.display.minutes.value=Strmin;
setTimeout('timer('+time+','+dmgtaken+','+enemyid+','+indchurch+')', 2);
}

function ajaxFormRegion(){
    var formregion = Form.serialize($('formregionselect'));
    new Ajax.Updater('divregionselect', 'fight.jsp', {asynchronous:true, parameters:formregion});
}

function ajaxFormRegister() {
    var formregister = Form.serialize($('formregister'));
    if(xmlhttp) {
      xmlhttp.open("GET","registeruser?" + formregister,true);
      xmlhttp.onreadystatechange = function(){
             if (xmlhttp.readyState == 4)
             {
                 if(xmlhttp.status == 200) {
                    fila[fila.length] = ["miolo", "herocreation.jsp?"+formregister];
                    //Se não há conexões pendentes, executa
                    if((ifila+1) == fila.length) setTimeout("ajaxRun()", 20);
                    return 0;
                 }
                 else {
                    alert("Error during AJAX call. Please try again");
                 }
               }
            }
      xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      xmlhttp.send(null);
      }
  }

