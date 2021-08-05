package main.thread;

import main.db.DbUtils;
import main.utils.XFile;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class ThreadTwo implements Runnable{
    public static Logger logger = Logger.getLogger(ThreadTwo.class);
    public int exit = 1;

    @Override
    public void run() {
        while (exit == 1) {
            try {
                Thread.sleep(3000);
                logger.info("List student have " + XFile.getTheNumberOfStudent() + " student in student.txt");
                logger.info("List student have " + DbUtils.getTheNumberOfStudents() + " student in database");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
