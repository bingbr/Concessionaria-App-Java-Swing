package ap3;
//@author William S.
import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.table.*;
import com.formdev.flatlaf.FlatDarkLaf;

public class Main extends javax.swing.JFrame {
    public static final String formatarData = "dd/MM/yyyy";
    int id = 0;
    String noCasoCarro;
    String noCasoCliente;
    List<Carro> ListaCarro;
    List<Cliente> ListaCliente;
    List<Venda> ListaVenda;
    public void CarregarTabelaCarro(){
        DefaultTableModel delo = new DefaultTableModel(new Object[]{"Cod.","Modelo","Marca","Ano","Data"}, 0);
        for (int i = 0; i < ListaCarro.size(); i++) {
            delo.addRow(new Object[]{ListaCarro.get(i).getCod(),ListaCarro.get(i).getModelo(),ListaCarro.get(i).getMarca(),ListaCarro.get(i).getAno(),ListaCarro.get(i).getDataAdicionado()});
        }
        tabela_carro.setModel(delo);
        tabela_carro.getColumnModel().getColumn(0).setMinWidth(36);
        tabela_carro.getColumnModel().getColumn(0).setMaxWidth(36);
        tabela_carro.getColumnModel().getColumn(3).setMinWidth(42);
        tabela_carro.getColumnModel().getColumn(3).setMaxWidth(42);
        tabela_carro.getColumnModel().getColumn(4).setMinWidth(85);
        tabela_carro.getColumnModel().getColumn(4).setMaxWidth(85);
    }
    public void CarregarTabelaCliente(){
        DefaultTableModel delo = new DefaultTableModel(new Object[]{"CPF","Nome","E-mail","Telefone","Data"}, 0);
        for (int i = 0; i < ListaCliente.size(); i++) {
            delo.addRow(new Object[]{ListaCliente.get(i).getCpf(),ListaCliente.get(i).getNome(),ListaCliente.get(i).getEmail(),ListaCliente.get(i).getTelefone(),ListaCliente.get(i).getDataAdicionado()});
        }
        tabela_cliente.setModel(delo);
        tabela_cliente.getColumnModel().getColumn(0).setMinWidth(117);
        tabela_cliente.getColumnModel().getColumn(0).setMaxWidth(117);
        tabela_cliente.getColumnModel().getColumn(3).setMinWidth(121);
        tabela_cliente.getColumnModel().getColumn(3).setMaxWidth(121);
        tabela_cliente.getColumnModel().getColumn(4).setMinWidth(85);
        tabela_cliente.getColumnModel().getColumn(4).setMaxWidth(85);
    }
    public void CarregarTabelaVenda(){
        DefaultTableModel delo = new DefaultTableModel(new Object[]{"ID","Cliente","Carro","Preço","Data"}, 0);
        for (int i = 0; i < ListaVenda.size(); i++) {
            delo.addRow(new Object[]{ListaVenda.get(i).getId(),ListaVenda.get(i).getModeloCarro(),ListaVenda.get(i).getNomeCliente(),ListaVenda.get(i).getPreco(),ListaVenda.get(i).getDataAdicionado()});
        }
        tabela_venda.setModel(delo);
        tabela_venda.getColumnModel().getColumn(0).setMinWidth(30);
        tabela_venda.getColumnModel().getColumn(0).setMaxWidth(30);
        tabela_venda.getColumnModel().getColumn(3).setMinWidth(80);
        tabela_venda.getColumnModel().getColumn(3).setMaxWidth(95);
        tabela_venda.getColumnModel().getColumn(4).setMinWidth(85);
        tabela_venda.getColumnModel().getColumn(4).setMaxWidth(85);
    }
    
    public final void carro_Button_Menu(boolean N, boolean E, boolean M){
        adicionar_carro_Button.setEnabled(N);
        editar_carro_Button.setEnabled(E);
        excluir_carro_Button.setEnabled(E);
        ok_carro_Button.setEnabled(M);
        cancelar_carro_Button.setEnabled(M);
        cod_Field.setEnabled(M);
        modelo_Field.setEnabled(M);
        marca_Field.setEnabled(M);
        ano_Field.setEnabled(M);
    }
    public void carro_text_Field(String Campo){
        cod_Field.setText(Campo);
        modelo_Field.setText(Campo);
        marca_Field.setText(Campo);
        ano_Field.setText(Campo);
    }
    public final void cliente_Button_Menu(boolean N, boolean E, boolean M){
        adicionar_cliente_Button.setEnabled(N);
        editar_cliente_Button.setEnabled(E);
        excluir_cliente_Button.setEnabled(E);
        ok_cliente_Button.setEnabled(M);
        cancelar_cliente_Button.setEnabled(M);
        cpf_Field.setEnabled(M);
        nome_Field.setEnabled(M);
        email_Field.setEnabled(M);
        telefone_Field.setEnabled(M);
    }
    public void cliente_text_Field(String Campo){
        cpf_Field.setText(Campo);
        nome_Field.setText(Campo);
        email_Field.setText(Campo);
        telefone_Field.setText(Campo);
    }
    public final void venda_Button_Menu(boolean N, boolean M){
        vender_Button.setEnabled(N);
        ok_venda_Button.setEnabled(M);
        cancelar_venda_Button.setEnabled(M);
        cliente_ComboBox.setEnabled(M);
        carro_ComboBox.setEnabled(M);
        preco_Field.setEnabled(M);
    }
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        ListaCarro = new ArrayList<Carro>();
        ListaCliente = new ArrayList<Cliente>();
        ListaVenda = new ArrayList<Venda>();
        noCasoCarro = "Inicio";
        noCasoCliente = "Inicio";
        controlar_carro_Menu();
        controlar_cliente_Menu();
    }
    
    public void controlar_carro_Menu(){
        switch (noCasoCarro){
            case "Inicio":
                carro_Button_Menu(true, false, false);
                venda_Button_Menu(true, false);
                break;
            case "Novo":
                carro_Button_Menu(false, false, true);
                break;
            case "Editar":
                carro_Button_Menu(false, false, true);
                break;
            default: JOptionPane.showMessageDialog(this, "Erro interno.");
        }
    }
    
    public void controlar_cliente_Menu(){
        switch (noCasoCliente){
            case "Inicio":
                cliente_Button_Menu(true, false, false);
                venda_Button_Menu(true, false);
                break;
            case "Novo":
                cliente_Button_Menu(false, false, true);
                break;
            case "Editar":
                cliente_Button_Menu(false, false, true);
                break;
            default: JOptionPane.showMessageDialog(this, "Erro interno.");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subMenu = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cod_Field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        modelo_Field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        marca_Field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ano_Field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ok_carro_Button = new javax.swing.JButton();
        cancelar_carro_Button = new javax.swing.JButton();
        adicionar_carro_Button = new javax.swing.JButton();
        excluir_carro_Button = new javax.swing.JButton();
        editar_carro_Button = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela_carro = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nome_Field = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        email_Field = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ok_cliente_Button = new javax.swing.JButton();
        cancelar_cliente_Button = new javax.swing.JButton();
        telefone_Field = new javax.swing.JFormattedTextField();
        cpf_Field = new javax.swing.JFormattedTextField();
        adicionar_cliente_Button = new javax.swing.JButton();
        editar_cliente_Button = new javax.swing.JButton();
        excluir_cliente_Button = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabela_cliente = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        preco_Field = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ok_venda_Button = new javax.swing.JButton();
        cancelar_venda_Button = new javax.swing.JButton();
        carro_ComboBox = new javax.swing.JComboBox<>();
        cliente_ComboBox = new javax.swing.JComboBox<>();
        vender_Button = new javax.swing.JButton();
        buscar_Button = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabela_venda = new javax.swing.JTable();
        buscar_Field = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        file_Menu = new javax.swing.JMenu();
        open_Menu = new javax.swing.JMenuItem();
        save_Menu = new javax.swing.JMenuItem();
        exit_Menu = new javax.swing.JMenuItem();
        about_Menu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Concessionária AP3");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Carro"));

        jLabel1.setText("Código do Veículo:");

        jLabel2.setText("Modelo:");

        jLabel3.setText("Marca:");

        jLabel4.setText("Ano:");

        ok_carro_Button.setText("OK");
        ok_carro_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_carro_ButtonActionPerformed(evt);
            }
        });

        cancelar_carro_Button.setText("Cancelar");
        cancelar_carro_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_carro_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(modelo_Field, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(cod_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ano_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marca_Field))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ok_carro_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelar_carro_Button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cod_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelo_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marca_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ano_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ok_carro_Button)
                    .addComponent(cancelar_carro_Button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        adicionar_carro_Button.setText("Adicionar Carro");
        adicionar_carro_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionar_carro_ButtonActionPerformed(evt);
            }
        });

        excluir_carro_Button.setText("Excluir");
        excluir_carro_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluir_carro_ButtonActionPerformed(evt);
            }
        });

        editar_carro_Button.setText("Editar");
        editar_carro_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_carro_ButtonActionPerformed(evt);
            }
        });

        tabela_carro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Modelo", "Marca", "Ano", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_carro.getTableHeader().setReorderingAllowed(false);
        tabela_carro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_carroMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabela_carro);
        if (tabela_carro.getColumnModel().getColumnCount() > 0) {
            tabela_carro.getColumnModel().getColumn(0).setMinWidth(33);
            tabela_carro.getColumnModel().getColumn(0).setMaxWidth(33);
            tabela_carro.getColumnModel().getColumn(3).setMinWidth(32);
            tabela_carro.getColumnModel().getColumn(3).setMaxWidth(32);
            tabela_carro.getColumnModel().getColumn(4).setMinWidth(65);
            tabela_carro.getColumnModel().getColumn(4).setMaxWidth(65);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(adicionar_carro_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editar_carro_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excluir_carro_Button)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionar_carro_Button)
                    .addComponent(excluir_carro_Button)
                    .addComponent(editar_carro_Button))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        subMenu.addTab("Carros", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel5.setText("CPF:");

        jLabel6.setText("Nome:");

        jLabel7.setText("E-mail:");

        jLabel8.setText("Telefone:");

        ok_cliente_Button.setText("OK");
        ok_cliente_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_cliente_ButtonActionPerformed(evt);
            }
        });

        cancelar_cliente_Button.setText("Cancelar");
        cancelar_cliente_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_cliente_ButtonActionPerformed(evt);
            }
        });

        try {
            telefone_Field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            cpf_Field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nome_Field, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(email_Field)
                    .addComponent(telefone_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ok_cliente_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelar_cliente_Button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cpf_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(telefone_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ok_cliente_Button)
                    .addComponent(cancelar_cliente_Button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        adicionar_cliente_Button.setText("Adicionar Cliente");
        adicionar_cliente_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionar_cliente_ButtonActionPerformed(evt);
            }
        });

        editar_cliente_Button.setText("Editar");
        editar_cliente_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_cliente_ButtonActionPerformed(evt);
            }
        });

        excluir_cliente_Button.setText("Excluir");
        excluir_cliente_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluir_cliente_ButtonActionPerformed(evt);
            }
        });

        tabela_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "E-mail", "Telefone", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_cliente.getTableHeader().setReorderingAllowed(false);
        tabela_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_clienteMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabela_cliente);
        if (tabela_cliente.getColumnModel().getColumnCount() > 0) {
            tabela_cliente.getColumnModel().getColumn(0).setMinWidth(83);
            tabela_cliente.getColumnModel().getColumn(0).setMaxWidth(83);
            tabela_cliente.getColumnModel().getColumn(3).setMinWidth(85);
            tabela_cliente.getColumnModel().getColumn(3).setMaxWidth(85);
            tabela_cliente.getColumnModel().getColumn(4).setMinWidth(65);
            tabela_cliente.getColumnModel().getColumn(4).setMaxWidth(65);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(adicionar_cliente_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addComponent(editar_cliente_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excluir_cliente_Button)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionar_cliente_Button)
                    .addComponent(excluir_cliente_Button)
                    .addComponent(editar_cliente_Button))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        subMenu.addTab("Clientes", jPanel2);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Vender"));

        jLabel9.setText("Cliente:");

        jLabel10.setText("Carro:");

        jLabel11.setText("Preço:");

        ok_venda_Button.setText("OK");
        ok_venda_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_venda_ButtonActionPerformed(evt);
            }
        });

        cancelar_venda_Button.setText("Cancelar");
        cancelar_venda_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_venda_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cliente_ComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                    .addComponent(carro_ComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(preco_Field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ok_venda_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelar_venda_Button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cliente_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(carro_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preco_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ok_venda_Button)
                    .addComponent(cancelar_venda_Button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        vender_Button.setText("Vender");
        vender_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vender_ButtonActionPerformed(evt);
            }
        });

        buscar_Button.setText("Buscar Venda");
        buscar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_ButtonActionPerformed(evt);
            }
        });

        tabela_venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Carro", "Preço", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabela_venda.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tabela_venda);
        if (tabela_venda.getColumnModel().getColumnCount() > 0) {
            tabela_venda.getColumnModel().getColumn(0).setMinWidth(30);
            tabela_venda.getColumnModel().getColumn(0).setMaxWidth(30);
            tabela_venda.getColumnModel().getColumn(3).setMinWidth(50);
            tabela_venda.getColumnModel().getColumn(3).setMaxWidth(82);
            tabela_venda.getColumnModel().getColumn(4).setMinWidth(65);
            tabela_venda.getColumnModel().getColumn(4).setMaxWidth(65);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(vender_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(buscar_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar_Button)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vender_Button)
                    .addComponent(buscar_Button)
                    .addComponent(buscar_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        subMenu.addTab("Vendas", jPanel3);

        file_Menu.setText("Arquivo");

        open_Menu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        open_Menu.setText("Abrir");
        open_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_MenuActionPerformed(evt);
            }
        });
        file_Menu.add(open_Menu);

        save_Menu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        save_Menu.setText("Salvar");
        save_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_MenuActionPerformed(evt);
            }
        });
        file_Menu.add(save_Menu);

        exit_Menu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exit_Menu.setText("Sair");
        exit_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_MenuActionPerformed(evt);
            }
        });
        file_Menu.add(exit_Menu);

        jMenuBar1.add(file_Menu);

        about_Menu.setText("Sobre");
        about_Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                about_MenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(about_Menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subMenu)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /* Menu */
    private void open_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open_MenuActionPerformed
        try {
            JFileChooser abrir = new JFileChooser();
            abrir.setDialogTitle("Procurar arquivo:");
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Dados Salvos (*.ap3)", "ap3");
            abrir.setFileFilter(filtro);
            int abriu = abrir.showOpenDialog(this);
            List<String> linhas;
            if (abriu == JFileChooser.APPROVE_OPTION) {
                File localNameArq = abrir.getSelectedFile();
                String localArq = ""+localNameArq;
                linhas = Files.readAllLines(Paths.get(localArq));
                for (String linha : linhas) {
                    if (linha.startsWith(":")) {
                        String[] dados = linha.split(":");
                        Cliente novoCliente = new Cliente(dados[1], dados[2], dados[3], dados[4], dados[5]);
                        ListaCliente.add(novoCliente);
                    }
                    if (linha.startsWith("#")) {
                        String[] dados = linha.split("#");
                        Carro novoCarro = new Carro(Integer.parseInt(dados[1]), dados[2], dados[3], Integer.parseInt(dados[4]), dados[5]);
                        ListaCarro.add(novoCarro);
                    }
                    if (linha.startsWith(";")) {
                        String[] dados = linha.split(";");
                        Venda novaVenda = new Venda(Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[5]);
                        ListaVenda.add(novaVenda);
                    }
                }
                CarregarTabelaCarro();
                CarregarTabelaCliente();
                CarregarTabelaVenda();
                JOptionPane.showMessageDialog(null, "Dados carregados com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                throw new IOException();
            }
        } catch (IOException | NullPointerException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado.\nVerifique os dados e tente novamente.", "ERRO:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_open_MenuActionPerformed
    private void save_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_MenuActionPerformed
        try {
            JFileChooser salvar = new JFileChooser();
            salvar.setDialogTitle("Salvar Arquivo:");
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Dados Salvos (*.ap3)", "ap3");
            salvar.setFileFilter(filtro);
            int escolha = salvar.showSaveDialog(this);
            if(escolha == JFileChooser.APPROVE_OPTION){
                try (FileWriter save = new FileWriter(salvar.getSelectedFile()+".ap3")) {
                    for (int i = 0; i < ListaCliente.size(); i++){
                        save.write(":" +ListaCliente.get(i).getCpf()+ ":" +ListaCliente.get(i).getNome()+ ":" +ListaCliente.get(i).getEmail()+ ":" +ListaCliente.get(i).getTelefone()+ ":" +ListaCliente.get(i).getDataAdicionado()+ "\n");
                    }
                    for (int i = 0; i < ListaCarro.size(); i++){
                        save.write("#" +ListaCarro.get(i).getCod()+ "#" +ListaCarro.get(i).getModelo()+ "#" +ListaCarro.get(i).getMarca()+ "#" +ListaCarro.get(i).getAno()+ "#" +ListaCarro.get(i).getDataAdicionado()+ "\n");
                    }
                    for (int i = 0; i < ListaVenda.size(); i++){
                        save.write(";" +ListaVenda.get(i).getId()+ ";" +ListaVenda.get(i).getNomeCliente()+ ";" + ListaVenda.get(i).getModeloCarro()+ ";" +ListaVenda.get(i).getPreco()+ ";" +ListaVenda.get(i).getDataAdicionado()+ "\n");
                    }
                }
            } else {
                throw new IOException();
            }
            JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso.", "Dados Salvos", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado. \nVerifique os dados e tente novamente.", "ERRO:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_save_MenuActionPerformed
    private void exit_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_MenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exit_MenuActionPerformed
    private void about_MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_about_MenuMouseClicked
        JOptionPane.showMessageDialog(null, "Programa para avaliação da faculdade.\nDesigned by William in NetBeans", "Sobre", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_about_MenuMouseClicked
    /* Carro */
    private void adicionar_carro_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionar_carro_ButtonActionPerformed
        noCasoCarro = "Novo";
        carro_text_Field("");
        controlar_carro_Menu();
    }//GEN-LAST:event_adicionar_carro_ButtonActionPerformed
    private void editar_carro_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_carro_ButtonActionPerformed
        noCasoCarro = "Editar";
        controlar_carro_Menu();
    }//GEN-LAST:event_editar_carro_ButtonActionPerformed
    private void excluir_carro_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluir_carro_ButtonActionPerformed
        int in = tabela_carro.getSelectedRow();
        if (in >= 0 && in < ListaCarro.size()){
            ListaCarro.remove(in);
        }
        CarregarTabelaCarro();
        noCasoCarro = "Inicio";
        controlar_carro_Menu();
        carro_text_Field("");
    }//GEN-LAST:event_excluir_carro_ButtonActionPerformed
    private void ok_carro_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok_carro_ButtonActionPerformed
        try {
            if (noCasoCarro.equals("Novo")) {
                Date data = new Date();
                DateFormat d = new SimpleDateFormat(formatarData);
                String dataFormatado = d.format(data);
                Carro novoCarro = new Carro(Integer.parseInt(cod_Field.getText()), modelo_Field.getText(), marca_Field.getText(), Integer.parseInt(ano_Field.getText()), dataFormatado);
                ListaCarro.add(novoCarro);              
            } else {
                int in = tabela_carro.getSelectedRow();
                ListaCarro.get(in).setCod(Integer.parseInt(cod_Field.getText()));
                ListaCarro.get(in).setModelo(modelo_Field.getText());
                ListaCarro.get(in).setMarca(marca_Field.getText());
                ListaCarro.get(in).setAno(Integer.parseInt(ano_Field.getText()));
            }
            CarregarTabelaCarro();
            noCasoCarro = "Inicio";
            controlar_carro_Menu();
            carro_text_Field("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Você deixou de preencher algum campo.", "Ops, ocorreu um erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ok_carro_ButtonActionPerformed
    private void cancelar_carro_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_carro_ButtonActionPerformed
        noCasoCarro = "Inicio";
        controlar_carro_Menu();
    }//GEN-LAST:event_cancelar_carro_ButtonActionPerformed
    /* Cliente */
    private void adicionar_cliente_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionar_cliente_ButtonActionPerformed
        noCasoCliente = "Novo";
        controlar_cliente_Menu();
        cliente_text_Field("");
    }//GEN-LAST:event_adicionar_cliente_ButtonActionPerformed
    private void editar_cliente_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_cliente_ButtonActionPerformed
        noCasoCliente = "Editar";
        controlar_cliente_Menu();
    }//GEN-LAST:event_editar_cliente_ButtonActionPerformed
    private void excluir_cliente_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluir_cliente_ButtonActionPerformed
        int in = tabela_cliente.getSelectedRow();
        if (in >= 0 && in < ListaCliente.size()) {
            ListaCliente.remove(in);
        }
        CarregarTabelaCliente();
        noCasoCliente = "Inicio";
        controlar_cliente_Menu();
        cliente_text_Field("");
    }//GEN-LAST:event_excluir_cliente_ButtonActionPerformed
    private void ok_cliente_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok_cliente_ButtonActionPerformed
        try {       
            if (noCasoCliente.equals("Novo")) {
                Date data = new Date();
                DateFormat d = new SimpleDateFormat(formatarData);
                String dataFormatado = d.format(data);
                Cliente novoCliente = new Cliente(cpf_Field.getText(), nome_Field.getText(), email_Field.getText(), telefone_Field.getText(), dataFormatado);
                if (cpf_Field.getText().contains("   .   .   -  ") || nome_Field.getText().equals("") || email_Field.getText().equals("") || telefone_Field.getText().contains("(  )     -    ")) {
                    throw new Exception();
                } else {
                    ListaCliente.add(novoCliente);
                }
            } else {
                int in = tabela_cliente.getSelectedRow();
                ListaCliente.get(in).setCpf(cpf_Field.getText());
                ListaCliente.get(in).setNome(nome_Field.getText());
                ListaCliente.get(in).setEmail(email_Field.getText());
                ListaCliente.get(in).setTelefone(telefone_Field.getText());
            }
            CarregarTabelaCliente();
            noCasoCliente = "Inicio";
            controlar_cliente_Menu();
            cliente_text_Field("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Você deixou de preencher um campo.", "Ops, ocorreu um erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ok_cliente_ButtonActionPerformed
    private void cancelar_cliente_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_cliente_ButtonActionPerformed
        noCasoCliente = "Inicio";
        controlar_cliente_Menu();
    }//GEN-LAST:event_cancelar_cliente_ButtonActionPerformed
    /* Venda */
    private void vender_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vender_ButtonActionPerformed
        carro_ComboBox.removeAllItems();
        cliente_ComboBox.removeAllItems();
        for (int i = 0; i < ListaCarro.size(); i++) {
            String modeloBox = ListaCarro.get(i).getMarca() + " " + ListaCarro.get(i).getModelo() + " " + ListaCarro.get(i).getAno();
            carro_ComboBox.addItem(modeloBox);
        }
        for (int i = 0; i < ListaCliente.size(); i++) {
            String nomeBox = ListaCliente.get(i).getNome();
            cliente_ComboBox.addItem(nomeBox);
        }
        venda_Button_Menu(false, true);
        preco_Field.setText("");
    }//GEN-LAST:event_vender_ButtonActionPerformed
    private void buscar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_ButtonActionPerformed
        String entrada = buscar_Field.getText();
        for (int i = 0; i < ListaVenda.size(); i++) {
            String modelo = ListaVenda.get(i).getModeloCarro();
            String nome = ListaVenda.get(i).getNomeCliente();
            int local = ListaVenda.get(i).getId();
            if (entrada.contains(modelo)) {
                JOptionPane.showMessageDialog(this, modelo+ " foi encontrado no ID " +local);
            }
            if (entrada.contains(nome)) {
                JOptionPane.showMessageDialog(this, nome+ " foi encontrado no ID " +local);
            }
        }
        CarregarTabelaVenda();
    }//GEN-LAST:event_buscar_ButtonActionPerformed
    private void ok_venda_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok_venda_ButtonActionPerformed
        id++;
        try {
            Date data = new Date();
            DateFormat d = new SimpleDateFormat(formatarData);
            String dataFormatado = d.format(data);
            Venda novaVenda = new Venda(id, carro_ComboBox.getSelectedItem().toString(), cliente_ComboBox.getSelectedItem().toString(), preco_Field.getText(), dataFormatado);
            if (preco_Field.getText().equals("")) {
                throw new NullPointerException();
            } else {
                ListaVenda.add(novaVenda);
                CarregarTabelaVenda();
                venda_Button_Menu(true, false);
                carro_ComboBox.removeAllItems();
                cliente_ComboBox.removeAllItems();
                preco_Field.setText("");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Você deixou de preencher algum campo.", "Ops, ocorreu um erro!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ok_venda_ButtonActionPerformed
    private void cancelar_venda_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_venda_ButtonActionPerformed
        venda_Button_Menu(true, false);
        carro_ComboBox.removeAllItems();
        cliente_ComboBox.removeAllItems();
        preco_Field.setText("");
    }//GEN-LAST:event_cancelar_venda_ButtonActionPerformed
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    
	}//GEN-LAST:event_formMouseClicked
    private void tabela_carroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_carroMouseClicked
        int in = tabela_carro.getSelectedRow();
        if (in >= 0 && in < ListaCarro.size()){
            Carro novoCarro = ListaCarro.get(in);
            cod_Field.setText(String.valueOf(novoCarro.getCod()));
            modelo_Field.setText(novoCarro.getModelo());
            marca_Field.setText(novoCarro.getMarca());
            ano_Field.setText(String.valueOf(novoCarro.getAno()));
            carro_Button_Menu(true, true, false);
        }
    }//GEN-LAST:event_tabela_carroMouseClicked
    private void tabela_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_clienteMouseClicked
        int in = tabela_cliente.getSelectedRow();
        if (in >= 0 && in < ListaCliente.size()){
            Cliente novoCliente = ListaCliente.get(in);
            cpf_Field.setText(novoCliente.getCpf());
            nome_Field.setText(novoCliente.getNome());
            email_Field.setText(novoCliente.getEmail());
            telefone_Field.setText(novoCliente.getTelefone());
            cliente_Button_Menu(true, true, false);
        }
    }//GEN-LAST:event_tabela_clienteMouseClicked
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());
        }  catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu about_Menu;
    private javax.swing.JButton adicionar_carro_Button;
    private javax.swing.JButton adicionar_cliente_Button;
    private javax.swing.JTextField ano_Field;
    private javax.swing.JButton buscar_Button;
    private javax.swing.JTextField buscar_Field;
    private javax.swing.JButton cancelar_carro_Button;
    private javax.swing.JButton cancelar_cliente_Button;
    private javax.swing.JButton cancelar_venda_Button;
    private javax.swing.JComboBox<String> carro_ComboBox;
    private javax.swing.JComboBox<String> cliente_ComboBox;
    private javax.swing.JTextField cod_Field;
    private javax.swing.JFormattedTextField cpf_Field;
    private javax.swing.JButton editar_carro_Button;
    private javax.swing.JButton editar_cliente_Button;
    private javax.swing.JTextField email_Field;
    private javax.swing.JButton excluir_carro_Button;
    private javax.swing.JButton excluir_cliente_Button;
    private javax.swing.JMenuItem exit_Menu;
    private javax.swing.JMenu file_Menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField marca_Field;
    private javax.swing.JTextField modelo_Field;
    private javax.swing.JTextField nome_Field;
    private javax.swing.JButton ok_carro_Button;
    private javax.swing.JButton ok_cliente_Button;
    private javax.swing.JButton ok_venda_Button;
    private javax.swing.JMenuItem open_Menu;
    private javax.swing.JTextField preco_Field;
    private javax.swing.JMenuItem save_Menu;
    private javax.swing.JTabbedPane subMenu;
    private javax.swing.JTable tabela_carro;
    private javax.swing.JTable tabela_cliente;
    private javax.swing.JTable tabela_venda;
    private javax.swing.JFormattedTextField telefone_Field;
    private javax.swing.JButton vender_Button;
    // End of variables declaration//GEN-END:variables
}