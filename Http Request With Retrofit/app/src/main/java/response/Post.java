
package response;

import android.os.Message;

public class Post {

    private String username;
    private String cat_name;
    public String getUsername() {
        return username;
    }

    public String getCat_name() {
        return cat_name;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public String getPub_date() {
        return pub_date;
    }

    private String title;
    private String content;
    private String image;
    private String pub_date;

    @Override
    public String toString() {
        return "title:" + this.title;
    }

}


