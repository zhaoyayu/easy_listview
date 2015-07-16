package zyy.ticket.model;

/**
 * 演出票Model
 */

public class TicketModel extends BaseModel {

    private static final long serialVersionUID = 1L;

    /** 项目id */
    private String perform_id;

    private String project_name; // 项目名称

    private String venue_name; // 场馆名称

    private String horizontal_image; // 水平图片

    private String vertical_image; // 垂直图片

    private String free_count; // 剩余票数量

    private String low_price_transaction; // 最低售价

    private String high_price_transaction; // 最高售价


    public String getPerform_id() {
        return perform_id;
    }


    public void setPerform_id(String perform_id) {
        this.perform_id = perform_id;
    }


    public String getProject_name() {
        return project_name;
    }


    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }


    public String getVenue_name() {
        return venue_name;
    }


    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }


    public String getHorizontal_image() {
        return horizontal_image;
    }


    public void setHorizontal_image(String horizontal_image) {
        this.horizontal_image = horizontal_image;
    }


    public String getVertical_image() {
        return vertical_image;
    }


    public void setVertical_image(String vertical_image) {
        this.vertical_image = vertical_image;
    }


    public String getFree_count() {
        return free_count;
    }


    public void setFree_count(String free_count) {
        this.free_count = free_count;
    }


    public String getLow_price_transaction() {
        return low_price_transaction;
    }


    public void setLow_price_transaction(String low_price_transaction) {
        this.low_price_transaction = low_price_transaction;
    }


    public String getHigh_price_transaction() {
        return high_price_transaction;
    }


    public void setHigh_price_transaction(String high_price_transaction) {
        this.high_price_transaction = high_price_transaction;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }


}
