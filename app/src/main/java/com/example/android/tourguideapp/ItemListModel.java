package com.example.android.tourguideapp;

/**
 * Creating a custom class called AlbumItems.
 * Object of this call will have 3 properties:
 * (albumName, artisteName and albumResourceId)
 * {@link ItemListModel} represents a data model class
 * It contains the representation for the gridView and listView
 * use in TourGuideApp APK
 *
 */

public class ItemListModel {

    /** Name of the title Category */
    private String myTitleName;

    /** Drawable of the pictures displayed */
    private int myDrawablePicId;

    /** Drawable of the icon displayed */
    private int myDrawableIconId;

    /**
     * Create a new list item object (constructor)
     * @param titleName is the title of the category
     * @param drawablePicId is the drawable Id of the image
     * @param drawableIconId  is the drawable id of the icon
     */
    public ItemListModel (String titleName, int drawablePicId, int drawableIconId) {
        myTitleName = titleName;
        myDrawablePicId = drawablePicId;
        myDrawableIconId = drawableIconId;
    }

    /** Get the name of the title */
    public String getTitleName () {
        return myTitleName;
    }

    /** Get the image resource id of the category */
    public int getDrawablePic () {
        return myDrawablePicId;
    }

    /** Get the icon resource id of the category */
    public int getDrawableIcon () {
        return myDrawableIconId;
    }

    /** Return the string representation of the (@link ItemListModel) object**/
    @Override
    public String toString () {
        return "ItemListModel{" +
                "myTitleName='" + myTitleName + '\'' +
                ", myDrawablePicId=" + myDrawablePicId + '\'' +
                ", myDrawableIconId=" + myDrawableIconId + '}';
    }
}
