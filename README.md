# PIS

<!-- TOC -->
* [PIS](#pis)
  * [Proje Genel Bakış](#proje-genel-bakış)
    * [Not](#not)
  * [Geliştirici](#geliştirici)
  * [Proje Gereksinimleri](#proje-gereksinimleri)
  * [Yapı](#yapı)
<!-- TOC -->

## Project Overview
This repository contains a microservices-based Parcel Tracking System, initially developed as a college assignment by a team of four. 
It allows clients to add and track shipments using unique tracking numbers. The system integrates with various carriers for precise shipment location tracking. 
Key features include local database storage of tracking history and automatic updates for registered shipments. 
The system also supports searching across all shipment attributes and offers functionality for printing tracking histories, with files stored in a dedicated resource.

### Note
At the time of college submission, the project was in its [initial form](https://github.com/Percival33/PIS/tree/e904b722c8ec0cf4c6c1359c2bb9e564471e1912). 
Post-submission, it has been further developed to include Kubernetes support, along with the addition of monitoring tools Grafana and Prometheus. 

## Team Members
- [Dawid Kaszyński](https://github.com/dawidkasz)
- [Mikołaj Szawerda](https://github.com/MikolajSzawerda)
- [Jakub Jażdzyk](https://github.com/kubajaz)
- [Marcin Jarczewski](https://github.com/percival33)

## Project Requirements

**CI/CD:** Jenkins  
**Artifact Deposu:** Nexus

**Veritabanları:**
- MongoDB
- Elasticsearch

**Backend Teknolojileri:**
- Java 17
- Gradle/Maven
- Spring Boot 3.1
- Hibernate
- OpenFeign
- Resilience4j
- Apache Kafka
- MinIO
- Hashicorp Vault
- JUnit
- Docker + Docker Compose

**Frontend Teknolojileri:**
- React

**Mikro Hizmetler:**
- Service Discovery (Hizmet Keşfi)
- API Gateway (API Geçidi)
- Config Server (Yapılandırma Sunucusu)

## Yapı

Proje, aşağıdaki hizmetleri içeren bir monorepo (tek depo) olarak yapılandırılmıştır:

- `gateway`: Mikro hizmetler için API geçidi.
- `frontend`: React tabanlı kullanıcı arayüzü.
- `parcel-finder`: Elasticsearch ve Kafka ile paket arama hizmeti.
- `parcel-tracker`: Sürekli paket takip hizmeti.
- `report-generator`: Paket takip geçmişi için PDF rapor oluşturma.
- `service-discovery`: Eureka keşif sunucusu.
- `config-server`: Mikro hizmetler için dış yapılandırmaların yönetimi.

**Additional Directories:**
- `devops`: Configuration for NGINX reverse proxy, Jenkins setup, and automated build and deployment scripts.