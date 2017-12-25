package hy.springmaven.service;

import java.util.List;

import hy.springmaven.pojo.ImageItem;
import hy.springmaven.pojo.ImageList;

public interface ImageService {
	public boolean addImage(ImageItem imageItem);
	public boolean deleteImage(String id);
	public boolean updateImage(ImageItem imageItem);
	public ImageItem getImage(String id);
	public ImageList getImages(List<String> idList);
	public ImageList getImages(String imageType);
	public List<ImageItem> getAllImages();
}