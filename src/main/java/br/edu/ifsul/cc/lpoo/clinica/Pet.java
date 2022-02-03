

package br.edu.ifsul.cc.lpoo.clinica;


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
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
private Calendar data_nascimento;
public Pet()
{
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
