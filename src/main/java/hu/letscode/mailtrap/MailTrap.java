package hu.letscode.mailtrap;

import java.util.List;

import feign.RequestLine;

public interface MailTrap {

    @RequestLine("GET /api/v1/inbox/{inboxId}/messages")
    List<Message> messages(String inboxId);

}
