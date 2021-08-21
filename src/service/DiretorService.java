package service;

import model.Diretor;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DiretorService implements IService<Diretor>{

    @Override
    public Diretor save(Diretor diretor) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement insert = conn.prepareStatement("insert into diretor values(?,?,?,?,?)");
        insert.setInt(1, diretor.getId());
        insert.setString(2, diretor.getNome());
        insert.setString(3, diretor.getCpf());
        insert.setBigDecimal(4, diretor.getSalario());
        insert.setBigDecimal(5, diretor.getBonus());
        insert.executeUpdate();
        conn.close();

        return diretor;
    }

    @Override
    public Diretor update(Diretor diretor) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement insert = conn.prepareStatement("UPDATE diretor SET id = ?, nome = ?, cpf = ?,salario = ?, bonus = ? WHERE id = ?");
        insert.setInt(1, diretor.getId());
        insert.setString(2, diretor.getNome());
        insert.setString(3, diretor.getCpf());
        insert.setBigDecimal(4, diretor.getSalario());
        insert.setBigDecimal(5, diretor.getBonus());
        insert.setInt(6, diretor.getId());
        insert.executeUpdate();
        conn.close();

        return diretor;
    }

    @Override
    public Diretor delete(Diretor diretor) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement statement2 = conn.prepareStatement("DELETE FROM diretor WHERE ID = ?");
        statement2.setInt(1, diretor.getId());
        statement2.executeUpdate();
        conn.close();

        return diretor;
    }
}
