package ru.ac.uniyar.testingcourse.conference;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testing {

    private Conference conference;
    private Participant participant1;
    private Participant participant2;

    @BeforeEach
    void setUp() {
        conference = new ConferenceImpl();
        participant1 = new Participant("John", "Doe", "john.doe@example.com");
        participant2 = new Participant("Jane", "Smith", "jane.smith@example.com");
    }

    @Test
    void testRegisterParticipant() {
        assertDoesNotThrow(() -> conference.register(participant1, 100));
    }

    @Test
    void testRegisterParticipantAlreadyRegistered() {
        conference.register(participant1, 100);
        assertThrows(Conference.AlreadyRegistredException.class, () -> conference.register(participant1, 100));
    }

    @Test
    void testRegisterParticipantBlacklisted() {
        conference.addToBlacklist(participant1.getEmail());
        assertThrows(Conference.BlacklistedException.class, () -> conference.register(participant1, 100));
    }

    @Test
    void testMarkFeePaid() {
        conference.register(participant1, 100);
        conference.markFeePaid(participant1);
        assertEquals(100, conference.budget());
    }

    @Test
    void testBudget() {
        conference.register(participant1, 100);
        conference.markFeePaid(participant1);
        conference.register(participant2, 200);
        conference.markFeePaid(participant2);
        assertEquals(300, conference.budget());
    }

    @Test
    void testAddAndRemoveFromBlacklist() {
        conference.addToBlacklist(participant1.getEmail());
        assertThrows(Conference.BlacklistedException.class, () -> conference.register(participant1, 100));
        conference.removeFromBlacklist(participant1.getEmail());
        assertDoesNotThrow(() -> conference.register(participant1, 100));
    }
}
