package pe.feo.view.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "UsuarioRegistroModelRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuarioRegistroModelRequest implements Serializable{

	private static final long serialVersionUID = -3871479688192272152L;
	
	private String nombres;
	private String apellidos;
	private String correo;
	private String dni;
}
