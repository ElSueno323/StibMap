package g54720.Model;

import g54720.Model.DataBase.*;
import g54720.Model.Modelisation.Dijkstra;
import g54720.Model.Modelisation.Graph;
import g54720.Model.Modelisation.Node;
import g54720.config.ConfigManager;
import g54720.utils.Observable;
import g54720.utils.Observer;
import g54720.utils.RepositoryException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Model extends Observable {

    private StationsRepository stationsRepository;
    private StopsRepository stopsRepository;
    private LineRepository lineRepository;

    private FavorisRepository favorisRepository;

    private Graph reseauStib=new Graph();

    public Model() throws Exception{
            ConfigManager.getInstance().load();
            String dbUrl=ConfigManager.getInstance().getProperties("db.url");

            stationsRepository=new StationsRepository();

            stopsRepository=new StopsRepository();

            lineRepository=new LineRepository();

            favorisRepository=new FavorisRepository();

            int ordre=1;
            Node precedent=null;
            for(StopsDto stop:stopsRepository.getAll()){
                Node temp=new Node(stationsRepository.get(stop.getId_station()).getText(),stop.getId_station(),stop.getId_line());
                if(reseauStib.getTheNode(temp.getStation())!=null){
                    reseauStib.getTheNode(temp.getStation()).addLigne(stop.getId_line());
                }else{
                    reseauStib.addNode(temp);
                }
                if(ordre<stop.getId_order()){
                        reseauStib.getTheNode(stop.getId_station()).addDestination(precedent,1);

                }
                ordre=stop.getId_order();
                precedent=temp;
            }
        // probleme pour
        // gar ouest ->delacroix
        // art loi -> madou
        //merode ->thieffry
        //pq?
//        for (Node station : reseauStib.getNodes()){
//            System.out.println(station.getName());
//        }
        reseauStib.getTheNode(8072).addDestination(reseauStib.getTheNode(8202),1);
            //merode thierffry
        reseauStib.getTheNode(8042).addDestination(reseauStib.getTheNode(8412),1);
        //art loi ->madou
        reseauStib.getTheNode(8382).addDestination(reseauStib.getTheNode(8372),1);
        //gar ouest -> delrcoix ::car premier
        reseauStib.getTheNode(8472).addDestination(reseauStib.getTheNode(8764),1);
        //simois <-> elisabteth
    }

    public List<StationsDto> getAllStations()throws Exception{
        return stationsRepository.getAll();
    }

    public StationsDto getStation(int key) throws Exception{
        return stationsRepository.get(key);
    }
    public List<FavorisDto> getAllFavoris()throws Exception{
        return favorisRepository.getAll();
    }

    public void addFavoris(Node inOut[]){
        try{
            int id_favoris=favorisRepository.getAll().get(favorisRepository.getAll().size()-1).getId_favoris()+1;
            favorisRepository.add(new FavorisDto(id_favoris,inOut[0].getStation(),inOut[1].getStation(),inOut[0].getName(),inOut[1].getName()));
        }catch (Exception e){
            notifyObserver(null);
        }

        notifyObserver(null);
    }

    public void removeFavoris(FavorisDto favorisDto) throws Exception{
        favorisRepository.remove(new Integer[]{favorisDto.getId_favoris()
                ,favorisDto.getId_origin(),favorisDto.getId_destination()});
        notifyObserver(null);
    }

    public void searchShortPath(StationsDto []inOut){
        reseauStib.resetShortPath();
        Graph shortPath=Dijkstra.calculateShortestPathFromSource(reseauStib,reseauStib.getTheNode(inOut[0].getId()));

  /*      System.out.println("voisiins pour :"+inOut[0].getText()+":");
        for(Map.Entry<Node,Integer> entry:shortPath.getTheNode(inOut[0].getId()).getNeightbord().entrySet()){
            System.out.print(entry.getKey().getName()+" ");
        }

        System.out.println("\nvoisiins pour :"+inOut[1].getText()+":");
        for(Map.Entry<Node,Integer> entry:shortPath.getTheNode(inOut[1].getId()).getNeightbord().entrySet()){
            System.out.print(entry.getKey().getName()+" ");
        }
        System.out.println("\nchemin a prendre");
        for(Node node:shortPath.getTheNode(inOut[1].getId()).getShortestPath() ){
            //System.out.println(node.getName()+" ");
        }*/

        shortPath.getTheNode(inOut[1].getId()).getShortestPath().add(reseauStib.getTheNode(inOut[1].getId()));
        notifyObserver(shortPath.getTheNode(inOut[1].getId()).getShortestPath());
    }
    @Override
    public void registerObserver(Observer observer) {
        super.registerObserver(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        super.removeObserver(observer);
    }

    @Override
    public void notifyObserver(Object object) {
        super.notifyObserver(object);
    }
}
