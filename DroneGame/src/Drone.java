public class Drone {

    private int movementSpeed;
    private ImagePanel image;

    public Drone(String imagePath,int startingX, int startingY,int movementSpeed){
        this.image = new ImagePanel(imagePath,startingX,startingY);
        this.movementSpeed = movementSpeed;
    }

    public void moveUp(){
        this.image.moveUp(movementSpeed);
    }
    public void moveDown(){
        this.image.moveDown(movementSpeed);
    }

    public void moveLeft(){
        this.image.moveLeft(movementSpeed);
    }

    public void moveRight(){
        this.image.moveRight(movementSpeed);
    }

}
