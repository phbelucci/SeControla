package entity;

public class Usuario {

    private Integer codUs;
    private String nomeUs;
    private String senhaUs;
    private Integer codNivelAcesso;
    private Integer codGrupo;


    public Usuario() {
    }

    public boolean verificaSenha(String senha) {
        if (this.senhaUs.equals(senha)) {
            return true;
        }
        return false;
    }

    public Integer getCodGrupo() {
        return codGrupo;
    }

    public void setCodUs(Integer codUs) {
        this.codUs = codUs;
    }

    public void setNomeUs(String nomeUs) {
        this.nomeUs = nomeUs;
    }

    public void setSenhaUs(String senhaUs) {
        this.senhaUs = senhaUs;
    }

    public void setCodNivelAcesso(Integer codNivelAcesso) {
        this.codNivelAcesso = codNivelAcesso;
    }

    public void setCodGrupo(Integer codGrupo) {
        this.codGrupo = codGrupo;
    }
}
