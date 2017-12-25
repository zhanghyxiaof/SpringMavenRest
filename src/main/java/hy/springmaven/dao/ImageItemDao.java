package hy.springmaven.dao;

import java.util.List;

import hy.springmaven.pojo.ImageItem;

public interface ImageItemDao {
    int insert(ImageItem record);

    int insertSelective(ImageItem record);
    
    ImageItem getImageItemById(String id);
    
    List<ImageItem> getAllImages();
}