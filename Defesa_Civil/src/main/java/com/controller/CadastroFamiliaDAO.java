package com.controller;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.model.CadastroFamilia;
import util.JPAUtil;

public class CadastroFamiliaDAO {

    public CadastroFamilia Salvar(CadastroFamilia cf){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            em.merge(cf);
            transacao.commit();
            return cf;
        }
        catch (Exception ex){
            if(transacao.isActive()){
                transacao.rollback();
            }
            System.err.println("Erro ao salvar Cadastro da familia"+ ex.getMessage());
            return cf;
        }finally {
            em.close();
        }
    }
    public CadastroFamilia BuscarPorId(int idFamilia){
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.find(CadastroFamilia.class, idFamilia);
        }
        catch (Exception ex){
            System.err.println("Erro ao buscar o Id da familia"+ ex.getMessage());
            return null;
        }finally {
            em.close();
        }
    }
    public CadastroFamilia Atualizar(CadastroFamilia cf){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            em.merge(cf);
            transacao.commit();
            return cf;
        }
        catch (Exception ex){
            if(transacao.isActive()){
                transacao.rollback();
            }
            System.err.println("Erro ao atualizar cadastro da familia"+ ex.getMessage());
            return null;
        }finally {
            em.close();
        }
    }
    public void Deletar(int idFamilia){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            CadastroFamilia cf = em.find(CadastroFamilia.class, idFamilia);
            if(cf != null){
                em.remove(cf);
            }
        }
        catch (Exception ex){
            if(transacao.isActive()){
                transacao.rollback();
            }
            System.err.println("Erro ao deletar cadastro da familia"+ ex.getMessage());
        }finally {
            em.close();
        }
    }
}
