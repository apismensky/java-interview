package com.apismensky;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * You are given several logs that each log contains a unique id and timestamp. Timestamp is a string that has the following format:
 * Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59. All domains are zero-padded decimal numbers.
 *
 * Design a log storage system to implement the following functions:
 *
 * void Put(int id, string timestamp): Given a log's unique id and timestamp, store the log in your storage system.
 *
 *
 * int[] Retrieve(String start, String end, String granularity): Return the id of logs whose timestamps are within the range from start
 * to end. Start and end all have the same format as timestamp. However, granularity means the time level for consideration. \For
 * example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day", it means that we need to find the logs
 * within the range from Jan. 1st 2017 to Jan. 2nd 2017.
 *
 * Example 1:
 *
 * put(1, "2017:01:01:23:59:59"); put(2, "2017:01:01:22:59:59"); put(3, "2016:01:01:00:00:00");
 * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need to return all logs within 2016 and
 * 2017. retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need to return all logs start from
 * 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range. Note:
 *
 * There will be at most 300 operations of Put or Retrieve. Year ranges from [2000,2017]. Hour ranges from [00,23]. Output for Retrieve
 * has no order required.
 */
class LogSystem {

    private List<LogEntry> logEntries;

    private enum Granularity {
        Year,
        Month,
        Day,
        Hour,
        Minute,
        Second;
    }

    private static class LogEntry {
        private static final int MIN_SEC = 60;
        private static final int HOUR_SEC = 60 * MIN_SEC;
        private static final int DAY_SEC = 24 * HOUR_SEC;
        private static final int MONTH_SEC = 30 * DAY_SEC;
        private static final int YEAR_SEC = 12 * MONTH_SEC;
        private final int id;
        private final String time;
        private final long timestamp;

        public LogEntry(int id, String time) {
            this.id = id;
            this.time = time;
            this.timestamp = parseTimestamp(time, Granularity.Second, false);
        }

        public int getId() {
            return id;
        }

        public String getTime() {
            return time;
        }

        public boolean inRange(String from, String to, Granularity gra) {
            long fromTimestamp = parseTimestamp(from, gra, false);
            long toTimestamp = parseTimestamp(to, gra, true);
            return this.timestamp >= fromTimestamp && this.timestamp <= toTimestamp;
        }

        // 2016:01:01:01:01:01
        private long parseTimestamp(String timestamp, Granularity gra, boolean include) {
            String[] timeComponents = timestamp.split(":");
            int year = Integer.parseInt(timeComponents[0]) - 2000;
            int month = Integer.parseInt(timeComponents[1]);
            int day = Integer.parseInt(timeComponents[2]);
            int hours = Integer.parseInt(timeComponents[3]);
            int minutes = Integer.parseInt(timeComponents[4]);
            int seconds = Integer.parseInt(timeComponents[5]);

            int yearSec = YEAR_SEC * year;
            int monthSec = MONTH_SEC * month;
            int daySec = DAY_SEC * day;
            int hourSec = HOUR_SEC * hours;
            int minSec = MIN_SEC * minutes;

            switch (gra) {
                case Year:
                    return include ? yearSec + YEAR_SEC : yearSec;
                case Month:
                    return include ? monthSec + MONTH_SEC + yearSec : monthSec + yearSec;
                case Day:
                    return include ? daySec + DAY_SEC + monthSec + yearSec : daySec + monthSec + yearSec;
                case Hour:
                    return include ? hourSec + HOUR_SEC + daySec + monthSec + yearSec : hourSec + daySec + monthSec + yearSec;
                case Minute:
                    return include ? minSec + MIN_SEC + hourSec + daySec + monthSec + yearSec : minSec + hourSec + daySec + monthSec + yearSec;
                default:
                    return seconds + minSec + hourSec + daySec + monthSec + yearSec;
            }
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                   "id=" + id +
                   ", time='" + time + '\'' +
                   '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            LogEntry logEntry = (LogEntry)o;
            return id == logEntry.id &&
                   Objects.equals(time, logEntry.time);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, time);
        }
    }

    public LogSystem() {
        logEntries = new ArrayList<>();
    }

    public void put(int id, String timestamp) {
        logEntries.add(new LogEntry(id, timestamp));
    }

    public List<Integer> retrieve(String from, String to, String gra) {
        List<Integer> result = new ArrayList<>();
        for (LogEntry logEntry : logEntries) {
            if (logEntry.inRange(from, to, Granularity.valueOf(gra))) {
                result.add(logEntry.getId());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");
        System.out.println(logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00",
                                              "Year")); // return [1,2,3], because you need to return all logs within 2016 and 2017.
        System.out.println(logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour")); // return [1,2]
    }

}

/**
 * Your LogSystem object will be instantiated and called as such: LogSystem obj = new LogSystem(); obj.put(id,timestamp); List<Integer>
 * param_2 = obj.retrieve(s,e,gra);
 */
