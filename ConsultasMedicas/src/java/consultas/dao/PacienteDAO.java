/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.dao;

import consultas.beans.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import javax.naming.NamingException;

/**
 *
 * @author Bruno
 */
public class PacienteDAO {
    
    private final static String CRIAR_PACIENTE_SQL = "insert into PACIENTE"
            + " (CPF, nome, senha,telefone,sexo, dataDeNascimento)"
            + " values (?,?,?,?,?,?)";


    private final static String BUSCAR_PACIENTE_SQL = "select"
            + " CPF, nome, senha, telefone,sexo, dataDeNascimento"
            + " from paciente"
            + " where CPF=?";
    
    DataSource dataSource;


    public PacienteDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public Paciente gravarPaciente(Paciente u) throws SQLException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(CRIAR_PACIENTE_SQL, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, u.getCPF());
            ps.setString(2, u.getNome());
            ps.setString(3, u.getSenha());
            ps.setString(4, u.getTelefone());
            ps.setString(5, u.getSexo());
            ps.setDate(6, new java.sql.Date(u.getDataNascimento().getTime()));
            ps.execute();

        }
        return u;
    }
}
