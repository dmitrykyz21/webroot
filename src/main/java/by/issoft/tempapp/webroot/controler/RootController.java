package by.issoft.tempapp.webroot.controler;

import by.issoft.tempapp.webroot.dto.InfoDto;
import by.issoft.tempapp.webroot.service.ChildMsgService;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @Resource private ChildMsgService childMsgService;

    @GetMapping("/root-info")
    public InfoDto getInfo(){

        final InfoDto infoDto = new InfoDto();
        final String msg = childMsgService.getMsg();
        infoDto.setMsg(msg);

        return infoDto;
    }

}
