/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.dao;

import consultas.beans.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author Bruno
 */
public class ConsultaDAO {
    private final static String CRIAR_CONSULTA_SQL = "insert into Consulta"
            + " (CPF,CRM, dataConsulta)"
            + " values (?,?,?)";


    private final static String BUSCAR_CONSULTA_SQL_MED = "select"
            + " CPF,CRM, dataConsulta"
            + " from Consulta"
            + " where CRM=?";
    
    private final static String BUSCAR_CONSULTA_SQL_PAC = "select"
            + " CPF,CRM, dataConsulta"
            + " from Consulta"
            + " where CPF=?";
    
    DataSource dataSource;


    public ConsultaDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public Consulta gravarConsulta(Consulta u) throws SQLException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(CRIAR_CONSULTA_SQL, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, u.getCPF());
            ps.setString(2, u.getCRM());
            ps.setDate(3,new java.sql.Date(u.getDataConsulta().getTime()));
            ps.execute();

        }
        return u;
    }
}
