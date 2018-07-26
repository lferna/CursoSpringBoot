//node {
//   def mvnHome
//   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      // **       in the global configuration.           
//      sh 'rm -rf *'
//      checkout scm
//      mvnHome = tool 'Maven3'
//   }
//   stage('Build') {
//         sh "'${mvnHome}/bin/mvn' -DskipTests clean package"       
//   }
//}

@Library('mslibpipelines@master') _

def config = [:]

config = [
    gitCredentials: '61c9ce98-3487-4525-abcd-430715481a9d',
        mavenVersion: 'Maven3',
        mavenProfile: true
]

doStartApp(config)

