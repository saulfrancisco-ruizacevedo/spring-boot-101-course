package com.dartrox.course.springboot.service.demo.architecture;


import com.dartrox.course.springboot.service.demo.SpringbootServiceDemoApplication;
import static com.tngtech.archunit.core.domain.properties.CanBeAnnotated.Predicates.annotatedWith;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import com.tngtech.archunit.library.Architectures;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@AnalyzeClasses(
        packagesOf = SpringbootServiceDemoApplication.class,
        importOptions = {
                ImportOption.DoNotIncludeTests.class,
                ArchitectureImportOptionUtils.DoNotIncludeLombokBuilders.class,
                ArchitectureImportOptionUtils.DoNotIncludeMapperImpl.class
        })
public class ArchitectureTest {

    @ArchTest
    public static final ArchRule CONTROLLER_NAMING = classes()
            .that().areAnnotatedWith(RestController.class)
            .or().haveSimpleNameEndingWith("Controller")

            .should().haveSimpleNameEndingWith("Controller")
            .andShould().beAnnotatedWith(RestController.class)

            .because("Controller does not end with *Controller");

    @ArchTest
    public static final ArchRule LAYERED_ARCHITECTURE = Architectures.layeredArchitecture()
            .consideringOnlyDependenciesInLayers()

            .layer("Controller").definedBy(annotatedWith(RestController.class))
            .layer("Service").definedBy(annotatedWith(Service.class))
            .layer("Repository").definedBy(annotatedWith(Repository.class))

            .whereLayer("Controller").mayNotAccessAnyLayer()
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Service")
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")

            .because("Enforcing layered architecture");

    @ArchTest
    public static final ArchRule DTO_CONTAINMENT_CHECK = classes()
            .that().haveSimpleNameEndingWith("DTO")

            .should().resideInAnyPackage("..dto.request..", "..dto.response..")

            .because("Classes with DTO suffix should reside inside the dto package");

    @ArchTest
    public static final ArchRule ENTITY_CONTAINMENT_CHECK = classes()
            .that().areAnnotatedWith(Entity.class)

            .should().resideInAPackage("..entity..")

            .because("Classes annotated with Entity.class should reside in the entity package");
}
