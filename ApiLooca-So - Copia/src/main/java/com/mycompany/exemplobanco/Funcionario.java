package com.mycompany.exemplobanco;

public class Funcionario {
    private int idFuncionario;
    private String senha;
    private String fkEmpresa;
    
    
    
    @Override
    public String toString() {
      return "Funcionario [idFuncionario=" + idFuncionario + ", senha=" + senha + ", fkEmpresa=" + fkEmpresa + "]";
    }
    // Getters and Setters
    public int getIdFuncionario() {
      return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
      this.idFuncionario = idFuncionario;
    }
    public String getSenha() {
      return senha;
    }
    public void setSenha(String senha) {
      this.senha = senha;
    }
    public String getFkEmpresa() {
      return fkEmpresa;
    }
    public void setFkEmpresa(String fkEmpresa) {
      this.fkEmpresa = fkEmpresa;
    }
    
    
}
