package Modelos;

/**
 *
 * @author Estefano Mlller
 */
public class Usuario {
    
    private int Usuario_id;
    private String Usuario_usuario;
    private String Usuario_Pass;
    private String Profesores_idProfesor;
    private String Estudiantes_idEstudiantes;
    private int Egesados_idEGRESADO;

    public Usuario(String Usuario_usuario, String Usuario_Pass) {
        this.Usuario_usuario = Usuario_usuario;
        this.Usuario_Pass = Usuario_Pass;
    }

    public Usuario(int Usuario_id, String Usuario_usuario, String Usuario_Pass, String Profesores_idProfesor, String Estudiantes_idEstudiantes, int Egesados_idEGRESADO) {
        this.Usuario_id = Usuario_id;
        this.Usuario_usuario = Usuario_usuario;
        this.Usuario_Pass = Usuario_Pass;
        this.Profesores_idProfesor = Profesores_idProfesor;
        this.Estudiantes_idEstudiantes = Estudiantes_idEstudiantes;
        this.Egesados_idEGRESADO = Egesados_idEGRESADO;
    }
    
    
    
    

    public int getUsuario_id() {
        return Usuario_id;
    }

    public void setUsuario_id(int Usuario_id) {
        this.Usuario_id = Usuario_id;
    }

    public String getUsuario_usuario() {
        return Usuario_usuario;
    }

    public void setUsuario_usuario(String Usuario_usuario) {
        this.Usuario_usuario = Usuario_usuario;
    }

    public String getUsuario_Pass() {
        return Usuario_Pass;
    }

    public void setUsuario_Pass(String Usuario_Pass) {
        this.Usuario_Pass = Usuario_Pass;
    }

    public String getProfesores_idProfesor() {
        return Profesores_idProfesor;
    }

    public void setProfesores_idProfesor(String Profesores_idProfesor) {
        this.Profesores_idProfesor = Profesores_idProfesor;
    }

    public String getEstudiantes_idEstudiantes() {
        return Estudiantes_idEstudiantes;
    }

    public void setEstudiantes_idEstudiantes(String Estudiantes_idEstudiantes) {
        this.Estudiantes_idEstudiantes = Estudiantes_idEstudiantes;
    }

    public int getEgesados_idEGRESADO() {
        return Egesados_idEGRESADO;
    }

    public void setEgesados_idEGRESADO(int Egesados_idEGRESADO) {
        this.Egesados_idEGRESADO = Egesados_idEGRESADO;
    }
    
    
    

}