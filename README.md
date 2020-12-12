# elasticsearch indexer
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Total Lines](https://tokei.rs/b1/github/apache/Incubator-DolphinScheduler?category=lines)](https://github.com/apache/Incubator-DolphinScheduler)
[![codecov](https://codecov.io/gh/apache/incubator-dolphinscheduler/branch/dev/graph/badge.svg)](https://codecov.io/gh/apache/incubator-dolphinscheduler/branch/dev)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=apache-dolphinscheduler&metric=alert_status)](https://sonarcloud.io/dashboard?id=apache-dolphinscheduler)
# 分支管理

## 1.服务器部署分支情况

* dev1。dev环境分支
* daily。daily环境分支
* gray。g ra y环境分支
* master。生产环境分支

## 2.分支拉取规范

* feature。feature分支为需求分支，建议每次从master拉取。
* hotfix。hotfix分支为bug修复分支，建议每次从master拉取。
* release。release分支为上线分支，建议每次从master拉取，merge开发分支。因为线上分支固定为master分支，需要在上线前将release分支merge到master分支中。

## 3.版本管理规范

* SNAPSHOT。SNAPSHOT为快照版本，开发期间使用。
* RELEASE。RELEASE为发布版本，更改发布到线上使用。
* aa.bb.cc。版本号，依据不同的需求等级，升级相应段位的版本号。

