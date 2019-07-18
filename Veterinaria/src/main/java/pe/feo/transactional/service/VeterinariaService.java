package pe.feo.transactional.service;

import pe.feo.view.model.UsuarioRegistroModelRequest;
import pe.feo.view.model.UsuarioRegistroModelResponse;

public interface VeterinariaService {

	public UsuarioRegistroModelResponse registrarUsuario(UsuarioRegistroModelRequest request);
}
