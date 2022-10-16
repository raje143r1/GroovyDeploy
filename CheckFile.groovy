pipeline{
       agent {
			label 'master'
			}
	     options 
		   { 
		     timestamps() 
		   }
        stages{
			
               stage("Predeployment"){
					   steps{
						   script{
								
						       if(ArtifacatstoDeploy == 'EarandXML'){
								withAnt(installation: 'Ant 1.8.4', jdk: 'Zulu OpenJDK 8.0.302') {
									 wrap([$class: 'MaskPasswordsBuildWrapper', varPasswordPairs: [[password: "${env.pwd}", var: 'PSWD'],[password: "${env.TIBCOPwd}", var: 'TPSWD']]]) {
									sh "ant -f \"${workspace}\"@script/abc27b879062018c45d2aa53e75587cc2d6cc6eed65da714bf3caff22484a027/TIBCO/build_test.xml PreDeploymentStep UploadEAR UploadXML"	
									
									}
								}
							 }
							 else if(ArtifacatstoDeploy == 'isOnlyEAR'){
							 withAnt(installation: 'Ant 1.8.4', jdk: 'Zulu OpenJDK 8.0.302') {
									 wrap([$class: 'MaskPasswordsBuildWrapper', varPasswordPairs: [[password: "${env.pwd}", var: 'PSWD'],[password: "${env.TIBCOPwd}", var: 'TPSWD']]]) {
									sh "ant -f \"${workspace}\"@script/abc27b879062018c45d2aa53e75587cc2d6cc6eed65da714bf3caff22484a027/TIBCO/DeployOnlyEar.xml PreDeploymentStep UploadEAR"	
									}
								}
						   }
					   }
					}
               } 
			   
     } 
}
