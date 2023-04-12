package edu.uni.ap3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;

/**
 *
 * @author William S.
 */
public class Main extends javax.swing.JFrame {
    String noCasoCarro;
    String noCasoCliente;
    List<Carro> ListaCarro;
    List<Cliente> ListaCliente;
    List<Venda> ListaVenda;
    List<Venda> ListaPesquisa;
    private final Buttons buttons = new Buttons();
    private final Data data = new Data();

    protected void CarregarTabelaCarro() {
        int[] tamanho = new int[]{36, 42, 85};
        data.carregarTabela(ListaCarro, carro_Tabela,
                new Object[]{"Cod.", "Modelo", "Marca", "Ano", "Data"},
                carro -> new Object[]{carro.getCod(), carro.getModelo(), carro.getMarca(), carro.getAno(), carro.getDataAdicionado()},
                new int[]{0, 3, 4}, tamanho, tamanho);
    }

    protected void CarregarTabelaCliente() {
        int[] min = new int[]{116, 116, 85};
        int[] max = new int[]{119, 121, 85};
        data.carregarTabela(ListaCliente, cliente_Tabela,
                new Object[]{"CPF", "Nome", "E-mail", "Telefone", "Data"},
                cliente -> new Object[]{cliente.getCpfFormatado(), cliente.toString(), cliente.getEmail(), cliente.getTelefoneFormatado(), cliente.getDataAdicionado()},
                new int[]{0, 3, 4}, min, max);
    }

    protected void CarregarTabelaVenda(List<Venda> Lista) {
        int[] min = new int[]{30, 105, 85};
        int[] max = new int[]{30, 150, 85};
        data.carregarTabela(Lista, venda_Tabela,
                new Object[]{"ID","Cliente","Carro","Preço","Data"},
                venda -> new Object[]{venda.getId(), venda.getCliente(), venda.getCarro(), venda.getPrecoFormatado(), venda.getDataAdicionado()},
                new int[]{0, 3, 4}, min, max);
    }

    public final void carro_Button_Menu(boolean N, boolean E, boolean M){
        carro_adicionar_Button.setEnabled(N);
        carro_editar_Button.setEnabled(E);
        carro_excluir_Button.setEnabled(E);
        carro_ok_Button.setEnabled(M);
        carro_cancelar_Button.setEnabled(M);
        carro_cod_Field.setEnabled(M);
        carro_modelo_Field.setEnabled(M);
        carro_marca_Field.setEnabled(M);
        carro_ano_Field.setEnabled(M);
    }

    public void carro_text_Field(String Campo){
        carro_cod_Field.setText(Campo);
        carro_modelo_Field.setText(Campo);
        carro_marca_Field.setText(Campo);
        carro_ano_Field.setText(Campo);
    }

    public final void cliente_Button_Menu(boolean N, boolean E, boolean M){
        cliente_adicionar_Button.setEnabled(N);
        cliente_editar_Button.setEnabled(E);
        cliente_excluir_Button.setEnabled(E);
        cliente_ok_Button.setEnabled(M);
        cliente_cancelar_Button.setEnabled(M);
        cliente_cpf_Field.setEnabled(M);
        cliente_nome_Field.setEnabled(M);
        cliente_email_Field.setEnabled(M);
        cliente_telefone_Field.setEnabled(M);
    }

    public void cliente_text_Field(String Campo){
        cliente_cpf_Field.setText(Campo);
        cliente_nome_Field.setText(Campo);
        cliente_email_Field.setText(Campo);
        cliente_telefone_Field.setText(Campo);
    }

    public void venda_Button_Menu(boolean N, boolean M){
        venda_vender_Button.setEnabled(N);
        venda_ok_Button.setEnabled(M);
        venda_cancelar_Button.setEnabled(M);
        venda_cliente_ComboBox.setEnabled(M);
        venda_carro_ComboBox.setEnabled(M);
        venda_preco_Field.setEnabled(M);
    }

    public void carro_controlar_Menu(){
        switch (noCasoCarro) {
            case "Inicio" -> {
                carro_Button_Menu(true, false, false);
                venda_Button_Menu(true, false);
            }
            case "Novo" -> carro_Button_Menu(false, false, true);
            case "Editar" -> carro_Button_Menu(false, false, true);
            default -> JOptionPane.showMessageDialog(this, "Erro interno.");
        }
    }
    
    public void cliente_controlar_Menu(){
        switch (noCasoCliente) {
            case "Inicio" -> {
                cliente_Button_Menu(true, false, false);
                venda_Button_Menu(true, false);
            }
            case "Novo" -> cliente_Button_Menu(false, false, true);
            case "Editar" -> cliente_Button_Menu(false, false, true);
            default -> JOptionPane.showMessageDialog(this, "Erro interno.");
        }
    }
    
    /** Creates new form Main */
    public Main() {
        initComponents();

        setLocationRelativeTo(null);
        ListaCarro = new ArrayList<>();
        ListaCliente = new ArrayList<>();
        ListaVenda = new ArrayList<>();
        ListaPesquisa = new ArrayList<>();
        noCasoCarro = "Inicio";
        noCasoCliente = "Inicio";
        carro_controlar_Menu();
        cliente_controlar_Menu();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu_TabbedPane = new javax.swing.JTabbedPane();
        menu_Carro = new javax.swing.JPanel();
        subMenu_Carro = new javax.swing.JPanel();
        carro_cod_Field = new javax.swing.JTextField();
        carro_cod_Text = new javax.swing.JLabel();
        carro_modelo_Field = new javax.swing.JTextField();
        carro_modelo_Text = new javax.swing.JLabel();
        carro_marca_Field = new javax.swing.JTextField();
        carro_marca_Text = new javax.swing.JLabel();
        carro_ano_Field = new javax.swing.JTextField();
        carro_ano_Text = new javax.swing.JLabel();
        carro_ok_Button = new javax.swing.JButton();
        carro_cancelar_Button = new javax.swing.JButton();
        carro_adicionar_Button = new javax.swing.JButton();
        carro_editar_Button = new javax.swing.JButton();
        carro_excluir_Button = new javax.swing.JButton();
        carro_ScrollPane = new javax.swing.JScrollPane();
        carro_Tabela = new javax.swing.JTable();
        menu_Cliente = new javax.swing.JPanel();
        subMenu_Cliente = new javax.swing.JPanel();
        cliente_cpf_Text = new javax.swing.JLabel();
        cliente_nome_Field = new javax.swing.JTextField();
        cliente_nome_Text = new javax.swing.JLabel();
        cliente_email_Field = new javax.swing.JTextField();
        cliente_email_Text = new javax.swing.JLabel();
        cliente_telefone_Text = new javax.swing.JLabel();
        cliente_ok_Button = new javax.swing.JButton();
        cliente_cancelar_Button = new javax.swing.JButton();
        cliente_cpf_Field = new javax.swing.JFormattedTextField();
        cliente_telefone_Field = new javax.swing.JFormattedTextField();
        cliente_adicionar_Button = new javax.swing.JButton();
        cliente_editar_Button = new javax.swing.JButton();
        cliente_excluir_Button = new javax.swing.JButton();
        cliente_ScrollPane = new javax.swing.JScrollPane();
        cliente_Tabela = new javax.swing.JTable();
        menu_Venda = new javax.swing.JPanel();
        subMenu_Venda = new javax.swing.JPanel();
        venda_cliente_Text = new javax.swing.JLabel();
        venda_carro_Text = new javax.swing.JLabel();
        venda_preco_Text = new javax.swing.JLabel();
        venda_ok_Button = new javax.swing.JButton();
        venda_cancelar_Button = new javax.swing.JButton();
        venda_cliente_ComboBox = new javax.swing.JComboBox<>();
        venda_carro_ComboBox = new javax.swing.JComboBox<>();
        venda_preco_Field = new javax.swing.JTextField();
        venda_vender_Button = new javax.swing.JButton();
        venda_buscar_Button = new javax.swing.JButton();
        venda_ScrollPane = new javax.swing.JScrollPane();
        venda_Tabela = new javax.swing.JTable();
        venda_buscar_Field = new javax.swing.JTextField();
        menu_Barra = new javax.swing.JMenuBar();
        menu_Arquivo = new javax.swing.JMenu();
        menu_Abrir = new javax.swing.JMenuItem();
        menu_Salvar = new javax.swing.JMenuItem();
        menu_Sair = new javax.swing.JMenuItem();
        menu_Sobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Concessionária AP3");
        setMinimumSize(new java.awt.Dimension(620, 530));
        setName("ap3"); // NOI18N
        setPreferredSize(new java.awt.Dimension(650, 550));

        menu_TabbedPane.setMinimumSize(new java.awt.Dimension(77, 91));
        menu_TabbedPane.setPreferredSize(new java.awt.Dimension(473, 505));

        subMenu_Carro.setBorder(javax.swing.BorderFactory.createTitledBorder("Carro"));
        subMenu_Carro.setPreferredSize(new java.awt.Dimension(427, 193));

        carro_cod_Text.setText("Cód. do Veículo:");

        carro_modelo_Text.setText("Modelo:");

        carro_marca_Text.setText("Marca:");

        carro_ano_Text.setText("Ano:");

        carro_ok_Button.setText("OK");
        carro_ok_Button.addActionListener(evt -> buttons.carro_ok_ButtonActionPerformed(Main.this));

        carro_cancelar_Button.setText("Cancelar");
        carro_cancelar_Button.addActionListener(evt -> buttons.carro_cancelar_ButtonActionPerformed(Main.this));

        javax.swing.GroupLayout subMenu_CarroLayout = new javax.swing.GroupLayout(subMenu_Carro);
        subMenu_Carro.setLayout(subMenu_CarroLayout);
        subMenu_CarroLayout.setHorizontalGroup(
            subMenu_CarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenu_CarroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(subMenu_CarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(carro_modelo_Text)
                    .addComponent(carro_marca_Text)
                    .addComponent(carro_ano_Text)
                    .addComponent(carro_cod_Text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subMenu_CarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(carro_ano_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carro_cod_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carro_modelo_Field, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(carro_marca_Field))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(subMenu_CarroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(carro_ok_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carro_cancelar_Button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        subMenu_CarroLayout.setVerticalGroup(
            subMenu_CarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenu_CarroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subMenu_CarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carro_cod_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carro_cod_Text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subMenu_CarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carro_modelo_Text)
                    .addComponent(carro_modelo_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subMenu_CarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carro_marca_Text)
                    .addComponent(carro_marca_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(subMenu_CarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carro_ano_Text)
                    .addComponent(carro_ano_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subMenu_CarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carro_cancelar_Button)
                    .addComponent(carro_ok_Button))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        carro_adicionar_Button.setText("Adicionar Carro");
        carro_adicionar_Button.addActionListener(evt -> buttons.carro_adicionar_ButtonActionPerformed(Main.this));

        carro_editar_Button.setText("Editar");
        carro_editar_Button.addActionListener(evt -> buttons.carro_editar_ButtonActionPerformed(Main.this));

        carro_excluir_Button.setText("Excluir");
        carro_excluir_Button.addActionListener(evt -> buttons.carro_excluir_ButtonActionPerformed(Main.this));

        carro_Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Modelo", "Marca", "Ano", "Data"
            }
        ) {
            final Class<?>[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            final boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class<?> getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        carro_Tabela.setMinimumSize(new java.awt.Dimension(75, 80));
        carro_Tabela.setPreferredSize(new java.awt.Dimension(375, 80));
        carro_Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttons.carro_TabelaMouseClicked(Main.this);
            }
        });
        carro_ScrollPane.setViewportView(carro_Tabela);

        javax.swing.GroupLayout menu_CarroLayout = new javax.swing.GroupLayout(menu_Carro);
        menu_Carro.setLayout(menu_CarroLayout);
        menu_CarroLayout.setHorizontalGroup(
            menu_CarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_CarroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menu_CarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carro_ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addComponent(subMenu_Carro, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addGroup(menu_CarroLayout.createSequentialGroup()
                        .addComponent(carro_adicionar_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(carro_editar_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carro_excluir_Button)))
                .addContainerGap())
        );
        menu_CarroLayout.setVerticalGroup(
            menu_CarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_CarroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subMenu_Carro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(menu_CarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carro_adicionar_Button)
                    .addComponent(carro_excluir_Button)
                    .addComponent(carro_editar_Button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carro_ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu_TabbedPane.addTab("Carros", menu_Carro);

        subMenu_Cliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        subMenu_Cliente.setPreferredSize(new java.awt.Dimension(427, 193));

        cliente_cpf_Text.setText("CPF:");

        cliente_nome_Text.setText("Nome:");

        cliente_email_Text.setText("E-mail:");

        cliente_telefone_Text.setText("Telefone:");

        cliente_ok_Button.setText("OK");
        cliente_ok_Button.addActionListener(evt -> buttons.cliente_ok_ButtonActionPerformed(Main.this));

        cliente_cancelar_Button.setText("Cancelar");
        cliente_cancelar_Button.addActionListener(evt -> buttons.cliente_cancelar_ButtonActionPerformed(Main.this));

        try {
            cliente_cpf_Field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cliente_cpf_Field.setToolTipText("");

        try {
            cliente_telefone_Field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cliente_telefone_Field.setToolTipText("");

        javax.swing.GroupLayout subMenu_ClienteLayout = new javax.swing.GroupLayout(subMenu_Cliente);
        subMenu_Cliente.setLayout(subMenu_ClienteLayout);
        subMenu_ClienteLayout.setHorizontalGroup(
            subMenu_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenu_ClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(subMenu_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cliente_nome_Text)
                    .addComponent(cliente_email_Text)
                    .addComponent(cliente_telefone_Text)
                    .addComponent(cliente_cpf_Text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subMenu_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cliente_cpf_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cliente_telefone_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cliente_nome_Field, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(cliente_email_Field))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(subMenu_ClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cliente_ok_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cliente_cancelar_Button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        subMenu_ClienteLayout.setVerticalGroup(
            subMenu_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenu_ClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subMenu_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliente_cpf_Text)
                    .addComponent(cliente_cpf_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subMenu_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliente_nome_Text)
                    .addComponent(cliente_nome_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subMenu_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliente_email_Text)
                    .addComponent(cliente_email_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subMenu_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliente_telefone_Text)
                    .addComponent(cliente_telefone_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subMenu_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliente_cancelar_Button)
                    .addComponent(cliente_ok_Button))
                .addContainerGap())
        );

        cliente_adicionar_Button.setText("Adicionar Cliente");
        cliente_adicionar_Button.addActionListener(evt -> buttons.cliente_adicionar_ButtonActionPerformed(Main.this));

        cliente_editar_Button.setText("Editar");
        cliente_editar_Button.addActionListener(evt -> buttons.cliente_editar_ButtonActionPerformed(Main.this));

        cliente_excluir_Button.setText("Excluir");
        cliente_excluir_Button.addActionListener(evt -> buttons.cliente_excluir_ButtonActionPerformed(Main.this));

        cliente_Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "E-mail", "Telefone", "Data"
            }
        ) {
            final Class<?>[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            final boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class<?> getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cliente_Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttons.cliente_TabelaMouseClicked(Main.this);
            }
        });
        cliente_ScrollPane.setViewportView(cliente_Tabela);

        javax.swing.GroupLayout menu_ClienteLayout = new javax.swing.GroupLayout(menu_Cliente);
        menu_Cliente.setLayout(menu_ClienteLayout);
        menu_ClienteLayout.setHorizontalGroup(
            menu_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_ClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menu_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cliente_ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addComponent(subMenu_Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addGroup(menu_ClienteLayout.createSequentialGroup()
                        .addComponent(cliente_adicionar_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cliente_editar_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cliente_excluir_Button)))
                .addContainerGap())
        );
        menu_ClienteLayout.setVerticalGroup(
            menu_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_ClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subMenu_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(menu_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliente_adicionar_Button)
                    .addComponent(cliente_excluir_Button)
                    .addComponent(cliente_editar_Button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cliente_ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu_TabbedPane.addTab("Clientes", menu_Cliente);

        subMenu_Venda.setBorder(javax.swing.BorderFactory.createTitledBorder("Vender"));
        subMenu_Venda.setPreferredSize(new java.awt.Dimension(278, 162));

        venda_cliente_Text.setText("Cliente:");

        venda_carro_Text.setText("Carro:");

        venda_preco_Text.setText("Preço:");

        venda_ok_Button.setText("OK");
        venda_ok_Button.addActionListener(evt -> buttons.venda_ok_ButtonActionPerformed(Main.this));

        venda_cancelar_Button.setText("Cancelar");
        venda_cancelar_Button.addActionListener(evt -> buttons.venda_cancelar_ButtonActionPerformed(Main.this));

        javax.swing.GroupLayout subMenu_VendaLayout = new javax.swing.GroupLayout(subMenu_Venda);
        subMenu_Venda.setLayout(subMenu_VendaLayout);
        subMenu_VendaLayout.setHorizontalGroup(
            subMenu_VendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenu_VendaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(subMenu_VendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(venda_carro_Text)
                    .addComponent(venda_preco_Text)
                    .addComponent(venda_cliente_Text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subMenu_VendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(venda_carro_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(venda_cliente_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(venda_preco_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(subMenu_VendaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(venda_ok_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(venda_cancelar_Button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        subMenu_VendaLayout.setVerticalGroup(
            subMenu_VendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenu_VendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subMenu_VendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(venda_cliente_Text)
                    .addComponent(venda_cliente_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subMenu_VendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(venda_carro_Text)
                    .addComponent(venda_carro_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subMenu_VendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(venda_preco_Text)
                    .addComponent(venda_preco_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subMenu_VendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(venda_cancelar_Button)
                    .addComponent(venda_ok_Button))
                .addContainerGap())
        );

        venda_vender_Button.setText("Vender");
        venda_vender_Button.addActionListener(evt -> buttons.venda_vender_ButtonActionPerformed(Main.this));

        venda_buscar_Button.setText("Buscar Venda");
        venda_buscar_Button.addActionListener(evt -> buttons.venda_buscar_ButtonActionPerformed(Main.this));

        venda_Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Carro", "Preço", "Data"
            }
        ) {
            final Class<?>[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            final boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class<?> getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        venda_ScrollPane.setViewportView(venda_Tabela);

        javax.swing.GroupLayout menu_VendaLayout = new javax.swing.GroupLayout(menu_Venda);
        menu_Venda.setLayout(menu_VendaLayout);
        menu_VendaLayout.setHorizontalGroup(
            menu_VendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu_VendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menu_VendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(subMenu_Venda, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addComponent(venda_ScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, menu_VendaLayout.createSequentialGroup()
                        .addComponent(venda_vender_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(venda_buscar_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(venda_buscar_Button)))
                .addContainerGap())
        );
        menu_VendaLayout.setVerticalGroup(
            menu_VendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_VendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subMenu_Venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(menu_VendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(venda_vender_Button)
                    .addComponent(venda_buscar_Button)
                    .addComponent(venda_buscar_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(venda_ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu_TabbedPane.addTab("Vendas", menu_Venda);

        menu_Barra.setMaximumSize(new java.awt.Dimension(120, 32768));
        menu_Barra.setMinimumSize(new java.awt.Dimension(120, 26));
        menu_Barra.setPreferredSize(new java.awt.Dimension(120, 26));

        menu_Arquivo.setText("Arquivo");
        menu_Arquivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        menu_Abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_Abrir.setText("Abrir");
        menu_Abrir.addActionListener(evt -> buttons.menu_AbrirActionPerformed(Main.this));
        menu_Arquivo.add(menu_Abrir);

        menu_Salvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_Salvar.setText("Salvar");
        menu_Salvar.addActionListener(evt -> buttons.menu_SalvarActionPerformed(Main.this));
        menu_Arquivo.add(menu_Salvar);

        menu_Sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_Sair.setText("Sair");
        menu_Sair.addActionListener(evt -> buttons.menu_SairActionPerformed());
        menu_Arquivo.add(menu_Sair);

        menu_Barra.add(menu_Arquivo);

        menu_Sobre.setText("Sobre");
        menu_Sobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttons.menu_SobreMouseClicked();
            }
        });
        menu_Barra.add(menu_Sobre);

        setJMenuBar(menu_Barra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu_TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu_TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menu_TabbedPane.getAccessibleContext().setAccessibleName("AP3");

        getAccessibleContext().setAccessibleName("AP3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the FlatLaf Dark look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JScrollPane carro_ScrollPane;
    protected javax.swing.JTable carro_Tabela;
    protected javax.swing.JButton carro_adicionar_Button;
    protected javax.swing.JTextField carro_ano_Field;
    protected javax.swing.JLabel carro_ano_Text;
    protected javax.swing.JButton carro_cancelar_Button;
    protected javax.swing.JTextField carro_cod_Field;
    protected javax.swing.JLabel carro_cod_Text;
    protected javax.swing.JButton carro_editar_Button;
    protected javax.swing.JButton carro_excluir_Button;
    protected javax.swing.JTextField carro_marca_Field;
    protected javax.swing.JLabel carro_marca_Text;
    protected javax.swing.JTextField carro_modelo_Field;
    protected javax.swing.JLabel carro_modelo_Text;
    protected javax.swing.JButton carro_ok_Button;
    protected javax.swing.JScrollPane cliente_ScrollPane;
    protected javax.swing.JTable cliente_Tabela;
    protected javax.swing.JButton cliente_adicionar_Button;
    protected javax.swing.JButton cliente_cancelar_Button;
    protected javax.swing.JFormattedTextField cliente_cpf_Field;
    protected javax.swing.JLabel cliente_cpf_Text;
    protected javax.swing.JButton cliente_editar_Button;
    protected javax.swing.JTextField cliente_email_Field;
    protected javax.swing.JLabel cliente_email_Text;
    protected javax.swing.JButton cliente_excluir_Button;
    protected javax.swing.JTextField cliente_nome_Field;
    protected javax.swing.JLabel cliente_nome_Text;
    protected javax.swing.JButton cliente_ok_Button;
    protected javax.swing.JFormattedTextField cliente_telefone_Field;
    protected javax.swing.JLabel cliente_telefone_Text;
    protected javax.swing.JMenuItem menu_Abrir;
    protected javax.swing.JMenu menu_Arquivo;
    protected javax.swing.JMenuBar menu_Barra;
    protected javax.swing.JPanel menu_Carro;
    protected javax.swing.JPanel menu_Cliente;
    protected javax.swing.JMenuItem menu_Sair;
    protected javax.swing.JMenuItem menu_Salvar;
    protected javax.swing.JMenu menu_Sobre;
    protected javax.swing.JTabbedPane menu_TabbedPane;
    protected javax.swing.JPanel menu_Venda;
    protected javax.swing.JPanel subMenu_Carro;
    protected javax.swing.JPanel subMenu_Cliente;
    protected javax.swing.JPanel subMenu_Venda;
    protected javax.swing.JScrollPane venda_ScrollPane;
    protected javax.swing.JTable venda_Tabela;
    protected javax.swing.JButton venda_buscar_Button;
    protected javax.swing.JTextField venda_buscar_Field;
    protected javax.swing.JButton venda_cancelar_Button;
    protected javax.swing.JComboBox<String> venda_carro_ComboBox;
    protected javax.swing.JLabel venda_carro_Text;
    protected javax.swing.JComboBox<String> venda_cliente_ComboBox;
    protected javax.swing.JLabel venda_cliente_Text;
    protected javax.swing.JButton venda_ok_Button;
    protected javax.swing.JTextField venda_preco_Field;
    protected javax.swing.JLabel venda_preco_Text;
    protected javax.swing.JButton venda_vender_Button;
    // End of variables declaration//GEN-END:variables
}
