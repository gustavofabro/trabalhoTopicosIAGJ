package listener;

import dao.VendaDao;
import util.LogEvents;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.DataCompraJIF;

public class DataCompraListener implements ActionListener {

    private LogEvents logEvents = new LogEvents();
    private VendaDao dao = new VendaDao();
    private DataCompraJIF dataCompra;

    public DataCompraListener(DataCompraJIF dataCompra) {
        this.dataCompra = dataCompra;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "procurarDataCompra":
                
                dataCompra.setListaDataCompras(
                    dao.getVendaInDate(dataCompra.getDataInicial(),
                               dataCompra.getDataFinal())
                );

            case "campoData":
                dataCompra.procurarDataCompra();
                break;

            case "copiarDataCompra":
                if (!dataCompra.getCompra().isEmpty()) {
                }
                break;

            case "cancelarDataCompra":
                dataCompra.setVisible(false);
                dataCompra.apagarCampos();
                break;
        }
    }
}
