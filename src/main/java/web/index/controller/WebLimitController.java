package web.index.controller;

import com.base.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/webLimit")
public class WebLimitController extends BaseController {

	@RequestMapping("/goManager")
	public String goList() {
		return "index/manager";
	}
	
	@RequestMapping("/toUpload")
    //@ResponseBody 返回json数据
    public String toUpload() {
    	log.error("到了");
        return "test/upload/upload";
    }
}
