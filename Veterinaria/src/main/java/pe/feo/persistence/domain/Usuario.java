package pe.feo.persistence.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

	private Integer id;
	private String nombres;
	private String apellidos;
	private String correo;
	private String dni;
	private Integer estado;
}
