package com.example.prescription.controller;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TwoFactorAuthController {

    private final GoogleAuthenticator gAuth = new GoogleAuthenticator();

    @GetMapping("/2fa")
    public String twoFactorAuthPage(Model model, HttpSession session) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        GoogleAuthenticatorKey key = gAuth.createCredentials();
        session.setAttribute("2fa_secret", key.getKey());
        String qrUrl = GoogleAuthenticatorQRGenerator.getOtpAuthURL("MyApp", username, key);
        model.addAttribute("qrUrl", qrUrl);
        return "2fa";
    }

    @PostMapping("/error")
    public String error(HttpServletRequest request){
        return "error";
    }

    @PostMapping("/verify-2fa")
    public String verifyTwoFactorAuth(@RequestParam("code") String code, HttpSession session) {
        String secret = (String) session.getAttribute("2fa_secret");

        // Parse the code as an integer
        int verificationCode = Integer.parseInt(code);

        if (gAuth.authorize(secret, verificationCode)) {
            session.removeAttribute("2fa_secret");
            session.setAttribute("2fa_authenticated", true);
            // Redirect to the page you want to go after successful verification
            return "redirect:/";
        } else {
            // Redirect back to the 2FA page with an error parameter
            return "redirect:/2fa?error";
        }
    }

}
