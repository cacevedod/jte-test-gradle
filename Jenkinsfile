pipeline{
    agent {
        docker { image 'maven:3-alpine' }
    }
    stages{
        stage('build'){
            steps{
                sh 'chmod +x gradlew'
                sh './gradlew clean build -DskipTests=true'
                archiveArtifacts artifacts: 'build/libs/**/*.jar'
            }            
        }
        stage('test'){
            steps{
                sh './gradlew test'
            }
            post {
                always {
                    junit 'build/test-results/**/*.xml'
                    archiveArtifacts artifacts: 'build/reports/jacoco/**/*.xml'
                }
            }            
        }
        stage('approve'){
            when{
                branch 'master'
            }
            agent none
            steps{
                script{
                    timeout(time: 5, unit: 'SECONDS'){
                        input message: 'Apruebas el despliegue', submitter: 'admin'
                    }
                }
            }
        }
        stage('deploy'){
            when{
                branch 'master'
            }
            steps{
                echo "Pendiente de implementación"
            }
        }
    }
}