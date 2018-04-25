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
public class AgendarConsultaFormBean {
    String CRM,data;

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
     public List<String> validar()
    {
        List<String> mensagens = new ArrayList<String>();
        if(CRM.length() != 11)
            mensagens.add("CRM deve conter 11 dígitos!");
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.parse(data);
        } catch (ParseException pe) {
            mensagens.add("Data de nascimento deve estar no formato dd/mm/aaaa!");
        }
        
        return (mensagens.isEmpty() ? null : mensagens);
    }
}
