package com.software.test.Controllers;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.software.test.Entity.Author;
import com.software.test.Entity.Bank;
import com.software.test.Entity.Book;
import com.software.test.Entity.Cart;
import com.software.test.Entity.CashDeliInfo;
import com.software.test.Entity.Category;
import com.software.test.Entity.Customer;
import com.software.test.Entity.Delivery;
import com.software.test.Entity.OrderDetail;
import com.software.test.Entity.Orders;
import com.software.test.Entity.UserCard;
import com.software.test.Repository.BankRepository;
import com.software.test.Repository.BookRepository;
import com.software.test.Repository.CashDeliRepository;
import com.software.test.Repository.CategoryRepository;
import com.software.test.Repository.CustomerRepository;
import com.software.test.Repository.DeliveryRepository;
import com.software.test.Repository.OrderDetailRepository;
import com.software.test.Repository.OrdersRepository;
import com.software.test.Repository.UserCardRepository;






@Controller
public class BookStore_Controller {
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private OrderDetailRepository orderdetRepo;
	
	@Autowired
	private OrdersRepository orderRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private UserCardRepository usercardRepo;
	
	@Autowired
	private CashDeliRepository cashdeliRepo;
	
	@Autowired
	private BankRepository bankRepo;
	
	@Autowired
	private DeliveryRepository deliRepo;
	
	@Autowired
	private HttpSession session;
	List<Cart> cartlist = new ArrayList<Cart>();
	//Home Page
	
	@RequestMapping("/homepage")
	public String home() 
	{
		return "home2";
	}
	
	@RequestMapping("/homepage2")
	public String home2() 
	{
		return "home";
	}
	
	
	// Book Detail
	@GetMapping("/books")
	public String showBooks(Model model) 
	{
		List<Book> books = bookRepo.findAll();
		model.addAttribute("books", books);
		model.addAttribute("title", "All books");
		return "books";
	}
	
	@GetMapping("/books2")
	public String showBooks2(Model model) 
	{
		List<Book> books = bookRepo.findAll();
		model.addAttribute("books", books);
		model.addAttribute("title", "All books");
		return "books2login";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/mycart")
	public String myCart(Model model) 
	{
		cartlist = (List<Cart>) session.getAttribute("cartlist");
		int totalPrice = 0;
		if(cartlist != null) 
		{
			for (Cart c:cartlist) 
			{
				totalPrice += c.getPrice() * c.getQuantity();
			}
		}
			
		model.addAttribute("totalprice", totalPrice);
		model.addAttribute("cartlist", cartlist);
		
		return "cartlogin";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/mycart2")
	public String myCart2(Model model) 
	{
		cartlist = (List<Cart>) session.getAttribute("cartlist");
		int totalPrice = 0;
		if(cartlist != null) 
		{
			for (Cart c:cartlist) 
			{
				totalPrice += c.getPrice() * c.getQuantity();
			}
		}
			
		model.addAttribute("totalprice", totalPrice);
		model.addAttribute("cartlist", cartlist);
		
		return "cart";
	}
	
	@GetMapping("/productdetail/{id}")
	public String productdetail(@PathVariable(name="id")Integer id, Model model)
	{
		Book books = bookRepo.findById(id).get();
		/*
		 * Book bookcat = new Book(); bookcat.setCategory(books.getCategory());
		 * bookcat.setImg(books.getImg()); bookcat.setTitle(books.getTitle());
		 * bookcat.setPrice(books.getPrice());
		 * 
		 * model.addAttribute("bookcat", bookcat);
		 */
		model.addAttribute("books", books);
		
		return "productdetail";
		
	}
	
	@GetMapping("/productdetail2/{id}")
	public String productdetail2(@PathVariable(name="id")Integer id, Model model)
	{
		Book books = bookRepo.findById(id).get();
		/*
		 * Book bookcat = new Book(); bookcat.setCategory(books.getCategory());
		 * bookcat.setImg(books.getImg()); bookcat.setTitle(books.getTitle());
		 * bookcat.setPrice(books.getPrice());
		 * 
		 * model.addAttribute("bookcat", bookcat);
		 */
		model.addAttribute("books", books);
		
		return "productdetail2";
		
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/addcart-book/{id}")
	public String addCart(@PathVariable(name="id") Integer id, Model model)
	{	
		boolean flag = false;
		
		Book book = bookRepo.findById(id).get();
		if(session.getAttribute("cartlist")!= null) 
		{
			
			cartlist = (List<Cart>) session.getAttribute("cartlist");
			for (Cart c:cartlist) 
			{
				if(id == c.getId())
				{
					c.setQuantity(c.getQuantity()+1);
					flag = true;
					break;
				}
			}
			if (!flag)
			{
				Cart cart = new Cart();
				cart.setId(book.getId());
				cart.setTitle(book.getTitle());
				cart.setIsbn(book.getIsbn());
				cart.setPrice(book.getPrice());
				cart.setAuthor(book.getAuthor());
				cart.setCategory(book.getCategory());
				cart.setImg(book.getImg());
				cart.setPdfile(book.getPdfile());
				cart.setQuantity(1);
				
				cartlist.add(cart);
				session.setAttribute("cartlist", cartlist);
			}
		}
		else 
		{
			cartlist = new ArrayList<Cart>();
			Cart cart = new Cart();
			cart.setId(book.getId());
			cart.setTitle(book.getTitle());
			cart.setIsbn(book.getIsbn());
			cart.setPrice(book.getPrice());
			cart.setAuthor(book.getAuthor());
			cart.setCategory(book.getCategory());
			cart.setImg(book.getImg());
			cart.setPdfile(book.getPdfile());
			cart.setQuantity(1);
			
			cartlist.add(cart);
			session.setAttribute("cartlist", cartlist);
		}
		return "redirect:/books";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/addcart-book1/{id}")
	public String addCart1(@PathVariable(name="id") Integer id, Model model)
	{	
		boolean flag = false;
		
		Book book = bookRepo.findById(id).get();
		if(session.getAttribute("cartlist")!= null) 
		{
			
			cartlist = (List<Cart>) session.getAttribute("cartlist");
			for (Cart c:cartlist) 
			{
				if(id == c.getId())
				{
					c.setQuantity(c.getQuantity()+1);
					flag = true;
					break;
				}
			}
			if (!flag)
			{
				Cart cart = new Cart();
				cart.setId(book.getId());
				cart.setTitle(book.getTitle());
				cart.setIsbn(book.getIsbn());
				cart.setPrice(book.getPrice());
				cart.setAuthor(book.getAuthor());
				cart.setCategory(book.getCategory());
				cart.setImg(book.getImg());
				cart.setPdfile(book.getPdfile());
				cart.setQuantity(1);
				
				cartlist.add(cart);
				session.setAttribute("cartlist", cartlist);
			}
		}
		else 
		{
			cartlist = new ArrayList<Cart>();
			Cart cart = new Cart();
			cart.setId(book.getId());
			cart.setTitle(book.getTitle());
			cart.setIsbn(book.getIsbn());
			cart.setPrice(book.getPrice());
			cart.setAuthor(book.getAuthor());
			cart.setCategory(book.getCategory());
			cart.setImg(book.getImg());
			cart.setPdfile(book.getPdfile());
			cart.setQuantity(1);
			
			cartlist.add(cart);
			session.setAttribute("cartlist", cartlist);
		}
		return "redirect:/books2";
	}
	
	@GetMapping("/checkout")
	public String checkoutcart(Model model) 
	{
		
		Customer logincheck = (Customer) session.getAttribute("customer");
		if (logincheck == null) 
		{
			return "redirect:/login2";
		}
		else 
		{
			Customer loginCus = (Customer) session.getAttribute("customer"); 
			Orders order = new Orders();
			order.setOrderdate(LocalDate.now());
			order.setCustomer(loginCus);
			int totalPrice = 0;
			if(cartlist != null) 
			{
				for (Cart c:cartlist) 
				{
					totalPrice += c.getPrice() * c.getQuantity();
				}
			}
			
			session.setAttribute("totalprice", totalPrice);
			order.setTotalprice(totalPrice);
			order.setStatus("pending");
			
			
			Orders checkorder = orderRepo.save(order);
			List<OrderDetail> detailList = new ArrayList<OrderDetail>();
			
			
			for (Cart c:cartlist) 
			{
				OrderDetail od = new OrderDetail();
				od.setQuantity(c.getQuantity());
				od.setQuanprice(c.getQuantity() * c.getPrice());
				od.setBook(new Book(c.getId(), c.getTitle(), c.getIsbn(), c.getPrice(), c.getAuthor(), c.getCategory(), c.getImg(), c.getPdfile(), c.getDescription()));
				od.setOrder(order);
				orderdetRepo.save(od);
				detailList.add(od);
			}
			session.setAttribute("orders", order);
			session.setAttribute("orderdetail", detailList);
			model.addAttribute("cashdeli", new CashDeliInfo());
			model.addAttribute("usercard", new UserCard());
			model.addAttribute("checkorder", checkorder);
			return "payment";
		}
		
	}
	
	@GetMapping("/login2")
	public String loginpage2(Model model) {
		model.addAttribute("login", new Customer());
		model.addAttribute("register", new Customer());
		return "account2";
	}
	
	@GetMapping("/login")
	public String loginpage(Model model) {
		model.addAttribute("login", new Customer());
		model.addAttribute("register", new Customer());
		return "account";
	}

	@PostMapping("/cusregis")
	public String customerregister(Customer customer) 
	{

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		customer.setPassword(encoder.encode(customer.getPassword()));
		custRepo.save(customer);
		return "redirect:/login";
	}
	 
	
	
	@PostMapping("/customerLog")
	public String customerlogin(@ModelAttribute Customer customerlogin, Model model) {
		Customer clogin = custRepo.findByEmail(customerlogin.getEmail());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (clogin != null && encoder.matches(customerlogin.getPassword(), clogin.getPassword())) 
		{
			session.setAttribute("customer", clogin);
			return "home2";

		} else {
			model.addAttribute("span", "Error!");
			model.addAttribute("login", new Customer());
			model.addAttribute("register", new Customer());
			return "account";
		}
	}
	
	@PostMapping("/customerLog2")
	public String customerlogin2(@ModelAttribute Customer customerlogin, Model model) {
		Customer clogin = custRepo.findByEmail(customerlogin.getEmail());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (clogin != null && encoder.matches(customerlogin.getPassword(), clogin.getPassword())) 
		{
			session.setAttribute("customer", clogin);
			return "redirect:/mycart";

		} else {
			model.addAttribute("span", "Error!");
			model.addAttribute("login", new Customer());
			model.addAttribute("register", new Customer());
			return "account2";
		}
	}
	
	@GetMapping("/profile/+{id}")
	public String profilepage() 
	{
		/*
		 * List<Customer> customer = custRepo.findAll();
		 * 
		 * model.addAttribute("customer", customer);
		 */
		
		return "profilepage";
	}
	
	@GetMapping("/delete-cart/{id}")
	public String delCart(@PathVariable(name="id") Integer id) {
		List<Cart> cartremove= (List<Cart>) session.getAttribute("cartlist");
		Iterator<Cart> iterator = cartremove.iterator();
		while (iterator.hasNext()) 
		{
			if (iterator.next().getId()==id) {
				iterator.remove();
			}
		}
		
		return "redirect:/mycart2";
	}
	
	@GetMapping("/delete-cart2/{id}")
	public String delCart2(@PathVariable(name="id") Integer id) {
		List<Cart> cartremove= (List<Cart>) session.getAttribute("cartlist");
		Iterator<Cart> iterator = cartremove.iterator();
		while (iterator.hasNext()) 
		{
			if (iterator.next().getId()==id) {
				iterator.remove();
			}
		}
		
		return "redirect:/mycart";
	}
	
	@RequestMapping("/search-book-cat")
	public String searchbc(@RequestParam(name = "cat") String search, Model model) 
	{
		
		if (search.equalsIgnoreCase("Viewall")) {
			List<Book> books = bookRepo.findAll();
			List<Category> categories = catRepo.findAll();
			model.addAttribute("categories", categories);
			model.addAttribute("books", books);
			return "books";
		}
		else {
			List<Book> books = bookRepo.findbycatbookname(search);
			List<Category> categories = catRepo.findAll();
			model.addAttribute("categories", categories);
			model.addAttribute("books", books);
			return "books";
		}
	}
	
	@RequestMapping("/search-book-cat2")
	public String searchbc2(@RequestParam(name = "cat") String search, Model model) 
	{
		
		if (search.equalsIgnoreCase("Viewall")) {
			List<Book> books = bookRepo.findAll();
			List<Category> categories = catRepo.findAll();
			model.addAttribute("categories", categories);
			model.addAttribute("books", books);
			return "books2login";
		}
		else {
			List<Book> books = bookRepo.findbycatbookname(search);
			List<Category> categories = catRepo.findAll();
			model.addAttribute("categories", categories);
			model.addAttribute("books", books);
			return "books2login";
		}
	}
	
	@PostMapping("/usercardinfo")
	public String saveusercardinfo(@RequestParam String payment,@ModelAttribute UserCard usercard, CashDeliInfo cashdeli, Model model) 
	{	
		Integer totalPrice = (Integer) session.getAttribute("totalprice");
		Orders orders = (Orders) session.getAttribute("orders"); 
		List<Cart> cartlist = (List<Cart>) session.getAttribute("cartlist");
		Delivery deli = new Delivery();
		if (payment.equalsIgnoreCase("credit")) 
		{	
			Bank clogin = bankRepo.findbycardnumcvv(usercard.getCardholdernumber(), usercard.getCardcvv());
			if(clogin != null) {
				if (totalPrice < clogin.getBalance()) {
					clogin.setBalance(clogin.getBalance()-totalPrice);
					bankRepo.save(clogin);
					orders.setPayment("Paid");
					orders.getOrderdate();
					orders.getCustomer();
					orders.getStatus();
					orders.getTotalprice();
					orderRepo.save(orders);
					deli.setDeliaddress(usercard.getCardholderaddress());
					deli.setDeliname(usercard.getCardholdername());
					deli.setPhonenumber(usercard.getCardphonenumber());
					deliRepo.save(deli);
					model.addAttribute("orderinfo", orders);
					model.addAttribute("deliinfo", deli);
					model.addAttribute("cartlist", cartlist);
					return "receipt";
				}
				else {
					model.addAttribute("span", "Balance not enough!");
					return "redirect:/checkout";
				}
				
			}
			else {
				model.addAttribute("span", "Incorrect Card Number or CVV!");
				return "redirect:/checkout";
			}
			
		} else {
			cashdeliRepo.save(cashdeli);
			orders.setPayment("Unpaid");
			orders.getOrderdate();
			orders.getCustomer();
			orders.getStatus();
			orders.getTotalprice();
			deli.setDeliaddress(cashdeli.getCusaddress());
			deli.setDeliname(cashdeli.getCusname());
			deli.setPhonenumber(cashdeli.getCusnumber());
			deliRepo.save(deli);
			orderRepo.save(orders);
			model.addAttribute("orderinfo", orders);
			model.addAttribute("deliinfo", deli);
			model.addAttribute("cartlist", cartlist);
			return "receipt";
		}
		 
	}
	
	@RequestMapping("/receipt")
	public String showreceipt() {
		return "receipt";
	}
	
	@GetMapping("/logout")
	public String customerLogout(Model model) 
	{
		session.removeAttribute("orderdetail");
		session.removeAttribute("orders");
		session.removeAttribute("customer");
		session.removeAttribute("cartlist");
		session.removeAttribute("totalprice");
		session.removeAttribute("customer");
		return"redirect:/homepage2";
	}
	
	@GetMapping("/logout2")
	public String customerLogout2(Model model) 
	{
		session.removeAttribute("orderdetail");
		session.removeAttribute("orders");
		session.removeAttribute("customer");
		session.removeAttribute("cartlist");
		session.removeAttribute("totalprice");
		session.removeAttribute("customer");	
		return"home";
	}
	/*
	 * @RequestMapping("/payment") public String paymentpage(Model model) { Customer
	 * cuscheck = (Customer) session.getAttribute("customer");
	 * 
	 * Orders order = orderRepo.findById(cuscheck.getId()).get(); List<OrderDetail>
	 * datalist = orderdetRepo.findByOrderId(cuscheck.getId());
	 * 
	 * model.addAttribute("datalist", datalist); model.addAttribute("order", order);
	 * 
	 * return "payment"; }
	 */
}
