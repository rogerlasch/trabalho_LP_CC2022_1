package br.edu.ifsul.cc.lpoo.cv.gui.pet;
import br.edu.ifsul.cc.lpoo.cv.Controle;
import br.edu.ifsul.cc.lpoo.cv.util.Util;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class JPet extends JPanel implements ActionListener {
    private Controle controle;
    private GridBagLayout gridLayout;
    private GridBagConstraints posicionador;
    private JLabel  lbName;
    private JTextField txName;
    private JLabel  lbCpf;
    private JTextField txCpf;
private JComboBox racas;
    private JButton btnAdd;
    private Border defaultBorder;
    //construtor da classe que recebe um parametro.
    public JPet(Controle controle){
        this.controle = controle;
        initComponents();
    }
    private void initComponents(){
        gridLayout = new GridBagLayout();//inicializando o gerenciador de layout
        this.setLayout(gridLayout);//definie o gerenciador para este painel.
        lbName = new JLabel("Do PET:");
        lbName.setToolTipText("Nome do PET"); //acessibilidade
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0;//policao da linha (vertical)
        posicionador.gridx = 0;// posição da coluna (horizontal)
        this.add(lbName, posicionador);//o add adiciona o rotulo no painel
        txName = new JTextField(10);
        txName.setFocusable(true);    //acessibilidade
        txName.setToolTipText("Nome do PET"); //acessibilidade
        Util.considerarEnterComoTab(txName);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 1;//policao da linha (vertical)
        posicionador.gridx = 0;// posição da coluna (horizontal)
        defaultBorder = txName.getBorder();
        this.add(txName, posicionador);//o add adiciona o rotulo no painel
        lbCpf = new JLabel("Cpf do dono:");
        lbCpf.setToolTipText("Cpf do dono"); //acessibilidade
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        this.add(lbCpf, posicionador);//o add adiciona o rotulo no painel
        txCpf = new JTextField(10);
        txCpf.setFocusable(true);    //acessibilidade
        txCpf.setToolTipText("Digite o cpf do dono"); //acessibilidade
        Util.considerarEnterComoTab(txCpf);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 1;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        defaultBorder = txCpf.getBorder();
        this.add(txCpf, posicionador);//o add adiciona o rotulo no painel
String ts []={"Teste1", "teste2", "teste3"};
racas=new JComboBox(ts);
racas.setBounds(50, 50,90,20);
racas.setToolTipText("Selecione uma raca");
racas.setFocusable(true);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0;//policao da linha (vertical)
        posicionador.gridx = 2;// posição da coluna (horizontal)
        this.add(racas, posicionador);//o add adiciona o rotulo no painel

        btnAdd = new JButton("Adicionar");
        btnAdd.setFocusable(true);    //acessibilidade
        btnAdd.setToolTipText("Adicionar"); //acessibilidade
        Util.registraEnterNoBotao(btnAdd);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 1;//policao da linha (vertical)
        posicionador.gridx = 2;// posição da coluna (horizontal)
        btnAdd.addActionListener(this);//registrar o botão no Listener
        btnAdd.setActionCommand("comando_adicionar_pet");
        this.add(btnAdd, posicionador);//o add adiciona o rotulo no painel
    }
    public void requestFocus(){
        txName.requestFocus();
    }
    public void cleanForm(){
        txName.setText("");
txCpf.setText("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            //testa para verificar se o botão btnAdd foi clicado.
            if(e.getActionCommand().equals(btnAdd.getActionCommand())){
                    txName.requestFocus();
    }
}
}
