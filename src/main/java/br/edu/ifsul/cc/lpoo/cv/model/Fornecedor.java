

package br.edu.ifsul.cc.lpoo.cv.model;


import java.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class Fornecedor extends Pessoa
{
String cnpj;
String IE;
public Fornecedor()
{
}
public void setCNPJ(String cnpj)
{
this.cnpj=cnpj;
}

public String getCNPJ()
{
return this.cnpj;
}
public void setIe(String IE)
{
this.IE=IE;
}
public String getIe()
{
return this.IE;
}
}
