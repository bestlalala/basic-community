pipeline{
   agent any
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
   }
}