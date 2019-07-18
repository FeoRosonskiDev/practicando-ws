package pe.feo.view.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import pe.feo.view.model.UsuarioRegistroModelRequest;
import pe.feo.view.model.UsuarioRegistroModelResponse;

@WebService(serviceName = "VeterinariaEndpoint")
public interface VeterinariaEndpoint {

	@WebMethod()
	@WebResult(name = "UsuarioRegistroModelResponse")
	public UsuarioRegistroModelResponse registrarUsuario(UsuarioRegistroModelRequest request);
}
