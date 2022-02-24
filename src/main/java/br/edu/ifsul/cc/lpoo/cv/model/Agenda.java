

package br.edu.ifsul.cc.lpoo.cv.model;


import java.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_agenda")
public class Agenda
{
@Id
@SequenceGenerator(name = "seq_agenda", sequenceName = "seq_agenda_id", allocationSize = 1)
@GeneratedValue(generator = "seq_agenda", strategy = GenerationType.SEQUENCE)
Integer id;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
Calendar data_inicio;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
Calendar data_fim;
    @Column(nullable = false, length=256)
String Observacao;
public Agenda()
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

public void setData_inicio(Calendar data_inicio)
{
this.data_inicio=data_inicio;
}

public Calendar getData_inicio()
{
return this.data_inicio;
} 

public void setData_fim(Calendar data_fim)
{
this.data_fim=data_fim;
}

public Calendar getData_fim()
{
return this.data_fim;
} 

public void setObservacao(String Observacao)
{
this.Observacao=Observacao;
}

public String getObservacao()
{
return this.Observacao;
} 


}
