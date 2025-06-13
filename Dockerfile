FROM jenkins/jenkins:lts

USER root

# Installer Maven et OpenJDK 17
RUN apt-get update && \
    apt-get install -y maven openjdk-17-jdk && \
    apt-get clean

ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

USER jenkins
