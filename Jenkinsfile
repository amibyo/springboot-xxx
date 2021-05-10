@Library('lib-maven@master') _

pipeline {
    agent any
  
    stages {
        stage( 'Git-checkout') {
            steps {
            tache(
                branch: "master",
                url: "https://github.com/AMIBYO/maven-project.git"
            )
            }
    }
         stage( 'Git-checkout II') {
            steps {
            tache(
                branch: "master",
                url: "https://github.com/AMIBYO/pro.git"
            )
            }
    }
     
        
       
       stage('Notification') {
           steps {
echo "hello men we have sucess build"        }
   }
        
    }
}
