package data;

public class site {
    Integer siteType;
    String name;

    public site(Integer siteType, String name) {
        this.setSiteType(siteType);
        this.setName(name);
    }

    public Integer getSiteType() {
        return siteType;
    }

    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
