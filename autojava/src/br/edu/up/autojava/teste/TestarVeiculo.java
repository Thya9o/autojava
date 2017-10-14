package br.edu.up.autojava.teste;

import org.junit.Test;

import br.edu.up.autojava.model.Veiculo;
import br.edu.up.autojava.dal.VeiculoDAO;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

public class TestarVeiculo {
	
	// vars para executar testes
	public static VeiculoDAO dao = new VeiculoDAO();
	public static Veiculo testObject = new Veiculo();
	
    @BeforeClass
    public static void before() {
    	testObject.setPlaca("TESTE");
        dao.adicionar(testObject);
    }

    @AfterClass
    public static void after() {
        dao.remover(testObject);
    }
    
	@Test
	public void cadastrarSuccess() {
		Veiculo o = new Veiculo();
		o.setPlaca("Teste");
		
		// salva o objeto
		dao.adicionar(o);
		
		// verifica os valores
		assertEquals(true, o.getId() != null);
		
		// verifica se os dados cadastrados sao iguais
		Veiculo persistedObject = dao.buscar(o.getId());
		assertEquals(true, o.getId() == persistedObject.getId());
		assertEquals(true, o.validate());
		
		// exclui o objeto para nao poluir o banco
		dao.remover(o);
	}
	
	@Test
	public void cadastrarError() {
		Veiculo o = new Veiculo();
		
		o.setPlaca(null);
		
		// verifica se o cliente foi cadastrado com erro
		assertEquals(false, o.getId() != null);
		assertEquals(false, o.getPlaca() != null);
		assertEquals(false, dao.buscar(o.getId()) != null);
		assertEquals(false, o.validate());
	}
	
	@Test
	public void buscarSuccess() {
		Veiculo o = dao.buscar(dao.listar().get(0).getId());
	
		// verifica se um objeto foi encontrado
		assertEquals(true, o != null);
		assertEquals(true, o.getId() != null);
	}
	
	@Test(expected = NullPointerException.class)
	public void buscarError() {
		Veiculo o = dao.buscar(0);
		
		// verifica se nenhum objeto foi encontrado
		assertEquals(false, o != null);
		assertEquals(false, o.getId() != null);
	}
	
	@Test
	public void alterarSuccess() {
		Veiculo o = dao.buscar(dao.listar().get(0).getId());
	
		// altera o objeto
		o.setPlaca("Teste Alterado");
		dao.alterar(o);
		
		// verifica se o objeto foi alterado
		assertEquals(true, o.getId() != null);
		assertEquals(true, dao.buscar(o.getId()).getPlaca().equals("Teste Alterado"));
		assertEquals(true, o.validate());
	}
	
	@Test
	public void alterarError() {
		Veiculo o = dao.buscar(dao.listar().get(0).getId());
	
		// altera o objeto
		o.setPlaca(null);
		dao.alterar(o);
		
		// verifica se o objeto foi alterado
		assertEquals(true, o.getId() != null);
		assertEquals(true, dao.buscar(o.getId()).getPlaca() != null);
		assertEquals(false, o.validate());
	}
	
	@Test
	public void listarSuccess() {		
		// verifica se o tamanho da lista encontrada é maior que zero
		assertEquals(true, dao.listar().size() > 0);
	}
	
	@Test
	public void excluirSuccess() {
		Veiculo o = null;
		
		// salva um objeto para ser exluido
		o = new Veiculo();
		o.setPlaca("Teste Excluir");
		dao.adicionar(o);
		
		// verifica se o objeto foi salvo
		assertEquals(true, dao.buscar(o.getId()) != null);
		
		// exclui o objeto
		dao.remover(o);
		
		// verifica se o objeto foi exluido com sucesso
		assertEquals(true, dao.buscar(o.getId()) == null);
	}
}
