
package br.edu.ifsul.cc.lpoo.cv.test;

import br.edu.ifsul.cc.lpoo.cv.Raca;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import br.edu.ifsul.cc.lpoo.cv.Pet;
import br.edu.ifsul.cc.lpoo.cv.Cliente;
import br.edu.ifsul.cc.lpoo.cv.Especie;
import br.edu.ifsul.cc.lpoo.cv.dao.PersistenciaJPA;
import java.util.List;
import org.junit.Test;

public class TestPersistenciaJPA {
@Test
    public void testConexaoGeracaoTabelas(){
        PersistenciaJPA persistencia = new PersistenciaJPA();
        if(persistencia.conexaoAberta()){
            System.out.println("Conexão estabelecida!via JPA");
insert_racas(persistencia);
show_racas(persistencia);
//remove_raca(persistencia, 2);
insert_pets(persistencia);
show_pets(persistencia);
            persistencia.fecharConexao();
        }else{
            System.out.println("Falha ao abrir conexão.com o BD via JPA");
        }
    }
public void insert_racas(PersistenciaJPA  per)
{
System.out.println("Adicionando racas no db...");
try {
Cliente ps=new Cliente();
ps.setNome("Maria");
ps.setCpf("01234567891");
ps.setRG("00112234432");
ps.setSenha("12345");
ps.setEmail("maria@gmail.com");
ps.setNumero_celular("99823421234");
ps.setEndereco("Rua dos pinheiros");
ps.setComplemento("Perto do centro");
ps.setCep("99062772");
per.persist(ps);
Especie esp=new Especie();
esp.setNome("Canino");
esp.setId(1);
Raca r=new Raca();
r.setNome("Poodle");
r.setEspecie(esp);
per.persist(r);
r=new Raca();
r.setNome("Pinxer");
r.setEspecie(esp);
per.persist(r);
r=new Raca();
r.setNome("shiba");
r.setEspecie(esp);
per.persist(r);
r=new Raca();
r.setNome("Border collie");
r.setEspecie(esp);
per.persist(r);
r=new Raca();
r.setNome("Pastor Alemao");
r.setEspecie(esp);
per.persist(r);
        } catch (Exception e) {
e.printStackTrace();
        }
}
public void show_racas(PersistenciaJPA  per)
{
System.out.println("Mostrando racas");
try {
List<Raca> racas=per.listRacas();
System.out.println("Id\tNome\tEspecie");
for(Raca r: racas)
{
System.out.println(r.getId()+"\t"+r.getNome()+"\t"+r.getEspecie().getNome());
}
        } catch (Exception e) {
e.printStackTrace();
        }
}
public void remove_raca(PersistenciaJPA  per, Integer id)
{
System.out.println("Removendo raca: "+id);
try {
Raca r=new Raca();
r.setId(id);
per.remover(r);
        } catch (Exception e) {
e.printStackTrace();
        }
}
public void insert_pets(PersistenciaJPA  per)
{
System.out.println("Adicionando pets no db...");
try {
Calendar c=Calendar.getInstance();
Pet p=new Pet();
p.setNome("Cachorrinho");
c.set(Calendar.MONTH, Calendar.JANUARY);
p.setDataNascimento(c);
Cliente ps=new Cliente();
ps.setNome("Maria");
ps.setCpf("01234567891");
ps.setRG("00112234432");
ps.setSenha("12345");
ps.setEmail("maria@gmail.com");
ps.setNumero_celular("99823421234");
ps.setEndereco("Rua dos pinheiros");
ps.setComplemento("Perto do centro");
ps.setCep("99062772");
Especie esp=new Especie();
esp.setNome("Canino");
esp.setId(1);
p.setCliente(ps);
Raca r=new Raca();
r.setId(1);
r.setNome("Poodle");
r.setEspecie(esp);
p.setRaca(r);
per.persist(p);
        } catch (Exception e) {
e.printStackTrace();
        }
}
public void show_pets(PersistenciaJPA  per)
{
System.out.println("Mostrando pets");
try {
List<Pet> pets=per.listPets();
System.out.println("Id\tNome\tNascimento");
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
for(Pet p: pets)
{
System.out.println(p.getId()+"\t"+p.getNome()+"\t"+sdf.format(p.getDataNascimento().getTime()));
}
        } catch (Exception e) {
e.printStackTrace();
        }
}
public void remove_pet(PersistenciaJPA  per, Integer id)
{
System.out.println("Removendo pet: "+id);
try {
Pet p=new Pet();
p.setId(id);
per.remover(p);
        } catch (Exception e) {
e.printStackTrace();
        }
}
}
