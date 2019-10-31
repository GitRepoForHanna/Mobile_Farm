package utils.actions;

public enum DirectionPercentageCoordinates {
    TOP_LEFT(0.1, 0.1),
    LEFT_CENTER(0.1, 0.5),
    LEFT_BOTTOM(0.1, 0.9),
    BOTTOM_CENTER(0.5, 0.9),
    RIGHT_BOTTOM(0.9, 0.9),
    RIGHT_CENTER(0.9, 0.5),
    RIGHT_TOP(0.9, 0.1),
    TOP_CENTER(0.5, 0.1),
    CENTER(0.5, 0.5);

    private Double xCoord;
    private Double yCoord;

    DirectionPercentageCoordinates(Double xCoord, Double yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public Double getXCoord() {
        return xCoord;
    }

    public Double getYCoord() {
        return yCoord;
    }
}
