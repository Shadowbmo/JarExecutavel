package com.github.britooo.looca.api.teste;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.mycompany.exemplobanco.Conexao;
import com.mycompany.exemplobanco.ConexaoMysql;
import com.mycompany.exemplobanco.Empresa;
import com.mycompany.exemplobanco.Totem;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TesteApi {
    public TesteApi() {
        initComponents();
    }

    private static void AtualizaDados() {          
        Conexao conexao = new Conexao();
        ConexaoMysql conexao2 = new ConexaoMysql();
        JdbcTemplate con = conexao.getConexaoDoBanco();
        JdbcTemplate con2 = conexao2.getConexaoDoBanco();
        
        
        
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                
                Looca looca = new Looca();
    
    Sistema sistema = new Sistema();
    Memoria memoria = new Memoria();
    Processador processador = new Processador();
    Empresa empresa = new Empresa();
    
                
    Totem tot = con.queryForObject("select NumIdenti, fkEmpresa from totem where NumIdenti = 'T1' and fkEmpresa = '21.312.983/2191-23'", new BeanPropertyRowMapper<>(Totem.class));

    con.update("insert into MonitoramentoDeRecursos (UsoDeCpu, UsoDeMemoriaRam, fkTotem, fkEmpresa) values (?, ?, 'T1',? )", processador.getUso(), memoria.getEmUso(),   tot.getFkEmpresa());
    con2.update("insert into MonitoramentoDeRecursos (UsoDeCpu, UsoDeMemoriaRam, fkTotem, fkEmpresa) values (?, ?, 'T1',? )", processador.getUso(), memoria.getEmUso(),   tot.getFkEmpresa());
    System.out.println("Dados inseridos no banco...");

    System.out.println("Sistema");
    System.out.println("-------------------------------------------------------------------");
    
    System.out.println(sistema);
    System.out.println("-------------------------------------------------------------------");
   
    System.out.println("Memoria");
    System.out.println("-------------------------------------------------------------------");
    System.out.println(memoria);
    System.out.println("-------------------------------------------------------------------");
    
    System.out.println("Processador");
    System.out.println("-------------------------------------------------------------------");
    System.out.println(processador.getUso());
    System.out.println("-------------------------------------------------------------------");
    
    System.out.println("Temperatura");
    System.out.println("-------------------------------------------------------------------");

   
            } 
        }, 0 , 30000);
    }
    public static void main(String args[]) {
        new Runnable() {
            public void run() {
                new TesteApi().setVisible(true);
            }  
        };
        AtualizaDados();
    }

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

