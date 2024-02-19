package g54720.sortingrace.view;

import g54720.sortingrace.controller.Facade;
import g54720.sortingrace.model.SizeSort;
import g54720.sortingrace.model.Sort;
import g54720.sortingrace.model.Type;
import g54720.sortingrace.util.Observer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.lang.Object;

public class FxmlController implements Initializable, Observer {

    @FXML
    private ChoiceBox sortChoice;

    @FXML
    private ChoiceBox configurationChoice;

    @FXML
    private Button start;

    @FXML
    private Spinner threadSpinner;

    @FXML
    private Label rightStatus;

    @FXML
    private Label leftStatus;

    @FXML
    private TableView table;

    @FXML
    private TableColumn<Sort, String> nameCol;

    @FXML
    private TableColumn<Sort, Integer> sizeCol;

    @FXML
    private TableColumn<Sort, Integer> swapCol;

    @FXML
    private TableColumn<Sort, Double> durationCol;

    @FXML
    private LineChart chart;

    @FXML
    private ProgressBar progressBar;
    
    private Facade facade;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        facade = new Facade();
        SpinnerValueFactory<Integer> spinInit = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        threadSpinner.setValueFactory(spinInit);
        sortChoice.getItems().addAll("Tri à bulles", "Tri fusion");
        sortChoice.getSelectionModel().selectFirst();

        configurationChoice.getItems().addAll(SizeSort.VERY_EASY,SizeSort.EASY,
                SizeSort.MEDIUM, SizeSort.HARD,SizeSort.VERY_HARD);
        configurationChoice.getSelectionModel().selectFirst();

        table.getColumns().setAll(nameCol, sizeCol, swapCol, durationCol);

        nameCol.setCellValueFactory(new PropertyValueFactory<>("nameTri"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        swapCol.setCellValueFactory(new PropertyValueFactory<>("operations"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));

        facade.registerObserver(this);
    }

    @FXML
    private void beginGo(ActionEvent event) {
        Type nameTri;
        if (sortChoice.getValue() == "Tri à bulles") { //enum
            nameTri = Type.BUBBLE;
        } else {
            nameTri = Type.MERGE;
        }
        progressBar.setProgress(0.0);

        XYChart.Series serie = new XYChart.Series<>();

        serie.setName(nameTri.toString());

        chart.getData().add(serie);
        SizeSort st=(SizeSort) configurationChoice.getValue();
        facade.start((SizeSort)configurationChoice.getValue(), nameTri, (int) threadSpinner.getValue());
        leftStatus.setText("Thread actif :"+Thread.activeCount());
    }

    @Override
    public void update(Object object) {
        String debut="Dernière exécution | Début :  "+LocalTime.now().withNano(0).toString();
        Sort srt= (Sort) object;
        Platform.runLater(() -> {
            table.getItems().add(srt);
            progressBar.setProgress(progressBar.getProgress()+0.1);

            leftStatus.setText("Thread actif :"+Thread.activeCount());
            if(srt!= null){
                XYChart.Series ser = (XYChart.Series) chart.getData().get(chart.getData().size()-1);
                ser.getData().add(new XYChart.Data(srt.getSize(),srt.getOperations()));

            }
            rightStatus.setText(debut+"| Fin : "+LocalTime.now().withNano(0).toString());
        });
    }
}
















