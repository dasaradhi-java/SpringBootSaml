/*
 * package samlConfiguration;
 * 
 * import org.springframework.security.core.annotation.AuthenticationPrincipal;
 * import org.springframework.security.saml2.provider.service.authentication.
 * Saml2AuthenticatedPrincipal; import org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * @RestController public class HomeController {
 * 
 * 
 * @RequestMapping("/") public String home(@AuthenticationPrincipal
 * Saml2AuthenticatedPrincipal principal, Model model) {
 * model.addAttribute("name", principal.getName()); String email =
 * principal.getFirstAttribute("email"); if (email == null) { email =
 * principal.getFirstAttribute(
 * "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/emailaddress"); }
 * model.addAttribute("userAttributes", principal.getAttributes());
 * System.out.println("hello world"); return "home"; }
 * 
 * @GetMapping("/hello") public String helloworld() { return "hellow world"; }
 * 
 * }
 */

