/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.dao;

import consultas.beans.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author Bruno
 */
public class MedicoDAO {
    private final static String CRIAR_MEDICO_SQL = "insert into MEDICO"
            + " (CRM, nome, senha, especialidade)"
            + " values (?,?,?,?)";


    private final static String BUSCAR_MEDICO_SQL = "select"
            + " CRM, nome, senha, especialidade"
            + " from medico"
            + " where CRM=?";
    
    DataSource dataSource;


    public MedicoDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public Medico gravarMedico(Medico u) throws SQLException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(CRIAR_MEDICO_SQL, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, u.getCRM());
            ps.setString(2, u.getNome());
            ps.setString(3, u.getSenha());
            ps.setString(4,u.getEspecialidade());
            ps.execute();

        }
        return u;
    }
}
