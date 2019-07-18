package pe.feo.view.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.feo.transactional.service.VeterinariaService;
import pe.feo.view.model.UsuarioRegistroModelRequest;
import pe.feo.view.model.UsuarioRegistroModelResponse;

@Component
public class VeterinariaEndpointImpl implements VeterinariaEndpoint{
	
	@Autowired
	private VeterinariaService veterinariaService;

	@Override
	public UsuarioRegistroModelResponse registrarUsuario(UsuarioRegistroModelRequest request) {
		return veterinariaService.registrarUsuario(request);
	}

}
