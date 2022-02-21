package pe.todotic.mitiendaapi_s3.web.dto;

import lombok.Data;
import pe.todotic.mitiendaapi_s3.model.Usuario;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
public class UsuarioDTO {
    @NotNull(message = "El nombre es obligatorio")
    @Size(min = 3, max = 30)
    private String nombres;
    @NotNull(message = "El apellido es obligatorio")
    @Size(min = 3, max = 30)
    private String apellidos;
    @Pattern(regexp = "^.+@.+\\..+$",message = "correo Invalido")
    @NotNull(message = "El correo es obligatorio")
    private String email;
    @NotNull(message = "El password es obligatorio")
    @Size(min = 4, max = 10)
    private String password;
    @NotNull(message = "El rol es obligatorio")
    private Usuario.Rol rol;
}
