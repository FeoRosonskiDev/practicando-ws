package pe.feo.persistence.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.feo.config.BaseTest;
import pe.feo.persistence.domain.Usuario;

public class UsuarioRepositoryTest extends BaseTest{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	public void registrarUsuarioTest()
	{
		Usuario usuario = new Usuario();
		usuario.setNombres("Juan Carlos");
		usuario.setApellidos("Castillo Aycachi");
		usuario.setCorreo("carlosjordi@hotmail.com");
		usuario.setDni("70555913");
		usuario.setEstado(1);
		
		usuarioRepository.registrarUsuario(usuario);
		System.out.println("id del usuario nuevo:" + usuario.getId());
	}
	
	@Test
	public void buscarCorreoTest()
	{
		String correo = usuarioRepository.buscarCorreo("carlosjordi@hotmail.com");
		System.out.println("Existe el correo ? " + correo);
	}
	
	@Test
	public void buscarDniTest()
	{
		String dni = usuarioRepository.buscarDni("70555913");
		System.out.println("Existe el dni ? " + dni);
	}
}
