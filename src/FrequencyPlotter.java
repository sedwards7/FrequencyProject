import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Random;



public class FrequencyPlotter extends Application {

    public void start (Stage primaryStage){
        int [] bin = new int[30];

        EventHandler click100 = new EventHandler() {
            @Override
            public void handle(Event event) {
                for (int i = 0; i < bin.length; i++) {
                    bin[i] = getAndBin(100)[i];
                }
            }
        };
        Button num100 = new Button("100 nums");
        num100.setPrefSize(100,30);
        num100.setOnAction( click100);

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: beige;");
        pane.setPrefSize(600,600);
        pane.getChildren().addAll(num100);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static int[] getAndBin (int numOfNums){
        double[] randNums = new double[numOfNums];
        Random ran = new Random();

        int[] bin = new int[30];
        int index;

        for (int i = 0; i < randNums.length; i++){
            randNums[i] = ran.nextGaussian();
            if(randNums[i] > -3 && randNums[i] < 3) {
                index = (int) ((randNums[i] + 3) * 5);
                bin[index]++;
            }
        }
        return bin;
    }
}
