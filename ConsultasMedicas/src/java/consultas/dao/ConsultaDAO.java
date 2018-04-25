/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.dao;

import consultas.beans.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.naming.NamingException;
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

    private final static String VERIFICA_CONSULTA_CRM = "SELECT"
            + " CPF,CRM, DATACONSULTA"
            + " FROM CONSULTA"
            + " WHERE DATACONSULTA=? AND CRM=?";

    private final static String VERIFICA_CONSULTA_CPF = "SELECT"
            + " CPF,CRM, DATACONSULTA"
            + " FROM CONSULTA"
            + " WHERE DATACONSULTA=? AND CPF=?";

    DataSource dataSource;

    public ConsultaDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Consulta gravarConsulta(Consulta u) throws SQLException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(CRIAR_CONSULTA_SQL, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, u.getCPF());
            ps.setString(2, u.getCRM());
            ps.setDate(3, new java.sql.Date(u.getDataConsulta().getTime()));
            ps.execute();

        }
        return u;
    }

    public boolean verificaConsultaCRM(String CRM, Date data) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(VERIFICA_CONSULTA_CRM)) {

            ps.setDate(1, new java.sql.Date(data.getTime()));
            ps.setString(2, CRM);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next())
                    return true;
                else return false;
            }
        }
    }

    public boolean verificaConsultaCPF(String CPF, Date data) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(VERIFICA_CONSULTA_CPF)) {

            ps.setDate(1, new java.sql.Date(data.getTime()));
            ps.setString(2, CPF);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next())
                    return true;
                else return false;
            }
        }
    }
}
