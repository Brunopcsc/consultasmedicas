/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.forms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class LoginFormBean {
    String login,senha,tipo;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public List<String> validar()
    {
        List<String> mensagens = new ArrayList<String>();
        if(login.trim().length()==0)
            mensagens.add("Login não pode ser vazio!");
        if(senha.trim().length()==0)
            mensagens.add("Senha não deve ser vazia!");
        
        return (mensagens.isEmpty() ? null : mensagens);
    }
}
