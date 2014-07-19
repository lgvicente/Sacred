/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacred;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

/**
 *
 * @author luciano.vicente
 */
public class HeroItemDAO {
	
    public static HeroItemsBean getHeroItens(String login){

    	HeroItemsBean heroItemsBean = new HeroItemsBean();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String HeroItensQuery = null;


        HeroItensQuery = "Select h.*, lu.expneeded from HeroItens h inner join levelup lu on "
                         + "lu.level = h.herolevel+1 where userlogin = '"+login+"'";

        try{
        	conn = ConectionDB.getConnection();
         	stmt=conn.createStatement();
         	rs = stmt.executeQuery(HeroItensQuery);
	         	while (rs.next()) {
	     			String itemName = rs.getString("ItemName");
					if(itemName.equals("Gold")){                      
						  String heroName = rs.getString("heroname");
						  String heroLevel = rs.getString("herolevel");
						  String heroHP = rs.getString("herohp");
						  String heroMana = rs.getString("heroMana");
						  String qtdItem = rs.getString("QtdItem");
						  
						  heroItemsBean.setHeroName(heroName);
						  heroItemsBean.setHeroLevel(heroLevel);
						  heroItemsBean.setHeroHP(heroHP);
						  heroItemsBean.setHeroMana(heroMana);
						  heroItemsBean.setQtdItem(qtdItem);
					}
				}
     
	     	}catch (Exception ex){
	                System.out.println(ex);
        	}
		return heroItemsBean;
    }
};

