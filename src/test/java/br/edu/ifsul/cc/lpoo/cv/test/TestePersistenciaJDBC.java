
package br.edu.ifsul.cc.lpoo.cv.test;

import br.edu.ifsul.cc.lpoo.cv.model.Raca;
import br.edu.ifsul.cc.lpoo.cv.model.Pet;
import br.edu.ifsul.cc.lpoo.cv.model.*;
import br.edu.ifsul.cc.lpoo.cv.model.dao.PersistenciaJDBC;
import java.util.List;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import org.junit.Test;

public class TestePersistenciaJDBC {
//@Test
    public void testConexao() throws Exception {
        PersistenciaJDBC persistencia = new PersistenciaJDBC();
        if(persistencia.conexaoAberta()){
            System.out.println("Conexao estabelecida!");
            persistencia.fecharConexao();
        }else{
            System.out.println("Falhou ao abrir a conexao.via JDBC");
        }
    }
}
