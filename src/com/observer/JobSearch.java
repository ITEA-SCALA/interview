package com.observer;

/**
 * Шаблоны Java. Observer (Наблюдатель)
 * ***
 * @see https://www.youtube.com/watch?v=br5201sWOHM
 */
public class JobSearch {

    public static void main(String[] args) {
        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();

        jobSite.addVacancy(
                "First Java position");
        jobSite.addVacancy(
                "Second Java position");

        jobSite.addObserver(
                new Subscriber("Eugene Suelimanov"));
        jobSite.addObserver(
                new Subscriber("Peter Romanenko"));

        jobSite.addVacancy(
                "Third Java Position");
        jobSite.removeVacancy(
                "Third Java Position");
    }
}
