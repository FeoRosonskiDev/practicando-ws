package pe.feo.transactional.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.feo.config.BaseTest;
import pe.feo.transactional.service.VeterinariaService;
import pe.feo.view.model.UsuarioRegistroModelRequest;
import pe.feo.view.model.UsuarioRegistroModelResponse;

public class VeterinariaServiceImplTest extends BaseTest{
	
	@Autowired
	private VeterinariaService veterinariaService;

	@Test
	public void registrarUsuarioTest()
	{
		UsuarioRegistroModelRequest request = new UsuarioRegistroModelRequest();
		request.setNombres("Sandra Paola");
		request.setApellidos("Castillo Aycachi");
		request.setCorreo("sandra@gmail.com");
		request.setDni("70555915");
		
		UsuarioRegistroModelResponse response = veterinariaService.registrarUsuario(request);
		System.out.println("Usuario registrado ? " + gson.toJson(response));
	}
}
