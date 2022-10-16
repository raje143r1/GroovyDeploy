pipeline{
       agent any
	     options 
		   { 
		     timestamps() 
		   }
        stages{
			
               stage("Predeployment"){
					   steps{
						   script{
								
						       if(ArtifactsToDeploy == 'EarandXML'){
								   echo '${env.filename}'
									}
							 else if(ArtifactsToDeploy == 'isOnlyEAR'){
							  echo '${env.filename}'
						   }
					   }
					}
               } 
			   
     } 
}
