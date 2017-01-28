/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp1_tpgo;

import java.util.LinkedList;

/**
 *
 * @author golden Boy
 */
public class Objets {
    private LinkedList <ObjectImage> objImages = new LinkedList<ObjectImage>();
    private LinkedList <ObjectImage> images = new LinkedList<ObjectImage>();

    public LinkedList<ObjectImage> getObjImages() {
        return objImages;
    }

    public void setImages(LinkedList<ObjectImage> images) {
        this.images = images;
    }

    public LinkedList<ObjectImage> getImages() {
        return images;
    }

    public void setObjImages(LinkedList<ObjectImage> objImages) {
        this.objImages = objImages;
    }
    public void addImage(ObjectImage obj){
        objImages.add(obj);
    }
    public void addImg(ObjectImage obj){
        images.add(obj);
    }
    public ObjectImage ifExist(int i ,int j){
        for (ObjectImage obj : objImages ) {
            if(obj.getI()==i && obj.getJ()==j) return obj;
        }   
        return null;
    }
}
