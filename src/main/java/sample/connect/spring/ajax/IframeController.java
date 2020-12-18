package sample.connect.spring.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IframeController {

    @RequestMapping(value = "/iframe", method = RequestMethod.GET)
    public String getIframe() {
        return "iframe";
    }
}
