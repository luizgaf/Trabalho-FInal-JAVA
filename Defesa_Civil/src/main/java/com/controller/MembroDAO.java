package com.controller;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.model.Membro;
import util.JPAUtil;

public class MembroDAO {

    public Membro Salvar(Membro membro){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            em.merge(membro);
            transacao.commit();
            return membro;
        }
        catch (Exception ex){
            if(transacao.isActive()){
                transacao.rollback();
            }
            System.err.println("Erro ao salvar membro da familia"+ ex.getMessage());
            return null;
        }finally {
            em.close();
        }
    }
    public Membro BuscarPorId (Membro cpf){
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.find(Membro.class, cpf);
        }
        catch (Exception ex){
            System.err.println("Erro ao buscar id do membro"+ ex.getMessage());
            return null;
        }
    }
    public Membro Atualizar (Membro membro){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            em.merge(membro);
            transacao.commit();
            return membro;
        }
        catch (Exception ex){
            if(transacao.isActive()){
                transacao.rollback();
            }
            System.err.println("Erro ao atualizar membro da familia"+ ex.getMessage());
            return null;
        }finally {
            em.close();
        }
    }
    public void Deletar (int cpf){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            Membro membro = em.find(Membro.class, cpf);
            if(membro != null){
                em.remove(cpf);
            }
        }
        catch (Exception ex){
            if(transacao.isActive()){
                transacao.rollback();
            }
            System.err.println("Erro ao deletar da familia"+ ex.getMessage());

        }finally {
            em.close();
        }
    }
}
