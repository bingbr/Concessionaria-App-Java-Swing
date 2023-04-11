package edu.uni.ap3;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author William S.
 */
public class Data {
    protected static int novoId(List<Venda> ListaVenda) {
        return ListaVenda.stream().mapToInt(Venda::getId).max().orElse(0) + 1;
    }

    protected static long stringPraLong(String txt) {
        return Long.parseLong(txt.replaceAll("[^\\d]", ""));
    }

    protected static String saveData(Date data) {
        SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return formataData.format(data);
    }

    protected static Date loadData(String data) throws ParseException {
        SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return formataData.parse(data);
    }

    protected static String fixDataString(String data) {
        while (data.length() < 11)
            data = "0" + data;
        return data;
    }

    private void setTamanhoColunas(JTable tabela, int[] coluna, int[] min, int[] max) {
        for (int i = 0; i < coluna.length; i++) {
            tabela.getColumnModel().getColumn(coluna[i]).setMinWidth(min[i]);
            tabela.getColumnModel().getColumn(coluna[i]).setMaxWidth(max[i]);
        }
    }

    protected <T> void carregarTabela(List<T> lista, JTable tabela, Object[] colunaNome, Function<T, Object[]> objeto, int[] coluna, int[] min, int[] max) {
        DefaultTableModel modelo = new DefaultTableModel(colunaNome, 0);
        for (T item : lista)
            modelo.addRow(objeto.apply(item));
        tabela.setModel(modelo);
        setTamanhoColunas(tabela, coluna, min, max);
    }
}
