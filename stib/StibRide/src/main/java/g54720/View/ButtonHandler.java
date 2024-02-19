package g54720.View;

import g54720.Presentation.Presenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ButtonHandler implements EventHandler<ActionEvent> {
    private Presenter presenter;
    private Action type;

    public ButtonHandler(Presenter presenter,Action type){
        this.presenter=presenter;
        this.type=type;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        switch (type){
            case Add:
                presenter.addFavoris();
                break;
            case Use:
                presenter.useFavoris();
                break;
            case Search:
                presenter.search();
                break;
            case Delete:
                presenter.deleteFavoris();
        }
    }
}
