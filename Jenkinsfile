pipeline{
    agent any
    
    tools{
        maven "Maven3"
      
        
    }
    
    stages{
        stage('Checkout') {
            steps {
            checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/zmirzaei63/MavenProject-4-Pipeline.git']])

            }
        }

         stage('Build') {
                    steps {
                  
                    bat "mvn clean install"
                    

                    }
                }
         stage('Build docker image') {
                    steps {
                    bat "docker build -t zmirzaei/mavenproject4docker:1.3."

                    }
                }
         stage('login to docker') {
                    steps {
                        withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                           bat "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                  
                        }
                   

                    }
                }
        stage('Push docker image') {
                    steps {
                    bat "docker push zmirzaei63/maven:v1"

                    }
                }
     stage('Running Container') {
                    steps {
                    bat "docker run -d -p 8081:8080 --name my-maven-container-lab3 zmirzaei63/maven:v1"

                    }
                }
    }
}  
