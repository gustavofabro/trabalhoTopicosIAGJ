package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.dao.VendaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.grc.view.DataCompraJIF;

public class DataCompraListener implements ActionListener {

    private DataCompraJIF dataCompra;
    private VendaDao dao = new VendaDao();

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
        }
    }
}
