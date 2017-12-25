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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebImageController {

	@Resource
	private ImageService imageService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView hello() {

		ModelAndView mv = new ModelAndView();

		mv.addObject("spring", "spring mvc");

		mv.setViewName("login");

		return mv;

	}

	@RequestMapping(value = "/verifylogon", method = RequestMethod.POST)
	public String verifyLogin(@ModelAttribute("SpringWeb") ImageItem item,
			ModelMap model) {
		model.addAttribute("name", item.getName());
		model.addAttribute("desc", item.getDescription());
		model.addAttribute("id", item.getId());

		return "result";
	}

	@RequestMapping(value = "/addImage", method = RequestMethod.POST)
	public String addImage(@ModelAttribute("SpringWeb") ImageItem item,
			ModelMap model) {
		model.addAttribute("name", item.getName());
		model.addAttribute("desc", item.getDescription());
		model.addAttribute("id", item.getId());

		return "result";
	}
	
	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public ModelAndView image() {

		ImageItem item = new ImageItem();
		item.setId("testId");
		item.setName("testName");
		item.setDescription("testDesc");
		ModelAndView mv = new ModelAndView("image", "command", item);

		return mv;

	}

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

	/*
	 * @RequestMapping(method = RequestMethod.POST)
	 * 
	 * @ResponseBody public String createImages(@RequestBody List<ImageItem>
	 * imageItemList, HttpServletRequest request) { return
	 * imageItemList.toString(); }
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public ImageItem getImageById(@PathVariable String id) {
	 * ImageItem imageItem = imageService.getImage(id); return imageItem; }
	 * 
	 * @RequestMapping(method = RequestMethod.GET)
	 * 
	 * @ResponseBody public List<ImageItem> getAllImages() {
	 * 
	 * return imageService.getAllImages(); }
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	 * 
	 * @ResponseBody public void updateImage(@RequestBody ImageItem imageItem,
	 * 
	 * @PathVariable String id) { imageService.updateImage(imageItem); }
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	 * 
	 * @ResponseBody public void deleteImage(@PathVariable String id) {
	 * imageService.deleteImage(id); }
	 * 
	 * @RequestMapping(value = "/resources/{id}", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public void getIcon(@PathVariable("id") String id,
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * IOException { if(StringUtils.isEmpty(id)) { id = ""; } String fileName =
	 * request.getSession().getServletContext().getRealPath("/") +
	 * "/WEB-INF/images/"+id.trim()+".jpg"; File file = new File(fileName);
	 * 
	 * if(!(file.exists()&&file.canRead())){ file=new
	 * File(request.getSession().getServletContext().getRealPath("/") +
	 * "/WEB-INF/images/root.jpg"); } FileInputStream inputStream=new
	 * FileInputStream(file); byte[] data=new byte[(int)file.length()]; int
	 * length = inputStream.read(data); inputStream.close();
	 * response.setContentType("image/png"); OutputStream stream =
	 * response.getOutputStream(); stream.write(data); stream.flush();
	 * stream.close(); }
	 */
}
