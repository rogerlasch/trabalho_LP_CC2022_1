

package br.edu.ifsul.cc.lpoo.cv.model;

import java.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_raca")
@NamedQueries({
    @NamedQuery(name="list_racas",
               query="SELECT r From Raca r order by r.id asc")
})
public class Raca implements Serializable
{
@Id
@SequenceGenerator(name = "seq_raca", sequenceName = "seq_raca_id", allocationSize = 1)
@GeneratedValue(generator = "seq_raca", strategy = GenerationType.SEQUENCE)
private Integer id;
    @Column(nullable = false, length=256)
private String nome;
    @ManyToOne
    @JoinColumn(name = "especie_id", nullable = false)
Especie especie;
public Raca()
{
}
@Override
public String toString()
{
return getId().toString();
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
public void setEspecie(Especie esp)
{
this.especie=esp;
}
public Especie getEspecie()
{
return this.especie;
}
}
