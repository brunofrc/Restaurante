package com.cedro.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cedro.business.BusinessException;
import com.cedro.business.IPratoBusiness;
import com.cedro.business.IRestauranteBusiness;
import com.cedro.entity.Prato;
import com.cedro.entity.Restaurante;


@RestController
@CrossOrigin(origins = "*")
public class Controller {
	
	@Autowired
	private IRestauranteBusiness business;
	
	@Autowired
	private IPratoBusiness businessPrato;
	 
	@RequestMapping(value = "/api/restaurante/readByExample", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> readbyExample(@RequestBody Restaurante restaurante)
			throws BusinessException {

		try {
			List<Restaurante> restaurantes = business.readByExample(restaurante);

			return new ResponseEntity<List<Restaurante>>(restaurantes,
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	
	@RequestMapping(value = "/api/restaurante/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createRestaurante(@RequestBody Restaurante restaurante)
			throws BusinessException {

		try {
			business.create(restaurante);

			return new ResponseEntity<Object[]>(new Object[] { restaurante, "registro salvo com sucesso!" },
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	@RequestMapping(value = "/api/restaurante/readAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> readAllRestaurante()
			throws BusinessException {
		
		try {
			List<Restaurante> restaurantes = business.readAllRestaurantes();
			
			return new ResponseEntity<List<Restaurante>>(restaurantes,
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	@RequestMapping(value = "/api/restaurante/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateRestaurante(@RequestBody Restaurante restaurante)
			throws BusinessException {

		try {
			business.update(restaurante);

			return new ResponseEntity<Object[]>(new Object[] { restaurante, "registro atualizado com sucesso!" },
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	@RequestMapping(value = "/api/restaurante/delete", method = RequestMethod.POST)
	public ResponseEntity<?> deleteRestaurante(@RequestBody Restaurante restaurante)
			throws BusinessException {

		try {
			business.delete(restaurante);

			return new ResponseEntity<String>("registro excluído com sucesso!",
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	@RequestMapping(value = "/api/prato/readByExample", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> readbyExample(@RequestBody Prato prato)
			throws BusinessException {

		try {
			List<Prato> pratos = businessPrato.readByExample(prato);

			return new ResponseEntity<List<Prato>>(pratos,
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	
	@RequestMapping(value = "/api/prato/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createPrato(@RequestBody Prato prato)
			throws BusinessException {

		try {
			businessPrato.create(prato);

			return new ResponseEntity<Object[]>(new Object[] { prato, "registro salvo com sucesso!" },
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	@RequestMapping(value = "/api/prato/readAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> readAllPrato()
			throws BusinessException {
		
		try {
			List<Prato> pratos = businessPrato.readAllPratos();
			
			return new ResponseEntity<List<Prato>>(pratos,
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	@RequestMapping(value = "/api/prato/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePrato(@RequestBody Prato prato)
			throws BusinessException {

		try {
			businessPrato.update(prato);

			return new ResponseEntity<Object[]>(new Object[] { prato, "registro atualizado com sucesso!" },
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	@RequestMapping(value = "/api/prato/delete", method = RequestMethod.POST)
	public ResponseEntity<?> deletePrato(@RequestBody Prato prato)
			throws BusinessException {

		try {
			businessPrato.delete(prato);

			return new ResponseEntity<String>("registro excluído com sucesso!",
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
}
