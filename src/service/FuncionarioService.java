package service;

import model.Funcionario;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioService implements IService<Funcionario>{

    @Override
    public Funcionario save(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement insert = conn.prepareStatement("insert into funcionario values(?,?,?,?)");
        insert.setInt(1, funcionario.getId());
        insert.setString(2, funcionario.getNome());
        insert.setString(3, funcionario.getCpf());
        insert.setBigDecimal(4, funcionario.getSalario());
        insert.executeUpdate();
        conn.close();

        return funcionario;
    }

    @Override
    public Funcionario update(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement insert = conn.prepareStatement("UPDATE funcionario SET id = ?, nome = ?, cpf = ?,salario = ? WHERE id = ?");
        insert.setInt(1, funcionario.getId());
        insert.setString(2, funcionario.getNome());
        insert.setString(3, funcionario.getCpf());
        insert.setBigDecimal(4, funcionario.getSalario());
        insert.setInt(5, funcionario.getId());
        insert.executeUpdate();
        conn.close();

        return funcionario;
    }

    @Override
    public Funcionario delete(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement statement2 = conn.prepareStatement("DELETE FROM funcionario WHERE ID = ?");
        statement2.setInt(1, funcionario.getId());
        statement2.executeUpdate();
        conn.close();

        return funcionario;
    }
}
