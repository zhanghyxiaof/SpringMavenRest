package hy.springmaven.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hy.springmaven.pojo.ImageItem;
import hy.springmaven.pojo.ImageList;
import hy.springmaven.service.ImageService;
import hy.springmaven.service.ImageServiceImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/images")
public class RestImageController {

	@Resource
	private ImageService imageService;

	protected Log log = LogFactory.getLog(this.getClass());
	/*
	 * @RequestMapping(method = RequestMethod.POST)
	 * 
	 * @ResponseBody public String createImage(@RequestBody ImageItem imageItem)
	 * { imageService.addImage(imageItem); return imageItem.getId(); }
	 */

	/*
	 * @RequestMapping(value = "", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public String createImage(@RequestBody ImageItem imageItem,
	 * HttpServletRequest request) { imageService.addImage(imageItem); return
	 * imageItem.getId(); }
	 */

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String createImages(@RequestBody List<ImageItem> imageItemList,
			HttpServletRequest request) {
		return imageItemList.toString();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Cacheable(value = "ImageCache")
	@ResponseBody
	public ImageItem getImageById(@PathVariable String id) {
		log.error("Start to get image by id: " + id);
		ImageItem imageItem = imageService.getImage(id);
		log.info("Finish image query for: " + id);
		return imageItem;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ImageItem> getAllImages() {

		return imageService.getAllImages();
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET)
	 * 
	 * @ResponseBody public ImageList getImageByType(String type) {
	 * 
	 * return imageService.getImages(type); }
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateImage(@RequestBody ImageItem imageItem,
			@PathVariable String id) {
		imageService.updateImage(imageItem);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteImage(@PathVariable String id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/resources/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void getIcon(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
	    if(StringUtils.isEmpty(id))
	    {
	    	id = "";
	    }
		String fileName = request.getSession().getServletContext().getRealPath("/") + "/WEB-INF/images/"+id.trim()+".jpg";
		File file = new File(fileName);

		if(!(file.exists()&&file.canRead())){
			file=new File(request.getSession().getServletContext().getRealPath("/") + "/WEB-INF/images/root.jpg");
		}
		FileInputStream inputStream=new FileInputStream(file);
		byte[] data=new byte[(int)file.length()];
		int length = inputStream.read(data);
		inputStream.close();
		response.setContentType("image/png");
		OutputStream stream = response.getOutputStream();
		stream.write(data);
		stream.flush();
		stream.close();
	}
}
