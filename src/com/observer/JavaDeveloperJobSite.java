package com.observer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class JavaDeveloperJobSite implements Observed {
    private List<String> vacancies = new LinkedList<>();
    private List<Observer> subscribers = new LinkedList<>();

    public void addVacancy(String vacancy) {
        synchronized (this) {
            vacancies.add(vacancy);
            notifyObserver();
        }
    }

    public void removeVacancy(String vacancy) {
        synchronized (this) {
            vacancies.remove(vacancy);
            notifyObserver();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        synchronized (this) {
            subscribers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        synchronized (this) {
            subscribers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
//        for (Observer observer : subscribers) {
//            observer.handleEvent(vacancies);
//        }

//        subscribers.stream()
//                .forEach(observer -> observer.handleEvent(vacancies));

        Iterator<Observer> iSubscribers = subscribers.iterator();
        while (iSubscribers.hasNext()) {
            Observer observer = iSubscribers.next();
            observer.handleEvent(vacancies);
        }
    }
}
