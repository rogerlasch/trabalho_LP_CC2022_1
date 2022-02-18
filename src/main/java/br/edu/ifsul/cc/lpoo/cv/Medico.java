

package br.edu.ifsul.cc.lpoo.cv;


import java.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class Medico extends Pessoa
{
String crmv;
public Medico()
{
}
public void setCRMV(String c)
{
this.crmv=c;
}
String getCRMV()
{
return this.crmv;
}
}
