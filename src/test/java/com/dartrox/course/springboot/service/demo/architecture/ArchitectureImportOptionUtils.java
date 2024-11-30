package com.dartrox.course.springboot.service.demo.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.core.importer.Location;

public class ArchitectureImportOptionUtils {

    static class DoNotIncludeLombokBuilders implements ImportOption {

        @Override
        public boolean includes(Location location) {
            return !location.contains("Builder");
        }
    }

    static class DoNotIncludeMapperImpl implements ImportOption {

        @Override
        public boolean includes(Location location) {
            return !location.contains("MapperImpl");
        }
    }
}
