

package br.edu.ifsul.cc.lpoo.cv.model;


import java.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_especie")
public class Especie
{
@Id
@SequenceGenerator(name = "seq_especie", sequenceName = "seq_especie_id", allocationSize = 1)
@GeneratedValue(generator = "seq_especie", strategy = GenerationType.SEQUENCE)
Integer id;
    @Column(nullable = false, length=256)
String nome;
public Especie()
{
}
@Override
public String toString()
{
return getNome();
}
public void setId(Integer id)
{
this.id=id;
}
public Integer getId()
{
return this.id;
}

public void setNome(String nome)
{
this.nome=nome;
}

public String getNome()
{
return this.nome;
}


}
