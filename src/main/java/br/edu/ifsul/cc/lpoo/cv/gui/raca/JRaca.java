package br.edu.ifsul.cc.lpoo.cv.gui.raca;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class JRaca extends JPanel {
    private CardLayout cardLayout;
    private Controle controle;
    private JRacaList listagem;
    private JRacaForm formulario;
    public JRaca(Controle controle){
        this.controle = controle;
        initComponents();
    }
    private void initComponents(){
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        listagem = new JRacaList(this, controle);
        formulario = new JRacaForm(this, controle);
        this.add(listagem, "tela_raca_listagem");
        this.add(getFormulario(), "tela_raca_formulario");
    }
    public void showTela(String nomeTela){
        if(nomeTela.equals("tela_raca_listagem")){
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
    public JRacaForm getFormulario() {
        return formulario;
    }
}
