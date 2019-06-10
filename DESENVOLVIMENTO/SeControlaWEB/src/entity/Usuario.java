package entity;

public class Usuario {

    private Integer codUs;
    private String nomeUs;
    private String senhaUs;
    //private Image avatarUs;
    private Integer codNivelAcesso;
    private Integer codGrupo;
    //private Login login;

    /*
    //com avatar
    public UsuarioEndpoint(Integer codUs, String nomeUs, Integer codGrupo, String usuario, Image avatarUs,String senha) {
        //login = new Login(codUs, usuario, senha);

        this.codUs = codUs;
        this.nomeUs = nomeUs;
        this.avatarUs = avatarUs;
        this.codGrupo = codGrupo;
    }
    */

    public Usuario() {
    }

    public Usuario(String nomeUs, String senha) {
        this.codUs = 1;
        this.nomeUs = nomeUs;
        this.senhaUs=senha;
        this.codGrupo = 1;
        this.codNivelAcesso = 2;
    }

    //sem avatar
    public Usuario(Integer codUs, String nomeUs, Integer codGrupo, String usuario, String senha) {
        //login = new Login(codUs, usuario, senha);

        this.codUs = codUs;
        this.nomeUs = nomeUs;
        this.codGrupo = codGrupo;
    }


    public boolean verificaSenha(String senha){
        if (this.senhaUs.equals(senha)){
            return true;
        }
        return false;
    }

    public Integer getCodUs() {
        return codUs;
    }

    public String getNomeUs() {
        return nomeUs;
    }

    public String getSenhaUs() {
        return senhaUs;
    }

    public Integer getCodNivelAcesso() {
        return codNivelAcesso;
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
