package tests;


import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import src.controller.Main;
import src.model.PlayerModel;
import src.view.MonsterView;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SalM4Tests extends ApplicationTest {
    private Main controller;
    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Main();
        controller.start(primaryStage);
        primaryStage.show();
    }

    @Test
    public void testMonstersHealthInitialized() {
        clickOn("Start");
        write("username");
        clickOn("Let's go!");
        ArrayList<MonsterView> mV = controller.getMazeView().getCurrent().getMonsterViews();
        assertTrue(mV.get(0).currentModel().getMonsterHP() != 0);
    }

    @Test
    public void testInitialInventoryEmpty() {
        clickOn("Start");
        write("username");
        clickOn("Let's go!");
        PlayerModel pm = controller.getPlayerView().getModel();
        assertTrue(pm.getPlayerHP() != 0);
    }

}
