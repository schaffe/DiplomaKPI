package com.dzidzoiev.weka;

import com.dzidzoiev.model.csv.Rating;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dzidzoiev on 11/18/15.
 */
public class ModelDatasets {
    public static Instances convertToInstances(List<Rating> list) {
        List<Attribute> attributes = Arrays.asList(
                new Attribute("userId", 0),
                new Attribute("placeId", 1),
                new Attribute("rating", 2),
                new Attribute("timestamp", 3));

        FastVector fastVector = new FastVector();
        attributes.forEach(fastVector::addElement);

        List<Instance> instancesList = list.stream()
                .map(ModelDatasets::fromRating)
                .collect(Collectors.toList());

        Instances instances = new Instances("ratings", fastVector, 0);
        instancesList.forEach(instances::add);

        return instances;
    }

    public static Instance fromRating(Rating r) {
        Instance instance = new Instance(4);
        instance.setValue(0, r.getUserId());
        instance.setValue(1, r.getPlaceId());
        instance.setValue(2, r.getRating());
        instance.setValue(3, r.getTimestamp());
        return instance;
    }
}
