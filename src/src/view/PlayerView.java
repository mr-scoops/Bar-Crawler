package src.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PlayerView {
    private Image sprite;
    private ImageView imageView;

    private Pane layer;

    private double x;
    private double y;

    private double dx;
    private double dy;

    private double width;
    private double height;

    private final double playerWidth = 76 /2;
    private final double playerHeight = 156 / 2;
    private final double topBoarder = 76 / 2;
    private final double leftBoarder = 76 / 2;

    /**
     * Player constructor.
     */
    public PlayerView(Pane layer, Image sprite, double x, double y, double w, double h) {
        this.layer = layer;
        this.sprite = sprite;

        this.x = x;
        this.y = y;

        this.imageView = new ImageView(sprite);
        this.imageView.relocate(x, y);

        this.width = w;
        this.height = h;

        addToLayer();
    }

    /**
     * Adds player to layer.
     */
    public void addToLayer() {
        this.layer.getChildren().add(this.imageView);
    }

    public Pane getLayer() {
        return this.layer;
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public void setSprite(Image im) {
        this.imageView.setImage(im);
    }
    public void move() {
        if(0 + leftBoarder <= x  + dx && x + dx < width - playerWidth - leftBoarder)
        x += dx;
        if( 0 + topBoarder <= y + dy && y + dy < height - playerHeight - topBoarder)
        y += dy;
    }

    public void updateUI() {
        imageView.relocate(x, y);
    }
}