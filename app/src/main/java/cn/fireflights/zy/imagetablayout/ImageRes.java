package cn.fireflights.zy.imagetablayout;

/**
 * Created by ZY on 2016/11/15.
 */
public class ImageRes {

    private String title;
    private int imageDrawableRes;

    public ImageRes() {

    }

    public ImageRes(String title, int imageDrawableRes) {
        this.imageDrawableRes = imageDrawableRes;
        this.title = title;
    }

    public int getImageDrawableRes() {
        return imageDrawableRes;
    }

    public void setImageDrawableRes(int imageDrawableRes) {
        this.imageDrawableRes = imageDrawableRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
