pipeline {
    agent any
    stages {
        stage('checking') {
            steps {
                git branch: 'main', url: 'https://github.com/jiakeke/sep1-aikido.git'
            }
        }
        stage('build & test') {
            steps {
                /* sh 'mvn clean install' */
                sh 'mvn clean verify'
            }
        }

        stage('Test & Coverage') {
            steps {
                sh 'mvn test jacoco:report' // Run tests and generate a JaCoCo coverage report
            }

            post {
                always {
                    junit 'target/surefire-reports/*.xml' // Archive JUnit test results
                    jacoco execPattern: '**/target/jacoco.exec' // Archive JaCoCo coverage report
                }
            }

        }
    }
}
