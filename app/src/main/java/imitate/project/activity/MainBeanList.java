package imitate.project.activity;

public class MainBeanList {



//            "photoId": 0,
//                    "photoName": "http://www.nj-lsj.net/Taste/upload/1564969116639.jpg",
//                    "productCode": null,
//                    "productName": "黄鹤楼细支珍品",
//                    "photoPath": null,
//                    "org_code": null,
//                    "cityCompany": null,
//                    "registTime": null,
//                    "face": null,
//                    "shelfCode": "201904190007000",
//                    "lackProduct": "正常"



    private int photoId;
    private String photoName;
    private String productCode;
    private String productName;
    private String photoPath;
    private String org_code;
    private String cityCompany;
    private String registTime;
    private String face;
    private String shelfCode;
    private String lackProduct;

    @Override
    public String toString() {
        return "MainBeanList{" +
                "photoId=" + photoId +
                ", photoName='" + photoName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", org_code='" + org_code + '\'' +
                ", cityCompany='" + cityCompany + '\'' +
                ", registTime='" + registTime + '\'' +
                ", face='" + face + '\'' +
                ", shelfCode='" + shelfCode + '\'' +
                ", lackProduct='" + lackProduct + '\'' +
                '}';
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public String getCityCompany() {
        return cityCompany;
    }

    public void setCityCompany(String cityCompany) {
        this.cityCompany = cityCompany;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getShelfCode() {
        return shelfCode;
    }

    public void setShelfCode(String shelfCode) {
        this.shelfCode = shelfCode;
    }

    public String getLackProduct() {
        return lackProduct;
    }

    public void setLackProduct(String lackProduct) {
        this.lackProduct = lackProduct;
    }
}
