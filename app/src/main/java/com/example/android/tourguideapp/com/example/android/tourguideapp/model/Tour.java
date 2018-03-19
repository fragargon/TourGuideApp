package com.example.android.tourguideapp.com.example.android.tourguideapp.model;

/**
 * Creating a custom class called AlbumItems.
 * Object of this call will have 3 properties:
 * (albumName, artisteName and albumResourceId)
 * {@link Tour} represents a data model class
 * It contains the representation for the grid view and list view.
 * use in TourGuideApp APK
 *
 */

public class Tour {

    /** Name of the title Category */
    private String myTitleName;

    /** Name of the item name Category */
    private String myItemName;

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
    public Tour(String titleName, int drawablePicId, int drawableIconId) {
        myTitleName = titleName;
        myDrawablePicId = drawablePicId;
        myDrawableIconId = drawableIconId;
    }

    /**
     * Create a new list item object (constructor)
     * @param titleName is the title of the category
     * @param itemName is the name of the item in the category
     * @param drawablePicId is the drawable Id of the image
     * @param drawableIconId  is the drawable id of the icon
     */
    public Tour(String titleName, String itemName, int drawablePicId, int drawableIconId) {
        myTitleName = titleName;
        myItemName = itemName;
        myDrawablePicId = drawablePicId;
        myDrawableIconId = drawableIconId;
    }

    /** Get the name of the title */
    public String getTitleName () {
        return myTitleName;
    }

    /** Get the name of the title */
    public String getItemName () {
        return myItemName;
    }

    /** Get the image resource id of the category */
    public int getDrawablePic () {
        return myDrawablePicId;
    }

    /** Get the icon resource id of the category */
    public int getDrawableIcon () {
        return myDrawableIconId;
    }

    /** Return the string representation of the (@link Tour) object**/
    @Override
    public String toString () {
        return "Tour{" +
                "myTitleName='" + myTitleName + '\'' +
                "myItemName='" + myItemName + '\'' +
                ", myDrawablePicId=" + myDrawablePicId + '\'' +
                ", myDrawableIconId=" + myDrawableIconId + '}';
    }
}
