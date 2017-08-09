package ua.golovchenko.artem.goodday.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Artem on 08.08.2017.
 *
 */


public class CSVUtils {
    public static Collection<String[]> getTestData(String fileName) throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String record;
        BufferedReader file = new BufferedReader(new FileReader(fileName));

        while ((record = file.readLine()) != null) {
            String fields[] = record.split(",");
            records.add(fields);
        }

        file.close();
        return records;
    }
}
