package com.kdetails.datastore;

import com.kdetails.util.Constants;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleDataStore implements IDataStore {

    public String fromArrayOfMapsToString(Map<String, String>[] arrayOfMaps) throws IllegalArgumentException{
        if(arrayOfMaps == null || arrayOfMaps.length <=0 ) {
            throw new IllegalArgumentException("Empty array found.");
        }

        return Arrays.stream(arrayOfMaps)
                .map(hashMap ->
                        hashMap.entrySet().stream()
                                .map(entry -> entry.getKey() + Constants.KEY_VALUE_SEPARATOR.getValue() + entry.getValue())
                                .collect(Collectors.joining(Constants.MAP_ENTRY_SEPARATOR.getValue())))
                .collect(Collectors.joining(Constants.ARRAY_SEPARATOR.getValue()));
    }

    public Map[] fromStringToArrayOfMaps(String stringOfArrayOfMaps) throws IllegalArgumentException {
        if(stringOfArrayOfMaps == null || stringOfArrayOfMaps.isEmpty() ) {
            throw new IllegalArgumentException("Empty/Null string found");
        }

        return Arrays.stream(stringOfArrayOfMaps.split(Constants.ARRAY_SEPARATOR.getValue())).map(mapString ->
                Arrays.stream(mapString.split(Constants.MAP_ENTRY_SEPARATOR.getValue()))
                        .collect(Collectors.toMap(entryString ->
                                        entryString.replaceAll(Constants.REGEX_TO_REPLACE_AFTER.getValue(), ""),
                                entryString -> entryString.replaceAll(Constants.REGEX_TO_REPLACE_BEFORE.getValue(), ""))))
                .toArray(Map[]::new);
    }
}
