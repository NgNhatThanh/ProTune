package protune.view.in.mainzone.homepane.audiocard.button;

import java.util.ArrayList;
import java.util.List;

public class CardButtonManage {
    private List<CardButton> btnList = new ArrayList<>();

    public void add(CardButton cardButton){
        btnList.add(cardButton);
    }

    public void setVisible(boolean visible){
        for(CardButton btn : btnList) btn.setVisible(visible);
    }

}
