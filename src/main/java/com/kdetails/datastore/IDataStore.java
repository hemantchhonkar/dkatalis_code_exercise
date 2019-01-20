package com.kdetails.datastore;

import java.util.*;

interface IDataStore {
    String fromArrayOfMapsToString(Map<String, String>[] arrayOfMaps) throws IllegalArgumentException;
    Map[] fromStringToArrayOfMaps(String stringOfArrayOfMaps) throws IllegalArgumentException;
}
