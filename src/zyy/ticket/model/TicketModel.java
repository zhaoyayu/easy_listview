package zyy.ticket.model;

/**
 * 演出票Model
 */

public class TicketModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	/** 项目id */
	private String id;

	private String ticketname; // 项目名称

	private String venuename; // 场馆名称

	private String ticketthumb; // 海报图片

	private String horizontalimage; // 水平图片

	private String verticalimage; // 垂直图片

	private String starttime; // 出演时间

	private String freecount; // 剩余票数量

	private String low_price_original; // 原价最低

	private String high_price_original; // 原价最高

	private String low_price; // 最低售价

	private String highest_price; // 最高售价

	private String lowest_price_count; // 最低价票数量

	private int transaction_status; // 座位状态:1 可以购买;2 购买中锁定状态;3 已经被购买

	private String vertical_image; // 垂直图片

	private String horizontal_image; // 水平图片

	private String project_desc; // 项目介绍

	private String project_url; // 项目描述url

	private String start_time; // 场次开始时间

	private boolean is_seller_scene_goods;// 是否支持当面取票

	private boolean is_seller_send_goods;// 是否支持快递

	private boolean is_buyer_fetch_goods;// 是否支持上面取票

	private Boolean is_fans; // 是否已经关注该场次

	private String service_current; // 服务器返回的当前时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTicketname() {
		return ticketname;
	}

	public void setTicketname(String ticketname) {
		this.ticketname = ticketname;
	}

	public String getVenuename() {
		return venuename;
	}

	public void setVenuename(String venuename) {
		this.venuename = venuename;
	}

	public String getTicketthumb() {
		return ticketthumb;
	}

	public void setTicketthumb(String ticketthumb) {
		this.ticketthumb = ticketthumb;
	}

	public String getHorizontalimage() {
		return horizontalimage;
	}

	public void setHorizontalimage(String horizontalimage) {
		this.horizontalimage = horizontalimage;
	}

	public String getVerticalimage() {
		return verticalimage;
	}

	public void setVerticalimage(String verticalimage) {
		this.verticalimage = verticalimage;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getFreecount() {
		return freecount;
	}

	public void setFreecount(String freecount) {
		this.freecount = freecount;
	}

	public String getLow_price_original() {
		return low_price_original;
	}

	public void setLow_price_original(String low_price_original) {
		this.low_price_original = low_price_original;
	}

	public String getHigh_price_original() {
		return high_price_original;
	}

	public void setHigh_price_original(String high_price_original) {
		this.high_price_original = high_price_original;
	}

	public String getLow_price() {
		return low_price;
	}

	public void setLow_price(String low_price) {
		this.low_price = low_price;
	}

	public String getHighest_price() {
		return highest_price;
	}

	public void setHighest_price(String highest_price) {
		this.highest_price = highest_price;
	}

	public String getLowest_price_count() {
		return lowest_price_count;
	}

	public void setLowest_price_count(String lowest_price_count) {
		this.lowest_price_count = lowest_price_count;
	}

	public int getTransaction_status() {
		return transaction_status;
	}

	public void setTransaction_status(int transaction_status) {
		this.transaction_status = transaction_status;
	}

	public String getVertical_image() {
		return vertical_image;
	}

	public void setVertical_image(String vertical_image) {
		this.vertical_image = vertical_image;
	}

	public String getHorizontal_image() {
		return horizontal_image;
	}

	public void setHorizontal_image(String horizontal_image) {
		this.horizontal_image = horizontal_image;
	}

	public String getProject_desc() {
		return project_desc;
	}

	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}

	public String getProject_url() {
		return project_url;
	}

	public void setProject_url(String project_url) {
		this.project_url = project_url;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public boolean isIs_seller_scene_goods() {
		return is_seller_scene_goods;
	}

	public void setIs_seller_scene_goods(boolean is_seller_scene_goods) {
		this.is_seller_scene_goods = is_seller_scene_goods;
	}

	public boolean isIs_seller_send_goods() {
		return is_seller_send_goods;
	}

	public void setIs_seller_send_goods(boolean is_seller_send_goods) {
		this.is_seller_send_goods = is_seller_send_goods;
	}

	public boolean isIs_buyer_fetch_goods() {
		return is_buyer_fetch_goods;
	}

	public void setIs_buyer_fetch_goods(boolean is_buyer_fetch_goods) {
		this.is_buyer_fetch_goods = is_buyer_fetch_goods;
	}

	public Boolean getIs_fans() {
		return is_fans;
	}

	public void setIs_fans(Boolean is_fans) {
		this.is_fans = is_fans;
	}

	public String getService_current() {
		return service_current;
	}

	public void setService_current(String service_current) {
		this.service_current = service_current;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
