package data;

import java.util.ArrayList;
import java.util.List;

public class department {

    private Integer departmentId;
    private String name;
    private List<township> townships= new ArrayList<>();

    public department(Integer departmentId, String name ){
        this.setDepartmentId(departmentId);
        this.setName(name);
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<township> getTownships() {
        return townships;
    }

    public void  addTownship(township _township){
        townships.add(_township);
    }

}
