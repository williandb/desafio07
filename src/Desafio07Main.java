import model.Funcionario;
import model.Diretor;
import repository.DiretorRepository;
import repository.FuncionarioRepository;
import service.DiretorService;
import service.FuncionarioService;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Desafio07Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Funcionario
        Funcionario funcionario = new Funcionario(1, "Francisco de Oliveira", "12345678900", new BigDecimal(3000.0));
        FuncionarioService fService = new FuncionarioService();
        fService.save(funcionario);

        funcionario.setNome(funcionario.getNome()+" - alterado");
        fService.update(funcionario);

        FuncionarioRepository fRepository = new FuncionarioRepository();

        fRepository.findAll();

        fRepository.findById(1);

        //Diretor
        Diretor diretor = new Diretor(1, "José da Silva", "12345678900", new BigDecimal(3000.0), new BigDecimal(500.0));
        DiretorService dService = new DiretorService();
        dService.save(diretor);

        diretor.setNome(diretor.getNome()+" - alterado");
        dService.update(diretor);

        DiretorRepository dRepository = new DiretorRepository();

        dRepository.findAll();

        dRepository.findById(1);

    }
}
