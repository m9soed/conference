package ru.ac.uniyar.testingcourse.conference;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class ConferenceImpl implements Conference {
    private final Set<String> blacklist = new HashSet<>();
    private final Map<String, Integer> registeredParticipants = new HashMap<>();
    private final Map<String, Boolean> feePaidStatus = new HashMap<>();
    private int totalBudget = 0;

    @Override
    public void register(Participant participant, Integer feeAmount) {
        String email = participant.getEmail();
        if (blacklist.contains(email)) {
            throw new BlacklistedException();
        }
        if (registeredParticipants.containsKey(email)) {
            throw new AlreadyRegistredException();
        }
        registeredParticipants.put(email, feeAmount);
        feePaidStatus.put(email, false);
    }

    @Override
    public void markFeePaid(Participant participant) {
        String email = participant.getEmail();
        if (registeredParticipants.containsKey(email) && !feePaidStatus.get(email)) {
            totalBudget += registeredParticipants.get(email);
            feePaidStatus.put(email, true);
        }
    }

    @Override
    public Integer budget() {
        return totalBudget;
    }

    @Override
    public void addToBlacklist(String email) {
        blacklist.add(email);
    }

    @Override
    public void removeFromBlacklist(String email) {
        blacklist.remove(email);
    }
}
