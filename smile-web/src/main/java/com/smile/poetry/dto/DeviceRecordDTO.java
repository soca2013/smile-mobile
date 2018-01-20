package com.smile.poetry.dto;


import java.util.Date;

/**
 * Created by zhutao on 2017/4/25.
 */
public class DeviceRecordDTO {


    /**
     * 记录id
     */
    private long id;

    /**
     * 设备id
     */
    private long deviceId;

    private String windSpeed;



    /**
     * 风向
     */
    private String windDirection;

    /**
     * 气压
     */
    private String barometer;

    /**
     * 温度
     */
    private String temperature;

    /**
     * pm2.5
     */
    private int pm25;

    /**
     * 通道
     */
    private String channel;

    /**
     * 噪声
     */
    private String noise;

    /**
     * 湿度
     */
    private String humidity;

    /**
     * pm 10
     */
    private int pm10;

    /**
     * 上报时间
     */
    private long reportDate;

    /**
     * 上报时间
     */
    private Date reportTime;

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }


    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getBarometer() {
        return barometer;
    }

    public void setBarometer(String barometer) {
        this.barometer = barometer;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getPm25() {
        return pm25;
    }

    public void setPm25(int pm25) {
        this.pm25 = pm25;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public long getReportDate() {
        return reportDate;
    }

    public void setReportDate(long reportDate) {
        this.reportDate = reportDate;
    }
}
