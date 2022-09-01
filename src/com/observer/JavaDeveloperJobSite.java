package com.observer;

import java.util.LinkedList;
import java.util.List;

public class JavaDeveloperJobSite implements Observed {
    private List<String> vacancies = new LinkedList<>();
    private List<Observer> subscribers = new LinkedList<>();

    public void addVacancy(String vacancy) {
        vacancies.add(vacancy);
        notifyObserver();
    }

    public void removeVacancy(String vacancy) {
        vacancies.remove(vacancy);
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : subscribers) {
            observer.handleEvent(vacancies);
        }
    }
}
