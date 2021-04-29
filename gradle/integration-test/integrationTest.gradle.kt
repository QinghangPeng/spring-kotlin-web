sourceSets {
  integrationTest {
    kotlin {
      compileClasspath += sourceSets.test.compileClasspath
      runtimeClasspath += sourceSets.test.runtimeClasspath
    }
  }
}

dependencies {
  integrationTestImplementation sourceSets.test.output
}


idea {
  module {
    testSourceDirs += project.sourceSets.integrationTest.kotlin.srcDirs
    testSourceDirs += project.sourceSets.integrationTest.resources.srcDirs
    scopes.TEST.plus += [configurations.integrationTestCompile]
    scopes.TEST.plus += [configurations.integrationTestRuntime]
  }
}

configurations {
  integrationTestImplementation.extendsFrom implementation
  integrationTestRuntimeOnly.extendsFrom runtimeOnly
}

task integrationTest(type: Test) {
  systemProperty 'user.timezone', 'Asia/Singapore'
  testClassesDirs = sourceSets.integrationTest.output.classesDirs
  classpath = sourceSets.integrationTest.runtimeClasspath
  useJUnitPlatform()
}

integrationTest.mustRunAfter test
check.dependsOn integrationTest
