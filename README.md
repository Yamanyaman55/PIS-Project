# PIS

<!-- TOC -->
* [PIS](#pis)
  * [Proje Genel Bakış](#proje-genel-bakış)
    * [Not](#not)
  * [Geliştirici](#geliştirici)
  * [Proje Gereksinimleri](#proje-gereksinimleri)
  * [Yapı](#yapı)
<!-- TOC -->

## Proje Genel Bakış
Bu depo, mikro hizmet tabanlı bir Kargo Takip Sistemi içerir. Başlangıçta bir kolej ödevi olarak geliştirilmiştir.
Müşterilerin benzersiz takip numaraları kullanarak gönderileri eklemelerini ve takip etmelerini sağlar. Sistem, hassas gönderi konumu takibi için çeşitli taşıyıcılarla entegre olur.
Ana özellikler arasında takip geçmişinin yerel veritabanında saklanması ve kayıtlı gönderiler için otomatik güncellemeler bulunur.
Sistem ayrıca tüm gönderi nitelikleri arasında arama yapmayı destekler ve takip geçmişlerini yazdırma işlevi sunar; dosyalar özel bir kaynakta saklanır.

### Not
Teslimat sırasında proje [ilk halindeydi](https://github.com/Percival33/PIS/tree/e904b722c8ec0cf4c6c1359c2bb9e564471e1912).
Daha sonra, Kubernetes desteği ve Grafana ile Prometheus izleme araçlarının eklenmesiyle daha da geliştirildi.

## Geliştirici
- Nurullah

## Proje Gereksinimleri

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

**Ek Dizinler:**
- `devops`: NGINX ters proxy yapılandırması, Jenkins kurulumu ve otomatik derleme ve dağıtım betikleri.


denemee



