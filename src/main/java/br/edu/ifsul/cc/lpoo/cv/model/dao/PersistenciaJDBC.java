
package br.edu.ifsul.cc.lpoo.cv.model.dao;

import java.util.List;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import br.edu.ifsul.cc.lpoo.cv.model.*;


public class PersistenciaJDBC implements InterfacePersistencia {
    private final String DRIVER = "org.postgresql.Driver";
    private final String USER = "postgres";
    private final String SENHA = "12345";
    public static final String URL = "jdbc:postgresql://localhost:5432/trabalho2021";
    private Connection con = null;
    public PersistenciaJDBC () throws Exception {
        Class.forName(DRIVER); //carregamento do driver postgresql em tempo de execu√ß√£o
        System.out.println("Abrindo conex„o com: "+URL+" ...");
        this.con = (Connection) DriverManager.getConnection(URL, USER, SENHA);
    }
    @Override
    public Boolean conexaoAberta() {
        try {
            if(con != null)
                return !con.isClosed();//verifica se a conexao est√° aberta
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return false;
    }
    @Override
    public void fecharConexao() {
        try{
            this.con.close();//fecha a conexao.
            System.out.println("A conex„o foi encerrada.");
        }catch(SQLException e){
            e.printStackTrace();//gera uma pilha de erro na saida.
        }
    }
    @Override
    public Object find(Class c, Object id) throws Exception {
if(c==Pet.class)
{
PreparedStatement ps=this.con.prepareStatement("select p.nome, p.id, p.cliente_id, p.raca_id, r.nome, esp.id, esp.nome, c.nome, c.cpf, c.rg, c.endereco from tb_pet as p, tb_clientes as c, tb_raca as r, tb_especie as esp where p.id=? and p.cliente_id=c.cpf and p.raca_id=r.id and r.especie_id=esp.id;");
ps.setInt(1, ((Pet)id).getId());
ResultSet rs=ps.executeQuery();
if(rs.next())
{
Pet p=new Pet();
Cliente cc=new Cliente();
Especie esp=new Especie();
Raca r=new Raca();
p.setNome(rs.getString("nome"));
p.setId(rs.getInt("id"));
cc.setCpf(rs.getString("cliente_id"));
r.setId(rs.getInt("raca_id"));
r.setNome(rs.getString("nome"));
esp.setId(rs.getInt("id"));
esp.setNome(rs.getString("nome"));
cc.setNome(rs.getString("nome"));
cc.setRG(rs.getString("rg"));
cc.setEndereco(rs.getString("endereco"));
r.setEspecie(esp);
p.setRaca(r);
p.setCliente(cc);
return p;
}
}
else if(c==Raca.class)
{
PreparedStatement ps=this.con.prepareStatement("select ra.id, ra.nome, ra.especie_id, esp.nome from tb_raca as ra, tb_especie as esp where ra.id=? and esp.id=ra.especie_id");
ps.setInt(1, ((Raca)id).getId());
ResultSet rs=ps.executeQuery();
if(rs.next())
{
Raca ra=new Raca();
ra.setId(rs.getInt("id"));
ra.setNome(rs.getString("nome"));
Especie esp=new Especie();
esp.setId(rs.getInt("especie_id"));
esp.setNome(rs.getString("nome"));
ra.setEspecie(esp);
return ra;
}
}
else if(c==Especie.class)
{
PreparedStatement ps=this.con.prepareStatement("select id, nome from tb_especie where id = ?");
ps.setInt(1, ((Especie)id).getId());
ResultSet rs=ps.executeQuery();
if(rs.next())
{
Especie esp=new Especie();
esp.setId(rs.getInt("id"));
esp.setNome(rs.getString("nome"));
return esp;
}
}
else if(c==Cliente.class)
{
PreparedStatement ps=this.con.prepareStatement("select id, nome from tb_especie where id = ?");
ps.setString(1, ((Cliente)id).getCpf());
ResultSet rs=ps.executeQuery();
if(rs.next())
{
Cliente cl=new Cliente();
cl.setNome(rs.getString("nome"));
cl.setCpf(rs.getString("cpf"));
cl.setRG(rs.getString("rg"));
cl.setEmail(rs.getString("email"));
cl.setSenha(rs.getString("senha"));
cl.setNumero_celular(rs.getString("numero_celular"));
cl.setCep(rs.getString("cep"));
cl.setEndereco(rs.getString("endereco"));
cl.setComplemento(rs.getString("complemento"));
java.sql.Date dt=rs.getDate("data_nascimento");
Calendar cd=Calendar.getInstance();
cd.setTime(dt);
cl.setData_nascimento(cd);
return cl;
}
}
        return null;
    }
    @Override
    public void persist(Object o) throws Exception {
if(o==Pet.class)
{
Pet p=(Pet)o;
if(p.getId()==null)
{
PreparedStatement ps = this.con.prepareStatement("insert into tb_pet"
+ "(id, nome, cliente_id, raca_id) values "
+"(nextval('seq_pet_id'), ?, ?, ?)", new String[]{"id"});
                ps.setString(1, p.getNome());
ps.setString(2, p.getCliente().getCpf());
ps.setInt(3, p.getRaca().getId());
//java.sql.Date dt=new java.sql.Date(p.getDataNascimento().getTimeInMillis());
                ps.executeUpdate();
ResultSet rs = ps.getGeneratedKeys();
if (rs.next()) {
p.setId(rs.getInt(1));
                }
ps=this.con.prepareStatement("insert into tb_cliente_pet(cliente_id, pet_id) values(?, ?)");
ps.setString(1, p.getCliente().getCpf());
ps.setInt(2, p.getId());
                ps.executeUpdate();
}
else
{
PreparedStatement ps = this.con.prepareStatement("update tb_pet set nome = ?, cliente_id = ?, raca_id = ? where id = ?");
ps.setString(1, p.getNome());
ps.setString(2, p.getCliente().getCpf());
ps.setInt(3, p.getRaca().getId());
//ps.setDate(2, new java.sql.Date(p.getDataNascimento().getTimeInMillis()));
ps.setInt(4, p.getId());
ps.executeUpdate();
}
}
else if(o==Raca.class)
{
Raca ra=(Raca)o;
if(ra.getId()==null)
{
PreparedStatement ps = this.con.prepareStatement("insert into tb_raca"
+ "(id, nome, especie_id) values "
+"(nextval('seq_raca_id'), ?)", new String[]{"id"});
                ps.setString(1, ra.getNome());
ps.setInt(2, ra.getEspecie().getId());
                ps.executeUpdate();
ResultSet rs = ps.getGeneratedKeys();
if (rs.next()) {
ra.setId(rs.getInt(1));
                }
}
else
{
PreparedStatement ps = this.con.prepareStatement("update tb_raca set nome = ? where id = ?");
ps.setString(1, ra.getNome());
ps.setInt(2, ra.getId());
ps.executeUpdate();
}
}
else if(o==Cliente.class)
{
Cliente c=(Cliente)o;
PreparedStatement ps = this.con.prepareStatement("insert into tb_cliente(nome, cpf, rg, senha, email, numero_celular, endereco, cep, complemento) values(?, ?, ?, ?, ?, ?, ?, ?,?)");
                ps.setString(1, c.getNome());
ps.setString(2, c.getCpf());
ps.setString(3, c.getRG());
ps.setString(4, c.getSenha());
ps.setString(5, c.getEmail());
ps.setString(6, c.getNumero_celular());
ps.setString(7, c.getEndereco());
ps.setString(8, c.getComplemento());
ps.setString(9, c.getCep());
                ps.executeUpdate();
}
else if(o==Especie.class)
{
Especie esp=(Especie)o;
if(esp.getId()==null)
{
PreparedStatement ps = this.con.prepareStatement("insert into tb_especie"
+ "(id, nome) values "
+"(nextval('seq_especie_id'), ?)", new String[]{"id"});
                ps.setString(1, esp.getNome());
                ps.executeUpdate();
ResultSet rs = ps.getGeneratedKeys();
if (rs.next()) {
esp.setId(rs.getInt(1));
                }
}
else
{
PreparedStatement ps = this.con.prepareStatement("update tb_especie set nome = ? where id = ?");
ps.setString(1, esp.getNome());
ps.setInt(2, esp.getId());
ps.executeUpdate();
}
}

    }

    @Override
    public void remover(Object o) throws Exception {
if(o==Pet.class)
{
PreparedStatement ps = this.con.prepareStatement("delete from tb_pet where id = ?");
ps.setInt(1, ((Pet)o).getId());
ps.execute();
}
else if(o==Raca.class)
{
PreparedStatement ps = this.con.prepareStatement("delete from tb_raca where id = ?");
ps.setInt(1, ((Raca)o).getId());
ps.execute();
}
else if(o==Especie.class)
{
PreparedStatement ps = this.con.prepareStatement("delete from tb_especie where id = ?");
ps.setInt(1, ((Especie)o).getId());
ps.execute();
}
else if(o==Cliente.class)
{
PreparedStatement ps = this.con.prepareStatement("delete from tb_clientes where cpf = ?");
ps.setString(1, ((Cliente)o).getCpf());
ps.execute();
}
    }
    @Override
public List<Pet> listPets() throws Exception
{
        List<Pet> pets=null;
PreparedStatement ps = this.con.prepareStatement("select p.nome, p.id, p.cliente_id, p.raca_id, r.nome, esp.id, esp.nome, c.nome, c.cpf, c.rg, c.endereco from tb_pet as p, tb_clientes as c, tb_raca as r, tb_especie as esp where p.cliente_id=c.cpf and p.raca_id=r.id and r.especie_id=esp.id");
ResultSet rs = ps.executeQuery();
pets = new ArrayList();
        while(rs.next()){
Pet p=new Pet();
Cliente cc=new Cliente();
Especie esp=new Especie();
Raca r=new Raca();
p.setNome(rs.getString("nome"));
p.setId(rs.getInt("id"));
cc.setCpf(rs.getString("cliente_id"));
r.setId(rs.getInt("raca_id"));
r.setNome(rs.getString("nome"));
esp.setId(rs.getInt("id"));
esp.setNome(rs.getString("nome"));
cc.setNome(rs.getString("nome"));
cc.setRG(rs.getString("rg"));
cc.setEndereco(rs.getString("endereco"));
r.setEspecie(esp);
p.setRaca(r);
p.setCliente(cc);
pets.add(p);
        }
return pets;
}
    @Override
public List<Raca> listRacas() throws Exception
{
        List<Raca> racas=null;
PreparedStatement ps = this.con.prepareStatement("select r.nome, r.id, r.especie_id, e.nome from tb_raca as r, tb_especie as e where r.especie_id=e.id;");
ResultSet rs = ps.executeQuery();
racas = new ArrayList();
        while(rs.next()){
            Raca r = new Raca();
Especie e=new Especie();
r.setNome(rs.getString("nome"));
r.setId(rs.getInt("id"));
e.setId(rs.getInt("especie_id"));
e.setNome(rs.getString("nome"));
r.setEspecie(e);
racas.add(r);
        }
return racas;
}
public List<Especie> listEspecies() throws Exception
{
        List<Especie> especies=null;
PreparedStatement ps = this.con.prepareStatement("select id, nome from tb_especie;");
ResultSet rs = ps.executeQuery();
especies = new ArrayList();
        while(rs.next()){
            Especie esp = new Especie();
esp.setId(rs.getInt("id"));
esp.setNome(rs.getString("nome"));
especies.add(esp);
        }
return especies;
}


}
