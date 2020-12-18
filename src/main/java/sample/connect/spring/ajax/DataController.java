package sample.connect.spring.ajax;

import com.atlassian.connect.spring.AtlassianHostUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.connect.spring.ajax.repository.CompanyRepository;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class DataController {

    private CompanyRepository companyRepository;
    @Autowired
    public DataController(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }
    @RequestMapping(value = "/data", method = GET, produces = "application/json")
    public AtlassianHostUser getData(@AuthenticationPrincipal AtlassianHostUser hostUser) {
        return hostUser;
    }
}
