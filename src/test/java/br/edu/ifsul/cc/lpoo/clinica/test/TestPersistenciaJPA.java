
package br.edu.ifsul.cc.lpoo.clinica.test;

import br.edu.ifsul.cc.lpoo.clinica.Raca;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import br.edu.ifsul.cc.lpoo.clinica.Pet;
import br.edu.ifsul.cc.lpoo.clinica.dao.PersistenciaJPA;
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
Raca r=new Raca();
r.setNome("Poodle");
per.persist(r);
r=new Raca();
r.setNome("Pinxer");
per.persist(r);
r=new Raca();
r.setNome("shiba");
per.persist(r);
r=new Raca();
r.setNome("Border collie");
per.persist(r);
r=new Raca();
r.setNome("Pastor Alemao");
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
System.out.println("Id\tNome");
for(Raca r: racas)
{
System.out.println(r.getId()+"\t"+r.getNome());
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
per.persist(p);
p=new Pet();
p.setNome("Bolinha");
c.set(Calendar.YEAR, 2015);
p.setDataNascimento(c);
per.persist(p);
p=new Pet();
p.setNome("Lulu");
c.set(Calendar.YEAR, 2021);
p.setDataNascimento(c);
c.set(Calendar.MONTH, Calendar.APRIL);
per.persist(p);
p=new Pet();
p.setNome("Laica");
c.set(Calendar.DAY_OF_MONTH, 15);
p.setDataNascimento(c);
per.persist(p);
p=new Pet();
p.setNome("Dudu");
c.set(Calendar.MONTH, Calendar.MAY);
p.setDataNascimento(c);
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
