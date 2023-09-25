package vn.fpt.edu.cinema.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.fpt.edu.cinema.dto.request.account.CreateAccountRequest;
import vn.fpt.edu.cinema.dto.request.account.LoginRequest;
import vn.fpt.edu.cinema.dto.response.ImageResponse;
import vn.fpt.edu.cinema.dto.response.LoginResponse;
import vn.fpt.edu.cinema.dto.response.SeatStatusResponse;
import vn.fpt.edu.cinema.entity.Account;
import vn.fpt.edu.cinema.service.AccountService;
import vn.fpt.edu.cinema.service.TheaterService;
import vn.fpt.edu.cinema.service.impl.ImageService;
import vn.fpt.edu.cinema.service.impl.SeatService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/testFE")
public class TestFEController {
    @Autowired
    AccountService accountService;

    @Autowired
    SeatService seatService;

    @Autowired
    ImageService imageService;

    @Autowired
    TheaterService theaterService;


    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/login")
    public String testFELogin(){
        return "login";
    }

    @PostMapping("/view")
    public String dashBoardAdmin(HttpSession session, Model model,
                                 @RequestParam(value = "user-email") String userName,
                                 @RequestParam(value = "user-password") String passWord) {
        if (userName.trim().equals("") || passWord.trim().equals("")) {
            model.addAttribute("errorMessage", "Sai tên đăng nhập");
            return "login";
        }
        LoginResponse user = accountService.login(LoginRequest.builder()
                .emailOrUsername(userName)
                .password(passWord)
                .build());
        if (user == null) {
            model.addAttribute("errorMessage", "Sai tên đăng nhập");
            return "login";
        }

        model.addAttribute("user", user);
        List<ImageResponse> filmsViewImages = imageService.getImagePublicUrl("view_film");
        model.addAttribute("films", filmsViewImages);
        session.setAttribute("user", user);

        return viewDashBoard(session, model);
    }

    @GetMapping("view/home")
    public String viewDashBoard(HttpSession session, Model model) {
        LoginResponse user = (LoginResponse) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("errorMessage", "Chưa đăng nhập !!!");
            return "login";
        }
        if (user.getRoles().equals("ADMIN") || user.getRoles().equals("STAFF")) {
            return "Admin";
        }
        model.addAttribute("user", accountService.getAccountDetail(user.getAccountId()));
        model.addAttribute("isLoggedIn", 1);
        model.addAttribute("lstTheater", theaterService.getAllTheater(PageRequest.of(0, 8)).toList());
        return "listCinema";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        if (user == null) {
            model.addAttribute("errorMessage", "Chưa đăng nhập !!!");
            return "login";
        } else {
            session.removeAttribute("user");
            return "login";
        }
    }


    @PostMapping("/regis")
    public String dashBoardAdmin(HttpSession session, Model model,
                                 @RequestParam(value = "user-name") String userName,
                                 @RequestParam(value = "user-email") String email,
                                 @RequestParam(value = "user-password") String password,
                                 @RequestParam(value = "user-fullname") String fullName) {
        accountService.createAccount(CreateAccountRequest.builder()
                .email(email)
                .password(password)
                .fullName(fullName)
                .username(userName)
                .build());
        return "login";
    }

    @GetMapping("/register")
    public String testFERegister(){
        return "register";
    }
    @GetMapping("/home")
    public String testFEHome(Model model){
        Account user = new Account();
        // Check if user.getFullName is null
        if (user.getFullName() == null) {
            // User is not logged in
            model.addAttribute("isLoggedIn", 0);
        } else {
            // User is logged in
            model.addAttribute("isLoggedIn", 1);
        }
        List<ImageResponse> filmsViewImages = imageService.getImagePublicUrl("view_film");
        model.addAttribute("films", filmsViewImages);
        model.addAttribute("user", user);
        return "home";
    }
    @GetMapping("/book_sits")
    public String bookSits(HttpSession session, Model model){
        Map<String, List<SeatStatusResponse>> seats = seatService.getSeats(session);
        model.addAttribute("seats", seats);
        return "book2";
    }
    @GetMapping("/edit_information")
    public String editInfor(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "editinfor";
    }
    @GetMapping("/list_film")
    public String listfilm(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "listfilm";
    }
    @GetMapping("/detail_film")
    public String detailFilm(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "detailfilm";
    }
    @GetMapping("/detail_user")
    public String detailUser(HttpSession session, Model model){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        model.addAttribute("user", accountService.getAccountDetail(user.getAccountId()));
        model.addAttribute("isLoggedIn", 1);
        return "detailsacc";
    }
    @GetMapping("/admin")
    public String admin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "Admin";
    }
    @GetMapping("/book_sits3")
    public String bookSits3(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "book3-buy";
    }

    @GetMapping("/book_sits_final")
    public String bookSitsFinal(HttpSession session){
        return "book-final";
    }
    @GetMapping("/list_cinema")
    public String listCinema(HttpSession session){

        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "listCinema";
    }
    @GetMapping("/detail_cinema")
    public String detailCinema(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "detailsCinema";
    }

    @GetMapping("/list_film_admin")
    public String listFilmAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "listFilm-Admin";
    }

    @GetMapping("/booking_admin")
    public String bookingAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "booking-admin";
    }
    @GetMapping("/customerAdmin")
    public String customerAdmin(HttpSession session) {
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "customer-admin";
    }
    @GetMapping("/ticket_admin")
    public String ticketAdmin(HttpSession session)
    {
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "ticket-admin";
    }
    @GetMapping("/room_admin")
    public String roomAdmin(HttpSession session)
    {
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "room-admin";
    }
    @GetMapping("/schedule_admin")
    public String scheduleAdmin(HttpSession session)
    {
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "schedule-admin";
    }
    @GetMapping("/seat_admin")
    public String seatAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "seat-admin";
    }
    @GetMapping("/payment_admin")
    public String paymentAdmin(HttpSession session){

        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "payment-admin";
    }
    @GetMapping("/slot_admin")
    public String slotAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "slot-admin";
    }

    @GetMapping("/member_admin")
    public String memberAdmin(HttpSession session)
    {
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "member-admin";
    }
    @GetMapping("/theater_admin")
    public String theaterAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "theater-admin";
    }


    @GetMapping("/create_booking_admin")
    public String createBookingAdmin(HttpSession session){

        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "createBookingAdmin";
    }
    @GetMapping("/create_customer_admin")
    public String createCustomerAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "createCustomerAdmin";
    }
    @GetMapping("/create_list_film_admin")
    public String createListFilmAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "createListFilmAdmin";
    }
    @GetMapping("/create_member_admin")
    public String createMemberAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "createMemberAdmin";
    }
    @GetMapping("/create_payment_admin")
    public String createPaymentAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "createPaymentAdmin";
    }
    @GetMapping("/create_room_admin")
    public String createRoomAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "createRoomAdmin";
    }

    @GetMapping("/create_schedule_admin")
    public String createScheduleAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "createScheduleAdmin";
    }

    @GetMapping("/create_seat_admin")
    public String createSeatAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "createSeatAdmin";
    }

    @GetMapping("/create_slot_admin")
    public String createSlotAdmin(HttpSession session)
    {
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "createSlotAdmin";
    }

    @GetMapping("/create_theater_admin")
    public String createTheaterAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "createTheaterAdmin";
    }

    @GetMapping("/create_ticket_admin")
    public String createTicketAdmin(HttpSession session){
        LoginResponse user = objectMapper.convertValue(session.getAttribute("user"), LoginResponse.class);
        return "createTicketAdmin";
    }
}


