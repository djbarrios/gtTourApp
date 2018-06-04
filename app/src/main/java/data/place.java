package data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class place {
    private Integer id;
    private String department;
    private String township;
    private String siteType;
    private String hasParkingLot;
    private String hasInternet;
    private String hasHotels;
    private String title;
    private String latitude;
    private String longitude;
    private String description;
    private String picture1;
    private String picture2;
    private String picture3;
    private generalInfo generalInfo = new generalInfo();

    public place(String department,String township, String siteType, String hasParkingLot, String hasInternet, String hasHotels, String title, String latitude, String longitude, String description, String picture1, String picture2, String picture3){
        this.setId(0);
        this.setDepartment(department) ;
        this.setTownship(township);
        this.setSiteType(siteType);
        this.setHasParkingLot(hasParkingLot);
        this.setHasInternet(hasInternet);
        this.setHasHotels(hasHotels);
        this.setTitle(title);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setDescription(description);
        this.setPicture1(picture1);
        this.setPicture2(picture2);
        this.setPicture3(picture3);
    }

    public place(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getHasParkingLot() {
        return hasParkingLot;
    }

    public void setHasParkingLot(String hasParkingLot) {
        this.hasParkingLot = hasParkingLot;
    }

    public String getHasInternet() {
        return hasInternet;
    }

    public void setHasInternet(String hasInternet) {
        this.hasInternet = hasInternet;
    }

    public String getHasHotels() {
        return hasHotels;
    }

    public void setHasHotels(String hasHotels) {
        this.hasHotels = hasHotels;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture1() {
        return picture1;
    }

    public void setPicture1(String picture1) {
        this.picture1 = picture1;
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getPicture3() {
        return picture3;
    }

    public void setPicture3(String picture3) {
        this.picture3 = picture3;
    }

    public Bitmap getBitmap(String imageStream) {
        Bitmap decodedByte = null;
        if (!imageStream.equals("")) {
            byte[] decodedString = Base64.decode(imageStream, Base64.DEFAULT);
            decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        }
        return decodedByte;
    }

    public static List<place> getListFromJSON(JSONArray array) {
        List<place> placeList = null;
        if (array != null) {
            if (array.length() > 0) {
                placeList = new ArrayList<place>();
                place object;
                for (int i= 0; i < array.length(); i ++) {
                    object = null;
                    try {
                        object = new place();
                        object.setDepartment(array.getJSONObject(i).getString("departamento"));
                        object.setTownship(array.getJSONObject(i).getString("municipio"));
                        object.setTitle(array.getJSONObject(i).getString("titulo"));
                        object.setLatitude(array.getJSONObject(i).getString("latitud"));
                        object.setLongitude(array.getJSONObject(i).getString("longitud"));
                        object.setDescription(array.getJSONObject(i).getString("descripcion"));
                        object.setSiteType(array.getJSONObject(i).getString("tipo_sitio"));
                        object.setPicture1(array.getJSONObject(i).getString("foto1"));
                        object.setPicture2(array.getJSONObject(i).getString("foto2"));
                        object.setPicture3(array.getJSONObject(i).getString("foto3"));
                        object.setHasParkingLot(array.getJSONObject(i).getString("parqueo"));
                        object.setHasInternet(array.getJSONObject(i).getString("internet"));
                        object.setHasHotels(array.getJSONObject(i).getString("hoteles"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (object != null) {
                        placeList.add(object);
                    }
                }
            }
        }
        return placeList;
    }

    public String getDepartmentName(Integer departmentId){
        String departmentName;
        departmentName = "";
        for (department dep:generalInfo.getDepartments()
                ) {
            if (dep.getDepartmentId() == departmentId){
                departmentName = dep.getName();
                break;
            }
        }
        return departmentName;
    }

    public department getDepartment(Integer departmentId){
        department department;
        department = null;
        for (department dep:generalInfo.getDepartments()
                ) {
            if (dep.getDepartmentId() == departmentId){
                department = dep;
                break;
            }
        }
        return department;
    }

    public String getTownshipName(Integer departmenId,Integer townshipId){
        String townshipName;
        townshipName = "";
        department departmen = this.getDepartment(departmenId);
        for (township town:departmen.getTownships()
                ) {
            if (town.getTownshipId() == townshipId){
                townshipName = town.getName();
                break;
            }
        }
        return townshipName;
    }

    public String getSiteTypeName(Integer siteTypeId){
        String siteTypeName;
        siteTypeName = "";
        for (site siteType:generalInfo.getStieTypes()
                ) {
            if (siteType.getSiteType() == siteTypeId){
                siteTypeName = siteType.getName();
                break;
            }
        }
        return siteTypeName;
    }
}
