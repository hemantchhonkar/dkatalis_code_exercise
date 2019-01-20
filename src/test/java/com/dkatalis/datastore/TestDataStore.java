package com.dkatalis.datastore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestDataStore {

    private String expectedString;
    private Map[] expectedArrayOfMaps;
    private IDataStore dataStore;

    @Before
    public void setUp() {
        this.dataStore = new SimpleDataStore();
        this.expectedString = this.getStringOfArrayOfMaps();
        this.expectedArrayOfMaps = this.getArrayOfMaps();
    }

    @Test(expected = IllegalArgumentException.class)
    public void from_null_or_empty_array_of_maps_to_string_exception_test() {
        this.dataStore.fromArrayOfMapsToString(null);
    }

    @Test
    public void from_array_of_maps_to_string_test() {
        String stringOfArrayOfMaps = this.dataStore.fromArrayOfMapsToString(this.expectedArrayOfMaps);
        Assert.assertEquals(this.expectedString, stringOfArrayOfMaps);
    }

    @Test(expected = IllegalArgumentException.class)
    public void from_null_or_empty_string_to_array_of_maps_exception_test() {
        this.dataStore.fromStringToArrayOfMaps(null);
    }

    @Test
    public void from_string_to_array_of_maps_test() {
        Map[] arrayOfMaps = this.dataStore.fromStringToArrayOfMaps(expectedString);
        Assert.assertTrue(Arrays.equals(expectedArrayOfMaps, arrayOfMaps));
    }

    private Map[] getArrayOfMaps() {
        Map<String, String> stringMap1 = new HashMap<>();
        stringMap1.put("key01", "value01");
        stringMap1.put("key02", "value02");
        stringMap1.put("key03", "value03");
        stringMap1.put("key04", "value04");
        stringMap1.put("key05", "value05");

        Map<String, String> stringMap2 = new HashMap<>();
        stringMap2.put("key11", "value11");
        stringMap2.put("key12", "value12");
        stringMap2.put("key13", "value13");
        stringMap2.put("key14", "value14");
        stringMap2.put("key15", "value15");

        return new Map[]{stringMap1, stringMap2};
    }

    private String getStringOfArrayOfMaps() {
        return "key04=value04;key03=value03;key02=value02;key01=value01;key05=value05\n" +
                "key15=value15;key14=value14;key13=value13;key12=value12;key11=value11";
    }

}
