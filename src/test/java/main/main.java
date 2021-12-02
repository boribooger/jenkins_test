package main;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import tests.FirstTest;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("xmlSuite");
        xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
        xmlSuite.setThreadCount(2);

        //firefox test
        {
            XmlTest xmlTest = new XmlTest(xmlSuite);
            xmlTest.setName("firefox");
            xmlTest.setThreadCount(1);
            xmlTest.addParameter("browser", "firefox");

            XmlClass publicTestClass = new XmlClass(FirstTest.class);
            List<XmlClass> list = new ArrayList<>();
            list.add(publicTestClass);
            xmlTest.setXmlClasses(list);
        }

        //chrome test
        {
            XmlTest xmlTest1 = new XmlTest(xmlSuite);
            xmlTest1.setName("chrome");
            xmlTest1.setThreadCount(1);
            xmlTest1.addParameter("browser", "chrome");

            XmlClass publicTestClass1 = new XmlClass(FirstTest.class);
            List<XmlClass> list1 = new ArrayList<>();
            list1.add(publicTestClass1);
            xmlTest1.setXmlClasses(list1);
        }

        TestNG testNG = new TestNG();

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(xmlSuite);
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}
