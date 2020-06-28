@Library('lib-maven@master') _

pipeline {
    agent any
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
