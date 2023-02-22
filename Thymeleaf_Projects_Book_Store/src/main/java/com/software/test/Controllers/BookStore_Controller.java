package com.software.test.Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.software.test.Entity.Admin;
import com.software.test.Entity.Author;
import com.software.test.Entity.Book;
import com.software.test.Entity.Category;
import com.software.test.Entity.Customer;
import com.software.test.Entity.Income;
import com.software.test.Entity.OrderDetail;
import com.software.test.Entity.Orders;
import com.software.test.Entity.User;
import com.software.test.Repository.AdminRepository;
import com.software.test.Repository.AuthorRepository;
import com.software.test.Repository.BookRepository;
import com.software.test.Repository.CategoryRepository;
import com.software.test.Repository.CustomerRepository;
import com.software.test.Repository.OrderDetailRepository;
import com.software.test.Repository.OrdersRepository;
import com.software.test.Repository.UserRepository;

@Controller
public class BookStore_Controller {
	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private AuthorRepository authRepo;

	@Autowired
	private CategoryRepository catRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CustomerRepository custRepo;

	@Autowired
	private OrderDetailRepository orderdetRepo;

	@Autowired
	private OrdersRepository orderRepo;

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private HttpSession session;

	// Home Page

	@RequestMapping("/homepage")
	public String home() {
		return "home";
	}

	// Author Detail
	@GetMapping("/authorsform")
	public String authorsform(Model model) {
		model.addAttribute("author", new Author());
		model.addAttribute("title", "New Author Form");
		return "author";
	}

	@PostMapping("/authorSave")
	public String saveAuthor(Author author) {
		authRepo.save(author);
		return "success";
	}

	@GetMapping("/authortable")
	public String showAuthors(Model model, HttpServletRequest request) {
		//pagination
		/*
		 * int page = 0; int size = 2;
		 * 
		 * if (request.getParameter("page") != null &&
		 * !request.getParameter("page").isEmpty()) { page =
		 * Integer.parseInt(request.getParameter("page")) - 1; }
		 * 
		 * if (request.getParameter("size") != null &&
		 * !request.getParameter("size").isEmpty()) { page =
		 * Integer.parseInt(request.getParameter("size")); }
		 * 
		 * model.addAttribute("authors",authRepo.findAll(PageRequest.of(page, size)));
		 */
		List<Author> authors = authRepo.findAll();
		model.addAttribute("authors", authors);
		model.addAttribute("title", "All Authors");

		return "authortable";
	}

	@GetMapping("/edit-auth/{id}")
	public String editAuthor(@PathVariable(name = "id") Integer id, Model model) {
		List<Author> authlist = authRepo.findAll();
		model.addAttribute("authlist", authlist);
		model.addAttribute("author", authRepo.findById(id));
		return "updateAuthor";
	}

	@RequestMapping("/update-auth")
	public String updatePlayer(@ModelAttribute Author author) {
		Author updateauthor = authRepo.findById(author.getId()).get();
		updateauthor.setName(author.getName());
		updateauthor.setPassword(author.getPassword());
		updateauthor.setEmail(author.getEmail());
		updateauthor.setDateBirth(author.getDateBirth());
		authRepo.save(updateauthor);
		return "redirect:/authortable";
	}

	@GetMapping("/delete-auth/{id}")
	public String delAuth(@PathVariable(name = "id") Integer id) {
		authRepo.deleteById(id);
		return "redirect:/authortable";
	}

	@RequestMapping("/search-author")
	public String searchauthor(@RequestParam(name = "search") String search, Model model) {
		List<Author> author = authRepo.findbyname(search);
		model.addAttribute("authors", author);
		return "authortable";

	}

	// Category Detail
	@GetMapping("/categoryform")
	public String showCategoryForm(Model model) {
		model.addAttribute("title", "New Category Form");
		model.addAttribute("category", new Category());
		return "category";
	}

	@PostMapping("/categorysave")
	public String saveCategory(Category category) {
		catRepo.save(category);
		return "success";
	}

	@GetMapping("/categorytable")
	public String showCategories(Model model) {
		List<Category> categories = catRepo.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("title", "All categories");
		return "categories";
	}

	@GetMapping("/edit-cat/{id}")
	public String editCategory(@PathVariable(name = "id") Integer id, Model model) {
		List<Category> catlist = catRepo.findAll();
		model.addAttribute("catlist", catlist);
		model.addAttribute("category", catRepo.findById(id));
		return "updateCategory";
	}

	@RequestMapping("/update-cat")
	public String updatePlayer(@ModelAttribute Category category) {
		Category updatecategory = catRepo.findById(category.getId()).get();
		updatecategory.setName(category.getName());
		catRepo.save(updatecategory);
		return "redirect:/categorytable";
	}

	@GetMapping("/delete-cat/{id}")
	public String delCat(@PathVariable(name = "id") Integer id) {
		catRepo.deleteById(id);
		return "redirect:/categorytable";
	}

	@RequestMapping("/search-category")
	public String searchcat(@RequestParam(name = "search") String search, Model model) {
		List<Category> categories = catRepo.findbyname(search);
		model.addAttribute("categories", categories);
		return "categories";

	}

	// Book Detail
	@GetMapping("/books")
	public String showBooks(Model model, HttpServletRequest request) {
		
		/*
		 * //pagination int page = 0; int size = 4;
		 * 
		 * if (request.getParameter("page") != null &&
		 * !request.getParameter("page").isEmpty()) { page =
		 * Integer.parseInt(request.getParameter("page")) - 1; }
		 * 
		 * if (request.getParameter("size") != null &&
		 * !request.getParameter("size").isEmpty()) { page =
		 * Integer.parseInt(request.getParameter("size")); }
		 */
		
		List<Book> books = bookRepo.findAll();
	    //model.addAttribute("books",bookRepo.findAll(PageRequest.of(page, size)));
		model.addAttribute("books", books);
		model.addAttribute("title", "All books");
		return "books";
	}

	@GetMapping("/bookform")
	public String showBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("title", "New Book");
		List<Category> categories = catRepo.findAll();
		List<Author> authors = authRepo.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("authors", authors);
		return "book";
	}

	@PostMapping("/booksave")
	public String saveBook(Book book, @RequestParam("picture") MultipartFile pfile,
			@RequestParam("pdf") MultipartFile pdfile) throws IOException {
		String fname = StringUtils.cleanPath(pfile.getOriginalFilename());
		String pname = StringUtils.cleanPath(pdfile.getOriginalFilename());
		String uploadDir = "uploads/";
		book.setImg(fname);
		book.setPdfile(pname);
		Path fpath = Paths.get(uploadDir);
		Path uploadedFile = null;
		Path uploadedFile2 = null;
		if (!Files.exists(fpath)) {
			Path upPath = Files.createDirectories(fpath);
			uploadedFile = upPath.resolve(fname);
			uploadedFile2 = upPath.resolve(pname);
			Files.copy(pfile.getInputStream(), uploadedFile, StandardCopyOption.REPLACE_EXISTING);
			Files.copy(pdfile.getInputStream(), uploadedFile2, StandardCopyOption.REPLACE_EXISTING);
		} else {
			// store the uploaded file in the path
			uploadedFile = fpath;
			uploadedFile2 = fpath;
			// Store the uploaded file onto the server
			uploadedFile = uploadedFile.resolve(fname);
			uploadedFile2 = uploadedFile2.resolve(pname);
			Files.copy(pfile.getInputStream(), uploadedFile, StandardCopyOption.REPLACE_EXISTING);
			Files.copy(pdfile.getInputStream(), uploadedFile2, StandardCopyOption.REPLACE_EXISTING);
			bookRepo.save(book);
		}
		return "success";
	}

	@GetMapping("/edit-book/{id}")
	public String editBook(@PathVariable(name = "id") Integer id, Model model) {
		List<Book> booklist = bookRepo.findAll();
		List<Category> categories = catRepo.findAll();
		List<Author> authors = authRepo.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("authors", authors);
		model.addAttribute("booklist", booklist);
		model.addAttribute("book", bookRepo.findById(id));
		return "updateBook";
	}

	@PostMapping("/update-book")
	public String updateBook(@ModelAttribute Book book ,@RequestParam("picture") MultipartFile pfile,
			@RequestParam("pdf") MultipartFile pdfile) throws IOException {
		Book updatebook = bookRepo.findById(book.getId()).get();
		updatebook.setTitle(book.getTitle());
		updatebook.setIsbn(book.getIsbn());
		updatebook.setPrice(book.getPrice());
		updatebook.setAuthor(book.getAuthor());
		updatebook.setCategory(book.getCategory());
		updatebook.setImg(book.getImg());
		updatebook.setPdfile(book.getPdfile());
		updatebook.setDescription(book.getDescription());
		bookRepo.save(updatebook);
		
		String fname = StringUtils.cleanPath(pfile.getOriginalFilename());
		String pname = StringUtils.cleanPath(pdfile.getOriginalFilename());
		String uploadDir = "uploads/";
		book.setImg(fname);
		book.setPdfile(pname);
		Path fpath = Paths.get(uploadDir);
		Path uploadedFile = null;
		Path uploadedFile2 = null;
		if (!Files.exists(fpath)) {
			Path upPath = Files.createDirectories(fpath);
			uploadedFile = upPath.resolve(fname);
			uploadedFile2 = upPath.resolve(pname);
			Files.copy(pfile.getInputStream(), uploadedFile, StandardCopyOption.REPLACE_EXISTING);
			Files.copy(pdfile.getInputStream(), uploadedFile2, StandardCopyOption.REPLACE_EXISTING);
		} else {
			// store the uploaded file in the path
			uploadedFile = fpath;
			uploadedFile2 = fpath;
			// Store the uploaded file onto the server
			uploadedFile = uploadedFile.resolve(fname);
			uploadedFile2 = uploadedFile2.resolve(pname);
			Files.copy(pfile.getInputStream(), uploadedFile, StandardCopyOption.REPLACE_EXISTING);
			Files.copy(pdfile.getInputStream(), uploadedFile2, StandardCopyOption.REPLACE_EXISTING);
			bookRepo.save(book);
		}
		return "redirect:/books";
	}

	@GetMapping("/delete-book/{id}")
	public String delbook(@PathVariable(name = "id") Integer id) {
		bookRepo.deleteById(id);
		return "redirect:/books";
	}

	@RequestMapping("/search-book")
	public String searchbook(@RequestParam(name = "search") String search, Model model) {
		List<Book> books = bookRepo.findbyname(search);
		model.addAttribute("books", books);
		return "books";

	}

	@GetMapping("/vieworder")
	public String viewOrder(Model model) {

		List<Orders> orders = orderRepo.findAll();
		model.addAttribute("orders", orders);
		return "orderdetails";
	}

	@GetMapping("/orderdetail/{id}")
	public String orderDetail(Model model, @PathVariable(name = "id") Integer id) {
		Orders order = orderRepo.findById(id).get();
		List<OrderDetail> datalist = orderdetRepo.findByOrderId(id);

		model.addAttribute("datalist", datalist);
		model.addAttribute("order", order);
		return "detailorder";

//		List<OrderDetail> orderdetail = orderdetRepo.findAll();
//		model.addAttribute("orderdetail", orderdetail);
//		return "detailorder";
	}

	@GetMapping("/confirmstatus/{id}")
	public String confirmStatus(@PathVariable(name = "id") Integer id, @ModelAttribute Orders order) {
		Orders confirmorder = orderRepo.findById(id).get();
		confirmorder.setStatus("confirm");
		confirmorder.setPayment("Paid");
		orderRepo.save(confirmorder);
		return "redirect:/vieworder";
	}

	@RequestMapping("/adminloginform")
	public String adminloginform(Model model) {
		model.addAttribute("adminlogin", new Admin());
		return "adminlogin";
	}

	@PostMapping("/adminloginsave")
	public String adminlogin(@ModelAttribute Admin adminlogin, Model model) {
		Admin alogin = adminRepo.findbyuserandpass(adminlogin.getUsername(), adminlogin.getPassword());
		// Admin admin = adminRepo.findByEmail(adminlogin.getEmail());
		if (alogin != null) {
			session.setAttribute("admin", alogin);
			return "home";
		} else {
			model.addAttribute("span", "Error!");
			model.addAttribute("adminlogin", new Admin());
			return "adminlogin";
		}
//		return "home";
	}

	@GetMapping("/dailyincome")
	public String dailyincome(Model model) {
		Map<LocalDate, Integer> dailyMap = new HashMap<LocalDate, Integer>();
		List<Income> incomelist = orderRepo.findbydailyincome();

		
		for (Income income : incomelist) 
		{
			dailyMap.put(income.getOrderDate(), income.getTotalPrice());
		}
		 
		model.addAttribute("dailyMap", dailyMap);
		model.addAttribute("incomelist", incomelist);

		return "income";
	}

	@GetMapping("/monthlyincome")
	public String monthlyincome(Model model) {
		Map<String, Integer> monthlyMap = new HashMap<String, Integer>();
		List<Income> incomelist = orderRepo.findbymonthlyincome();

		for (Income income : incomelist) {
			monthlyMap.put(income.getMonth()+ "-" +income.getYear(), income.getTotalPrice());
		}
		model.addAttribute("monthlyMap", monthlyMap);
		model.addAttribute("incomelist", incomelist);
		return "income2";

	}

	@GetMapping("/yearlyincome")
	public String yearlyincome(Model model) {
		Map<String, Integer> yearlyMap = new HashMap<String, Integer>();
		List<Income> incomelist = orderRepo.findbyyearlyincome();

		for (Income income : incomelist) {
			yearlyMap.put(income.getYear(), income.getTotalPrice());
		}
		model.addAttribute("yearlyMap", yearlyMap);
		model.addAttribute("incomelist", incomelist);
		return "income3";

	}

	@GetMapping("/logout")
	public String LogoutAdmin(Model model) {
		session.removeAttribute("admin");
		return "redirect:/adminloginform";
	}
	
	@GetMapping("/cusinfo")
	public String showCustomer(Model model) {
		List<Customer> cus = custRepo.findAll();
		model.addAttribute("customer", cus);
		
		return "customertable";
	}
	
//	//User Controller
//	@GetMapping("/register")
//	public String showRegisterform(Model model) {
//		model.addAttribute("user", new User());
//		return "register";
//	}
//	
//	@PostMapping("/user/save")
//	public String saveUser(User user) {
//		System.out.println(user.getUsername());
//		System.out.println(user.getPassword());
//		System.out.println(user.getRole());
//		
//		String pwd = user.getPassword();
//		BCryptPasswordEncoder bencoder = new BCryptPasswordEncoder();
//		String enPassword = bencoder.encode(pwd);
//		user.setPassword(enPassword);
//		userRepo.save(user);
//		return "success";
//	}
}
