pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out code...'
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        bat 'gradlew.bat clean test --no-build-cache --rerun-tasks'
                    }
                }
            }
        }

        stage('Allure Report') {
            steps {
                    allure includeProperties: false,
                           results: [[path: 'app/build/allure-results']]
                  }
        }
    }

    post {
        always {
            echo 'Pipeline completed'
        }
    }
}