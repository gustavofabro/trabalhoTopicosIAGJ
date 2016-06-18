package listener;

import util.LogEvents;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.DataCompraJIF;

public class DataCompraListener implements ActionListener {
    private LogEvents logEvents = new LogEvents();

    private DataCompraJIF dataCompra;

    public DataCompraListener(DataCompraJIF dataCompra) {
        this.dataCompra = dataCompra;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "campoData":
                dataCompra.procurarDataCompra();
                break;

            case "copiarDataCompra":
                break;

            case "cancelarDataCompra":
                dataCompra.setVisible(false);
                dataCompra.apagarCampos();
                break;
        }
    }
}
