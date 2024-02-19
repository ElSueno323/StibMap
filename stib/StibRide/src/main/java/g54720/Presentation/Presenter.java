package g54720.Presentation;

import g54720.Model.DataBase.FavorisDto;
import g54720.Model.DataBase.StationsDto;
import g54720.Model.Model;
import g54720.Model.Modelisation.Node;
import g54720.View.ControllerView;
import g54720.utils.Observable;
import g54720.utils.Observer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class Presenter implements Observer {

    private ControllerView controllerView;
    private Model model;
    public Presenter(Model model,ControllerView controllerView){
        this.controllerView=controllerView;
        this.model=model;
    }

    public void initialize()throws Exception{
        controllerView.setSearch(model.getAllStations());
        controllerView.setTableFavoris(model.getAllFavoris());
        controllerView.addHandlerButton(this);
    }
    public void search(){
        model.searchShortPath(controllerView.giveSearch());
    }

    public void addFavoris(){
        Node [] inOut= controllerView.getSearch();
        model.addFavoris(inOut);
    }

    public void useFavoris(){
        try{
            StationsDto [] inOut={model.getStation(controllerView.getFavoris().getId_origin()),
                    model.getStation(controllerView.getFavoris().getId_destination())};
            model.searchShortPath(inOut);
        }catch (Exception e){

        }
    }

    public void deleteFavoris(){
        try{
            model.removeFavoris(controllerView.getFavoris());
        }catch (Exception e){

        }
    }

    @Override
    public void update(Observable observable, Object object) {
        Model save=(Model) observable;

        if(object!=null){
            List<Node> nodes=(List<Node>) object;

            controllerView.searchTable(nodes);
        }
        try{
            controllerView.setSearch(model.getAllStations());
            controllerView.setTableFavoris(model.getAllFavoris());
        }catch (Exception exception){

        }
    }
}
