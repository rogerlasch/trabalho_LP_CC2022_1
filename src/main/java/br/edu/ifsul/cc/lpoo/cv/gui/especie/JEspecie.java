package br.edu.ifsul.cc.lpoo.cv.gui.especie;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class JEspecie extends JPanel {
    private CardLayout cardLayout;
    private Controle controle;
    private JEspecieList listagem;
    private JEspecieForm formulario;
    public JEspecie(Controle controle){
        this.controle = controle;
        initComponents();
    }
    private void initComponents(){
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        listagem = new JEspecieList(this, controle);
        formulario = new JEspecieForm(this, controle);
        this.add(listagem, "tela_especie_listagem");
        this.add(getFormulario(), "tela_especie_formulario");
showTela("tela_especie_listagem");
    }
    public void showTela(String nomeTela){
        if(nomeTela.equals("tela_especie_listagem")){
            listagem.populaTable();
        }
        cardLayout.show(this, nomeTela);
    }
    /**
     * @return the controle
     */
    public Controle getControle() {
        return controle;
    }
    /**
     * @return the formulario
     */
    public JEspecieForm getFormulario() {
        return formulario;
    }
}
