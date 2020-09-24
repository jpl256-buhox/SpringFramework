package mx.com.cfe.cfecontigo.auth.server.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "segc_usuario")
public class UserModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_segcusuarios")
	@SequenceGenerator(name="gen_segcusuarios", sequenceName = "seq_segc_usuario", allocationSize = 1)
	@Column(name = "id_usuario", updatable = false, nullable = false)
	private long idUser;
	@Column(name = "nombre")
	private String firstName;
	@Column(name = "apellidos")
	private String lastName;
	@Column(name = "correo")
	private String email;
	@Column(name = "contrasena")
	private String passwrd;
	@Column(name = "id_tipo_usuario")
	private int idUserType;
	@Column(name = "token")
	private String accessToken;
	@Column(name = "paperless")
	private Boolean paperless;
	@Column(name = "notificaciones")
	private Boolean notifications;
	
	// Audit
	// id
	@Column(name = "usuario_creacion")
	private String creationUser;
	// id
	@Column(name = "usuario_modificacion")
	private String modificationUser;
	// timestamp
	@Column(name = "fecha_creacion")
	private Timestamp creationDate;
	// timestamp
	@Column(name = "fecha_modificacion")
	private Timestamp modificationDate;
	// 1 registro 0 eliminado 
	@Column(name = "es_estado_registro")
	private String registerState;
	
	
	
	
	// Not in DB
	@Transient
	private String refreshToken;
		
	
	
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswrd() {
		return passwrd;
	}
	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}
	public int getIdUserType() {
		return idUserType;
	}
	public void setIdUserType(int idUserType) {
		this.idUserType = idUserType;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Boolean getPaperless() {
		return paperless;
	}
	public void setPaperless(Boolean paperless) {
		this.paperless = paperless;
	}
	public Boolean getNotifications() {
		return notifications;
	}
	public void setNotifications(Boolean notifications) {
		this.notifications = notifications;
	}
	public String getCreationUser() {
		return creationUser;
	}
	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}
	public String getModificationUser() {
		return modificationUser;
	}
	public void setModificationUser(String modificationUser) {
		this.modificationUser = modificationUser;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Timestamp getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Timestamp modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getRegisterState() {
		return registerState;
	}
	public void setRegisterState(String registerState) {
		this.registerState = registerState;
	}
	@Override
	public String toString() {
		return "UserModel [idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", passwrd=" + passwrd + ", idUserType=" + idUserType + ", accessToken=" + accessToken
				+ ", paperless=" + paperless + ", notifications=" + notifications + ", creationUser=" + creationUser
				+ ", modificationUser=" + modificationUser + ", creationDate=" + creationDate + ", modificationDate="
				+ modificationDate + ", registerState=" + registerState + "]";
	}
	
	
	
	
}
