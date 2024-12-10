/**
 *
 */
package com.social.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * <h1>Usuario</h1> Modelo que representa a un usuario del sistema
 *
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;

	private String password;
	private String email;
	private String nombre;
	private String apellidos;
	private String descripcion;
	@Column(length = 16777216)
	private String fotoPerfil;
	@Column(length = 16777216)
	private String fotoDesc;
	private String role;

	@Transient
	private String passwordConfirm;

	@ManyToMany
	private Set<Usuario> amigos = new HashSet<Usuario>();

	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
	private Set<Publicacion> post = new HashSet<>();

	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
	private Set<Comentario> comentarios = new HashSet<>();

	@ManyToMany
	private Set<Publicacion> likesDados = new HashSet<>();

	public Usuario() {
		this.setFotoPerfil("https://ssl.gstatic.com/images/branding/product/1x/avatar_circle_blue_512dp.png");
	}


	public Usuario(String username, String password, String email, String nombre, String apellidos, String descripcion,
				   String fotoPerfil, String fotoDesc, Set<Usuario> amigos, Set<Publicacion> post,
				   Set<Comentario> comentarios, Set<Publicacion>) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.descripcion = descripcion;
		this.fotoPerfil = fotoPerfil;
		this.fotoDesc = fotoDesc;
		this.amigos = amigos;
		this.post = post;
		this.comentarios = comentarios;
	}

	public Usuario(String username, String nombre, String apellidos) {
		this(username, "1234", "a@example.com", nombre, apellidos, "prueba",
				"https://ssl.gstatic.com/images/branding/product/1x/avatar_circle_blue_512dp.png", "fotodesc_jpg",
				new HashSet<Usuario>(), new HashSet<Publicacion>(), new HashSet<Comentario>(),
				new HashSet<Publicacion>());
	}

	// ===================GETTERS===================
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the foto_perfil
	 */
	public String getFotoPerfil() {
		return fotoPerfil;
	}

	/**
	 * @return the foto_desc
	 */
	public String getFotoDesc() {
		return fotoDesc;
	}

	/**
	 * @return the amigos
	 */
	public Set<Usuario> getAmigos() {
		return amigos;
	}

	/**
	 * @return the post
	 */
	public Set<Publicacion> getPost() {
		return post;
	}

	/**
	 * @return the comentarios
	 */
	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	/**
	 * @return the likes_dados
	 */
	public Set<Publicacion> getLikesDados() {
		return likesDados;
	}

	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	// ===================SETTERS===================

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @param passwordConfirm
	 *            the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @param foto_perfil
	 *            the foto_perfil to set
	 */
	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	/**
	 * @param foto_desc
	 *            the foto_desc to set
	 */
	public void setFotoDesc(String fotoDesc) {
		this.fotoDesc = fotoDesc;
	}

	/**
	 * @param amigos
	 *            the amigos to set
	 */
	public void setAmigos(Set<Usuario> amigos) {
		this.amigos = amigos;
	}

	/**
	 * @param post
	 *            the post to set
	 */
	public void setPost(Set<Publicacion> post) {
		this.post = post;
	}

	/**
	 * @param comentarios
	 *            the comentarios to set
	 */
	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * @param likes_dados
	 *            the likes_dados to set
	 */
	public void setLikesDados(Set<Publicacion> likesDados) {
		this.likesDados = likesDados;
	}
	// ===================Equals===================

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;

	}
	@Override
	public int hashCode() {
		final int prime = 31; // A prime number used for hash computation
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	// ===================ToString===================
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario-> id:" + id + " username:" + username + " nombre:" + nombre + " apellidos:" + apellidos
				+ " email:" + email;
	}

	public String getNombreCompleto() {
		return nombre + " " + apellidos;
	}

	public void addAmigo(Usuario u) {
		this.amigos.add(u);
	}

	public boolean esAmigo(Usuario u) {
		if (this.getUsername().equals(u.getUsername())) // Mismos usuarios
			return false;
		return amigos.contains(u);
	}



	public void addPost(Publicacion post2) {
		this.post.add(post2);
	}

	public void addComentario(Comentario com) {
		this.comentarios.add(com);
	}

	public void addLike(Publicacion u) {
		this.likesDados.add(u);
	}

	public boolean dioLike(Publicacion post) {
		return this.likesDados.stream().filter(x -> x.getId().equals(post.getId())).count() > 0;
	}

	public void deleteAmigo(Usuario usuario) {
		this.amigos.remove(usuario);
	}
}
