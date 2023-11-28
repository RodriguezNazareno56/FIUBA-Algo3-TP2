package edu.fiuba.algo3.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ModelDependenciesTest {
    private final String MODEL = "..modelo..";
    private final String JAVA_LANG = "java..";
    private final String JUNIT = "org.junit..";
    private final String MOCKITO = "org.mockito..";
    private final String JSON_IN_JAVA = "org.json..";
    private final String JACKSON_DATABIND = "com.fasterxml.jackson.databind";

    @Test
    public void elModeloSoloPuedeReferenciarClasesDelModeloAdemasJavaAdemasJunit() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("edu.fiuba.algo3.modelo");

        String[] listOfPackages = {MODEL, JAVA_LANG, JUNIT, MOCKITO, JSON_IN_JAVA, JACKSON_DATABIND};

        ArchRule myRule = classes().that().resideInAPackage(MODEL)
                .should().onlyDependOnClassesThat().resideInAnyPackage(listOfPackages);

        myRule.check(importedClasses);
    }

}
