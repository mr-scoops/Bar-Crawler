package src.controller;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import src.model.Direction;
import src.view.MazeView;
import src.view.MonsterView;

import src.view.PlayerView;

import java.util.ArrayList;

public class PlayerController {
    private PlayerView player;
    private MazeView maze;
    private Stage stage;
    private double dx = 1;
    private double dy = 1;

    public PlayerController(Stage stage, PlayerView player, MazeView maze) {
        this.maze = maze;
        this.stage = stage;
        this.player = player;
        double dx = 5;
        double dy = 5;
        stage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                event.consume();
                switch (event.getCode()) {
                case W:
                    player.changeDirection(Direction.BACK);
                    player.setDx(0);
                    player.setDy(-dy);

                    System.out.println("up");
                    break;
                case S:
                    player.changeDirection(Direction.FRONT);
                    player.setDx(0);
                    player.setDy(dy);

                    System.out.println("down");
                    break;
                case A:
                    player.changeDirection(Direction.LEFT);
                    player.setDx(-dx);
                    player.setDy(0);

                    System.out.println("left");
                    break;
                case D:
                    player.changeDirection(Direction.RIGHT);
                    player.setDx(dx);
                    player.setDy(0);

                    System.out.println("right");
                    break;
                case SPACE:
                    player.attackSprite();
                    Direction direct = player.getDirection();
                    ArrayList<MonsterView> monsterList = (maze.getCurrent().getMonsterViews());
                    //for (MonsterView monster : monsterList) {
                    for (int i = 0; i < monsterList.size(); i++) {
                        MonsterView monster = monsterList.get(i);
                        switch (direct) {
                            case FRONT:
                                if (((player.getX() - monster.getX() < 30)
                                        && (player.getY() - monster.getY() < 60))
                                        && ((monster.getX() - player.getX() < 30)
                                        && (monster.getY() - player.getY() < 60))) {
                                    maze.damageMonster(monster, i);
                                    System.out.println(player.getDx());
                                    System.out.println(player.getX());
                                    System.out.println(monster.getX());
                                }
                                break;
                            case BACK:
                                if (((player.getX() - monster.getX() < 30)
                                        && (player.getY() - monster.getY() < 60))
                                        && ((monster.getX() - player.getX() < 30)
                                        && (monster.getY() - player.getY() < 60))) {
                                    maze.damageMonster(monster, i);
                                }
                                break;
                            case RIGHT:
                                if (((player.getX() - monster.getX() < 60)
                                        && (player.getY() - monster.getY() < 30))
                                        && ((monster.getX() - player.getX() < 60)
                                        && (monster.getY() - player.getY() < 30))) {
                                    maze.damageMonster(monster, i);
                                }
                                break;
                            case LEFT:
                                if (((player.getX() - monster.getX() < 60)
                                        && (player.getY() - monster.getY() < 31))
                                        && ((monster.getX() - player.getX() < 61)
                                        && (monster.getY() - player.getY() < 30))) {
                                    maze.damageMonster(monster, i);
                                }
                                break;
                            default:
                                break;
                            }
                        }
                        System.out.println("attack");
                        break;
                    case SPACE:
                        player.attackSprite();

                        System.out.println("attack");
                        break;
                    default:
                        break;
                }
            }
        });
        stage.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                player.setDy(0);
                player.setDx(0);
                player.endStep();
            }
        });



        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                player.move();
                player.updateUI();
            }
        };
        timer.start();

        //AnimationTimer timerEnemy = new AnimationTimer() {
        //@Override
        //public void handle(long now) {
        //ArrayList<MonsterView> monsterList = (maze.getCurrent().getMonsterViews());
        //for (MonsterView monster : monsterList) {
        //monster.currentModel().attack(player, monster);
        //}
        //}
        //};
        //timer.start();
    }

}
