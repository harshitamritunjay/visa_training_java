package com.visa.prj.client;

import java.util.List;

import com.visa.prj.dao.DaoException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJpaImpl;
import com.visa.prj.entity.Product;

public class InsertClient {

	public static void main(String agrs[]) {
		ProductDao dao = new ProductDaoJpaImpl();

		// Transient state of object "p"
		Product p = new Product(0, "Dell Laptop", 705000.00, 200);
		try {
	
			dao.addProduct(p);
			
			List<Product> products=dao.getProducts();
			for(Product prd:products) {
				System.out.println(prd);
			}
		} catch (DaoException e) {

			e.printStackTrace();
		}
		/*while(true) {
			print();
			
			int choice = KeyboardUtil.getInt("Select option: ");
			if(choice==1) {
				ProductDao dao=new ProductDaoJpaImpl();
				Product p= new Product(0,"Dell new laptop",432000,100);
				try {
					dao.addProduct(p);
				}catch(DaoException e) {
					e.printStackTrace();
				}
			}
			else if(choice==2) {
				ProductDao dao= new ProductDaoJpaImpl();
				try {
					dao.deleteProduct(5);
				}catch(DaoException e) {
					e.printStackTrace();
				}
			}else if(choice==3) {
				ProductDao dao= new ProductDaoJpaImpl();
				try {
					List<Product> products=dao.getProducts();
					for(Product prd:products) {
						System.out.println(prd);
					}
				} catch (DaoException e) {

					e.printStackTrace();
				}
				
			}
			else if(choice==4) {
				ProductDao dao= new ProductDaoJpaImpl();
				Product p= new Product(6,"hello laptop",123400,190);
				try {
					dao.updateProduct(p);
				} catch (DaoException e) {
					
					e.printStackTrace();
				}
			}
			else if(choice==5){
				System.exit(0);
			}
		}
*/	}
	private static void print()
	{
		System.out.println("1: Add Product");
		System.out.println("2:Delete Product");
		System.out.println("3: Get products");
		System.out.println("4:Update product ");
		System.out.println("5: Exit");
	}
}
