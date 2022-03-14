
package br.edu.ifsul.cc.lpoo.cv;

import br.edu.ifsul.cc.lpoo.cv.model.dao.PersistenciaJDBC;
import br.edu.ifsul.cc.lpoo.cv.model.Funcionario;
import br.edu.ifsul.cc.lpoo.cv.gui.JFramePrincipal;
import br.edu.ifsul.cc.lpoo.cv.gui.JMenuBarHome;
import br.edu.ifsul.cc.lpoo.cv.gui.JPanelHome;
import br.edu.ifsul.cc.lpoo.cv.gui.autenticacao.JPanelAutenticacao;
import br.edu.ifsul.cc.lpoo.cv.gui.raca.JRaca;
import br.edu.ifsul.cc.lpoo.cv.gui.especie.JEspecie;
import javax.swing.JOptionPane;

/**
 *
 * @author telmo
 */
public class Controle {

    private PersistenciaJDBC conexaoJDBC;

    private JFramePrincipal frame; // frame principal da minha aplicação gráfica

    private JPanelAutenticacao pnlAutenticacao;
private JRaca jraca;
private JEspecie jespecie;

    private JMenuBarHome menuBar; //menu principal

    private JPanelHome pnlHome; // painel de boas vindas (home)


    //construtor.
    public Controle(){

    }

    public boolean conectarBD() throws Exception {

            conexaoJDBC = new PersistenciaJDBC();

            if(getConexaoJDBC()!= null){

                        return getConexaoJDBC().conexaoAberta();
            }

            return false;
    }

    public void fecharBD(){

        System.out.println("Fechando conexao com o Banco de Dados");
        getConexaoJDBC().fecharConexao();

    }

    public void initComponents(){


        //inicia a interface gráfica.
        //"caminho feliz" : passo 5

        frame = new JFramePrincipal();

        pnlAutenticacao = new JPanelAutenticacao(this);
jraca=new JRaca(this);
jespecie=new JEspecie(this);
        menuBar = new JMenuBarHome(this);

        pnlHome = new JPanelHome(this);


        frame.addTela(pnlAutenticacao, "tela_autenticacao");//carta 1
frame.addTela(jraca, "tela_raca");
frame.addTela(jespecie, "tela_especie");
        frame.addTela(pnlHome, "tela_home");//carta 2
        frame.showTela("tela_autenticacao"); // apreseta a carta cujo nome é "tela_autenticacao"

        frame.setVisible(true); // torna visível o jframe


    }

    public void autenticar(String ctps, String senha) {
//                frame.setJMenuBar(menuBar);//adiciona o menu de barra no frame
//                frame.showTela("tela_home");//muda a tela para o painel de boas vindas (home)
        try{
Funcionario f=getConexaoJDBC().doLogin(ctps, senha);
            if(f!=null){
                JOptionPane.showMessageDialog(pnlAutenticacao, "Funcionario"+f.getNome()+" autenticado com sucesso!", "Autenticação", JOptionPane.INFORMATION_MESSAGE);
                frame.setJMenuBar(menuBar);//adiciona o menu de barra no frame
                frame.showTela("tela_home");//muda a tela para o painel de boas vindas (home)
            }else{
                JOptionPane.showMessageDialog(pnlAutenticacao, "Dados inválidos!", "Autenticação", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(pnlAutenticacao, "Erro ao executar a autenticação no Banco de Dados!", "Autenticação", JOptionPane.ERROR_MESSAGE);
e.printStackTrace();
        }
    }

    public void showTela(String nomeTela){

        if(nomeTela.equals("tela_autenticacao")){

            pnlAutenticacao.cleanForm();
            frame.showTela(nomeTela);
            pnlAutenticacao.requestFocus();

        }else{

            frame.showTela(nomeTela);
        }

    }

    /**
     * @return the conexaoJDBC
     */
    public PersistenciaJDBC getConexaoJDBC() {
        return conexaoJDBC;
    }

}
