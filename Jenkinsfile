pipeline {
    agent any
    tools {
        maven "maven"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Test') {
                    steps {
                        sh 'mvn clean test'
                    }
                }
        stage('Build') {
            steps {
                sh 'mvn install'
            }
        }
    }
    post {
        failure {
            emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}',
            to: "${EMAIL_TO}",
            subject: 'Build failed in Jenkins: $PROJECT_NAME - #$BUILD_NUMBER'
        }
    }
}