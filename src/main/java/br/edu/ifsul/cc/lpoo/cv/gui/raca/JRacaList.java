package br.edu.ifsul.cc.lpoo.cv.gui.raca;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import br.edu.ifsul.cc.lpoo.cv.model.Raca;
import br.edu.ifsul.cc.lpoo.cv.model.Especie;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class JRacaList extends javax.swing.JPanel {
    private Controle controle;
    private JRaca pnlRaca;
    private SimpleDateFormat format;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlSul;
    private javax.swing.JScrollPane scpRolagem;
    private javax.swing.JScrollPane scrolEspecies;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTable especies;
    private javax.swing.JTextField txtfFiltro;
    public JRacaList() {
        initComponents();
    }
    public JRacaList(JRaca pnlRaca, Controle controle) {
        this.pnlRaca = pnlRaca;
        this.controle = controle;
        initComponents();
        format = new SimpleDateFormat("dd/MM/yyyy");
    }
    public void populaTable(){
        DefaultTableModel model =  (DefaultTableModel) tblListagem.getModel();
        DefaultTableModel model2 =  (DefaultTableModel) especies.getModel();
        model.setRowCount(0);
model2.setRowCount(0);
        try {
            List<Raca> racas = controle.getConexaoJDBC().listRacas();
            for(Raca r : racas){
                model.addRow(new Object[]{r.getId(), r.getNome()});
Especie esp=r.getEspecie();
model2.addRow(new Object[]{esp.getId(), esp.getNome()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar racas :"+ex.getLocalizedMessage(), "racas", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {
        pnlSul = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        pnlCentro = new javax.swing.JPanel();
        scpRolagem = new javax.swing.JScrollPane();
scrolEspecies = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();
tblListagem.setFocusable(true);
        especies = new javax.swing.JTable();
especies.setFocusable(true);
        setLayout(new java.awt.BorderLayout());
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        pnlSul.add(btnNovo);
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlSul.add(btnEditar);
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        pnlSul.add(btnRemover);
        jButton1.setText("Cancelar");
        pnlSul.add(jButton1);
        add(pnlSul, java.awt.BorderLayout.PAGE_END);
        pnlCentro.setLayout(new java.awt.BorderLayout());
        tblListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
"Id", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scpRolagem.setViewportView(tblListagem);
        pnlCentro.add(scpRolagem, java.awt.BorderLayout.CENTER);
        especies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
"Id", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
scrolEspecies.setViewportView(especies);
        pnlCentro.add(scrolEspecies, java.awt.BorderLayout.CENTER);
        add(pnlCentro, java.awt.BorderLayout.CENTER);
populaTable();
    }
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {
        pnlRaca.showTela("tela_raca_formulario");
        pnlRaca.getFormulario().setRacaFormulario(null);
    }
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
            int indice = tblListagem.getSelectedRow();
            if(indice > -1){
                DefaultTableModel model =  (DefaultTableModel) tblListagem.getModel();
                Vector linha = (Vector) model.getDataVector().get(indice);
                Raca r = (Raca) linha.get(0);
                pnlRaca.showTela("tela_raca_formulario");
                pnlRaca.getFormulario().setRacaFormulario(r);
            }else{
                  JOptionPane.showMessageDialog(this, "Selecione uma linha para editar!", "Edição", JOptionPane.INFORMATION_MESSAGE);
            }
    }
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {
            int indice = tblListagem.getSelectedRow();
            if(indice > -1){
                DefaultTableModel model =  (DefaultTableModel) tblListagem.getModel();
                Vector linha = (Vector) model.getDataVector().get(indice);
                Raca r = (Raca) linha.get(0); 
                try {
                    pnlRaca.getControle().getConexaoJDBC().remover(r);
                    JOptionPane.showMessageDialog(this, "Raca removido!", "Raca", JOptionPane.INFORMATION_MESSAGE);
                    populaTable();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao remover Raca -:"+ex.getLocalizedMessage(), "racas", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }else{
                  JOptionPane.showMessageDialog(this, "Selecione uma linha para remover!", "Remoção", JOptionPane.INFORMATION_MESSAGE);
            }
    }
}
