package com.observer;

/**
 * Шаблоны Java. Observer (Наблюдатель)
 * ***
 * @see https://www.youtube.com/watch?v=br5201sWOHM
 */
public class JobSearch {

    public static void main(String[] args) {
        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();

        jobSite.addVacancy("First Java position");
        jobSite.addVacancy("Second Java position");

        Observer firstSubscriber = new Subscriber("Eugene Suelimanov");
        Observer secondSubscriber = new Subscriber("Peter Romanenko");

        jobSite.addObserver(firstSubscriber);
        jobSite.addObserver(secondSubscriber);

        jobSite.addVacancy("Third Java Position");
        jobSite.removeVacancy("Third Java Position");
    }
}
