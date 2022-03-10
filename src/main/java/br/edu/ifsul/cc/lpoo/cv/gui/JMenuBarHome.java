
package br.edu.ifsul.cc.lpoo.cv.gui;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author telmo
 */
public class JMenuBarHome extends JMenuBar implements ActionListener {

    private JMenu menuArquivo;
    private JMenuItem menuItemLogout;
    private JMenuItem menuItemSair;

    private JMenu menuCadastro;
    private JMenuItem menuItemPet;
private JMenuItem menuItemRaca;
private JMenuItem menuItemEspecie;
private JMenuItem menuItemPessoa;

    private Controle controle;

    public JMenuBarHome(Controle controle){

        this.controle = controle;

        initComponents();
    }

    private void initComponents(){

        menuArquivo = new JMenu("Arquivo");
        menuArquivo.setMnemonic(KeyEvent.VK_A);//ativa o ALT + A para acessar esse menu - acessibilidade
        menuArquivo.setToolTipText("Arquivo"); //acessibilidade
        menuArquivo.setFocusable(true); //acessibilidade

        menuItemSair = new JMenuItem("Sair");
        menuItemSair.setToolTipText("Sair"); //acessibilidade
        menuItemSair.setFocusable(true);     //acessibilidade

        menuItemLogout = new JMenuItem("Logout");
        menuItemLogout.setToolTipText("Logout"); //acessibilidade
        menuItemLogout.setFocusable(true);     //acessibilidade

        menuItemLogout.addActionListener(this);
        menuItemLogout.setActionCommand("menu_logout");
        menuArquivo.add(menuItemLogout);

        menuItemSair.addActionListener(this);
        menuItemSair.setActionCommand("menu_sair");
        menuArquivo.add(menuItemSair);

        menuCadastro = new JMenu("Cadastros");
        menuCadastro.setMnemonic(KeyEvent.VK_C);//ativa o ALT + C para acessar esse menu - acessibilidade
        menuCadastro.setToolTipText("Cadastro"); //acessibilidade
        menuCadastro.setFocusable(true); //acessibilidade

        menuItemPet = new JMenuItem("Pet");
        menuItemPet.setToolTipText("Pet"); //acessibilidade
        menuItemPet.setFocusable(true); //acessibilidade
        menuItemPet.addActionListener(this);
        menuItemPet.setActionCommand("menu_pet");
        menuCadastro.add(menuItemPet);

        menuItemRaca = new JMenuItem("Raca");
        menuItemRaca.setToolTipText("Raca"); //acessibilidade
        menuItemRaca.setFocusable(true); //acessibilidade
        menuItemRaca.addActionListener(this);
        menuItemRaca.setActionCommand("menu_raca");
        menuCadastro.add(menuItemRaca);
        menuItemEspecie = new JMenuItem("Especie");
        menuItemEspecie.setToolTipText("Especie"); //acessibilidade
        menuItemEspecie.setFocusable(true); //acessibilidade
        menuItemEspecie.addActionListener(this);
        menuItemEspecie.setActionCommand("menu_especie");
        menuCadastro.add(menuItemEspecie);

        menuItemPessoa = new JMenuItem("Pessoa");
        menuItemPessoa.setToolTipText("Pessoa"); //acessibilidade
        menuItemPessoa.setFocusable(true); //acessibilidade
        menuItemPessoa.addActionListener(this);
        menuItemPessoa.setActionCommand("menu_pet");
        menuCadastro.add(menuItemPessoa);

        this.add(menuArquivo);
        this.add(menuCadastro);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals(menuItemSair.getActionCommand())){

            //se o usuario clicou no menuitem Sair
            int d = JOptionPane.showConfirmDialog(this, "Deseja realmente sair do sistema? ", "Sair", JOptionPane.YES_NO_OPTION);
            if(d == 0){
                controle.fecharBD();//fecha a conexao com o banco de dados.
                System.exit(0);//finaliza o processo do programa.
            }


        }else if(e.getActionCommand().equals(menuItemPet.getActionCommand())){
                        controle.showTela("tela_pet");
}
else if(e.getActionCommand().equals(menuItemRaca.getActionCommand())){
                        controle.showTela("tela_raca");
}
else if(e.getActionCommand().equals(menuItemEspecie.getActionCommand())){
                        controle.showTela("tela_especie");
}
else if(e.getActionCommand().equals(menuItemPessoa.getActionCommand())){
                        controle.showTela("tela_pessoa");
}
else if(e.getActionCommand().equals(menuItemLogout.getActionCommand())){

                        controle.showTela("tela_autenticacao");
        }

    }


}
