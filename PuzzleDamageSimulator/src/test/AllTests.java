/*
 * Created on 2015/01/05
 * Copyright (C) 2015 Koga Laboratory. All rights reserved.
 *
 */
package test;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {

  public static Test suite() throws URISyntaxException, ClassNotFoundException {
    return AllTests.createTestSuite();
  }

  protected static TestSuite createTestSuite() throws URISyntaxException, ClassNotFoundException {
    TestSuite suite = new TestSuite();

    URL codeSourceUrl = AllTests.class.getProtectionDomain().getCodeSource().getLocation();
    File codeSourceFile = new File(codeSourceUrl.toURI());
    String codeSourceName = codeSourceFile.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\");

    List<File> testCaseFiles = new ArrayList<File>();
    AllTests.listTestCase(testCaseFiles, codeSourceFile);

    for (File testCaseFile : testCaseFiles) {
      String fileName = testCaseFile.getAbsolutePath();
      String className = fileName.replaceAll(codeSourceName + "\\\\", "").replaceAll(".class", "").replaceAll("\\\\", ".");
      suite.addTest(new JUnit4TestAdapter(Class.forName(className)));
    }
    return suite;
  }

  protected static void listTestCase(final List<File> testCaseFiles, final File file) {

    for (File child : file.listFiles()) {
      if (child.isFile()) {
        if (child.getAbsolutePath().endsWith("Test.class")) {
          testCaseFiles.add(child);
        }
      } else if (child.isDirectory()) {
        AllTests.listTestCase(testCaseFiles, child);
      }
    }
  }
}