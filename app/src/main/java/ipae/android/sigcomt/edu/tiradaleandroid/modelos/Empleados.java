package ipae.android.sigcomt.edu.tiradaleandroid.modelos;

/**
 * Created by jpulido on 21/10/2015.
 */
public class Empleados {

    private Integer idUsuario;
    private String usuario;
    private String clave;

    public Empleados(Integer idUsuario, String usuario, String clave) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
