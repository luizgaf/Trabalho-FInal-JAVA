package com.controller;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


import com.model.CadastroFamilia;
import com.model.Endereco;
import org.springframework.transaction.annotation.Transactional;
import util.JPAUtil;

public class EnderecoDAO {

    public Endereco Salvar (Endereco endereco){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            em.merge(endereco);
            transacao.commit();
            return endereco;
        }
        catch (Exception ex){
            if (transacao.isActive()){
                transacao.rollback();
            }
            System.err.println("Erro ao salvar endereço do membro da familia"+ ex.getMessage());
            return null;
        }finally {
            em.close();
        }
    }

    public Endereco BuscarPorID (int idEndereco){
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.find(Endereco.class, idEndereco);
        }
        catch (Exception ex){
            System.err.println("Erro ao buscar id do enderço"+ ex.getMessage());
            return null;
        }finally {
            em.close();
        }
    }

    public Endereco Atualiazar (Endereco endereco){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            em.merge(endereco);
            transacao.commit();
            return endereco;
        }
        catch (Exception ex){
            if (transacao.isActive()){
                transacao.rollback();
            }
            System.err.println("Erro ao buscar id do enderço"+ ex.getMessage());
            return null;
        }finally {
            em.close();
        }
    }

    public void Deletar(int idEndereco){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            Endereco endereco = em.find(Endereco.class, idEndereco);
            if (endereco != null){
                em.remove(endereco);
            }
        }
        catch (Exception ex){
            if(transacao.isActive()){
                transacao.rollback();
            }
            System.err.println("Erro ao Deletar id do enderço"+ ex.getMessage());
        }finally {
            em.close();
        }
    }
    public List<Endereco> ListarEndereco(){
        EntityManager em = JPAUtil.getEntityManager();

        try {
            String jpql = "SELECT e FROM Endereco e";
            TypedQuery<Endereco> query = em.createQuery(jpql, Endereco.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao listar Endereços: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}
