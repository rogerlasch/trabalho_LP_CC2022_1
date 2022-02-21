
package br.edu.ifsul.cc.lpoo.cv.test;

import br.edu.ifsul.cc.lpoo.cv.Raca;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import br.edu.ifsul.cc.lpoo.cv.Pet;
import br.edu.ifsul.cc.lpoo.cv.dao.PersistenciaJDBC;
import br.edu.ifsul.cc.lpoo.cv.Cliente;
import br.edu.ifsul.cc.lpoo.cv.Especie;
import br.edu.ifsul.cc.lpoo.cv.dao.PersistenciaJPA;
import java.util.List;
import org.junit.Test;

public class TestPersistenciaJPA {
@Test
    public void testConexaoGeracaoTabelas() throws Exception{
        PersistenciaJPA persistencia = new PersistenciaJPA();
        if(persistencia.conexaoAberta()){
            System.out.println("Conexao estabelecida!via JPA");
testeRacas(persistencia);
testeClientes(persistencia);
            persistencia.fecharConexao();
        }else{
            System.out.println("Falha ao abrir conexao.com o BD via JPA");
        }
    }
public void testeRacas(PersistenciaJPA ins) throws Exception
{
List<Raca> racas=ins.listRacas();
if((racas==null)||(racas.isEmpty()))
{
System.out.println("Nao existem racas no db. Adicionando...");
insertEspecies(ins);
insertRacas(ins);
racas=ins.listRacas();
}
System.out.println("Mostrando racas...");
SPrinter sp=new SPrinter();
for(Raca r: racas)
{
sp.printRaca(r);
}
}

public void testeClientes(PersistenciaJPA ins) throws Exception
{
List<Pet> pets=ins.listPets();
if((pets==null)||(pets.isEmpty()))
{
System.out.println("Nao existem pets no db. Adicionando...");
insertClientes(ins);
pets=ins.listPets();
}
System.out.println("Mostrando pets...");
SPrinter sp=new SPrinter();
for(Pet r: pets)
{
sp.printPet(r);
}
Pet p=pets.get(0);
p.setNome("Frede");
ins.persist(p);
pets=ins.listPets();
p=pets.get(0);
System.out.println("Objeto modificado:");
sp.printPet(p);
}

public void insertEspecies(PersistenciaJPA ins) throws Exception
{
System.out.println("Insertando especies no banco de dados...");
Especie e=new Especie();;
e.setNome("Canino");
ins.persist(e);
e=new Especie();
e.setNome("Felino");
ins.persist(e);
e=new Especie();
e.setNome("Reptio");
ins.persist(e);
}
public void insertRacas(PersistenciaJPA ins) throws Exception
{
System.out.println("Adicionando racas ao db...");
Raca r=new Raca();
Especie e=new Especie();
e.setId(1);
r.setEspecie(e);
r.setNome("Pastor Alemao");
ins.persist(r);
r=new Raca();
e=new Especie();
e.setId(2);
r.setNome("Gato Persa");
r.setEspecie(e);
ins.persist(r);
r=new Raca();
e=new Especie();
e.setId(3);
r.setNome("Cascavel");
r.setEspecie(e);
ins.persist(r);
}
public void insertClientes(PersistenciaJPA ins)throws Exception
{
Especie e=new Especie();
e.setId(1);
Raca r=new Raca();
r.setId(1);
r.setEspecie(e);
Cliente c=new Cliente();
c.setCpf("01234567890");
c.setRG("1234567890");
c.setNumero_celular("549991231234");
c.setNome("Amanda");
c.setEndereco("Rua dos pinheiros 425");
c.setComplemento("Proximo ao centro");
c.setCep("0012532");
c.setEmail("amanda@gmail.com");
c.setSenha("12345");
ins.persist(c);
Pet p=new Pet();
p.setRaca(r);
p.setCliente(c);
p.setNome("Dorkas");
ins.persist(p);
//outro
e=new Especie();
e.setId(2);
r=new Raca();
r.setId(2);
r.setEspecie(e);
c=new Cliente();
c.setCpf("01521567890");
c.setRG("122598890");
c.setNumero_celular("549991438965");
c.setNome("Lucas");
c.setEndereco("Rua dos carvalhos 125");
c.setComplemento("Ao lado da rua dos pinheiros");
c.setCep("0033671");
c.setEmail("lucas@gmail.com");
c.setSenha("54321");
ins.persist(c);
p=new Pet();
p.setRaca(r);
p.setCliente(c);
p.setNome("Felicio");
ins.persist(p);
}

}
