/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacred;

import java.util.*;
import java.sql.*;

/**
 *
 * @author luciano.vicente
 */
public class ComponentPopulator {

    public List<String> countrylist() throws SQLException{

        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        String countryQuery = "select CountryName from country";
        List<String> countryname = new ArrayList<String>();

            conn = ConectionDB.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(countryQuery);

            while(rs.next()){
                countryname.add(rs.getString("CountryName"));
            }
            rs.close();
            conn.close();

        return countryname;
     }

    public List<String> itemtypelist() throws SQLException{

        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        String itemtypeQuery = "select itemtypedesc from itemtype";
        List<String> itemtype = new ArrayList<String>();

            conn = ConectionDB.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(itemtypeQuery);

            while(rs.next()){
                itemtype.add(rs.getString("itemtypedesc"));
            }
            rs.close();
            conn.close();

        return itemtype;
    }

    public List<String> classlist() throws SQLException{

        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        String classQuery = "select classname from class";
        List<String> classname = new ArrayList<String>();

            conn = ConectionDB.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(classQuery);

            while(rs.next()){
                classname.add(rs.getString("classname"));
            }
            rs.close();
            conn.close();

        return classname;
    }

    public List<String> itemraritylist() throws SQLException{

        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        String itemrarityQuery = "select itemraritydesc from itemrarity";
        List<String> itemrarity = new ArrayList<String>();

            conn = ConectionDB.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(itemrarityQuery);

            while(rs.next()){
                itemrarity.add(rs.getString("itemraritydesc"));
            }
            rs.close();
            conn.close();

        return itemrarity;
    }

    public List<String> itemlist() throws SQLException{

        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        String itemnameQuery = "select itemname from item";
        List<String> itemname = new ArrayList<String>();

            conn = ConectionDB.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(itemnameQuery);

            while(rs.next()){
                itemname.add(rs.getString("itemname"));
            }
            rs.close();
            conn.close();

        return itemname;
    }

    public List<String> enemylist() throws SQLException{

        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        String enemynameQuery = "select enemyname from enemy";
        List<String> enemyname = new ArrayList<String>();

            conn = ConectionDB.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(enemynameQuery);

            while(rs.next()){
                enemyname.add(rs.getString("enemyname"));
            }
            rs.close();
            conn.close();

        return enemyname;
    }

    public List<String> enemytypelist() throws SQLException{

        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        String enemytypeQuery = "select enemytypedesc from enemytype";
        List<String> enemytype = new ArrayList<String>();

            conn = ConectionDB.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(enemytypeQuery);

            while(rs.next()){
                enemytype.add(rs.getString("enemytypedesc"));
            }
            rs.close();
            conn.close();

        return enemytype;
    }

}
