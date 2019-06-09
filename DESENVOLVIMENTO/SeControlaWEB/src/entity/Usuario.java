package entity;

public class UsuarioTO {

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

    public UsuarioTO(String nomeUs, String senha) {
        //login = new Login(codUs, usuario, senha);
        this.nomeUs = nomeUs;
        //login.setSenha(senha);
    }

    //sem avatar
    public UsuarioTO(Integer codUs, String nomeUs, Integer codGrupo, String usuario, String senha) {
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


}
