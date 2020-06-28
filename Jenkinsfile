@Library('lib-maven@master') _

pipeline {
    agent any
    node {
         notification type: "slack", message: "Build succeeded"
    }
    stages {
        stage( ' ') {
            steps {
            tache(
                branch: "master",
                url: "https://github.com/AMIBYO/maven-project.git"
            )
            }
    }
        
     
        
        
       stage('Notification') {
            steps {
           notification type: "slack", message: "Build succeeded"
            }
    }
         
    }
}
