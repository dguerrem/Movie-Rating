package objetos;

public class Usuario {

	private String nick;
	private String nombreCompleto;
	private String fechaNacimiento;
	private String correo;
	private String password;
	private String codVerificacion;
	private char tipo;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nick, String nombreCompleto, String fechaNacimiento, String correo,
			String password, String numeroVerificacion) {
		this.nick = nick;
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.password = password;
		this.codVerificacion = numeroVerificacion;
		this.tipo = 'A';
	}
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCodVerificacion() {
		return codVerificacion;
	}

	public void setCodVerificacion(String codVerificacion) {
		this.codVerificacion = codVerificacion;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getUsuarioCompleto() {
		return nick + " " + nombreCompleto + " " + fechaNacimiento + " " + correo;
	}
}
