package repository;

import model.Funcionario;
import util.ConnectionManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository implements IRepository<Funcionario>{
    @Override
    public List<Funcionario> findAll() throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM funcionario");
        ResultSet resultSet = null;
        resultSet = statement.executeQuery();

        List<Funcionario> funcionarios = new ArrayList<>();

        System.out.println("---- Lista ----");
        while (resultSet.next()) {
            String index = resultSet.getString(2);
            System.out.println(index);
        }
        System.out.println("---- BUSCA POR ID FIM ----");
        conn.close();

        return funcionarios;
    }

    @Override
    public Funcionario findById(Integer id) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement statement3 = conn.prepareStatement("SELECT * FROM funcionario WHERE id = ?");
        statement3.setInt(1, id);
        ResultSet resultSet3 = null;
        resultSet3 = statement3.executeQuery();

        System.out.println("---- Listagem INI ----");
        while (resultSet3.next()) {
            String index = resultSet3.getString(2);
            System.out.println(index);
        }
        System.out.println("---- Listagem FIM ----");
        conn.close();

        return new Funcionario(1, "Francisco de Oliveira", "12345678900", new BigDecimal(3000.0));
    }
}
