package de.fidor.testdata.converters;

import lombok.Data;

@Data
public class GherkinTestCase {
    private String given;
    private String when;
    private String then;
}
