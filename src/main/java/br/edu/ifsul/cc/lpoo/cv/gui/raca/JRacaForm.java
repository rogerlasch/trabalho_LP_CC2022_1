package br.edu.ifsul.cc.lpoo.cv.gui.raca;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import br.edu.ifsul.cc.lpoo.cv.model.Raca;
import br.edu.ifsul.cc.lpoo.cv.model.Especie;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class JRacaForm extends javax.swing.JPanel {
    private Controle controle;
    private JRaca pnlRaca;
private Raca raca;
private List<Especie> especies;
private JComboBox cb_especies;
    private SimpleDateFormat format;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlSul;
    private javax.swing.JLabel lb_name;
    private javax.swing.JTextField r_name;
    public JRacaForm() {
        initComponents();
    }
    public JRacaForm(JRaca pnlRaca, Controle controle){
        this.pnlRaca = pnlRaca;
        this.controle = controle;
        initComponents();
        format = new SimpleDateFormat("dd/MM/yyyy");
    }
    public Raca getRacabyFormulario(){
         if(r_name.getText().trim().length() > 2)
{
            Raca r = new Raca();
            r.setNome(r_name.getText().trim());
            return r;
         }
         return null;
    }
    public void setRacaFormulario(Raca r){
if(r==null)
{
r_name.setText("");
}
else
{
r_name.setText(r.getNome());
}
    }
void setEspecies(List<Especie> especies)
{
this.especies=especies;
if(especies==null)
{
cb_especies.removeAllItems();
}
else
{
cb_especies.removeAllItems();
for(Especie esp : especies)
{
cb_especies.addItem(esp.getNome());
}
}
}

List<Especie> getEspecies()
{
return this.especies;
}
    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        pnlSul = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlCentro = new javax.swing.JPanel();
        lb_name = new javax.swing.JLabel();
        r_name = new javax.swing.JTextField();
        setLayout(new java.awt.BorderLayout());
        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnlSul.add(btnSave);
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlSul.add(btnCancelar);
        add(pnlSul, java.awt.BorderLayout.PAGE_END);
        pnlCentro.setLayout(new java.awt.GridBagLayout());
        lb_name.setText("Nome:");
cb_especies=new JComboBox();
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pnlCentro.add(lb_name, gridBagConstraints);
        r_name.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlCentro.add(r_name, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlCentro.add(cb_especies, gridBagConstraints);

        add(pnlCentro, java.awt.BorderLayout.CENTER);
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        Raca r = getRacabyFormulario();//recupera os dados do formulÃ¡rio
        if(r != null){
            try {
                pnlRaca.getControle().getConexaoJDBC().persist(r);
                JOptionPane.showMessageDialog(this, r.getNome(), "Salvar", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(this, "Raca armazenado!", "Salvar", JOptionPane.INFORMATION_MESSAGE);
                pnlRaca.showTela("tela_raca_listagem");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar Raca! : "+ex.getMessage(), "Salvar", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o formulário!", "Edição", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        pnlRaca.showTela("tela_raca_listagem");
    }
}
