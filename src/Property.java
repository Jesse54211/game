public class Property {
    private String propertyName;
    private int propertyCost;
    private Player propertyOwner;

    public Property(String propertyName, int propertyCost, Player propertyOwner) {
        this.propertyName = propertyName;
        this.propertyCost = propertyCost;
        this.propertyOwner = propertyOwner;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public int getPropertyCost() {
        return propertyCost;
    }

    public Player getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(Player propertyOwner) {
        this.propertyOwner = propertyOwner;
    }
}