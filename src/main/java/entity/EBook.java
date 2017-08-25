package entity;

import javax.persistence.Entity;

/**
 * Created by adam on 8/25/2017.
 */
@Entity
public class EBook extends Book{
    private String downloadUrl;

    private double sizeMB;

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getSizeMB() {
        return sizeMB;
    }

    public void setSizeMB(double sizeMB) {
        this.sizeMB = sizeMB;
    }
}
