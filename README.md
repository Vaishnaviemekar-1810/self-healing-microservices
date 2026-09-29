\# Self-Healing Microservices Platform



A containerized Spring Boot application deployed on Kubernetes with automated CI/CD using Jenkins, Maven, Docker, Git, and Kind.



\## Project Overview



The Self-Healing Microservices Platform demonstrates automated application build, containerization, Kubernetes deployment, health monitoring, self-healing, scaling, rolling updates, and rollback.



The project is implemented locally on Windows using Docker Desktop and a Kind Kubernetes cluster.



\## Technology Stack



\* Java 17

\* Spring Boot

\* Maven

\* Docker

\* Kubernetes

\* Kind

\* Jenkins

\* Git

\* GitHub

\* PowerShell



\## Architecture



```text

Developer

&#x20;   |

&#x20;   v

&#x20; GitHub

&#x20;   |

&#x20;   v

&#x20; Jenkins

&#x20;   |

&#x20;   +----> Maven Build

&#x20;   |

&#x20;   +----> Docker Image

&#x20;   |

&#x20;   v

&#x20; Kind Cluster

&#x20;   |

&#x20;   v

Kubernetes Deployment

&#x20;   |

&#x20;   +----> Health Service Pod

&#x20;   |

&#x20;   +----> Health Service Pod

&#x20;   |

&#x20;   v

&#x20;Kubernetes Service

&#x20;   |

&#x20;   v

&#x20;Application

```



\## Application Features



\* Spring Boot web application

\* Kubernetes Deployment with multiple replicas

\* Liveness probe

\* Readiness probe

\* Automatic pod replacement

\* Horizontal replica scaling

\* Rolling updates

\* Deployment rollback

\* Kubernetes Service

\* Jenkins CI/CD automation

\* Docker containerization



\## Kubernetes Configuration



The application is deployed using:



\* `deployment.yaml`

\* `service.yaml`



The Deployment manages application replicas and health probes.



The Service exposes the application inside the Kubernetes environment and provides access through a NodePort configuration.



\## Self-Healing



Kubernetes automatically maintains the desired number of application replicas.



When an application pod is manually deleted or becomes unavailable, the Kubernetes Deployment creates a replacement pod automatically.



This behavior was tested successfully during the project implementation.



\## Scaling



The application was tested with multiple replicas using Kubernetes Deployment scaling.



Example:



```bash

kubectl scale deployment health-service --replicas=4

```



The number of running replicas can be verified using:



```bash

kubectl get deployment health-service

```



\## Rolling Update



The application supports rolling updates through Kubernetes Deployment.



A new application version can be built using Jenkins and deployed without manually recreating the complete application deployment.



Deployment status can be monitored using:



```bash

kubectl rollout status deployment/health-service

```



\## Rollback



Kubernetes rollout history was used to maintain deployment revisions.



View deployment history:



```bash

kubectl rollout history deployment/health-service

```



Rollback to the previous revision:



```bash

kubectl rollout undo deployment/health-service

```



\## Jenkins CI/CD Pipeline



The Jenkins pipeline automates the following workflow:



```text

GitHub Checkout

&#x20;     ↓

Maven Build

&#x20;     ↓

Docker Image Build

&#x20;     ↓

Load Image into Kind

&#x20;     ↓

Kubernetes Deployment

&#x20;     ↓

Rollout Verification

```



The pipeline uses the Jenkins build number to create unique Docker image tags.



Example:



```text

self-healing-health-service:7

```



\## Build the Application



Build the Spring Boot application using Maven:



```bash

mvnw.cmd clean package

```



\## Build Docker Image



```bash

docker build -t self-healing-health-service:1.0 .

```



\## Run Kubernetes Deployment



```bash

kubectl apply -f deployment.yaml

kubectl apply -f service.yaml

```



\## Check Kubernetes Resources



Check pods:



```bash

kubectl get pods

```



Check deployment:



```bash

kubectl get deployment health-service

```



Check service:



```bash

kubectl get service health-service

```



\## Access the Application



For local access through Kubernetes port forwarding:



```bash

kubectl port-forward service/health-service 8082:8081

```



Open:



```text

http://localhost:8082/index.html

```



\## Project Verification



The following functionality was successfully tested:



\* Maven application build

\* Docker image creation

\* Kubernetes deployment

\* Kubernetes health probes

\* Pod self-healing

\* Replica scaling

\* Rolling update

\* Rollback

\* Jenkins automated build

\* Jenkins Docker image creation

\* Jenkins deployment to Kubernetes



\## Repository



GitHub repository:



https://github.com/Vaishnaviemekar-1810/self-healing-microservices



