package com.personal;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import com.personal.model.Report;
import com.personal.model.Salesman;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String pathToSalesmanList;
        String pathToReportList;
        if (args.length == 2) {
            pathToSalesmanList = args[0];
            pathToReportList = args[1];
            String salesmenJsonStr = sendGet(pathToSalesmanList);
            String reportJsonStr = sendGet(pathToReportList);
            Gson gson = new Gson();

            Salesman[] salesArr = gson.fromJson(salesmenJsonStr, Salesman[].class);
            Report report = gson.fromJson(reportJsonStr, Report.class);

            generateCSV("Result.csv", new ArrayList<Salesman>(Arrays.asList(salesArr)), report);
        } else {
            System.out.println("Please, provide paths for both the Salesman list and for ReportList");
            return;
        }


    }

    private static void generateCSV(String fileName, ArrayList<Salesman> salesmen, Report report) throws IOException {
        File file = new File(fileName);
        FileWriter outputfile = new FileWriter(file);

        // create CSVWriter object filewriter object as parameter
        CSVWriter writer = new CSVWriter(outputfile);

        // adding header to csv
        String[] header = {"Name", "Score"};
        writer.writeNext(header);

        salesmen.sort(Salesman::customCompare);
        double x = (report.getTopPerformersThreshold().doubleValue() / 100);

        //if the threshold is more than 100 percent, then index out of bounds
        int xPos = x <= 1 ?(int) (salesmen.size() * x) : salesmen.size();
        for (int i = 0; i < xPos; i++) {
            if (salesmen.get(i).getSalesPeriod() <= report.getPeriodLimit()) {
                Salesman s = salesmen.get(i);
                double score = report.isUseExperienceMultiplier() ?
                        s.getTotalSales().doubleValue()
                                / s.getSalesPeriod().doubleValue() * s.getExperienceMultiplier() :
                        s.getTotalSales().doubleValue() / s.getSalesPeriod().doubleValue();
                String[] data = {s.getName(), String.valueOf(score)};
                writer.writeNext(data);
            }
        }
        System.out.println("Finished");
        // closing writer connection
        writer.close();

    }

    private static String sendGet(String url) throws IOException {
        URL urlSales = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlSales.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            System.out.println("Something went wrong");
            return null;
        }
    }
}
