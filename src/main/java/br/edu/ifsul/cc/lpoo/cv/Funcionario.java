

package br.edu.ifsul.cc.lpoo.cv;


import java.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class Funcionario extends Pessoa
{
String numero_ctps;
String numero_pis;
public Funcionario()
{
}
public void setNumero_ctps(String numero_ctps)
{
this.numero_ctps=numero_ctps;
}
public String getNumero_ctps()
{
return this.numero_ctps;
}

public void setNumero_pis(String numero_pis)
{
this.numero_pis=numero_pis;
}

public String getNumero_pis()
{
return this.numero_pis;
}
}
