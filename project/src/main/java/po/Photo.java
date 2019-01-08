package po;

public class Photo {
    private int albumId;
    private String photoPath;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Photo(int albumId, String photoPath) {
        this.albumId = albumId;
        this.photoPath = photoPath;
    }

    public Photo(){

    }

    @Override
    public String toString() {
        return "Photo{" +
                "albumId=" + albumId +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
