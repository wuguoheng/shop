package junit.test;

import java.util.List;

import org.junit.Test;

import cn.edu.zhku.jsj.dao.impl.FoodDaoImpl;
import cn.edu.zhku.jsj.daomain.Food;

public class FoodDaoTest {
	FoodDaoImpl fooddao = new FoodDaoImpl();
/*	@Test
	public void addfoodtest(){
		Food food = new Food();
		food.setFoodname("五只松鼠");
		food.setPrice(15);
		food.setTotalnum(200);
		food.setImages("d://8.jpg");
		food.setDescription("好好好吃啊");
		food.setStore_id(1);
		fooddao.add(food);
	}
	@Test
	public void findTest(){
		List<Food> food = fooddao.find("猪肉");
		System.out.println(food.get(0));
	}
	
	@Test
	public void findAll(){
		System.out.println(fooddao.findAll());
	}
	
	@Test
	public void updateTest(){
		Food food = new Food();
		food.setFood_id(2);
		food.setTotalnum(250);
		food.setPrice(20);
		food.setDescription("真的好吃啊，快来啊");
		fooddao.update(food);
	}
	
	@Test
	public void deleteTest(){
		fooddao.delete(2);
	}*/
	@Test
	public void findtest(){
		fooddao.findAll().get(0).getFoodname();
	}
}
