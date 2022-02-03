
package br.edu.ifsul.cc.lpoo.clinica.test;

import br.edu.ifsul.cc.lpoo.clinica.Raca;
import br.edu.ifsul.cc.lpoo.clinica.Pet;
import br.edu.ifsul.cc.lpoo.clinica.dao.PersistenciaJDBC;
import java.util.List;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import org.junit.Test;

public class TestePersistenciaJDBC {
@Test
    public void testConexao() throws Exception {
        PersistenciaJDBC persistencia = new PersistenciaJDBC();
        if(persistencia.conexaoAberta()){
            System.out.println("Conexão estabelecida!");
testar_racas(persistencia);
            persistencia.fecharConexao();
        }else{
            System.out.println("Falhou ao abrir a conexão.via JDBC");
        }
    }
public void testar_racas(PersistenciaJDBC  per)
{
System.out.println("Entrou aqui");
try {
Raca r=new Raca();
r.setNome("Poodle");
per.persist(r);
        } catch (Exception e) {
e.printStackTrace();
        }
System.out.println("Saiu!");
}
}
