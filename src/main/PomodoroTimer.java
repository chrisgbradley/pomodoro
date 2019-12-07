package main;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.jetbrains.annotations.NotNull;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

class PomodoroTimer extends Observable {
    private IntegerProperty intervalInSeconds;
    private Timer timer;
    private int count = 0;

    PomodoroTimer() {
        intervalInSeconds = new SimpleIntegerProperty(0);
        timer = new Timer();
    }

    final void start() {
        try {
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    intervalInSeconds.set(intervalInSeconds.get() - 1);
                }
            }, 0, intervalInSeconds.get() * 100);
        } catch (IllegalArgumentException iae) {
            System.err.println("Can't be zero.");
        }
    }

    final void stop() {
        intervalInSeconds.set(0);
        timer.cancel();
    }

    final void add(int seconds) {
        intervalInSeconds.set(intervalInSeconds.get() + seconds);
    }

    final void less(int seconds) {
        if (intervalInSeconds.get() > 1)
            intervalInSeconds.set(intervalInSeconds.get() - seconds);
    }

    @NotNull
    String getTime() {
        int hours = Math.floorDiv(intervalInSeconds.get(), 3600);
        int minutes = Math.floorDiv(intervalInSeconds.get(), 60);
        int seconds = intervalInSeconds.get() % 60;

        StringBuilder sb = new StringBuilder();

        if (hours < 10) sb.append(0);
        sb.append(hours);
        sb.append(':');

        if (minutes < 10) sb.append(0);
        sb.append(minutes);
        sb.append(':');

        if (seconds < 10) sb.append(0);
        sb.append(seconds);
        sb.append('.');

        return sb.toString();
    }

    IntegerProperty intervalInSecondsProperty() {
        return intervalInSeconds;
    }
}
