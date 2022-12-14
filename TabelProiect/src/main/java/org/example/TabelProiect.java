import javax.swing.*;
import java.awt.*;

class TabelProiect {

    private static final String[] COLUMN_NAMES = {"Nume",
            "Prenume",
            "Specializare",
            "An de studii",
            "Buget"};

    private static final Object[][] DATA = {
            {"Bura", "Casian", "Calculatoare", 1, false},
            {"Vasadi", "Caleb", "Inginerie Mecanica", 3, true},
            {"Eghedi", "Fabian", "Chimie", 2, false},
            {"Olariu", "Stefan", "Litere", 1, true},
            {"Buda", "Alex", "Medicina Generala", 5, false}
    };


    public static void main(String[] args) {

        JFrame container = new JFrame("Table");
        JTable table = new JTable(DATA, COLUMN_NAMES);
        table.setGridColor(Color.magenta);
        table.setBackground(Color.GRAY);


        ListSelectionListenerImpl listSelectionListener = new ListSelectionListenerImpl(table);

        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        select.addListSelectionListener(listSelectionListener);

        JScrollPane scrollPane = new JScrollPane(table);

        container.add(scrollPane);
        container.setLayout(new BorderLayout());
        container.add(table.getTableHeader(), BorderLayout.PAGE_START);
        container.add(table, BorderLayout.CENTER);
        container.setVisible(true);
        container.setSize(400, 600);
    }

}