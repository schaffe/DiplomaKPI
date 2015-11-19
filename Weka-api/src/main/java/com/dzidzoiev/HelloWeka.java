package com.dzidzoiev;

import com.dzidzoiev.model.csv.Rating;
import com.dzidzoiev.utils.CSVHelper;
import com.dzidzoiev.weka.ModelDatasets;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

import java.io.File;
import java.util.List;

public class HelloWeka {
    public static final String filePath = "/home/dzidzoiev/Develop/datamining/Weka-api/src/main/resources/house.arff";
    public static final String targetPath = "target/temp/";

    public static void main(String[] args) throws Exception {
        String filename = "src/main/resources/ml-latest-small/ratings.csv";
        List<Rating> places = CSVHelper.readFile(filename, Rating.getCSVMapper());
//        System.out.println(places.size());
        Instances ratingInstances = ModelDatasets.convertToInstances(places);
        ArffSaver saver = new ArffSaver();
        saver.setInstances(ratingInstances);
        saver.setFile(new File(targetPath + "/ratings.arff"));
        saver.writeBatch();
    }
}
