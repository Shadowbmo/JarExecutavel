package com.mycompany.exemplobanco;

public class Empresa {
    private String idEmpresa;
    private String cnpj;
    
    @Override
    public String toString() {
      return "Empresa [idEmpresa=" + idEmpresa + ", cnpj=" + cnpj + "]";
    }

    public String getIdEmpresa() {
      return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
      this.idEmpresa = idEmpresa;
    }

    public String getCnpj() {
      return cnpj;
    }

    public void setCnpj(String cnpj) {
      this.cnpj = cnpj;
    }
    
    
}
