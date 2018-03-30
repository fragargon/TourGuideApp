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
    // String resource id for address
    private String address;
    // String resource id for tel
    private String tel;
    // String resource id for web
    private String web;
    // String resource id for desc
    private String desc;
    // Resource id for photo
    private int photoId;
    // Resource id for icon
    private int iconId;

    /**
     * This constructor is use with GridAdapter.
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
     * This constructor is use with InfoAdapter.
     * @param titleName is the title of the categories.
     * @param itemName   is the picture of the categories.
     * @param photoId    is the icon display in categories.
     */
    public Places(String titleName, String itemName, int photoId) {
        this.titleName = titleName;
        this.itemName = itemName;
        this.photoId = photoId;
    }

    /**
     * This is the details constructor.
     * @param titleName is the title name of object in categories.
     * @param itemName  is the item name of object in categories.
     * @param address   is the address name of object in categories.
     * @param tel       is the tel name of object in categories.
     * @param web       is the url name of object in categories.
     * @param desc      is the description name of object in categories.
     * @param photoId is the object's picture in categories.
     */
    public Places(String titleName, String itemName, String address, String tel, String web, String desc, int photoId) {
        this.titleName = titleName;
        this.itemName = itemName;
        this.address = address;
        this.tel = tel;
        this.web = web;
        this.desc = desc;
        this.photoId = photoId;
    }

    /**
     * This is the main constructor.
     * @param titleName is the title name of object in categories.
     * @param itemName  is the item name of object in categories.
     * @param address   is the address name of object in categories.
     * @param tel       is the tel name of object in categories.
     * @param web       is the url name of object in categories.
     * @param desc      is the description name of object in categories.
     * @param photoId is the object's picture in categories.
     */
    public Places(String titleName, String itemName, String address, String tel, String web, String desc, int photoId, int iconId) {
        this.titleName = titleName;
        this.itemName = itemName;
        this.address = address;
        this.tel = tel;
        this.web = web;
        this.desc = desc;
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

    /** Getter return the string resource ID for address */
    public String getAddress() {
        return address;
    }

    /** Getter return the string resource ID for tel */
    public String getTel() {
        return tel;
    }

    /** Getter return the string resource ID for web */
    public String getWeb() {
        return web;
    }

    /** Getter return the string resource ID for desc */
    public String getDesc() {
        return desc;
    }

    /** Getter return the image resource ID for photoId */
    public int getPhotoId(){
        return photoId;
    }

    /** Getters return the image resource ID for iconId */
    public int getIconId(){
        return iconId;
    }

    /**
     * Interface need by the Parcelable Class.
     * It will be required during un-marshaling data stored in a Parcel.
     */
    public static final Parcelable.Creator  CREATOR = new Parcelable.Creator() {
        public Places createFromParcel(Parcel in) {
            return new Places(in);
        }

        public Places[] newArray(int size) {
            return new Places[size];
        }
    };

    /**
     * This will be used only by the MyCreator
     * @param in
     */
        public Places(Parcel in){
            this.titleName = in.readString();
            this.itemName = in.readString();
            this.address = in.readString();
            this.tel = in.readString();
            this.web =in.readString();
            this.desc = in.readString();
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
            dest.writeString(this.address);
            dest.writeString(this.tel);
            dest.writeString(this.web);
            dest.writeString(this.desc);
            dest.writeInt(this.photoId);
            dest.writeInt(this.iconId);
    }

    /** Return the string representation of the (@link Places) object **/
    @Override
    public String toString() {
            return "Places{" +
                    "titleName='" + titleName + '\'' +
                    "itemName='" + itemName + '\'' +
                    "address='" + address + '\'' +
                    "tel='" + tel + '\'' +
                    "web='" + web + '\'' +
                    "desc='" + desc + '\'' +
                    "photoId='" + photoId + '\'' +
                    "drawableIconId='" + iconId +'\'' +
                    '}';
    }
}
