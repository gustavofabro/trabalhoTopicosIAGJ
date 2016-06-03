package listener;

import bean.LogEvents;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.AreaTransferencia;
import view.DataCompraJIF;

public class DataCompraListener implements ActionListener {
    private LogEvents logEvents = new LogEvents();

    private DataCompraJIF dataCompra;
    private AreaTransferencia clipboard;

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
                if (!dataCompra.getCompra().isEmpty()) {
                    clipboard.copy(dataCompra.getCompra());
                }
                break;

            case "cancelarDataCompra":
                dataCompra.setVisible(false);
                dataCompra.apagarCampos();
                break;
        }
    }
}
