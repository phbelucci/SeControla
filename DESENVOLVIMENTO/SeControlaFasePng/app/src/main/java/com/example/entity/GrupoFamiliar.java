package com.example.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GrupoFamiliar implements Serializable {

    private Integer codGrupo;
    private Integer codAdmGrupo;
    //private HashMap<String, List<com.example.primeiroprojeto.entity.Usuario>> usuariosGrupo;
    private List<Usuario> usuariosGrupo;
    private List<ContaBancaria> contasGrupo;
    private List<Lancamento> lancamentosGrupo;


    public GrupoFamiliar(Integer codGrupo, Usuario admin) {
        this.codGrupo = codGrupo;
        usuariosGrupo.add(admin);
    }


    public Integer getCodGrupo() {
        return codGrupo;
    }
    public Integer getCodAdmGrupo() {
        return codAdmGrupo;
    }
    public void setCodAdmGrupo(Integer codAdmGrupo) {
        this.codAdmGrupo = codAdmGrupo;
    }

    //Metodos para criar as listas
    public void setUsuariosGrupo(List<Usuario> usuariosGrupo) { this.usuariosGrupo = usuariosGrupo; }
    public void setLancamentosGrupo(List<Lancamento> lancamentosGrupo) { this.lancamentosGrupo = lancamentosGrupo; }
    public void setContasGrupo(List<ContaBancaria> contasGrupo) {
        this.contasGrupo = contasGrupo;
    }
    //Metodos para criar as listas


    private boolean verificaUsuario(Integer codUsuario){
        for (Usuario u:usuariosGrupo) {
            if(u.getCodUs()==codUsuario) {
                return true;
            }
        }

        return false;
    }
    private boolean verificaConta(Integer codConta){
        for (ContaBancaria c:contasGrupo) {
            if(c.getCodConta()==codConta){
                return true;
            }
        }
        return false;
    }
    private boolean verificaLancamento(Integer codLancamento){
        for (Lancamento l:lancamentosGrupo) {
            if(l.getCodLanc()==codLancamento){
                return true;
            }
        }
        return false;
    }

    public void addUsuariosGrupo(Usuario usuario) {
        if(!verificaUsuario(usuario.getCodUs())) {
            usuariosGrupo.add(usuario);
        }
    }
    public void addContasGrupo(ContaBancaria conta) {
        if(!verificaConta(conta.getCodConta())) {
            contasGrupo.add(conta);
        }
    }
    public void addLancamentosGrupo(Lancamento lancamento) {
        if(!verificaLancamento(lancamento.getCodLanc())){
            lancamentosGrupo.add(lancamento);
        }
    }

    public void removeUsuariosGrupo(Usuario usuario) {
        if(verificaUsuario(usuario.getCodUs())) {
            usuariosGrupo.remove(usuario);
        }
    }
    public void removeContasGrupo(ContaBancaria conta) {
        if(verificaConta(conta.getCodConta())) {
            contasGrupo.remove(conta);
        }
    }
    public void removeLancamentosGrupo(Lancamento lancamento) {
        if(verificaLancamento(lancamento.getCodLanc())){
            lancamentosGrupo.remove(lancamento);
        }
    }


    public List<Lancamento> getLancamentosGrupo() {
        return lancamentosGrupo;
    }
    public List<Usuario> getUsuariosGrupo() {
        return usuariosGrupo;
    }
    public List<ContaBancaria> getContasGrupo() {
        return contasGrupo;
    }

    public ContaBancaria getConta(Integer codConta){
        //testa se a conta existe
        if(!verificaConta(codConta)){
            // throw exception
            // "\"Conta não pertence ao Grupo\""
        }

        for (ContaBancaria c : contasGrupo) {
            if(c.getCodConta()==codConta)
                return c;
        }

        return null;
    }
    public Usuario getUsuario(Integer codUsuario){
        //testa se o usuario existe
        if(!verificaUsuario(codUsuario)){
            // throw exception
            // "\"Usuario não pertence ao Grupo\""
        }

        for (Usuario u: usuariosGrupo) {
            if (u.getCodUs() == codUsuario)
                return u;
        }

        return null;
    }
    public Lancamento getLancamento(Integer codLanc){
        if(!verificaLancamento(codLanc)){
            // throw exception
            // "\"Conta não pertence ao Grupo\""
        }

        for (Lancamento l:lancamentosGrupo){
            if(l.getCodLanc()==codLanc){
                return l;
            }
        }
        return null;
    }


}