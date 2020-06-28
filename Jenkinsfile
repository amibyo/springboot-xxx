@Library('lib-maven@master') _

pipeline {
    agent any
  
    stages {
        stage( 'file-lib-1 ') {
            steps {
            tache(
                branch: "master",
                url: "https://github.com/AMIBYO/maven-project.git"
            )
            }
    }
        
     
        
        
       stage('file-lib-2') {
            steps {
           notification type: "slack", message: "Build succeeded"
            }
    }
         
    }
}
