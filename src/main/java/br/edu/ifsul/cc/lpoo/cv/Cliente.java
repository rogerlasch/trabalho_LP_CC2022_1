

package br.edu.ifsul.cc.lpoo.cv;


import java.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_clientes")
public class Cliente extends Pessoa
{
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
Calendar data_ultima_visita;
    @ManyToMany
    @JoinTable(name = "tb_cliente_pet", joinColumns = {@JoinColumn(name = "cliente_id")},
                                       inverseJoinColumns = {@JoinColumn(name =
"pet_id")})
List<Pet> pets;
public Cliente()
{
}
public void set_DataUltimaVisita(Calendar c)
{
this.data_ultima_visita=c;
}
Calendar get_DataUltimaVisita()
{
return this.data_ultima_visita;
}
public void setPets(List<Pet> pets)
{
this.pets=pets;
}
public List<Pet> getPets()
{
return this.pets;
}
}
