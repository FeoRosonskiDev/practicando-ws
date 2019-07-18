package pe.feo.persistence.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import pe.feo.persistence.domain.Usuario;

public interface UsuarioRepository {
	
	@Insert("insert into usuario (nombres, apellidos, correo, dni, estado) " +
			"values (#{nombres}, #{apellidos}, #{correo}, #{dni}, #{estado})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public void registrarUsuario(Usuario usuario);
	
	@Select("select correo from usuario where correo = #{correo}")
	@Results(value = {
			@Result(column = "correo", property = "correo")
	})
	public String buscarCorreo(String correo);
	
	@Select("select dni from usuario where dni = #{dni}")
	@Results(value = {
			@Result(column = "dni", property = "dni")
	})
	public String buscarDni(String dni);
}
