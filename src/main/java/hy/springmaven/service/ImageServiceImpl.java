package hy.springmaven.service;

import hy.springmaven.dao.ImageItemDao;
import hy.springmaven.pojo.ImageItem;
import hy.springmaven.pojo.ImageList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("imageService")
public class ImageServiceImpl implements ImageService {
	
	@Resource
	private ImageItemDao imageItemDao;

	@Override
	public boolean addImage(ImageItem imageItem) {
		imageItemDao.insert(imageItem);
		return true;
	}

	@Override
	public boolean deleteImage(String id) {
		
		return false;
	}

	@Override
	public boolean updateImage(ImageItem imageItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageItem getImage(String id) {
		// TODO Auto-generated method stub
		
		return imageItemDao.getImageItemById(id);
	}

	@Override
	public ImageList getImages(List<String> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageList getImages(String imageType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImageItem> getAllImages() {
		
		return imageItemDao.getAllImages();
	}

}
