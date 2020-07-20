package net.mefmor.itf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignMockController {
    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("design", new Mock());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Mock design, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }
}
