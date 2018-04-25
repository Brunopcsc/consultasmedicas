/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.dao;

import consultas.beans.Administrador;
import consultas.beans.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.sql.DataSource;

/**
 *
 * @author Bruno
 */
public class AdministradorDAO {


    private final static String BUSCAR_ADMIN = "select "
            + "nome, senha"
            + " from administrador"
            + " where nome=? and senha=?";
    
    DataSource dataSource;


    public AdministradorDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
   
    
     public Administrador verificaLogin(String nome, String senha) throws SQLException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCAR_ADMIN)) {

            ps.setString(1, nome);
            ps.setString(2, senha);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {                    
                    Administrador admin = new Administrador();
                    admin.setNome(rs.getString("nome"));
                    admin.setSenha(rs.getString("senha"));
                    return admin;
                } else {
                    return null;
                }
            }
        }
     }
}
