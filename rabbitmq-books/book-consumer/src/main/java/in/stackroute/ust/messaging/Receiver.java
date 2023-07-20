package in.stackroute.ust.messaging;

import in.stackroute.ust.Dto.BookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

    @Component
    public class Receiver {
        private Logger logger = LoggerFactory.getLogger(Receiver.class);
        public void receiveMessage(BookDto book){
            logger.info("Received message: " + book);
        }
    }
