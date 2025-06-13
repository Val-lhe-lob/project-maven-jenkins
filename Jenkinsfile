pipeline {
    agent any

    tools {
        maven 'Maven3'   // Le nom défini dans "Global Tool Configuration"
        jdk 'Java21'     // Le nom de ton JDK (selon ce que tu as configuré)
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        success {
            echo 'Tests réussis !'
        }
        failure {
            echo 'Échec des tests.'
        }
    }
}