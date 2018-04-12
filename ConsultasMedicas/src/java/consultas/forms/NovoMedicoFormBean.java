/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class NovoMedicoFormBean {
    private String CRM,nome,senha,especialidade;

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
     public List<String> validar()
    {
        List<String> mensagens = new ArrayList<String>();
        if(nome.trim().length()==0)
            mensagens.add("Nome não pode ser vazio!");
        if(CRM.length() != 11)
            mensagens.add("CRM deve conter 11 dígitos!");
        if(especialidade.trim().length()==0)
            mensagens.add("Especialidade não pode ser vazia!");
        if(senha.trim().length()==0)
            mensagens.add("Senha não deve ser vazia!");
        
        return (mensagens.isEmpty() ? null : mensagens);
    }
}
