import cdk = require("@aws-cdk/core");
import ec2 = require("@aws-cdk/aws-ec2");
import ecr = require("@aws-cdk/aws-ecr");
import ecs = require("@aws-cdk/aws-ecs");
import ecs_patterns = require("@aws-cdk/aws-ecs-patterns");
import {App, Duration, RemovalPolicy} from "@aws-cdk/core";

const commonRegion = 'eu-central-1';

class RepositoryStack extends cdk.Stack {

    ecrRepo: ecr.Repository;

    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);

        this.ecrRepo = new ecr.Repository(this, "character-management-app", {
            repositoryName: "character-management-app",
            lifecycleRules: [{maxImageCount: 5}],
            removalPolicy: RemovalPolicy.DESTROY
        });
    }

    getRepo() {
        return this.ecrRepo;
    }

}

class CharacterManagementAppStack extends cdk.Stack {

    constructor(scope: cdk.App, id: string, ecrRepo: ecr.Repository, props?: cdk.StackProps) {
        super(scope, id, props);

        const vpc = new ec2.Vpc(this, 'CharacterManagementAppVPC', {maxAzs: 2});

        const cluster = new ecs.Cluster(this, 'CharacterManagementAppCluster', {
            vpc: vpc,
            clusterName: 'CharacterManagementAppCluster'
        });

        const logDriver = new ecs.AwsLogDriver({
            streamPrefix: "JdN",
        });

        // Instantiate Fargate Service with just cluster and image
        const fargateAppService = new ecs_patterns.ApplicationLoadBalancedFargateService(this, "FargateAppService", {
            cluster,
            serviceName: "FargateAppService",
            taskImageOptions: {
                image: ecs.ContainerImage.fromEcrRepository(ecrRepo, "0.0.1-SNAPSHOT"),
                enableLogging: true,
                logDriver: logDriver,
                containerPort: 8080,
                environment: {}
            },
            memoryLimitMiB: 512,
            cpu: 256,
            desiredCount: 1
        });

        fargateAppService.targetGroup.configureHealthCheck({
            path: "/healthcheck",
            port: "8080",
            unhealthyThresholdCount: 4,
            interval: Duration.seconds(30)
        });

        ecrRepo.grantPull(fargateAppService.taskDefinition.obtainExecutionRole());

    }

}

class CharacterManagementApp extends App {
    constructor() {
        super();

        const repoStack = new RepositoryStack(this, 'JdNAppRepo', {
            env: {
                'account': 'todo',
                'region': commonRegion
            }
        });

        new CharacterManagementAppStack(this, 'JdNApp', repoStack.getRepo());
    }
}

new CharacterManagementApp().synth();