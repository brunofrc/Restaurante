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
import com.cedro.business.IRestauranteBusiness;
import com.cedro.business.RestauranteBusiness;
import com.cedro.dao.DAOException;
import com.cedro.dao.RestauranteDAO;
import com.cedro.entity.Restaurante;


/**
 * Classe de Teste responsavel por garantir a cobertura de testes, referente aos
 * metodos presentes na classe {@link RestauranteBusiness}.
 *
 * @author bruno
 */
@RunWith(MockitoJUnitRunner.class)
public class RestauranteBusinessTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Mock(name = "dao")
	private RestauranteDAO dao;

	@Spy
	@InjectMocks
	private IRestauranteBusiness business = new RestauranteBusiness();

	@Before
	public void init() throws Exception {
	}

	/**
	 * Metodo responsavel por instanciar um objeto do tipo PontoInteresse
	 * 
	 * @param codigo
	 * @return
	 */
	private Restaurante geraNewRestaurante(int codigo) {
		Restaurante restaurante = new Restaurante();
		restaurante.setCodigo(codigo);
		restaurante.setNome("teste");
		return restaurante;
	}

	@Test
	public void stage01_readAllRestauranteSuccessTest() throws DAOException, BusinessException {
		// Prepara dados
		List<Restaurante> restaurantes = Arrays.asList(geraNewRestaurante(1));

		// Prepara Mock
		Mockito.doReturn(restaurantes).when(dao).readAllRestaurantes();

		// Executa teste
		List<Restaurante> result = business.readAllRestaurantes();

		// Valida dados
		Assert.assertNotNull(result);
		Assert.assertTrue(!CollectionUtils.isEmpty(result));
	}

	@Test
	public void stage02_readAllRestauranteExceptionTest() throws DAOException, BusinessException {
		exception.expect(BusinessException.class);

		// Prepara Mock
		Mockito.doThrow(new DAOException()).when(dao).readAllRestaurantes();

		// Executa teste
		business.readAllRestaurantes();
	}

	@Test
	public void stage03_readByExampleWhereNomeNull() throws BusinessException {
		exception.expect(BusinessException.class);
		exception.expectMessage("Nome requerido para pesquisa");

		// Prepara Dados
		Restaurante request = geraNewRestaurante(1);
		request.setNome(null);

		// Executa teste
		business.readByExample(request);
	}

	
	@Test
	public void stage04_readByExampleSuccesstest() throws DAOException, BusinessException {
		// Prepara dados
		List<Restaurante> restaurantes = Arrays.asList(geraNewRestaurante(1));

		// Prepara Mock
		Mockito.doReturn(restaurantes).when(dao).readByExample(geraNewRestaurante(1));

		// Executa teste
		List<Restaurante> result = business.readByExample(geraNewRestaurante(1));

		// Valida dados
		Assert.assertNotNull(result);
	}

	
}
