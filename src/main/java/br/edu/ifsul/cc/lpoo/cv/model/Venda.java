

package br.edu.ifsul.cc.lpoo.cv.model;


import java.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_venda")
public class Venda
{
@Id
@SequenceGenerator(name = "seq_venda", sequenceName = "seq_venda_id", allocationSize = 1)
@GeneratedValue(generator = "seq_venda", strategy = GenerationType.SEQUENCE)
Integer id;
    @Column(nullable = false, length=256)
String observacao;
    @Column(nullable = false)
Float valor_total;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
Calendar data;
public Venda()
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

public void setObservacao(String observacao)
{
this.observacao=observacao;
}

public String getObservacao()
{
return this.observacao;
}

public void setValor_total(Float valor_total)
{
this.valor_total=valor_total;
}

public Float getValor_total()
{
return this.valor_total;
} 

public void setData(Calendar data)
{
this.data=data;
}

public Calendar getData()
{
return this.data;
}
}
