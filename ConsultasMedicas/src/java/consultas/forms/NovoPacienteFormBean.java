/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class NovoPacienteFormBean {
    private String CPF,nome,senha,telefone,sexo,dataNascimento;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public List<String> validar()
    {
        List<String> mensagens = new ArrayList<String>();
        if(nome.trim().length()==0)
            mensagens.add("Nome não pode ser vazio!");
        if(CPF.length() != 11)
            mensagens.add("CPF deve conter 11 dígitos!");
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.parse(dataNascimento);
        } catch (ParseException pe) {
            mensagens.add("Data de nascimento deve estar no formato dd/mm/aaaa!");
        }
        if(telefone.trim().length()<11)
            mensagens.add("Telefone deve conter 11 dígitos!");
        if(senha.trim().length()==0)
            mensagens.add("Senha não deve ser vazia!");
        
        return (mensagens.isEmpty() ? null : mensagens);
    }
}
