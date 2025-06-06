import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class NotificationService {
    @Autowired private NotificationRepository notificationRepo;

    public void send(User recipient, String message) {
        Notification note = new Notification();
        note.setRecipient(recipient);
        note.setMessage(message);
        note.setIsRead(false);
        note.setTimestamp(LocalDateTime.now());
        notificationRepo.save(note);
    }

    public List<Notification> getNotifications(Long userId) {
        return notificationRepo.findByRecipientIdOrderByTimestampDesc(userId);
    }

    public void markAsRead(Long notificationId) {
        Notification note = notificationRepo.findById(notificationId).orElseThrow();
        note.setIsRead(true);
        notificationRepo.save(note);
    }
}
