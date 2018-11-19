package Controller;

import Model.DataBase.DBC;
import Model.Passenger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller {

    //<editor-fold defaultstate="collapsed", desc="FXML">
    @FXML
    Pane dataPane;
    @FXML
    Pane errorPane;

    @FXML
    TextField idInput;

    @FXML
    Label idLab;
    @FXML
    Label survLab;
    @FXML
    Label classLab;
    @FXML
    Label nameLab;
    @FXML
    Label sexLab;
    @FXML
    Label ageLab;
    @FXML
    Label siSpLab;
    @FXML
    Label paChLab;
    @FXML
    Label ticketLab;
    @FXML
    Label fareLab;
    @FXML
    Label cabinLab;
    @FXML
    Label embLab;
    //</editor-fold>

    private DBC db = Main.getDB();

    @FXML
    private void showPassFromId(){
        try{
            int id = Integer.parseInt(idInput.getText());
            Passenger passenger = db.getPassengerById(id);

            idLab.setText(""+passenger.getId());
            survLab.setText(""+passenger.getisAlive());
            classLab.setText(""+passenger.getPclass());
            nameLab.setText(""+passenger.getName());
            sexLab.setText(""+passenger.getSex());
            ageLab.setText(""+passenger.getAge());
            siSpLab.setText(""+passenger.getSibOrSpNum());
            paChLab.setText(""+passenger.getParOrChNum());
            ticketLab.setText(""+passenger.getTicket());
            fareLab.setText(""+passenger.getFare() );
            cabinLab.setText(""+passenger.getCabin());
            embLab.setText(""+passenger.getEmbarkLoc());

        } catch (Exception e){
            errorPane.setVisible(true);
            dataPane.setOpacity(0.3);
            dataPane.setDisable(true);
        }
    }

    @FXML
    private void pressErrorButton(){
        dataPane.setOpacity(1);
        dataPane.setDisable(false);
        errorPane.setVisible(false);
    }

}
