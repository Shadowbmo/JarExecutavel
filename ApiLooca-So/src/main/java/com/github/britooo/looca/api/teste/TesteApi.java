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
import java.awt.GraphicsEnvironment;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TesteApi {

    public TesteApi() {
        initComponents();
    }

    private static void AtualizaDados(String login, String senha, String numeroDeIdentificacaoDoTotem) {
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
                Temperatura temperatura = new Temperatura();
                Processador processador = new Processador();
                Empresa empresa = new Empresa();

                con.update("insert into MonitoramentoDeRecursos (UsoDeCpu, UsoDeMemoriaRam, Temperatura,DataHora, fkTotem, fkEmpresa) values (?, ?, ?, GETDATE(), ?,? )", processador.getUso(), memoria.getEmUso(), temperatura.getTemperatura(), numeroDeIdentificacaoDoTotem, login);
                con2.update("insert into monitoramentoderecursos (UsoDeCpu, UsoDeMemoriaRam,Temperatura,DataHora) values (?, ?, ?, now())", processador.getUso(), memoria.getEmUso(), temperatura.getTemperatura());
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
                System.out.println(temperatura.getTemperatura());
                System.out.println("-------------------------------------------------------------------");
                System.out.println("");
            }
        }, 0, 30000);
    }

    public static void main(String login, String senha, String numeroDeIdentificacaoDoTotem) {
        if (GraphicsEnvironment.isHeadless()) {
            AtualizaDados(login, senha, numeroDeIdentificacaoDoTotem);
        } else {
            new Runnable() {
                public void run() {
                    new TesteApi().setVisible(true);
                }
            };
            AtualizaDados(login, senha, numeroDeIdentificacaoDoTotem);
        }
    }

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
