package com.ultra.view.enderecos;

import com.ultra.controler.Endereco;
import com.ultra.controler.Pessoa;
import com.ultra.controler.TipoPessoa;
import com.ultra.model.DAOAbstrato;
import com.ultra.model.enderecos.ClienteEnderecoDAO;
import com.ultra.model.enderecos.FornecedorEnderecoDAO;
import com.ultra.model.enderecos.FuncionarioEnderecoDAO;
import com.ultra.model.pessoas.ClienteDAO;
import com.ultra.model.pessoas.PessoaDAO;
import com.ultra.view.ListedCrudController;
import com.ultra.view.util.modal.ErrorModal;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public abstract class EnderecoAbstratoController extends ListedCrudController<Endereco> {
    @FXML
    protected TextField logradouro;
    @FXML
    protected TextField bairro;
    @FXML
    protected TextField cidade;
    @FXML
    protected TextField estado;
    @FXML
    protected TextField pais;
    @FXML
    protected TextField cep;
    @FXML
    protected ComboBox<Pessoa> pessoa;

    public abstract TipoPessoa getTipo();

    @Override
    public Endereco newModelInstance() {
        return new Endereco();
    }

    @Override
    public DAOAbstrato<Endereco> newDAOInstance() {
        return getTipo().switchCase(ClienteEnderecoDAO::new, FuncionarioEnderecoDAO::new, FornecedorEnderecoDAO::new);
    }

    @Override
    public Iterable<Control> getFields() {
        return List.of(logradouro, bairro, cidade, estado, pais, cep, pessoa);
    }

    @Override
    public void executeCarregar(Endereco model) {
        logradouro.setText(model.getLogradouro());
        bairro.setText(model.getBairro());
        cidade.setText(model.getCidade());
        estado.setText(model.getEstado());
        pais.setText(model.getPais());
        cep.setText(model.getCep());

        ObservableList<Pessoa> items = pessoa.getItems();
        pessoa.getSelectionModel().select(
                items.indexOf(
                        items.stream()
                                .filter(p -> p.getPk() == model.getFk())
                                .collect(Collectors.toList())
                                .get(0)
                )
        );
    }

    @Override
    public void executeSalvar(Endereco model) {
        model.setLogradouro(logradouro.getText());
        model.setBairro(bairro.getText());
        model.setCidade(cidade.getText());
        model.setEstado(estado.getText());
        model.setPais(pais.getText());
        model.setCep(cep.getText());
        model.setFk(pessoa.getSelectionModel().getSelectedItem().getPk());
    }

    @Override
    public void aoInicializar() {
        PessoaDAO pessoaDAO = new ClienteDAO();
        try {
            pessoa.getItems().addAll(pessoaDAO.retreaveAll());
        } catch (SQLException e) {
            new ErrorModal(e.toString(), "Erro ao consultar as pessoas para o endereço");
        }
    }
}
