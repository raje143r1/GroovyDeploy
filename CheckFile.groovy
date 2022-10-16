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
								   echo '${env.filename}'
									}
								}
							 }
							 else if(ArtifacatstoDeploy == 'isOnlyEAR'){
							  echo '${env.filename}'
						   }
					   }
					}
               } 
			   
     } 
}
