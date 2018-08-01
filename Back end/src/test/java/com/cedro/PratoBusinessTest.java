package com.cedro;


import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.CollectionUtils;

import com.cedro.business.BusinessException;
import com.cedro.business.IPratoBusiness;
import com.cedro.business.PratoBusiness;
import com.cedro.dao.DAOException;
import com.cedro.dao.PratoDAO;
import com.cedro.entity.Prato;


/**
 * Classe de Teste responsavel por garantir a cobertura de testes, referente aos
 * metodos presentes na classe {@link PratoBusiness}.
 *
 * @author bruno
 */
@RunWith(MockitoJUnitRunner.class)
public class PratoBusinessTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Mock(name = "dao")
	private PratoDAO dao;

	@Spy
	@InjectMocks
	private IPratoBusiness business = new PratoBusiness();

	@Before
	public void init() throws Exception {
	}

	/**
	 * Metodo responsavel por instanciar um objeto do tipo PontoInteresse
	 * 
	 * @param codigo
	 * @return
	 */
	private Prato geraNewPrato(int codigo) {
		Prato prato = new Prato();
		prato.setCodigo(codigo);
		prato.setNome("teste");
		return prato;
	}

	@Test
	public void stage01_readAllPratosSuccessTest() throws DAOException, BusinessException {
		// Prepara dados
		List<Prato> pratos = Arrays.asList(geraNewPrato(1));

		// Prepara Mock
		Mockito.doReturn(pratos).when(dao).readAllPratos();

		// Executa teste
		List<Prato> result = business.readAllPratos();

		// Valida dados
		Assert.assertNotNull(result);
		Assert.assertTrue(!CollectionUtils.isEmpty(result));
	}

	@Test
	public void stage02_readAllPratosExceptionTest() throws DAOException, BusinessException {
		exception.expect(BusinessException.class);

		// Prepara Mock
		Mockito.doThrow(new DAOException()).when(dao).readAllPratos();

		// Executa teste
		business.readAllPratos();
	}

	
	@Test
	public void stage04_readByExampleSuccesstest() throws DAOException, BusinessException {
		// Prepara dados
		List<Prato> pratos = Arrays.asList(geraNewPrato(1));

		// Prepara Mock
		Mockito.doReturn(pratos).when(dao).readByExample(geraNewPrato(1));

		// Executa teste
		List<Prato> result = business.readByExample(geraNewPrato(1));

		// Valida dados
		Assert.assertNotNull(result);
	}
}
