pipeline{
    agent any
    
    tools{
        maven "Maven3"
      
        
    }
    
    stages{
        stage('Checkout') {
            steps {
            checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/bhavya123654/bhavithareddylab3.git']])

            }
        }

         stage('Build') {
                    steps {
                  
                    bat "mvn clean package"
                    

                    }
                }
         stage('Build docker image') {
                    steps {
                    bat "docker build -t bhavitha111234/maven:v1 ."

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
                    bat "docker push bhavitha111234/maven:v1"

                    }
                }
     stage('Running Container') {
                    steps {
                    bat "docker run -d -p 8081:8080 --name my-maven-container-lab3 bhavitha111234/maven:v1"

                    }
                }
    }
}  
