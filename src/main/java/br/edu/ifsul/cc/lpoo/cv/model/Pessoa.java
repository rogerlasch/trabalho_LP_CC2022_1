

package br.edu.ifsul.cc.lpoo.cv.model;


import java.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@MappedSuperclass
abstract class Pessoa
{
    @Column(nullable = false, length=256)
String nome;
@Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
String cpf;
    @Column(nullable = false, length=256)
String rg;
    @Column(nullable = false, length=256)
String senha;
    @Column(nullable = false, length=256)
String numero_celular;
    @Column(nullable = false, length=256)
String email;
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
Calendar data_nascimento;
    @Column(nullable = false, length=256)
String cep;
    @Column(nullable = false, length=256)
String endereco;
    @Column(nullable = false, length=256)
String complemento;
public Pessoa()
{
}
public void setNome(String nome)
{
this.nome=nome;
}

public String getNome()
{
return this.nome;
}

public void setCpf(String cpf)
{
this.cpf=cpf;
}

public String getCpf()
{
return this.cpf;
}

public void setRG(String rg)
{
this.rg=rg;
}

public String getRG()
{
return this.rg;
}

public void setNumero_celular(String numero_celular)
{
this.numero_celular=numero_celular;
}

public String getNumero_celular()
{
return this.numero_celular;
}

public void setEmail(String email)
{
this.email=email;
}

public String getEmail()
{
return this.email;
} 

public void setData_nascimento(Calendar data_nascimento)
{
this.data_nascimento=data_nascimento;
}

public Calendar getData_nascimento()
{
return this.data_nascimento;
} 

public void setCep(String cep)
{
this.cep=cep;
}

public String getCep()
{
return this.cep;
} 

public void setEndereco(String endereco)
{
this.endereco=endereco;
}

public String getEndereco()
{
return this.endereco;
} 

public void setComplemento(String complemento)
{
this.complemento=complemento;
}

public String getComplemento()
{
return this.complemento;
}
public void setSenha(String senha)
{
this.senha=senha;
}
public String getSenha()
{
return senha;
}
}
