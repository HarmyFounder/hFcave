package com.hF.hFcave.services;

import com.hF.hFcave.models.Habit;
import com.hF.hFcave.models.User;
import com.hF.hFcave.repositories.HabitRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalTime;
import java.util.List;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    @Autowired
    private MailSender mailSender;


    public List<Habit> getAll() {
        return habitRepository.findAll();
    }

    public Habit create(Habit habit) {

        return habitRepository.save(habit);
    }

    public List<Habit> getByTag(String filter) {

        if (filter != null && !filter.isEmpty()) {
            return habitRepository.findByTag(filter);
        } else {
            return habitRepository.findAll();
        }
    }


    public Habit update(Habit habitToBeUpdated, Habit updatedHabit) {
        BeanUtils.copyProperties(updatedHabit, habitToBeUpdated, "id");
        return habitRepository.save(habitToBeUpdated);
    }

    public void delete(Habit habit) {
        habitRepository.delete(habit);
    }

    public void setDone(Habit habit) {
        habit.setDone(true);
    }

    public void setNotifications(User user, int hour, int minute) throws MessagingException {
            for (Habit habit : user.getHabits()) {
                mailSender.send(user.getEmail(), habit.getTittle() + " by tag: " + habit.getTag(), "Remember about your habits hFcave", hour, minute);
        }
    }

}
