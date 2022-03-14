
package br.edu.ifsul.cc.lpoo.cv.gui.autenticacao;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import br.edu.ifsul.cc.lpoo.cv.util.Util;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author telmo
 */
public class JPanelAutenticacao extends JPanel implements ActionListener {

    private Controle controle;
    private GridBagLayout gridLayout;
    private GridBagConstraints posicionador;

    private JLabel  lbUser;
    private JLabel lblSenha;
    private JTextField txUser;
    private JPasswordField txSenha;
    private JButton btnLogar;
    private Border defaultBorder;

    //construtor da classe que recebe um parametro.
    public JPanelAutenticacao(Controle controle){

        this.controle = controle;
        initComponents();
    }

    private void initComponents(){

        gridLayout = new GridBagLayout();//inicializando o gerenciador de layout
        this.setLayout(gridLayout);//definie o gerenciador para este painel.

        lbUser = new JLabel("Numero_ctps:");
        lbUser.setToolTipText("Numero_ctps"); //acessibilidade
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0;//policao da linha (vertical)
        posicionador.gridx = 0;// posição da coluna (horizontal)
        this.add(lbUser, posicionador);//o add adiciona o rotulo no painel

        txUser = new JTextField(10);
        txUser.setFocusable(true);    //acessibilidade
        txUser.setToolTipText("Numero_ctps"); //acessibilidade
        Util.considerarEnterComoTab(txUser);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        defaultBorder = txUser.getBorder();
        this.add(txUser, posicionador);//o add adiciona o rotulo no painel

        lblSenha = new JLabel("Senha:");
        lblSenha.setToolTipText("Senha"); //acessibilidade
        posicionador = new GridBagConstraints();
        posicionador.gridy = 1;//policao da linha (vertical)
        posicionador.gridx = 0;// posição da coluna (horizontal)
        this.add(lblSenha, posicionador);//o add adiciona o rotulo no painel

        txSenha = new JPasswordField(10);
        txSenha.setFocusable(true);    //acessibilidade
        txSenha.setToolTipText("Senha"); //acessibilidade
        Util.considerarEnterComoTab(txSenha);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 1;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        this.add(txSenha, posicionador);//o add adiciona o rotulo no painel

        btnLogar = new JButton("Logar");
        btnLogar.setFocusable(true);    //acessibilidade
        btnLogar.setToolTipText("Logar!"); //acessibilidade
        Util.registraEnterNoBotao(btnLogar);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 2;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        btnLogar.addActionListener(this);//registrar o botão no Listener
        btnLogar.setActionCommand("comando_autenticar");
        this.add(btnLogar, posicionador);//o add adiciona o rotulo no painel


    }

    public void requestFocus(){

        txUser.requestFocus();
    }

    public void cleanForm(){

        txUser.setText("");
        txSenha.setText("");

        txUser.setBorder(defaultBorder);
        txSenha.setBorder(defaultBorder);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            //testa para verificar se o botão btnLogar foi clicado.
            if(e.getActionCommand().equals(btnLogar.getActionCommand())){

                //validacao do formulario.
                if(txUser.getText().trim().length() > 4){

                    txUser.setBorder(new LineBorder(Color.green,1));

                    if(new String(txSenha.getPassword()).trim().length() > 3 ){

                        txSenha.setBorder(new LineBorder(Color.green,1));

                        controle.autenticar(txUser.getText().trim(), new String(txSenha.getPassword()).trim());

                    }else{

                        JOptionPane.showMessageDialog(this, "Informe Senha com 4 ou mais dígitos", "Autenticação", JOptionPane.ERROR_MESSAGE);
                        txSenha.setBorder(new LineBorder(Color.red,1));
                        txSenha.requestFocus();

                    }

                }else{

                    JOptionPane.showMessageDialog(this, "Informe Numero_ctps com 11 d�gitos.", "Autentica��o", JOptionPane.ERROR_MESSAGE);
                    txUser.setBorder(new LineBorder(Color.red,1));
                    txUser.requestFocus();
                }


        }

    }

}
