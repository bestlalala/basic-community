pipeline{
    agent any
    stages{
        stage("Checkout"){
            steps{
                git url:'https://github.com/bestlalala/basic-community.git', branch: 'main'
            }
        }
        stage("Compile"){
            steps{
                sh "./gradlew compileJava"
            }
        }
    }
}