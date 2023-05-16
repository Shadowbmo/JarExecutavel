/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplobanco;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author maessio
 */
public class Conexao {
    
    private JdbcTemplate conexaoDoBanco;

    public Conexao() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://server-infinity-solutions.database.windows.net:1433;database=bd-infinity-solutions;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");
        dataSource.setUsername("server-admin-infinity-solutions");
        dataSource.setPassword("#Gfgrupo3");
        
        this.conexaoDoBanco = new JdbcTemplate(dataSource);
    }

    //Getters and Setters
    public JdbcTemplate getConexaoDoBanco() {
        return conexaoDoBanco;
    } 
    
}
