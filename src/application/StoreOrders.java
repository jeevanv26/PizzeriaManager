package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class StoreOrders {

    private ArrayList<Order> orders;

    public StoreOrders(ArrayList<Order>  orders) {
        this.orders = orders;
    }

    
    public  void export() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open a Target File to Export");
        chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"), new ExtensionFilter("All Files", "*,*"));
        Stage stage = new Stage();
        File targetFile  = chooser.showSaveDialog(stage);            
        FileWriter writer;
        if(targetFile!=null) {
            try {
                writer = new FileWriter(targetFile);
                for(int x = 0; x < orders.size(); x++) {
                    	int y = x + 1;
                        writer.write("Order " + y +":" + System.lineSeparator()+ orders.get(x).toString() + System.lineSeparator());
                 }
                writer.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            } 
        }
  }
}
