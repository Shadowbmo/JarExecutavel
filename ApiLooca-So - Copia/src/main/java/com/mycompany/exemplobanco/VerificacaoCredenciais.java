package com.mycompany.exemplobanco;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class VerificacaoCredenciais {

    public Boolean verCre(String login, String senha) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        Boolean verficacaoFinal = false;

        Empresa user = con.queryForObject("select * from empresa where email = ? and senha = ?"
    , new BeanPropertyRowMapper<>(Empresa.class), login, senha);
        
        System.out.println(user.getIdEmpresa());

        System.out.println("CREDENCIAISSS TESTE-------------------");

        if (user != null) {
            System.out.println(user);
            System.out.println("CREDENCIAISSSSSSSSSS");
            verficacaoFinal = true;
        }
        return verficacaoFinal;
    }
}
