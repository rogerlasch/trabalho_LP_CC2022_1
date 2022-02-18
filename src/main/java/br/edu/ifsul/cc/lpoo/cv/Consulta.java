

package br.edu.ifsul.cc.lpoo.cv;


import java.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_consulta")
public class Consulta
{
@Id
@SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta_id", allocationSize = 1)
@GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
Integer id;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
Calendar data;
    @Column(nullable = false)
String observacao;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
Calendar data_retorno;
    @Column(nullable = false)
Float valor;
public Consulta()
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

public void setData(Calendar data)
{
this.data=data;
}

public Calendar getData()
{
return this.data;
} 

public void setObservacao(String observacao)
{
this.observacao=observacao;
}

public String getObservacao()
{
return this.observacao;
} 

public void setData_retorno(Calendar data_retorno)
{
this.data_retorno=data_retorno;
}

public Calendar getData_retorno()
{
return this.data_retorno;
} 

public void setValor(Float valor)
{
this.valor=valor;
}

public Float getValor()
{
return this.valor;
}
}
