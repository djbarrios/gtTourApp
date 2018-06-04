package data;

public class township {
    private Integer townshipId;
    private String name;

    public township(Integer townshipId, String name ){
        this.setTownshipId(townshipId);
        this.setName(name);
    }

    public Integer getTownshipId() {
        return townshipId;
    }

    public void setTownshipId(Integer townshipId) {
        this.townshipId = townshipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
