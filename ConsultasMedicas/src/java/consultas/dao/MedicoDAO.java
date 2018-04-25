/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.dao;

import consultas.beans.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Bruno
 */
public class MedicoDAO {

    private final static String CRIAR_MEDICO_SQL = "insert into MEDICO"
            + " (CRM, nome, senha, especialidade)"
            + " values (?,?,?,?)";

    private final static String LISTA_MEDICO_SQL = "select"
            + " CRM, nome, senha, especialidade"
            + " from medico";

    private final static String BUSCAR_MEDICO_ESPECIALIDADE_SQL = "select"
            + " CRM, nome, senha, especialidade"
            + " from medico"
            + " where especialidade=?";

    private final static String BUSCAR_MEDICO_SQL = "select"
            + " CRM, nome, senha, especialidade"
            + " from medico"
            + " where CRM=? and senha=?";
    
    
    private final static String VERIFICA_MEDICO = "SELECT * FROM MEDICO WHERE CRM=?";

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
            ps.setString(4, u.getEspecialidade());
            ps.execute();

        }
        return u;
    }

    public List<Medico> listarTodosMedicos() throws SQLException, NamingException {
        List<Medico> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LISTA_MEDICO_SQL)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Medico medico = new Medico();
                    medico.setCRM(rs.getString("CRM"));
                    medico.setNome(rs.getString("nome"));
                    medico.setSenha(rs.getString("senha"));
                    medico.setEspecialidade(rs.getString("especialidade"));
                    ret.add(medico);
                }
            }
        }
        return ret;
    }

    public List<Medico> listarTodosMedicosPorEspecialidade(String especialidade) throws SQLException, NamingException {
        List<Medico> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCAR_MEDICO_ESPECIALIDADE_SQL)) {

            ps.setString(1, especialidade);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Medico medico = new Medico();
                    medico.setCRM(rs.getString("CRM"));
                    medico.setNome(rs.getString("nome"));
                    medico.setSenha(rs.getString("senha"));
                    medico.setEspecialidade(rs.getString("especialidade"));
                    ret.add(medico);
                }
            }
        }
        return ret;
    }

    public Medico verificaLogin(String crm, String senha) throws SQLException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCAR_MEDICO_SQL)) {

            ps.setString(1, crm);
            ps.setString(2, senha);
            try (ResultSet rs = ps.executeQuery()) {
                if ( rs.next()) {
                    Medico med = new Medico();
                    med.setCRM(rs.getString("CRM"));
                    med.setNome(rs.getString("nome"));
                    med.setSenha(rs.getString("senha"));
                    med.setEspecialidade(rs.getString("especialidade"));
                    return med;
                } else {
                    return null;
                }
            }
        }
    }
    
    public boolean verificaCRM(String crm) throws SQLException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(VERIFICA_MEDICO)) {

            ps.setString(1, crm);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next())
                    return true;
                else return false;
            }
        }
    }
}
