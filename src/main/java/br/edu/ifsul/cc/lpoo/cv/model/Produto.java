

package br.edu.ifsul.cc.lpoo.cv.model;


import java.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_produto")
public class Produto
{
@Id
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_id", allocationSize = 1)
@GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
Integer id;
    @Column(nullable = false, length=256)
String nome;
    @Column(nullable = false)
Float valor;
    @Column(nullable = false, length=256)
Float quantidade;
public Produto()
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

public void setNome(String nome)
{
this.nome=nome;
}

public String getNome()
{
return this.nome;
}

public void setValor(Float valor)
{
this.valor=valor;
}

public Float getValor()
{
return this.valor;
}

public void setQuantidade(Float quantidade)
{
this.quantidade=quantidade;
}

public Float getQuantidade()
{
return this.quantidade;
}
}
