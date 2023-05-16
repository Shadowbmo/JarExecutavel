
package com.mycompany.exemplobanco;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Maecio
 */
public class ConexaoMysql {
    private JdbcTemplate conexaoDoBancoMysql;
     public ConexaoMysql() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/SistemaOperacional");
        dataSource.setUsername("root");
        dataSource.setPassword("urubu100");
        
        this.conexaoDoBancoMysql = new JdbcTemplate(dataSource);
    }

    //Getters and Setters
    public JdbcTemplate getConexaoDoBanco() {
        return conexaoDoBancoMysql;
    } 
}
