package by.issoft.tempapp.webroot.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Data
public class InfoDto {

    private LocalDateTime time = LocalDateTime.now();
    private UUID uuid = UUID.randomUUID();
    private int random = new Random().nextInt();
    private String msg;

}
