

package br.edu.ifsul.cc.lpoo.test;

import br.edu.ifsul.cc.lpoo.cv.model.Raca;
import br.edu.ifsul.cc.lpoo.cv.model.Pet;
import br.edu.ifsul.cc.lpoo.cv.model.*;

public class SPrinter
{
public void printEspecie(Especie esp)
{
System.out.println("Id\tNome");
System.out.println(esp.getId()+"\t"+esp.getNome());
}
public void printRaca(Raca r)
{
System.out.println("Id\tNome\tEspecie_id\tEspecie_nome");
Especie esp=r.getEspecie();
System.out.println(r.getId()+"\t"+r.getNome()+"\t"+esp.getId()+"\t"+esp.getNome());
}
public void printCliente(Cliente c)
{
System.out.println("Nome\tCPF\tRG\tEndereco");
System.out.println(c.getNome()+"\t"+c.getCpf()+"\t"+c.getRG()+"\t"+c.getEndereco());
}
public void printPet(Pet c)
{
Raca r=c.getRaca();
Especie e=r.getEspecie();
System.out.println("ID\tNome\tRaca\tEspecie\tCliente");
System.out.println(c.getId()+"\t"+c.getNome()+"\t"+r.getNome()+"\t"+e.getNome()+"\t"+c.getCliente().getNome());
}
}
