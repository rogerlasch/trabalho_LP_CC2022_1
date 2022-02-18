
package br.edu.ifsul.cc.lpoo.cv.dao;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import br.edu.ifsul.cc.lpoo.cv.*;

public class PersistenciaJPA implements InterfacePersistencia {

    public EntityManagerFactory factory;    //fabrica de gerenciadores de entidades
    public EntityManager entity;            //gerenciador de entidades JPA

    public PersistenciaJPA(){

        //parametro: é o nome da unidade de persistencia (Persistence Unit)
        factory = Persistence.createEntityManagerFactory("trabalho2021");
        entity = factory.createEntityManager();
    }


    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    //CRUD : c (create) r (list) u (update) d (delete)
    @Override
    public Object find(Class c, Object id) throws Exception {
        return entity.find(c, id);//encontra um determinado registro
    }
    @Override
    public void persist(Object o) throws Exception {
        entity.getTransaction().begin();// abrir a transacao.
        entity.persist(o); //realiza o insert ou update.
        entity.getTransaction().commit(); //comita a transacao (comando sql)
    }
    @Override
    public void remover(Object o) throws Exception {
        entity.getTransaction().begin();// abrir a transacao.
entity.remove(o); //realiza o delete
        entity.getTransaction().commit(); //comita a transacao (comando sql)
    }
    @Override
public List<Pet> listPets() throws Exception
{
        return entity.createNamedQuery("list_pets").getResultList();
}
    @Override
public List<Raca> listRacas() throws Exception
{
        return entity.createNamedQuery("list_racas").getResultList();
}
}
