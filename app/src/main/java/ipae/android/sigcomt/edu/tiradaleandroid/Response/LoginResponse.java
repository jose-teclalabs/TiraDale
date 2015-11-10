package ipae.android.sigcomt.edu.tiradaleandroid.Response;

/**
 * Created by gcampos on 09/11/2015.
 */
public class LoginResponse {
    private String message;
    private Boolean succes;
    private Object valor;



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSucces() {
        return succes;
    }

    public void setSucces(Boolean succes) {
        this.succes = succes;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", succes=" + succes +
                ", valor=" + valor +
                '}';
    }

}
