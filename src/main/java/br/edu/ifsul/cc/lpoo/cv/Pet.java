

package br.edu.ifsul.cc.lpoo.cv;


import java.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_pet")
@NamedQueries({
    @NamedQuery(name="list_pets",
               query="SELECT p From Pet p order by p.id asc")
})

public class Pet implements Serializable
{
@Id
@SequenceGenerator(name = "seq_pet", sequenceName = "seq_pet_id", allocationSize = 1)
@GeneratedValue(generator = "seq_pet", strategy = GenerationType.SEQUENCE)
private Integer id;
    @Column(nullable = false, length=256)
private String nome;
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
private Calendar data_nascimento;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "raca_id", nullable = false)
Raca raca;
public Pet()
{
}
public void setCliente(Cliente c)
{
this.cliente=c;
}
public Cliente getCliente()
{
return this.cliente;
}
public void setRaca(Raca r)
{
this.raca=r;
}
public Raca getRaca()
{
return this.raca;
}
public Integer getId()
{
return this.id;
}
public void setId(Integer id)
{
this.id=id;
}
public String getNome()
{
return this.nome;
}
public void setNome(String nome)
{
this.nome=nome;
}
public Calendar getDataNascimento()
{
return data_nascimento;
}
public void setDataNascimento(Calendar data_nascimento)
{
this.data_nascimento=data_nascimento;
}
}
