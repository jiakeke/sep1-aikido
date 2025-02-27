import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AikidoTrackerTest {

    @Test
    public void testAikidoTrackerConstructor() {
        AikidoTracker tracker = new AikidoTracker("Gary Blue", "2023-01-01");
        assertEquals("Gary Blue", tracker.getName());
        assertEquals("2023-01-01", tracker.getStart().toString());
    }

    @Test
    public void testAddSession() {
        AikidoTracker tracker = new AikidoTracker("Gary Blue", "2023-01-01");
        tracker.addSession("2021-01-01", 60);
        assertEquals(1, tracker.getSessions());
        assertEquals(60, tracker.getDurations());
    }

    @Test
    public void testIsEligibleForKyu() {
        AikidoTracker tracker = new AikidoTracker("Gary Blue", "2025-01-01");
        assertFalse(tracker.isEligibleForKyu());
        tracker.addSession("2021-01-01", 60);
        assertFalse(tracker.isEligibleForKyu());
        tracker.addSession("2021-02-01", 60);
        assertFalse(tracker.isEligibleForKyu());
        for (int i = 0; i < 99; i++) {
            tracker.addSession("2025-01-10", 60);
        }
        System.out.println(tracker.getSessions());
        assertTrue(tracker.isEligibleForKyu());

        AikidoTracker tracker2 = new AikidoTracker("Gary Blue", "2021-01-01");
        assertFalse(tracker2.isEligibleForKyu());
        tracker2.addSession("2021-03-01", 60);
        assertTrue(tracker2.isEligibleForKyu());
    }

}
