

package br.edu.ifsul.cc.lpoo.cv;


import java.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_receita")
public class Receita
{
@Id
@SequenceGenerator(name = "seq_receita", sequenceName = "seq_receita_id", allocationSize = 1)
@GeneratedValue(generator = "seq_receita", strategy = GenerationType.SEQUENCE)
Integer id;
    @Column(nullable = false, length=256)
String orientacao;
public Receita()
{
}
public void setId(Integer id)
{
this.id=id;
}

public Integer getId()
{
return this.id;
} 

public void setOrientacao(String orientacao)
{
this.orientacao=orientacao;
}

public String getOrientacao()
{
return this.orientacao;
} 


}
