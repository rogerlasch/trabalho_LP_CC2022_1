
package br.edu.ifsul.cc.lpoo.clinica.dao;

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
import br.edu.ifsul.cc.lpoo.clinica.*;


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
PreparedStatement ps=this.con.prepareStatement("select id, nome, data_nascimento  from pets where id = ?");
ps.setInt(1, ((Pet)id).getId());
ResultSet rs=ps.executeQuery();
if(rs.next())
{
Pet p=new Pet();
p.setId(rs.getInt("id"));
p.setNome(rs.getString("nome"));
java.sql.Date dt=rs.getDate("data_nascimento");
Calendar cd=Calendar.getInstance();
cd.setTime(dt);
p.setDataNascimento(cd);
return p;
}
}
else if(c==Raca.class)
{
PreparedStatement ps=this.con.prepareStatement("select id, nome from raca where id = ?");
ps.setInt(1, ((Raca)id).getId());
ResultSet rs=ps.executeQuery();
if(rs.next())
{
Raca ra=new Raca();
ra.setId(rs.getInt("id"));
ra.setNome(rs.getString("nome"));
return ra;
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
+ "(id, nome, datanascimento) values "
+"(nextval('seq_pet_id'), ?, ?)", new String[]{"id"});
                ps.setString(1, p.getNome());
java.sql.Date dt=new java.sql.Date(p.getDataNascimento().getTimeInMillis());
                ps.executeUpdate();
ResultSet rs = ps.getGeneratedKeys();
if (rs.next()) {
p.setId(rs.getInt(1));
                }
}
else
{
PreparedStatement ps = this.con.prepareStatement("update tb_pet set nome = ? data_nascimento = ? where id = ?");
ps.setString(1, p.getNome());
ps.setDate(2, new java.sql.Date(p.getDataNascimento().getTimeInMillis()));
ps.setInt(3, p.getId());
ps.executeUpdate();
}
}
else if(o==Raca.class)
{
Raca ra=(Raca)o;
if(ra.getId()==null)
{
PreparedStatement ps = this.con.prepareStatement("insert into tb_raca"
+ "(id, nome) values "
+"(nextval('seq_raca_id'), ?)", new String[]{"id"});
                ps.setString(1, ra.getNome());
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
PreparedStatement ps = this.con.prepareStatement("delete from tb_Raca where id = ?");
ps.setInt(1, ((Raca)o).getId());
ps.execute();
}
    }
    @Override
public List<Pet> listPets() throws Exception
{
        List<Pet> pets=null;
PreparedStatement ps = this.con.prepareStatement("select id, nome, data_nascimento from pet order by id");
ResultSet rs = ps.executeQuery();
pets = new ArrayList();
        while(rs.next()){
            Pet p = new Pet();
p.setId(rs.getInt("id"));
p.setNome(rs.getString("nome"));
Calendar c=Calendar.getInstance();
c.setTimeInMillis(rs.getDate("data_nascimento").getTime());
pets.add(p);
        }
return pets;
}
    @Override
public List<Raca> listRacas() throws Exception
{
        List<Raca> racas=null;
PreparedStatement ps = this.con.prepareStatement("select id, nome from raca order by id");
ResultSet rs = ps.executeQuery();
racas = new ArrayList();
        while(rs.next()){
            Raca r = new Raca();
r.setId(rs.getInt("id"));
r.setNome(rs.getString("nome"));
racas.add(r);
        }
return racas;
}

}
