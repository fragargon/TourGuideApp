package com.example.android.tourguideapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Creating a custom class {@link Places} represents a data model.
 * It display information given by TourGuideApp through 6 categories.
 * Each categories display names, address, phone and pictures.
 */

public class Places implements Parcelable {

    // String resource id for title
    private String titleName;
    // String resource id for item
    private String itemName;
    // Resource id for photo
    private int photoId;
    // Resource id for icon
    private int iconId;

    /**
     * This method is use with GridAdapter
     * @param titleName is the title of the categories.
     * @param photoId   is the picture of the categories.
     * @param iconId    is the icon display in categories.
     */
    public Places(String titleName, int photoId, int iconId) {
        this.titleName = titleName;
        this.photoId = photoId;
        this.iconId = iconId;
    }

    /**
     * This method is use with InfoAdapter
     * @param titleName is the title of the categories.
     * @param itemName   is the picture of the categories.
     * @param iconId    is the icon display in categories.
     */
    public Places(String titleName, String itemName, int iconId) {
        this.titleName = titleName;
        this.itemName = itemName;
        this.iconId = iconId;
    }

    /**
     * This method is use with ListAdapter
     * @param titleName is the title name of object in categories.
     * @param itemName  is the item name of object in categories.
     * @param photoId   is the object's picture in categories.
     * @param iconId    is the object's icon in categories.
     */
    public Places(String titleName, String itemName, int photoId, int iconId) {
        this.titleName = titleName;
        this.itemName = itemName;
        this.photoId = photoId;
        this.iconId = iconId;
    }

    /** Getter return the string resource ID for title */
    public String getTitleName(){
        return titleName;
    }

    /** Getter return the string resource ID for item */
    public String getItemName() {
        return itemName;
    }

    /** Getter return the image resource ID for photoId */
    public int getPhotoId(){
        return photoId;
    }

    /** Getters return the image resource ID for iconId */
    public int getIconId(){
        return iconId;
    }

    // Interface need by the Parcelable Class
    public static final Parcelable.Creator  CREATOR = new Parcelable.Creator() {
        public Places createFromParcel(Parcel in) {
            return new Places(in);
        }

        public Places[] newArray(int size) {
            return new Places[size];
        }
    };

    /**
     * @param in read the given object in Parcel.
     */
        public Places(Parcel in){
            this.titleName = in.readString();
            this.itemName = in.readString();
            this.photoId = in.readInt();
            this.iconId = in.readInt();
        }

    /**
     *
     * @return need by the class Parcel.
     * The method describes the Parcel's CONTENTS_FILE_DESCRIPTOR.
     * There isn't one so it returns 0.
     */
    @Override
    public int describeContents() {
            return 0;
    }


    /**
     *
     * @param dest The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.titleName);
            dest.writeString(this.itemName);
            dest.writeInt(this.photoId);
            dest.writeInt(this.iconId);
    }

    /** Return the string representation of the (@link Places) object **/
    @Override
    public String toString() {
            return "Places{" +
                    "titleName='" + titleName + '\'' +
                    "itemName='" + itemName + '\'' +
                    "photoId='" + photoId + '\'' +
                    "drawableIconId='" + iconId +'\'' +
                    '}';
    }
}
