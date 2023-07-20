package in.stackroute.messaging;

import in.stackroute.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private Logger logger = LoggerFactory.getLogger(Receiver.class);
    public void receiveMessage(MessageDto message){
        logger.info("Received message: " + message);
    }
}
