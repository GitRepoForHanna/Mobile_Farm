package utils.actions;

public enum SwipeDirection {
    TOP(DirectionPercentageCoordinates.BOTTOM_CENTER, DirectionPercentageCoordinates.TOP_CENTER),
    LEFT(DirectionPercentageCoordinates.RIGHT_CENTER, DirectionPercentageCoordinates.LEFT_CENTER),
    RIGHT(DirectionPercentageCoordinates.LEFT_CENTER, DirectionPercentageCoordinates.RIGHT_CENTER),
    BOTTOM(DirectionPercentageCoordinates.TOP_CENTER, DirectionPercentageCoordinates.BOTTOM_CENTER);

    private DirectionPercentageCoordinates startPoint;
    private DirectionPercentageCoordinates endPoint;

    SwipeDirection(DirectionPercentageCoordinates startPoint, DirectionPercentageCoordinates endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public DirectionPercentageCoordinates getStartPoint() {
        return startPoint;
    }

    public DirectionPercentageCoordinates getEndPoint() {
        return endPoint;
    }

    public Double getStartPointX() {
        return startPoint.getXCoord();
    }

    public Double getStartPointY() {
        return startPoint.getYCoord();
    }

    public Double getEndPointX() {
        return endPoint.getXCoord();
    }

    public Double getEndPointY() {
        return endPoint.getYCoord();
    }
}
