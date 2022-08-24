pipeline {
  agent any
  tools {
      jdk "JAVA_HOME"
  }
  stages {
    stage('Run functional test cases') {
      steps {
       bat "mvn -f C:\Users\Sarika Nazare\workspace\JenkinsGitConfigure\BNTTeamWork\pom.xml clean install -DjenkinsBrowser=${params.device} -DbrowserStack=${params.version} -Dcucumber.options=\"--tags ${params.tagName}\""
      }
    }
  }
}