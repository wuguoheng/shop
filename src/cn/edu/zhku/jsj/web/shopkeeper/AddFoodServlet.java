package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;

import cn.edu.zhku.jsj.daomain.Food;
import cn.edu.zhku.jsj.formbean.FoodFormBean;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.WebUtil;

@WebServlet("/servlet/AddFoodServlet")
public class AddFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String imgsavepath = this.getServletContext().getRealPath("/images");
			try {
				Map map2 = WebUtil.doUploadFood(request, imgsavepath);
				FoodFormBean formbean = (FoodFormBean) map2.get("formbean");
				if(formbean!=null){
					request.setAttribute("errormap", formbean.getErrormap());
					request.getRequestDispatcher("/pages/addFood.jsp").forward(request, response);
					return;
				}else{
					Food food = (Food) map2.get("food");
					//图片 由于用 UUID 名  数据库 存放路径 大小设为 255 最多 可能只能存 5张图片
					
					
food.setStore_id(1);//测试用 由于 还没有店主登录进来  所以先 手动 赋值为 一个存在的店铺  到时候要删除！！


					BusinessService bus = new BusinessServiceImpl();
					int num = bus.addFood(food);
					if(num!=0){
						request.setAttribute("message", "商品上架成功,3秒后返回 <meta http-equiv='refresh' content='3;url=/shop/pages/store.jsp'");
						request.setAttribute("prepath", "/pages/store.jsp");
						request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
						return;
					}

				}
			} catch (FileSizeLimitExceededException e) {
				e.printStackTrace();
				request.setAttribute("message", "文件太大！");
				request.setAttribute("prepath", "/pages/addFood.jsp");
				request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
				return;
			}
	}

}