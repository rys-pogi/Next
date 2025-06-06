import org.springframework.data.jpa.repository.JpaRepository;


public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findByStaffIdAndIsBookedFalse(Long staffId);
}
