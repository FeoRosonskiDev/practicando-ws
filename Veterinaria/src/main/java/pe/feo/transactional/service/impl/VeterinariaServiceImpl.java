package pe.feo.transactional.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.feo.persistence.domain.Usuario;
import pe.feo.persistence.repository.UsuarioRepository;
import pe.feo.transactional.service.VeterinariaService;
import pe.feo.view.model.UsuarioRegistroModelRequest;
import pe.feo.view.model.UsuarioRegistroModelResponse;

@Service("veterinariaService")
@Transactional
public class VeterinariaServiceImpl implements VeterinariaService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UsuarioRegistroModelResponse registrarUsuario(UsuarioRegistroModelRequest request) 
	{
		if (request.getNombres().trim().equals(""))
			return registroUsuarioNoValido("El nombre es obligatorio");
		
		if (request.getNombres().trim().length() > 50)
			return registroUsuarioNoValido("Tu nombre debe tener 50 o menos caracteres");
		
		if (!request.getNombres().trim().matches("^([A-Za-z]\\s*)+$"))
			return registroUsuarioNoValido("No se permiten números ni caracteres especiales en el nombre");
		
		if (request.getApellidos().trim().equals(""))
			return registroUsuarioNoValido("El apellido es obligatorio");
		
		if (request.getApellidos().trim().length() > 50)
			return registroUsuarioNoValido("Tu apellido debe tener 50 o menos caracteres");
		
		if (!request.getApellidos().trim().matches("^([A-Za-z]\\s*)+$"))
			return registroUsuarioNoValido("No se permiten números ni caracteres especiales en el apellido");
		
		if (request.getCorreo().trim().equals(""))
			return registroUsuarioNoValido("El correo es obligatorio");
		
		if (request.getCorreo().trim().length() > 40)
			return registroUsuarioNoValido("El correo debe tener 40 o menos caracteres");
		
		if (!request.getCorreo().trim().matches("^[\\w\\.]+\\@[A-Za-z]+(\\.[A-Za-z]+)+$"))
			return registroUsuarioNoValido("Correo invalido");
		
		if (request.getDni().trim().equals(""))
			return registroUsuarioNoValido("El DNI es obligatorio");
		
		if (request.getDni().trim().length() != 8)
			return registroUsuarioNoValido("El DNI debe tener 8 caracteres");
		
		if (!request.getDni().trim().matches("^[0-9]+$"))
			return registroUsuarioNoValido("El DNI debe contener solo números");
		
		/* validaciones contra la base de datos */
		
		if (usuarioRepository.buscarCorreo(request.getCorreo()) != null)
			return registroUsuarioNoValido("El correo ya está en uso");
		
		if (usuarioRepository.buscarDni(request.getDni()) != null)
			return registroUsuarioNoValido("El DNI ya está en uso");
		
		/* despues de pasar todas las validaciones, recién realizamos el registro */
		
		Usuario usuario = new Usuario();
		usuario.setNombres(request.getNombres());
		usuario.setApellidos(request.getApellidos());
		usuario.setCorreo(request.getCorreo());
		usuario.setDni(request.getDni());
		usuario.setEstado(1);
		usuarioRepository.registrarUsuario(usuario);
		
		UsuarioRegistroModelResponse response = new UsuarioRegistroModelResponse();
		response.setCodigo("07");
		response.setObservacion("Registrado");
		
		return response;
	}
	
	private UsuarioRegistroModelResponse registroUsuarioNoValido(String observacion)
	{
		UsuarioRegistroModelResponse response = new UsuarioRegistroModelResponse();
		response.setCodigo("999");
		response.setObservacion(observacion);
		return response;
	}

}
