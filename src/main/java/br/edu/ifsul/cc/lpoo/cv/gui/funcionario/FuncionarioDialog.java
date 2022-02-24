package br.edu.ifsul.cc.lpoo.cv.gui.funcionario;
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

public class FuncionarioDialog extends JPanel implements ActionListener {
    private Controle controle;
    private GridBagLayout gridLayout;
    private GridBagConstraints posicionador;
    private JButton btnCriar;
    private Border defaultBorder;

JLabel lbName;
JTextField txName;
JLabel lbCpf;
JTextField txCpf;
JLabel lbRg;
JTextField txRg;
JLabel lbSenha;
JPasswordField txSenha;
JLabel lbCelular;
JTextField txCelular;
JLabel lbEmail;
JTextField txEmail;
JLabel lbEndereco;
JTextField txEndereco;
JLabel lbComplemento;
JTextField txComplemento;
JLabel lbCep;
JTextField txCep;
JLabel lbCtps;
JTextField txCtps;
JLabel lbPis;
JTextField txPis;
    //construtor da classe que recebe um parametro.
    public FuncionarioDialog (Controle controle){
        this.controle = controle;
        initComponents();
    }
    private void initComponents(){
        gridLayout = new GridBagLayout();//inicializando o gerenciador de layout
        this.setLayout(gridLayout);//definie o gerenciador para este painel.
 lbName=this.setLabel("Nome", 0, 0);
 txName=newTextField("Nome", 32, 1, 0);
 lbCpf=this.setLabel("CPF", 2, 0);
 txCpf=newTextField("CPF", 11, 3, 0);
 lbRg=this.setLabel("RG", 0, 1);
 txRg=newTextField("RG", 11, 1, 1);
 lbSenha=this.setLabel("Senha", 2, 1);
JPasswordField txSenha=new JPasswordField(10);;
txSenha.setFocusable(true);    //acessibilidade
txSenha.setToolTipText("Senha"); //acessibilidade
Util.considerarEnterComoTab(txSenha);
posicionador = new GridBagConstraints();
posicionador.gridy=2;
posicionador.gridx=2;
this.add(txSenha, posicionador);//o add adiciona o rotulo no painel
 lbCelular=this.setLabel("Celular", 0, 2);
 txCelular=newTextField("Celular", 15, 1, 2);
 lbEmail=this.setLabel("E-mail", 2, 2);
 txEmail=newTextField("e-mail", 64, 3, 2);
 lbEndereco=this.setLabel("Endereco", 0, 3);
 txEndereco=newTextField("Endereco", 64, 1, 3);
 lbComplemento=this.setLabel("Complemento", 2, 3);
 txComplemento=newTextField("Complemento", 64, 3, 3);
 lbCep=this.setLabel("Cep", 0, 4);
 txCep=newTextField("Cep", 64, 1, 4);
 lbCtps=this.setLabel("CTPS", 2, 4);
 txCtps=newTextField("Ctps", 16, 3, 4);
 lbPis=this.setLabel("Pis", 0, 5);
 txPis=newTextField("Pis", 15, 1, 5);
btnCriar=new JButton("Adicionar");
btnCriar.setFocusable(true);
btnCriar.setToolTipText("Criar"); //acessibilidade
Util.registraEnterNoBotao(btnCriar);
posicionador=new GridBagConstraints();
posicionador.gridy=3;
posicionador.gridx=5;
btnCriar.addActionListener(this);
btnCriar.setActionCommand("comando_criar");
this.add(btnCriar, posicionador);
    }
    public void requestFocus(){
txName.requestFocus();
    }
    public void cleanForm(){
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals(btnCriar.getActionCommand())){
    }
}
JLabel setLabel(String name, int y, int x)
{
JLabel lb=new JLabel(name);
lb.setToolTipText(name); //acessibilidade
posicionador =new GridBagConstraints();
posicionador.gridy=y;
        posicionador.gridx=x;
        this.add(lb, posicionador);//o add adiciona o rotulo no painel
return lb;
}
JTextField newTextField(String label, int size, int y, int x)
{
JTextField sf= new JTextField(size);
sf.setFocusable(true);
sf.setToolTipText(label);
Util.considerarEnterComoTab(sf);
posicionador = new GridBagConstraints();
posicionador.gridy=y;
posicionador.gridx=x;
        this.add(sf, posicionador);
return sf;
}
}
