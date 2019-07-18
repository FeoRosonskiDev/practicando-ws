package pe.feo.view.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "UsuarioRegistroModelResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuarioRegistroModelResponse implements Serializable{

	private static final long serialVersionUID = 9147243966088139723L;

	private String codigo;
	private String observacion;
}
