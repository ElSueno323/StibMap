package g54720.View;

import g54720.Model.DataBase.FavorisDto;
import g54720.Model.DataBase.StationsDto;
import g54720.Model.Modelisation.Node;
import g54720.Presentation.Presenter;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.controlsfx.control.SearchableComboBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerView implements Initializable{


    @FXML
    private Button buttonFavorisUse;
    @FXML
    private Button buttonFavorisRemove;
    @FXML
    private Button buttonFavorisAdd;
    @FXML
    private  TableView<FavorisDto> tableFavoris;
    @FXML
    private  TableColumn<FavorisDto,String> columnFavorisOrigin;
    @FXML
    private  TableColumn<FavorisDto,String> columnFavorisDestination;
    @FXML
    private ImageView buttonFavoris;
    @FXML
    private Label textFavoris;
    @FXML
    private VBox vboxFavoris;
    @FXML
    private VBox vboxSearch;
    @FXML
    private Label textResultat;
    @FXML
    private VBox vboxResultat;
    @FXML
    private Button buttonSearch;

    @FXML
    private TableView<Node> tableSearch;
    @FXML
    private TableColumn<Node, List<Integer>> columnLigne;

    @FXML
    private TableColumn<Node, String> columnStation;

    @FXML
    private SearchableComboBox<StationsDto> searchDestination;

    @FXML
    private SearchableComboBox<StationsDto> searchOrigin;


    @FXML
    private Label textDestination;

    @FXML
    private Label textOrigin;

    @FXML
    private Label textSearch;

    @FXML
    private Label textStationsNumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnLigne.setCellValueFactory(new PropertyValueFactory<>("lignes"));
        columnStation.setCellValueFactory(new PropertyValueFactory<>("name"));


        columnFavorisOrigin.setCellValueFactory(new PropertyValueFactory<>("text_origin"));
        columnFavorisDestination.setCellValueFactory(new PropertyValueFactory<>("text_destination"));
    }

    public void setSearch(List<StationsDto> stations){
        Callback<ListView<StationsDto>,ListCell<StationsDto>> cellFactory;
        cellFactory=new Callback<ListView<StationsDto>, ListCell<StationsDto>>() {
            @Override
            public ListCell<StationsDto> call(ListView<StationsDto> stationsDtoListView) {
                return new ListCell<StationsDto>(){
                    @Override
                    protected void updateItem(StationsDto item , boolean empty){
                        super.updateItem(item, empty);
                        if(item==null||empty){
                            setGraphic(null);
                        }else{
                            setText(item.getText());
                        }
                    }
                };
            }
        };

        searchOrigin.setItems(FXCollections.observableList(stations));
        searchDestination.setItems(FXCollections.observableList(stations));

        searchOrigin.setCellFactory(cellFactory);
        searchDestination.setCellFactory(cellFactory);

        searchOrigin.setButtonCell(cellFactory.call(null));
        searchDestination.setButtonCell(cellFactory.call(null));
    }

    public void setTableFavoris(List<FavorisDto> favorisDtos){
        tableFavoris.getItems().clear();
        for(FavorisDto favorisDto :favorisDtos){
            tableFavoris.getItems().add(favorisDto);
        }
    }

    public StationsDto[] giveSearch(){
        StationsDto inOut[]={searchOrigin.getValue(),searchDestination.getValue()};
        return inOut;
    }
    public void addHandlerButton(Presenter presenter){
        ButtonHandler searchHandler=new ButtonHandler(presenter,Action.Search);
        ButtonHandler favorisAddHandler=new ButtonHandler(presenter,Action.Add);
        ButtonHandler favorisDeleteHandler=new ButtonHandler(presenter,Action.Delete);
        ButtonHandler favorisUseHandler=new ButtonHandler(presenter,Action.Use);

        buttonFavorisRemove.setOnAction(favorisDeleteHandler);
        buttonFavorisAdd.setOnAction(favorisAddHandler);
        buttonFavorisUse.setOnAction(favorisUseHandler);
        buttonSearch.setOnAction(searchHandler);

    }

    public FavorisDto getFavoris(){

        return tableFavoris.getSelectionModel().getSelectedItem();
    }
    public Node[] getSearch(){
        Node inOut[]={tableSearch.getItems().get(0),tableSearch.getItems().get(tableSearch.getItems().size()-1)};
        return inOut;
    }
    public void searchTable(List<Node> nodes){
        tableSearch.getItems().clear();
        for(Node node : nodes){
            tableSearch.getItems().add(node);
        }
        textStationsNumber.setText("Nombres de Stations :"+nodes.size());
        textSearch.setText("Recherche : Terminé");
    }
}
