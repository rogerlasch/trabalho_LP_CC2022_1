package br.edu.ifsul.cc.lpoo.cv.gui.raca;
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

public class JpRaca extends JPanel implements ActionListener {
    private Controle controle;
    private GridBagLayout gridLayout;
    private GridBagConstraints posicionador;
    private JLabel  lbRaca;
    private JTextField txRaca;
    private JButton btnAdd;
    private Border defaultBorder;
    //construtor da classe que recebe um parametro.
    public JpRaca(Controle controle){
        this.controle = controle;
        initComponents();
    }
    private void initComponents(){
        gridLayout = new GridBagLayout();//inicializando o gerenciador de layout
        this.setLayout(gridLayout);//definie o gerenciador para este painel.
        lbRaca = new JLabel("Nome da raca:");
        lbRaca.setToolTipText("Nome da ra�a"); //acessibilidade
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0;//policao da linha (vertical)
        posicionador.gridx = 0;// posição da coluna (horizontal)
        this.add(lbRaca, posicionador);//o add adiciona o rotulo no painel
        txRaca = new JTextField(10);
        txRaca.setFocusable(true);    //acessibilidade
        txRaca.setToolTipText("Nome da nova raca"); //acessibilidade
        Util.considerarEnterComoTab(txRaca);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        defaultBorder = txRaca.getBorder();
        this.add(txRaca, posicionador);//o add adiciona o rotulo no painel
        btnAdd = new JButton("Adicionar");
        btnAdd.setFocusable(true);    //acessibilidade
        btnAdd.setToolTipText("Adicionar"); //acessibilidade
        Util.registraEnterNoBotao(btnAdd);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 2;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        btnAdd.addActionListener(this);//registrar o botão no Listener
        btnAdd.setActionCommand("comando_adicionar_pet");
        this.add(btnAdd, posicionador);//o add adiciona o rotulo no painel
    }
    public void requestFocus(){
        txRaca.requestFocus();
    }
    public void cleanForm(){
        txRaca.setText("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            //testa para verificar se o botão btnAdd foi clicado.
            if(e.getActionCommand().equals(btnAdd.getActionCommand())){
                    txRaca.requestFocus();
    }
}
}
