The Whole Quote World

<!-- TOC -->

* [Medium Article](#medium-article)
* [Prerequisite](#prerequisite)
    * [Maven Wrapper](#maven-wrapper)
    * [Installing Docker](#installing-docker)
* [Project structure](#project-structure)
    * [Data crawler tool](#data-crawler-tool)
* [UI Pages](#ui-pages)
    * [Authors page](#authors-page)
    * [Collections page](#collections-page)
    * [Quotes page](#quotes-page)
    * [Topics page](#topics-page)

<!-- TOC -->

# Medium Article

https://medium.com/@truongbui95/exploring-gitlab-ci-cd-ce6a7ffb5746

# Prerequisite

* Java 17, Eclipse Temurin (former AdoptOpenJDK) is recommended: https://adoptium.net/temurin/releases?version=17
* Spring Boot 3.1.4 or use Maven Wrapper instead
* MySQL (Local or Docker image)

## Maven Wrapper

Maven Wrapper allows you to use the version of Maven required by the project without installing it. It will
automatically download required Maven version (3.9.4), and will use it to build the project. Automatically downloaded
versions are saved into `~/.m2/wrapper/dists` folder.

To use Maven Wrapper just replace `mvn` with `./mvnw` in your scripts.

## Installing Docker

In case, you want to utilize MySQL Docker Image.

Follow this guide [Docker Install](https://docs.docker.com/desktop/install/mac-install/) to install docker on your local
machine.

Run MySQL as a container with the following command:

```shell
docker run mysql
```

# Project structure

* `kube` - Holding the necessary Kubernetes YAML files.
* `src` - Source Code
    * `controllers` - App controllers
    * `core` - Common constants
    * `crawl` - Data crawler tool
    * `model` - App entities
    * `repositories` - Repositories that implement business logics with DB
    * `services` - Services that implement business logics
* `resources` - UI resources
    * `static` - Static resources (JavaScript, CSS, images)
    * `templates` - Thymeleaf UI templates
* `test` - Testing Components

## Data crawler tool

The crawling executor tool is used to initially crawl and populate the project's database.<br>
It's necessary only during the project setup.<br>
To activate it, simply set crawling.executor.enabled to true in the application.yaml file.

*The crawled data contains unnecessary characters; we can optimize the crawling approach for efficiency.*

*The app loads sample data from the data.sql file into the database when it starts.*

# UI Pages

## Authors page

Displaying celebrity images as clickable options.<br>
Upon clicking a celebrity, users are redirected to a page featuring that celebrity's exclusive quotes.

## Collections page

Providing images for Quote Collections as clickable options.<br>
When a collection is clicked, users will be directed to a Quotes page exclusively showcasing quotes belonging to that
collection.

## Quotes page

Displaying all the quotes from celebrities and favorite quotes from around the world.

## Topics page

Providing images for Quote Topics as clickable options.<br>
When a topic is clicked, users will be directed to a Quotes page exclusively showcasing quotes belonging to that
topic.
