package kr.co.teada.ateat_project01;

public class AteFragItem {

    //item_detail_frag_ate.xml 상세샷에 포함된 멤버변수
    private String foodPic_Url;

    private String resName;
    private String msg;
    private String hash;

    //생성자 command + N


    public AteFragItem(String resName, String msg, String hash, String foodPic_Url) {
        this.resName = resName;
        this.msg = msg;
        this.hash = hash;
        this.foodPic_Url = foodPic_Url;
    }


    //FB DB 에 저장하려고 만든 빈 생성자
    public AteFragItem() {
    }

    //getter and setter

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getFoodPic_Url() {
        return foodPic_Url;
    }

    public void setFoodPic_Url(String foodPic_Url) {
        this.foodPic_Url = foodPic_Url;
    }
}
