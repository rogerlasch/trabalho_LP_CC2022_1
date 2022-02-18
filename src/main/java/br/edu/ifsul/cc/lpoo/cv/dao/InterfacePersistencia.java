
package br.edu.ifsul.cc.lpoo.cv.dao;

import java.util.List;
import br.edu.ifsul.cc.lpoo.cv.*;

public interface InterfacePersistencia {
    public Boolean conexaoAberta();
    public void fecharConexao();
    public Object find(Class c, Object id) throws Exception;//select.
    public void persist(Object o) throws Exception;//insert ou update.
    public void remover(Object o) throws Exception;//delete.
public List<Pet> listPets() throws Exception;
public List<Raca> listRacas() throws Exception;
}
