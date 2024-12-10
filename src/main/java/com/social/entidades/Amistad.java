package com.social.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <h1>Amistad</h1> Entidad que representa
 * las peticiones de amistad entre usuarios
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Entity
public class Amistad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private long usuario1;
	private long usuario2;
	
	public Amistad() {}
	
	public Amistad(long idUs1, long idUs2)
	{
		this.usuario1 = idUs1;
		this.usuario2 = idUs2;
	}

	public long getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(long usuario1Id) {
		this.usuario1 = usuario1Id;
	}

	public long getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(long usuario2Id) {
		this.usuario2 = usuario2Id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Amistad [id=" + id + ", id_usuario1=" + usuario1 + ", id_usuario2=" + usuario2 + "]";
	}
	
}
