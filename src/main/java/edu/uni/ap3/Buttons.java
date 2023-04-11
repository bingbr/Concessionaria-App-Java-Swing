package edu.uni.ap3;

import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Component;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.text.ParseException;
import java.nio.file.Files;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *
 * @author William S.
 */
public class Buttons extends Component {
    /* --- Menu --- */
    protected void menu_AbrirActionPerformed(Main main) {
        try {
            JFileChooser abrir = new JFileChooser();
            abrir.setDialogTitle("Procurar arquivo:");
            abrir.setFileFilter(new FileNameExtensionFilter("Dados Salvos (*.json)", "json"));
            int abriu = abrir.showOpenDialog(this);
            if (abriu == JFileChooser.APPROVE_OPTION) {
                String jsonString = new String(Files.readAllBytes(Paths.get("" + abrir.getSelectedFile())));
                JSONObject json = new JSONObject(jsonString);
                JSONArray carros = json.getJSONArray("ListaCarro");
                for (int i = 0; i < carros.length(); i++) {
                    JSONObject carro = carros.getJSONObject(i);
                    Carro novoCarro = new Carro(carro.getInt("cod"), carro.getString("modelo"), carro.getString("marca"), carro.getInt("ano"), Data.loadData(carro.getString("iso8601")));
                    main.ListaCarro.add(novoCarro);
                }
                JSONArray clientes = json.getJSONArray("ListaCliente");
                for (int i = 0; i < clientes.length(); i++) {
                    JSONObject cliente = clientes.getJSONObject(i);
                    Cliente novoCliente = new Cliente(cliente.getLong("cpf"), cliente.getString("nome"), cliente.getString("email"), cliente.getLong("telefone"), Data.loadData(cliente.getString("iso8601")));
                    main.ListaCliente.add(novoCliente);
                }
                JSONArray vendas = json.getJSONArray("ListaVenda");
                for (int i = 0; i < vendas.length(); i++) {
                    JSONObject venda = vendas.getJSONObject(i);
                    Venda novaVenda = new Venda(venda.getInt("id"), venda.getString("carro"), venda.getString("cliente"), venda.getDouble("preco"), Data.loadData(venda.getString("iso8601")));
                    main.ListaVenda.add(novaVenda);
                }
                main.CarregarTabelaCarro();
                main.CarregarTabelaCliente();
                main.CarregarTabelaVenda(main.ListaVenda);
                JOptionPane.showMessageDialog(null, "Os dados carregados com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                throw new IOException("Você precisa escolher um arquivo válido.");
            }
        } catch (RuntimeException | IOException | ParseException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getSimpleName().equalsIgnoreCase("IOException")  ? e.getMessage() : "Ocorreu um erro de " + e.getClass().getSimpleName() + ".", "ERRO:", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void menu_SalvarActionPerformed(Main main) {
        try {
            JFileChooser salvar = new JFileChooser();
            salvar.setDialogTitle("Salvar Arquivo:");
            salvar.setFileFilter(new FileNameExtensionFilter("Dados Salvos (*.json)", "json"));
            int escolha = salvar.showSaveDialog(this);
            if (escolha == JFileChooser.APPROVE_OPTION) {
                try (FileWriter save = new FileWriter(salvar.getSelectedFile() + ".json")) {
                JSONObject obj = new JSONObject();
                
                JSONArray listaCarro = new JSONArray();
                for (Carro dado : main.ListaCarro) {
                    JSONObject carro = new JSONObject();
                    carro.put("cod", dado.getCod());
                    carro.put("modelo", dado.getModelo());
                    carro.put("marca", dado.getMarca());
                    carro.put("ano", dado.getAno());
                    carro.put("iso8601", Data.saveData(dado.getData()));
                    listaCarro.put(carro);
                }
                obj.put("ListaCarro", listaCarro);
                
                JSONArray listaCliente = new JSONArray();
                for (Cliente dado : main.ListaCliente) {
                    JSONObject cliente = new JSONObject();
                    cliente.put("cpf", dado.getCpf());
                    cliente.put("nome", dado.toString());
                    cliente.put("email", dado.getEmail());
                    cliente.put("telefone", dado.getTelefone());
                    cliente.put("iso8601", Data.saveData(dado.getData()));
                    listaCliente.put(cliente);
                }
                obj.put("ListaCliente", listaCliente);

                JSONArray listaVenda = new JSONArray();
                for (Venda dado : main.ListaVenda) {
                    JSONObject venda = new JSONObject();
                    venda.put("id", dado.getId());
                    venda.put("cliente", dado.getCliente());
                    venda.put("carro", dado.getCarro());
                    venda.put("preco", dado.getPreco());
                    venda.put("iso8601", Data.saveData(dado.getData()));
                    listaVenda.put(venda);
                }
                obj.put("ListaVenda", listaVenda);

                save.write(obj.toString(4));
                }
            } else {
                throw new IOException("Algo deu errado.\nVerifique os dados e tente novamente.");
            }
            JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso.", "Dados Salvos", JOptionPane.INFORMATION_MESSAGE);
        } catch (RuntimeException | IOException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getSimpleName().equalsIgnoreCase("IOException")  ? e.getMessage() : "Ocorreu um erro de " + e.getClass().getSimpleName() + ".", "ERRO:", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void menu_SairActionPerformed() {
        System.exit(0);
    }

    protected void menu_SobreMouseClicked() {
        JOptionPane.showMessageDialog(null, "Programa para avaliação da faculdade.\nDesigned by William in NetBeans", "Sobre", JOptionPane.INFORMATION_MESSAGE);
    }

    /* --- Carro --- */
    protected void carro_adicionar_ButtonActionPerformed(Main main) {
        main.noCasoCarro = "Novo";
        main.carro_text_Field("");
        main.carro_controlar_Menu();
    }

    protected void carro_editar_ButtonActionPerformed(Main main) {
        main.noCasoCarro = "Editar";
        main.carro_controlar_Menu();
    }

    protected void carro_excluir_ButtonActionPerformed(Main main) {
        int in = main.carro_Tabela.getSelectedRow();
        if (in >= 0 && in < main.ListaCarro.size()) {
            main.ListaCarro.remove(in);
            main.CarregarTabelaCarro();
            main.noCasoCarro = "Inicio";
            main.carro_controlar_Menu();
            main.carro_text_Field("");
        }
    }

    protected void carro_ok_ButtonActionPerformed(Main main) {
        try {
            Carro carro;
            int cod = Integer.parseInt(main.carro_cod_Field.getText());
            String modelo = main.carro_modelo_Field.getText();
            String marca = main.carro_marca_Field.getText();
            int ano = Integer.parseInt(main.carro_ano_Field.getText());

            if (main.noCasoCarro.equals("Novo")) {
                boolean codExists = main.ListaCarro.stream().anyMatch(c -> c.getCod() == cod);
                if (codExists) {
                    JOptionPane.showMessageDialog(null, "O código do carro já existe.", "Ops, ocorreu um erro!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                carro = new Carro(cod, modelo, marca, ano, new Date());
                main.ListaCarro.add(carro);
            } else {
                int in = main.carro_Tabela.getSelectedRow();
                carro = main.ListaCarro.get(in);
                carro.setCod(cod);
                carro.setModelo(modelo);
                carro.setMarca(marca);
                carro.setAno(ano);
            }
            main.CarregarTabelaCarro();
            main.noCasoCarro = "Inicio";
            main.carro_controlar_Menu();
            main.carro_text_Field("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Você deixou de preencher algum campo.", "Ops, ocorreu um erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void carro_cancelar_ButtonActionPerformed(Main main) {
        main.noCasoCarro = "Inicio";
        main.carro_controlar_Menu();
        main.carro_text_Field("");
    }

    protected void carro_TabelaMouseClicked(Main main) {
        int in = main.carro_Tabela.getSelectedRow();
        if (in >= 0 && in < main.ListaCarro.size()) {
            Carro novoCarro = main.ListaCarro.get(in);
            main.carro_cod_Field.setText(String.valueOf(novoCarro.getCod()));
            main.carro_modelo_Field.setText(novoCarro.getModelo());
            main.carro_marca_Field.setText(novoCarro.getMarca());
            main.carro_ano_Field.setText(String.valueOf(novoCarro.getAno()));
            main.carro_Button_Menu(true, true, false);
        }
    }

    /* --- Cliente --- */
    protected void cliente_adicionar_ButtonActionPerformed(Main main) {
        main.noCasoCliente = "Novo";
        main.cliente_controlar_Menu();
        main.cliente_text_Field("");
    }

    protected void cliente_editar_ButtonActionPerformed(Main main) {
        main.noCasoCliente = "Editar";
        main.cliente_controlar_Menu();
    }

    protected void cliente_excluir_ButtonActionPerformed(Main main) {
        int in = main.cliente_Tabela.getSelectedRow();
        if (in >= 0 && in < main.ListaCliente.size()) {
            main.ListaCliente.remove(in);
            main.CarregarTabelaCliente();
            main.noCasoCliente = "Inicio";
            main.cliente_controlar_Menu();
            main.cliente_text_Field("");
        }
    }

    protected void cliente_ok_ButtonActionPerformed(Main main) {
        try {
            String cpf = main.cliente_cpf_Field.getText();
            String nome = main.cliente_nome_Field.getText();
            String email = main.cliente_email_Field.getText();
            String telefone = main.cliente_telefone_Field.getText();
            if (main.noCasoCliente.equals("Novo")) {
                if (cpf.contains("   .   .   -  ") || nome.isEmpty() || email.isEmpty() || telefone.contains("(  )     -    ")) {
                    throw new Exception("Você deixou de preencher um campo.");
                } else {
                    if (telefone.startsWith("(0")) {
                        throw new Exception("DDD do telefone não pode começar com 0.");
                    } else {
                        boolean cpfExists = main.ListaCliente.stream().anyMatch(cliente -> cliente.getCpfFormatado().equals(cpf));
                        if (cpfExists) {
                            throw new Exception("CPF já existe na lista de clientes.");
                        } else {
                            Cliente novoCliente = new Cliente(Data.stringPraLong(cpf), nome, email, Data.stringPraLong(telefone), new Date());
                            main.ListaCliente.add(novoCliente);
                        }
                    }
                }
            } else {
                int in = main.cliente_Tabela.getSelectedRow();
                main.ListaCliente.get(in).setCpf(Data.stringPraLong(cpf));
                main.ListaCliente.get(in).setNome(nome);
                main.ListaCliente.get(in).setEmail(email);
                main.ListaCliente.get(in).setTelefone(Data.stringPraLong(telefone));
            }
            main.CarregarTabelaCliente();
            main.noCasoCliente = "Inicio";
            main.cliente_controlar_Menu();
            main.cliente_text_Field("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ops, ocorreu um erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void cliente_cancelar_ButtonActionPerformed(Main main) {
        main.noCasoCliente = "Inicio";
        main.cliente_controlar_Menu();
        main.cliente_text_Field("");
    }

    protected void cliente_TabelaMouseClicked(Main main) {
        int in = main.cliente_Tabela.getSelectedRow();
        if (in >= 0 && in < main.ListaCliente.size()) {
            Cliente novoCliente = main.ListaCliente.get(in);
            main.cliente_cpf_Field.setText(novoCliente.getCpfFormatado());
            main.cliente_nome_Field.setText(novoCliente.toString());
            main.cliente_email_Field.setText(novoCliente.getEmail());
            main.cliente_telefone_Field.setText(novoCliente.getTelefoneFormatado());
            main.cliente_Button_Menu(true, true, false);
        }
    }

    /* --- Venda --- */
    protected void venda_vender_ButtonActionPerformed(Main main) {
        main.venda_carro_ComboBox.removeAllItems();
        main.venda_cliente_ComboBox.removeAllItems();
        for (Carro carro : main.ListaCarro) {
            String modeloBox = carro.toString();
            main.venda_carro_ComboBox.addItem(modeloBox);
        }
        for (Cliente cliente : main.ListaCliente) {
            String nomeBox = cliente.toString();
            main.venda_cliente_ComboBox.addItem(nomeBox);
        }
        main.venda_Button_Menu(false, true);
        main.venda_preco_Field.setText("");
    }

    protected void venda_buscar_ButtonActionPerformed(Main main) {
        try {
            String entrada = main.venda_buscar_Field.getText().toLowerCase();
            main.ListaPesquisa.clear();
            if (!entrada.isEmpty()) {
                for (Venda venda : main.ListaVenda) {
                    String modelo = venda.getCarro().toLowerCase();
                    String nome = venda.getCliente().toLowerCase();
                    boolean encontrouModelo = true;
                    boolean encontrouNome = true;
                    for (char c : entrada.toCharArray()) {
                        if (!modelo.contains(String.valueOf(c))) {
                            encontrouModelo = false;
                        }
                        if (!nome.contains(String.valueOf(c))) {
                            encontrouNome = false;
                        }
                        if (!encontrouModelo && !encontrouNome) {
                            break;
                        }
                    }
                    if (encontrouModelo || encontrouNome) {
                        Venda resultado = new Venda(venda.getId(), venda.getCarro(), venda.getCliente(), venda.getPreco(), venda.getData());
                        main.ListaPesquisa.add(resultado);
                    }
                }
                if (main.ListaPesquisa.size() > 0) {
                    main.venda_Tabela.removeAll();
                    main.CarregarTabelaVenda(main.ListaPesquisa);
                } else {
                    main.CarregarTabelaVenda(main.ListaVenda);
                    throw new NoSuchElementException(main.venda_buscar_Field.getText() + " não foi encontrado.");
                }
                main.venda_buscar_Field.setText("");
            } else {
                main.CarregarTabelaVenda(main.ListaVenda);
                throw new NullPointerException(main.venda_buscar_Field.getText() + "Você precisa digitar algo antes de pesquisar.");
            }
        } catch (NullPointerException | NoSuchElementException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ops, ocorreu um erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void venda_ok_ButtonActionPerformed(Main main) {
        try {
            String precoText = main.venda_preco_Field.getText().replace(",", ".");
            if (precoText.isEmpty() || !precoText.matches("\\d+(\\.\\d{1,2})?")) {
                throw new IllegalArgumentException("Preco inválido.");
            }
            Double preco = Double.parseDouble(precoText);
            Venda novaVenda = new Venda(Data.novoId(main.ListaVenda), Objects.requireNonNull(main.venda_carro_ComboBox.getSelectedItem()).toString(), Objects.requireNonNull(main.venda_cliente_ComboBox.getSelectedItem()).toString(), preco, new Date());
    
            main.ListaVenda.add(novaVenda);
            main.CarregarTabelaVenda(main.ListaVenda);
            main.venda_Button_Menu(true, false);
            main.venda_carro_ComboBox.removeAllItems();
            main.venda_cliente_ComboBox.removeAllItems();
            main.venda_preco_Field.setText("");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ops, ocorreu um erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void venda_cancelar_ButtonActionPerformed(Main main) {
        main.venda_Button_Menu(true, false);
        main.venda_carro_ComboBox.removeAllItems();
        main.venda_cliente_ComboBox.removeAllItems();
        main.venda_preco_Field.setText("");
    }
}
