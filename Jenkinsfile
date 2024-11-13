pipeline{
   agent any
   environment{
      DOCKERHUB_CREDENTIALS = credentials("docker-hub")
   }
   stages {
      stage("Permission"){
           steps{
               sh "chmod +x ./gradlew"
           }
       }
       stage("Compile"){
           steps{
               sh "./gradlew compileJava"
           }
       }
       stage("Test"){
           steps{
               sh "./gradlew test"
           }
       }
       stage("Code Coverage") {
           steps {
               sh "./gradlew jacocoTestCoverageVerification"
               sh "./gradlew jacocoTestReport"
            }
       }
       stage("Static Code Analysis"){
         steps{
             sh "./gradlew checkstyleMain"
                 publishHTML(target: [
                             reportDir: 'build/reports/checkstyle/',
                             reportFiles: 'main.html',
                             reportName: 'Checkstyle Report'
                 ])
         }
       }
       stage("Gradle Build") {
           steps {
               sh "./gradlew clean build"
           }
       }
       stage("Docker Image Build"){
            steps{
                sh "docker build -t bestlalala/board ."
            }
       }
       stage('docker hub login'){
            steps{
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
       }
       stage('docker hub push'){
            steps{
                sh 'docker push bestlalala/board:latest'
            }
       }

   }
}