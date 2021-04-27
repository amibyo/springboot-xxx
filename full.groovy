
pipeline {
    agent  {
docker { image 'node:14-alpine' }
}
triggers {
pollSCM '* * * * *'
}
    stages {
        stage('SCM') {
            steps {
                git url: 'https://github.com/foo/bar.git'
            }
        }
        stage ('Compile Stage') {
            //multi branche 
          when {
           branch 'develop'
             }     
            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn clean compile'
                    // Make sure the directory is wiped.
              
            }
        }
        stage('Build develop') {
           steps {
             echo 'Building'
                //dir: Changer le répertoire courant
               dir("local-snapshots-dir/") {
                   //deleteDir: Supprimer récursivement le répertoire courant de l'espace de travail
                deleteDir()
                 }
           // We'll deploy to a relative directory so we can save
            // that and deploy in a later step on a different node
            sh 'mvn -DaltDeploymentRepository=snapshot-repo::default::file:./local-snapshots-dir clean deploy'
          
        // Stash the build results so we can deploy them on another node -stash: Rangez certains fichiers à utiliser plus tard dans la construction
            stash name: 'plc4x-build-snapshots', includes: 'local-snapshots-dir/**'
             }
        }  
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Send out notifications on unsuccessful builds:') {
                //Send out notifications on unsuccessful builds:
              post {
        failure {
               mail to: 'team@example.com',
              subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
              body: "Something is wrong with ${env.BUILD_URL}"
                }
             }
                }

        stage('Build Docker image') {
                steps {
                sh './cmd docker'
                }
                }
        stage('Push Docker image') {
                environment {
                DOCKER_HUB_LOGIN = credentials('docker-hub')
                }
                steps {
                sh 'docker login -- username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                sh './mvn dockerPush'
                }
                }

        stage('Build image') {
            /* This builds the actual image; synonymous to
            * docker build on the command line */
             app = docker.build("getintodevops/hellonode")
            }
        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn test'
                }
            }
             post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('SonarQube analysis 1') {
            steps {
                sh 'mvn clean package sonar:sonar'
            }
        }
        stage("Quality Gate 1") {
            steps {
                      timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }            }
        }
        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn deploy'
                }
            }
        }

        //Using multiple containers:
     stages {
        stage('Back-end') {
                agent {
                docker { image 'maven:3-alpine' }
                }
                steps {
                sh 'mvn --version'
                }
                }
        stage('Front-end') {
                agent {
                docker { image 'node:14-alpine' }
                }
                steps {
                sh 'node --version'
                }
                }                 }     }
}


        //Using a Dockerfile
 pipeline {
   agent { dockerfile true }
      stages {
        stage('Test') {
            steps {
            sh 'node --version'
            sh 'svn --version'
            }
         }           }      }

//Caching data for containers :
 pipeline {
         agent {
          docker {
            image 'maven:3-alpine'
            args '-v $HOME/.m2:/root/.m2'
            }
            }
     stages {
        stage('Build') {
         steps {
            sh 'mvn -B'
            }         }             }             }
